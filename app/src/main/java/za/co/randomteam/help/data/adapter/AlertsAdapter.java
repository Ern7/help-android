package za.co.randomteam.help.data.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import za.co.randomteam.help.R;
import za.co.randomteam.help.data.listener.IAlertListener;
import za.co.randomteam.help.data.model.Alerts;

public class AlertsAdapter  extends RecyclerView.Adapter<AlertsAdapter.FeedModelViewHolder> {
    private List<Alerts> alertsList;
    private IAlertListener clickListener;

    public AlertsAdapter(List<Alerts> alertsList, IAlertListener clickListener){
        this.alertsList = alertsList;
        this.clickListener = clickListener;
    }
    @NonNull
    @Override
    public AlertsAdapter.FeedModelViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_alert, parent, false);
        return new AlertsAdapter.FeedModelViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull final AlertsAdapter.FeedModelViewHolder holder, int position) {
        final Alerts alert = alertsList.get(position);
        holder.title.setText(alert.getTitle());
        holder.subtitle.setText(alert.getSubtitle());
        holder.timestamp.setText(alert.getTime());

        if(!TextUtils.isEmpty(alert.getIcon())) {
            Picasso.get()
                    .load(getIcon(alert.getIcon()))
                    .fit()
                    .into(holder.icon);
        }

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            clickListener.onClick(alert);
            }
        });
    }

    int getIcon(String icon){
        if(icon.equals("person")){ //magic strings are bad
            return R.drawable.ic_person;
        }
        return R.drawable.ic_alert;
    }

    @Override
    public int getItemCount() {
        return alertsList.size();
    }

    public static class FeedModelViewHolder extends RecyclerView.ViewHolder {
        private View alertView;
        private TextView title, subtitle, timestamp;
        private ImageView icon;
        private RelativeLayout container;
        public FeedModelViewHolder(View v) {
            super(v);
            title = v.findViewById(R.id.title);
            subtitle = v.findViewById(R.id.subtitle);
            timestamp = v.findViewById(R.id.timestamp);
            icon = v.findViewById(R.id.icon);
            container = v.findViewById(R.id.container);
            alertView = v;
        }
    }


}

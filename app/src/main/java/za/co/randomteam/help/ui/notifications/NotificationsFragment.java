package za.co.randomteam.help.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import za.co.randomteam.help.R;
import za.co.randomteam.help.data.adapter.AlertsAdapter;
import za.co.randomteam.help.data.base.BaseFragment;
import za.co.randomteam.help.data.listener.IAlertListener;
import za.co.randomteam.help.data.model.Alerts;

public class NotificationsFragment extends BaseFragment implements IAlertListener {

    private NotificationsViewModel notificationsViewModel;
    ProgressBar progressBar;
    RecyclerView recyclerView;
    AlertsAdapter adapter;
    ArrayList<Alerts> alertsList = new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel = new ViewModelProvider.NewInstanceFactory ().create( NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        ((TextView)root.findViewById(R.id.toolbar_title)).setText("Alerts");
        setupControls(root);
        return root;
    }
    void setupControls(View root){
         adapter = new AlertsAdapter(alertsList,this);
         progressBar = root.findViewById(R.id.progress_bar);
         recyclerView = initRV(root);
         recyclerView.setAdapter(adapter);
         init();
    }
    void init(){
        notificationsViewModel.getProgress().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean s) {
                int visibility = s? View.VISIBLE:View.GONE;
                progressBar.setVisibility(visibility);
            }
        });

        notificationsViewModel.getAlerts().observe(getViewLifecycleOwner(), new Observer<ArrayList<Alerts>>() {
            @Override
            public void onChanged(ArrayList<Alerts> alerts) {
                alertsList.clear();
                alertsList.addAll(alerts);
                adapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    public <T> void onClick(T item) {
        Alerts alert = (Alerts)item;
        toast(alert.getTime());
    }
}
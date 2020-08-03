package za.co.randomteam.help.data.base;

import android.view.View;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import za.co.randomteam.help.R;

public class BaseFragment extends Fragment {

     protected RecyclerView initRV(View root) {
         RecyclerView view = root.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(requireContext());
        view.setLayoutManager(mLayoutManager);
        view.setItemAnimator(new DefaultItemAnimator());
        view.setHasFixedSize(true);
        return view;
    }

    protected <T> void toast(T msg){
        Toast.makeText(requireContext(),msg.toString(),Toast.LENGTH_LONG).show();
    }
}

package za.co.randomteam.help.ui.notifications;

import android.os.Handler;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import za.co.randomteam.help.data.model.Alerts;

public class NotificationsViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Alerts>> alertsList;
    private MutableLiveData<Boolean> isLoading;

    public NotificationsViewModel() {
       init();
    }

    void init(){
        alertsList = new MutableLiveData<>();

        isLoading = new MutableLiveData<>();
        isLoading.setValue(true);
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                isLoading.setValue(false);
                populateAlerts();
            }
        }, 4000);

    }

    public LiveData<Boolean> getProgress() {
        return isLoading;
    }

    public void populateAlerts(){
        final ArrayList<Alerts> _alerts = new ArrayList<>();
        _alerts.add(new Alerts(1,"John Doe needs your help!", "25 meters away", "2 mins ago","person"));
        _alerts.add(new Alerts(2,"General Message", "We have noticed high criminal activity...", "2 days ago","alert"));
        _alerts.add(new Alerts(3,"Sandra Khumalo needs your help!", "Was 53 meters away", "1 week ago","person"));
        alertsList.setValue(_alerts);
    }
    public LiveData<ArrayList<Alerts>> getAlerts() {
        return alertsList;
    }

}
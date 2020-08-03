package za.co.randomteam.help;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.lzyzsd.circleprogress.DonutProgress;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import androidx.fragment.app.Fragment;
import dmax.dialog.SpotsDialog;
import okhttp3.MultipartBody;
import okhttp3.Response;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class BaseFragment  extends Fragment {

    //views
    public View rootView;
    Boolean isInternetPresent = false;
    public Activity mActivity;
    public AlertDialog customAlertDialog;

    public String mtag = "";

    public static BaseFragment newInstance() {
        BaseFragment fragment = new BaseFragment();
        return fragment;
    }

    public BaseFragment() {
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    /* API */


    public void logout(){
       /* if (MyApplication.notificationManager != null)
            MyApplication.notificationManager.cancelAll();
        MyApplication.token = "";
        SharedPreferences.Editor editor = MyApplication.prefs.edit();
        editor.putString(PREFS_TOKEN, MyApplication.token);
        editor.commit();*/

    }


    public void Log(String Message) {
       /* if (MyApplication.DEBUG)
            Log.d(MyApplication.DEBUG_TAG, Message);*/
    }

    public void startLoading(){
        //  ((RelativeLayout) rootView.findViewById(R.id.loading))
        //          .setVisibility(View.VISIBLE);
    }

    public void stopLoading(){
        //  ((RelativeLayout) rootView.findViewById(R.id.loading))
        //          .setVisibility(View.GONE);
    }




    public void popAlert(Context context, String Title, String Message){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle(Title);
        alertDialogBuilder
                .setMessage(Message)
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        alertDialog.setCancelable(true);        //allows back button to cancel dialog box
    }




    public void popToast(Context context, String Message) {
        Log(Message);
        Toast slice = Toast.makeText(context, Message, Toast.LENGTH_SHORT);
        slice.show();
    }

    public void sendHit(String screen_name) {
        //  MyApplication.tracker.setScreenName(screen_name);
        //   MyApplication.tracker.send(new HitBuilders.ScreenViewBuilder().build());
    }


    public void closeKeypad(){
        if (getActivity() != null) {
            InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(INPUT_METHOD_SERVICE);
            View focusedView = getActivity().getCurrentFocus();
            if (focusedView != null) {
                imm.hideSoftInputFromWindow(focusedView.getWindowToken(), 0);
            }
        }
    }


    public void showLoadingAlert(String title){
        if (customAlertDialog != null){
            customAlertDialog.dismiss();
        }
        else {
            customAlertDialog = new SpotsDialog(getActivity(), R.style.custom_alert_loader);
        }

        customAlertDialog.setTitle(title);
        customAlertDialog.setCancelable(false);
        customAlertDialog.show();
    }

    public void hideLoadingAlert(){
        if (customAlertDialog != null){
            customAlertDialog.dismiss();
        }
    }


}

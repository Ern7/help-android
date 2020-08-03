package za.co.randomteam.help;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.lzyzsd.circleprogress.DonutProgress;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;
import okhttp3.MultipartBody;
import okhttp3.Response;

public class BaseActivity  extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState, String screenName, int layoutResourceId) {
        super.onCreate(savedInstanceState);


    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // outState.putBoolean(STATE_MENU_POSITION, menu_visible);
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }/*
    @Override
    public void onBackPressed() {       //all
        Utils.hideKeyboard((Activity) context);
        if (menu_visible)
            toggleMenuState(true);
        else
            super.onBackPressed();
    }
    */

    public void logout(){
      /*  if (MyApplication.notificationManager != null)
            MyApplication.notificationManager.cancelAll();
        MyApplication.token = "";
        SharedPreferences.Editor editor = MyApplication.prefs.edit();
        editor.putString(PREFS_TOKEN, MyApplication.token);
        editor.commit();*/

    }

    /* LOGGING */

    public void Log(String Message) {
     /*   if (MyApplication.DEBUG)
            Log.d(MyApplication.DEBUG_TAG, Message);*/
    }

    public void popToast(Context context, String Message) {
        Log(Message);
        Toast slice = Toast.makeText(context, Message, Toast.LENGTH_SHORT);
        slice.show();
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



    public void closeTransition(){
        //overridePendingTransition(R.anim.bottom_to_top, R.anim.top_to_bottom);
        //overridePendingTransition(R.anim.hold, R.anim.top_to_bottom);
    }

    public void backTransition(){
        overridePendingTransition(R.anim.abc_slide_out_bottom, R.anim.hold);
    }



    public void goBack(){
        finish();
        overridePendingTransition(R.anim.hold, R.anim.slide_out_to_right);
    }

    public void close(){
        finish();
        overridePendingTransition(R.anim.hold, R.anim.abc_slide_out_bottom);
    }

    public void closeKeypad(){
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        View focusedView = getCurrentFocus();
        if (focusedView != null) {
            imm.hideSoftInputFromWindow(focusedView.getWindowToken(), 0);
        }
    }

    public void setNavBar(String title, int iconResourceId) {
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(title);

        if (iconResourceId != 0)
            getSupportActionBar().setHomeAsUpIndicator(getResources().getDrawable(iconResourceId));
    }



}

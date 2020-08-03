package za.co.randomteam.help.ui.account;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONObject;

import java.util.HashMap;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import okhttp3.Response;
import za.co.randomteam.help.BaseFragment;
import za.co.randomteam.help.R;

public class RegisterUserDetailsFragment extends BaseFragment {

  //  EditText email_edittext, password_edittext;

    public RegisterUserDetailsFragment() {
        mtag = "login";
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

    }

    Fragment fragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_register_user_details, container, false);
        fragment = this;
        initViews();
        return rootView;
    }

    private void initViews(){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        final int screen_height = displayMetrics.heightPixels;


        //((RegisterActivity) getActivity()).disableFingerSwipe();
      /*  email_edittext = rootView.findViewById(R.id.email_address);
        password_edittext = rootView.findViewById(R.id.password);

        password_edittext.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    checkFields();

                    return true;
                }
                return false;
            }
        });*/

        (rootView.findViewById(R.id.next)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    //getActivity().onBackPressed();
                    if (((RegisterActivity) getActivity()).mPager.getCurrentItem() < ((RegisterActivity) getActivity()).NUM_PAGES - 1){
                        ((RegisterActivity) getActivity()).mPager.setCurrentItem(((RegisterActivity) getActivity()).mPager.getCurrentItem() + 1);
                    }
                }
            }
        });

    }



    @Override
    public void onResume()
    {
        super.onResume();
        if (!getUserVisibleHint())
        {
            return;
        }


    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
    }

    @Override
    public void onStop() {
        super.onStop();
        hideLoadingAlert();
    }

}

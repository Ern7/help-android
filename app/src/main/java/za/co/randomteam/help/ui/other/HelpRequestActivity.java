package za.co.randomteam.help.ui.other;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import za.co.randomteam.help.BaseActivity;
import za.co.randomteam.help.R;

public class HelpRequestActivity extends BaseActivity {

    private TextView toolbar_title;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_request);
        toolbar_title = findViewById(R.id.toolbar_title);
        toolbar_title.setText("Help Request");
    }
}

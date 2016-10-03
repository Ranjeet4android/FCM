package com.ranjeet.firebasecloudmessaging;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;



public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;

    private CheckBox notificationCheckbox;

    private MySharedPreference mySharedPreference;

    private boolean hasUserSubscribed;

    private BroadcastReceiver mRegistrationBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //checkPlayServices();
        Intent intent= getIntent();
        String push_title=intent.getStringExtra("push_title");
        String push_message=intent.getStringExtra("push_message");
        if(push_title!=null && push_message!=null)
        {
            Log.d("push_title","push_title-"+push_title+", push_message-"+push_message);
        }

        mySharedPreference = new MySharedPreference(this);
        notificationCheckbox = (CheckBox)findViewById(R.id.subscribe);

        final View coordinatorLayoutView = findViewById(R.id.snackbarPosition);


        boolean sentToken = mySharedPreference.hasUserSubscribeToNotification();
        if (sentToken) {
            notificationCheckbox.setChecked(true);
            notificationCheckbox.setEnabled(false);
            notificationCheckbox.setText(getString(R.string.registered));
            Snackbar.make(coordinatorLayoutView, getString(R.string.registered), Snackbar.LENGTH_LONG).show();
        } else {
            notificationCheckbox.setChecked(false);
            notificationCheckbox.setEnabled(false);
            notificationCheckbox.setText(getString(R.string.registered));
            Snackbar.make(coordinatorLayoutView, getString(R.string.un_register), Snackbar.LENGTH_LONG).show();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();
    }


}

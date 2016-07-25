package com.kavi.droid.emenu.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.kavi.droid.emenu.R;
import com.kavi.droid.emenu.services.connections.AsyncApiConnector;
import com.kavi.droid.emenu.services.connections.IApiConnector;
import com.kavi.droid.emenu.services.connections.SyncApiConnector;

/**
 * Created by kavi707 on 7/21/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class MainActivity extends AppCompatActivity {

    private Button syncBtn;
    private Button asyncBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpView();
    }

    private void setUpView() {

        syncBtn = (Button) findViewById(R.id.syncButton);
        asyncBtn = (Button) findViewById(R.id.asyncButton);

        syncBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSyncData();
            }
        });

        asyncBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getAsyncData();
            }
        });
    }

    private void getSyncData() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                IApiConnector apiConnector = new SyncApiConnector();
                String url = "https://brandsmacker.com/Services/SurveyService.svc/Brand?industryId=1";
//                String url = "http://52.200.0.200:3000/user/k1@gmail.com";
                String response = apiConnector.sendHttpGetRequest(url, null);

                Log.d("EMLog", ">>>>>>>>>>>>>>>>>>>>> Sync Data " + response);
            }
        }).start();
    }

    private void getAsyncData() {

        IApiConnector apiConnector = new AsyncApiConnector();
        String url = "https://brandsmacker.com/Services/SurveyService.svc/Brand?industryId=1";
//        String url = "http://52.200.0.200:3000/user/k1@gmail.com";
        String response = apiConnector.sendHttpGetRequest(url, null);

        Log.d("EMLog", ">>>>>>>>>>>>>>>>>>>>>>>>>>> Async Data " + response);
    }
}

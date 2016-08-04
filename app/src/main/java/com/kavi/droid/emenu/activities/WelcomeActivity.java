package com.kavi.droid.emenu.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kavi.droid.emenu.R;

/**
 * Created by kavi707 on 8/4/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class WelcomeActivity extends Activity {

    private TextView restaurantNameTextView;
    private Button viewMenuBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        setUpView();
    }

    private void setUpView() {

        restaurantNameTextView = (TextView) findViewById(R.id.restaurantNameTextView);
        viewMenuBtn = (Button) findViewById(R.id.viewMenuButton);

        viewMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tableSelectIntent = new Intent(WelcomeActivity.this, TableSelectActivity.class);
                startActivity(tableSelectIntent);
                finish();
            }
        });
    }
}

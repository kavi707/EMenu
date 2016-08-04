package com.kavi.droid.emenu.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kavi.droid.emenu.R;

/**
 * Created by kavi707 on 8/4/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class TableSelectActivity extends Activity {

    private Button continueBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_select);

        setUpViews();
    }

    private void setUpViews() {

        continueBtn = (Button) findViewById(R.id.continueBtn);

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menuIntent = new Intent(TableSelectActivity.this, MenuActivity.class);
                startActivity(menuIntent);
            }
        });
    }
}

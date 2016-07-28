package com.kavi.droid.emenu.activities;

import android.app.Activity;
import android.os.Bundle;

import com.kavi.droid.emenu.R;

/**
 * Created by kwijewardana on 7/28/16.
 */
public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        setUpViews();
    }

    private void setUpViews() {

    }
}

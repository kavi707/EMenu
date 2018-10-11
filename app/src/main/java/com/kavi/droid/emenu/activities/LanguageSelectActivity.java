package com.kavi.droid.emenu.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.kavi.droid.emenu.R;

/**
 * Created by kavi707 on 10/10/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */

public class LanguageSelectActivity extends Activity {

    private ImageButton germanImageBtn;
    private ImageButton englishImageBtn;
    private ImageButton russianImageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_select);

        setUpView();
    }

    private void setUpView() {

        germanImageBtn = (ImageButton) findViewById(R.id.germanImageButton);
        englishImageBtn = (ImageButton) findViewById(R.id.englishImageButton);
        russianImageBtn = (ImageButton) findViewById(R.id.russianImageButton);

        germanImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        englishImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent tableSelectIntent = new Intent(LanguageSelectActivity.this, TableSelectActivity.class);
                startActivity(tableSelectIntent);
                finish();*/

                Intent menuIntent = new Intent(LanguageSelectActivity.this, FoodMenuActivity.class);
                menuIntent.putExtra("SELECTED_TABLE_NUMBER", "01");
                startActivity(menuIntent);
            }
        });

        russianImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}

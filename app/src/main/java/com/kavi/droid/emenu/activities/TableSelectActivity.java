package com.kavi.droid.emenu.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.kavi.droid.emenu.R;
import com.kavi.droid.emenu.adapters.NumberPickerItemAdapter;

import java.util.ArrayList;

/**
 * Created by kavi707 on 8/4/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class TableSelectActivity extends Activity {

    private Button continueBtn;
    private RecyclerView horizontalListView;

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_select);

        setUpViews();
    }

    private void setUpViews() {

        continueBtn = (Button) findViewById(R.id.continueBtn);
        horizontalListView = (RecyclerView) findViewById(R.id.numberPicker);

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent menuIntent = new Intent(TableSelectActivity.this, FoodMenuActivity.class);
                startActivity(menuIntent);
            }
        });

        ArrayList<String> horizontalList= new ArrayList<>();

        horizontalList.add("");
        horizontalList.add("");
        horizontalList.add("");
        horizontalList.add("01");
        horizontalList.add("02");
        horizontalList.add("03");
        horizontalList.add("04");
        horizontalList.add("05");
        horizontalList.add("06");
        horizontalList.add("07");
        horizontalList.add("08");
        horizontalList.add("09");
        horizontalList.add("10");
        horizontalList.add("11");
        horizontalList.add("12");
        horizontalList.add("13");
        horizontalList.add("14");
        horizontalList.add("15");
        horizontalList.add("16");
        horizontalList.add("17");
        horizontalList.add("18");
        horizontalList.add("19");
        horizontalList.add("20");
        horizontalList.add("");
        horizontalList.add("");
        horizontalList.add("");

        NumberPickerItemAdapter numberPickerItemAdapter = new NumberPickerItemAdapter(horizontalList, context);

        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        horizontalListView.setLayoutManager(horizontalLayoutManagaer);
        horizontalListView.setAdapter(numberPickerItemAdapter);
    }
}

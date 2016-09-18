package com.kavi.droid.emenu.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.kavi.droid.emenu.R;
import com.kavi.droid.emenu.adapters.TableNumberGridItemAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kavi707 on 8/4/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class TableSelectActivity extends Activity {

    private GridView tableSelectGridView;

    private TableNumberGridItemAdapter tableNumberGridItemAdapter;
    private String selectedTableNumber = null;

    private Context context = this;
    List<String> horizontalList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_select);

        setUpViews();
    }

    private void setUpViews() {

        tableSelectGridView = (GridView) findViewById(R.id.tableSelectGridView);

        loadTables();

        tableSelectGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedTableNumber = horizontalList.get(position);
                if (selectedTableNumber != null) {
                    Intent menuIntent = new Intent(TableSelectActivity.this, FoodMenuActivity.class);
                    menuIntent.putExtra("SELECTED_TABLE_NUMBER", selectedTableNumber);
                    startActivity(menuIntent);
                } else {
                    Toast.makeText(context, "Please select table to continue", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void loadTables() {

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
        /*horizontalList.add("19");
        horizontalList.add("20");*/

        tableNumberGridItemAdapter = new TableNumberGridItemAdapter(horizontalList, context);
        tableSelectGridView.setAdapter(tableNumberGridItemAdapter);
    }
}

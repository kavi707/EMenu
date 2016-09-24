package com.kavi.droid.emenu.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.kavi.droid.emenu.Constants;
import com.kavi.droid.emenu.R;
import com.kavi.droid.emenu.adapters.TableNumberGridItemAdapter;
import com.kavi.droid.emenu.dialogs.LoadingProgressBarDialog;
import com.kavi.droid.emenu.models.Table;
import com.kavi.droid.emenu.services.connections.ApiCalls;
import com.kavi.droid.emenu.services.sharedPreferences.SharedPreferenceManager;
import com.kavi.droid.emenu.utils.CommonUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kavi707 on 8/4/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class TableSelectActivity extends Activity {

    private GridView tableSelectGridView;
    private ProgressDialog progress;

    private TableNumberGridItemAdapter tableNumberGridItemAdapter;
    private String selectedTableNumber = null;

    private Context context = this;
    private ApiCalls apiCalls = new ApiCalls();
    private CommonUtils commonUtils = new CommonUtils();
    private List<Table> tableList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_select);

        setUpViews();
    }

    private void setUpViews() {

        tableSelectGridView = (GridView) findViewById(R.id.tableSelectGridView);

        tableSelectGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectedTableNumber = tableList.get(position).getNumber();
                if (selectedTableNumber != null) {
                    Intent menuIntent = new Intent(TableSelectActivity.this, FoodMenuActivity.class);
                    menuIntent.putExtra("SELECTED_TABLE_NUMBER", selectedTableNumber);
                    startActivity(menuIntent);
                } else {
                    Toast.makeText(context, "Please select table to continue", Toast.LENGTH_LONG).show();
                }
            }
        });

        getTablesFromServer();
    }

    private void getTablesFromServer() {

        if (commonUtils.isOnline(context)) {

            if (progress == null) {
                progress = LoadingProgressBarDialog.createProgressDialog(context);
            }
            progress.show();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    String accessTokenResponse = apiCalls.getUserGridAccessToken(Constants.SYNC_METHOD,
                            Constants.USERNAME, Constants.PASSWORD);
                    String accessToken = processAccessTokenResponse(accessTokenResponse);

                    if (accessToken != null) {
                        // Save access token in shared preferences
                        SharedPreferenceManager.setCurrentUserToken(context, accessToken);

                        String tableResponse = apiCalls.getTables(Constants.SYNC_METHOD, accessToken, Constants.ENTITY_LIMIT_TABLES);
                        processTableList(tableResponse);
                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            populateTableGrid();
                            progress.dismiss();
                        }
                    });
                }
            }).start();
        } else {
            Toast.makeText(context, "Please check device Internet connection.", Toast.LENGTH_SHORT).show();
        }
    }

    private String processAccessTokenResponse(String jsonString) {

        String accessToken = null;
        if (jsonString != null) {
            try {
                JSONObject jsonData = new JSONObject(jsonString);
                accessToken = jsonData.getString("access_token");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return accessToken;
    }

    private void processTableList(String jsonString) {

        if (jsonString != null) {

            try {
                JSONObject jsonObject = new JSONObject(jsonString);
                JSONArray jsonArray = jsonObject.getJSONArray("entities");
                JSONObject jsonData;
                Table table;
                for (int i = 0; i < jsonArray.length(); i++) {
                    jsonData = jsonArray.getJSONObject(i);

                    table = new Table();
                    table.setTableUUID(jsonData.getString("uuid"));
                    table.setId(jsonData.getString("TableId"));
                    table.setNumber(jsonData.getString("TableNumber"));
                    table.setStatus(jsonData.getInt("Status"));

                    tableList.add(table);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void populateTableGrid() {
        tableNumberGridItemAdapter = new TableNumberGridItemAdapter(tableList, context);
        tableSelectGridView.setAdapter(tableNumberGridItemAdapter);
    }
}

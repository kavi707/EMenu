package com.kavi.droid.emenu.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.kavi.droid.emenu.R;
import com.kavi.droid.emenu.views.TableNumberGridItemView;

import java.util.List;

/**
 * Created by kavi707 on 9/13/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class TableNumberGridItemAdapter extends BaseAdapter {

    private List<String> tableNumList;
    private Context context;

    public TableNumberGridItemAdapter(List<String> tableNumList, Context context) {
        this.tableNumList = tableNumList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return tableNumList.size();
    }

    @Override
    public Object getItem(int position) {
        return (tableNumList == null)?null:tableNumList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TableNumberGridItemView tableNumberGridItemView;
        if (convertView == null) {
            tableNumberGridItemView = (TableNumberGridItemView) View.inflate(context, R.layout.view_tables_grid_item, null);
        } else {
            tableNumberGridItemView = (TableNumberGridItemView) convertView;
        }

        tableNumberGridItemView.setTableNumber(tableNumList.get(position));
        return tableNumberGridItemView;
    }
}

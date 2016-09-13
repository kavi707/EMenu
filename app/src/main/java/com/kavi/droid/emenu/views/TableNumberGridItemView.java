package com.kavi.droid.emenu.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kavi.droid.emenu.R;

/**
 * Created by kavi707 on 9/13/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class TableNumberGridItemView extends RelativeLayout {

    private TextView tableNumberTextView;
    private RelativeLayout tableNumberRelativeLayout;

    private String tableNumber;

    public TableNumberGridItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        tableNumberRelativeLayout = (RelativeLayout) findViewById(R.id.tableNumberRelativeLayout);
        tableNumberTextView = (TextView) findViewById(R.id.tableNumberTextView);
    }

    public String getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;

        tableNumberTextView.setText(tableNumber);
    }
}

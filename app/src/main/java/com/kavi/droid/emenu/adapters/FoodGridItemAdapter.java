package com.kavi.droid.emenu.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.kavi.droid.emenu.R;
import com.kavi.droid.emenu.models.FoodItem;
import com.kavi.droid.emenu.views.FoodGridItemView;

import java.util.List;

/**
 * Created by kavi707 on 8/15/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class FoodGridItemAdapter extends BaseAdapter {

    private List<FoodItem> foodItemList;
    private Context context;

    public FoodGridItemAdapter(List<FoodItem> foodItemList, Context context) {
        this.context = context;
        this.foodItemList = foodItemList;
    }

    @Override
    public int getCount() {
        return foodItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return (foodItemList == null)?null:foodItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FoodGridItemView foodGridItemView;
        if (convertView == null) {
            foodGridItemView = (FoodGridItemView) View.inflate(context, R.layout.view_food_grid_item, null);
        } else {
            foodGridItemView = (FoodGridItemView) convertView;
        }

        foodGridItemView.setFoodItem(foodItemList.get(position));
        return foodGridItemView;
    }
}

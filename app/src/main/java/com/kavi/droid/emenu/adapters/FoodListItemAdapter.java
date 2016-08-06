package com.kavi.droid.emenu.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.kavi.droid.emenu.R;
import com.kavi.droid.emenu.models.FoodItem;
import com.kavi.droid.emenu.views.FoodListItemView;

import java.util.List;

/**
 * Created by kavi707 on 8/6/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class FoodListItemAdapter extends BaseAdapter {

    private List<FoodItem> foodItemList;
    private Context context;

    public FoodListItemAdapter(List<FoodItem> foodItemList, Context context) {
        this.foodItemList = foodItemList;
        this.context = context;
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
        FoodListItemView foodListItemView;
        if (convertView == null) {
            foodListItemView = (FoodListItemView) View.inflate(context, R.layout.view_food_list_item, null);
        } else {
            foodListItemView = (FoodListItemView) convertView;
        }

        foodListItemView.setFoodItem(foodItemList.get(position));
        return foodListItemView;
    }
}

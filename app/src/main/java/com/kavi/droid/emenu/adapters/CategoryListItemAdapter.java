package com.kavi.droid.emenu.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.kavi.droid.emenu.R;
import com.kavi.droid.emenu.models.Category;
import com.kavi.droid.emenu.views.CategoryListItemView;

import java.util.List;

/**
 * Created by kavi707 on 8/6/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class CategoryListItemAdapter extends BaseAdapter {

    private List<Category> categoryList;
    private Context context;
    public static int selectedItemPosition;

    public CategoryListItemAdapter(List<Category> categoryList, Context context) {
        this.categoryList = categoryList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return categoryList.size();
    }

    @Override
    public Object getItem(int position) {
        return (categoryList == null)?null:categoryList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CategoryListItemView categoryListItemView;
        if (convertView == null) {
            categoryListItemView = (CategoryListItemView) View.inflate(context, R.layout.view_categoty_list_item, null);
        } else {
            categoryListItemView = (CategoryListItemView) convertView;
        }

        ImageView arrowImageView = (ImageView) categoryListItemView.findViewById(R.id.categoryArrowImageView);
        if (selectedItemPosition == position) {
            categoryListItemView.setBackgroundColor(context.getResources().getColor(R.color.categorySelectedBlue));
            arrowImageView.setImageDrawable(context.getResources().getDrawable(R.drawable.icon_category_arrow));
        } else {
            categoryListItemView.setBackgroundColor(context.getResources().getColor(R.color.categoryBlue));
            arrowImageView.setImageDrawable(null);
        }

        categoryListItemView.setCategory(categoryList.get(position));
        return categoryListItemView;
    }
}

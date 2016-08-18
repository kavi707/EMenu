package com.kavi.droid.emenu.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kavi.droid.emenu.R;

import java.util.List;

/**
 * Created by kwijewardana on 8/9/16.
 */
public class NumberPickerItemAdapter extends RecyclerView.Adapter<NumberPickerItemAdapter.PickerItemViewHolder> {

    private List<String> horizontalList;
    private Context context;
    private int midPos = 3;

    public NumberPickerItemAdapter(List<String> horizontalList, Context context) {
        this.horizontalList = horizontalList;
        this.context = context;
    }

    @Override
    public PickerItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_picker_item, parent, false);

        return new PickerItemViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(PickerItemViewHolder holder, int position) {
        final PickerItemViewHolder viewHolder = holder;
        holder.numberTextView.setText(horizontalList.get(position));

        if (position == midPos && !horizontalList.get(position).equals("")) {
            holder.numberTextView.setTextColor(context.getResources().getColor(R.color.lightPurple));
            holder.numberTextView.setTextSize(100);
            holder.numberTextView.setTypeface(Typeface.DEFAULT);
            holder.pickerItemLinearLayout.setBackground(context.getResources().getDrawable(R.drawable.background_table_select_box));
        } else {
            holder.numberTextView.setTextColor(context.getResources().getColor(R.color.colorDarkGrey));
            holder.numberTextView.setTextSize(80);
            holder.numberTextView.setTypeface(Typeface.DEFAULT_BOLD);
            holder.pickerItemLinearLayout.setBackground(null);
        }

        holder.numberTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Selected item + " + viewHolder.numberTextView.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return horizontalList.size();
    }

    public class PickerItemViewHolder extends RecyclerView.ViewHolder {
        public TextView numberTextView;
        public LinearLayout pickerItemLinearLayout;

        public PickerItemViewHolder(View view) {
            super(view);
            numberTextView = (TextView) view.findViewById(R.id.numberTextView);
            pickerItemLinearLayout = (LinearLayout) view.findViewById(R.id.pickerItemLinearLayout);
        }
    }
}

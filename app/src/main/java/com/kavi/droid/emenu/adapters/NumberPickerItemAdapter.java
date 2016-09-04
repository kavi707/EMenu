package com.kavi.droid.emenu.adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.kavi.droid.emenu.R;
import com.kavi.droid.emenu.models.Table;

import java.util.List;

/**
 * Created by kavi707 on 8/9/16.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class NumberPickerItemAdapter extends RecyclerView.Adapter<NumberPickerItemAdapter.PickerItemViewHolder> {

    private List<Table> tableList;
    private Context context;
    OnItemClickListener mItemClickListener;

    public NumberPickerItemAdapter(List<Table> tableList, Context context) {
        this.tableList = tableList;
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
        final int viewPosition = position;
        holder.numberTextView.setText(tableList.get(position).getNumber());

        holder.numberTextView.setTextColor(context.getResources().getColor(R.color.colorDarkGrey));
        holder.numberTextView.setTextSize(80);
        holder.numberTextView.setTypeface(Typeface.DEFAULT_BOLD);
        holder.pickerItemLinearLayout.setBackground(null);

        holder.numberTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemClickListener.onItemClick(v, viewPosition);
            }
        });
    }

    @Override
    public int getItemCount() {
        return tableList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public class PickerItemViewHolder extends RecyclerView.ViewHolder {
        private TextView numberTextView;
        private LinearLayout pickerItemLinearLayout;

        public PickerItemViewHolder(View view) {
            super(view);
            numberTextView = (TextView) view.findViewById(R.id.numberTextView);
            pickerItemLinearLayout = (LinearLayout) view.findViewById(R.id.pickerItemLinearLayout);
        }
    }
}

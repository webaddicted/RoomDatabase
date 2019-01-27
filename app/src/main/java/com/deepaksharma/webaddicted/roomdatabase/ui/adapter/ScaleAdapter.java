package com.deepaksharma.webaddicted.roomdatabase.ui.adapter;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.deepaksharma.webaddicted.roomdatabase.R;
import com.deepaksharma.webaddicted.roomdatabase.databinding.RowScaleBinding;

import java.util.ArrayList;
import java.util.List;

public class ScaleAdapter extends RecyclerView.Adapter<ScaleAdapter.ViewHolder> {
    private final ArrayList<Integer> colors;
    private List<String> scaleList ;
    public ScaleAdapter(List<String> scaleList) {
        this.scaleList = scaleList;
        colors = new ArrayList<>();
        colors.add(Color.RED);
        colors.add(Color.CYAN);
        colors.add(Color.YELLOW);
        colors.add(Color.GREEN);
    }
    @NonNull
    @Override
    public ScaleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowScaleBinding mBinding = DataBindingUtil.
                inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.row_scale,
                        parent, false);
//        LinearLayout.LayoutParams layoutParams =  new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 400);
//        layoutParams.leftMargin = 30;
//        layoutParams.rightMargin = 30;
//        mBinding.getRoot().setLayoutParams(layoutParams);
//        mBinding.getRoot().set
//        mBinding.getRoot().setG(Gravity.CENTER);
        return new ScaleAdapter.ViewHolder(mBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ScaleAdapter.ViewHolder holder, int position) {
//        ViewHolder viewHolder = (ViewHolder)holder;
//        RelativeLayout view = (RelativeLayout)viewHolder.itemView;
//        int backgroundColor = colors.get(position % colors.size());
//        view.setBackgroundColor(backgroundColor);
        LinearLayout.LayoutParams layoutParams =  new LinearLayout.LayoutParams(700, 800);
        layoutParams.leftMargin = 30;
        layoutParams.rightMargin = 30;
        holder.binding.getRoot().setLayoutParams(layoutParams);
        holder.binding();
    }

    @Override
    public int getItemCount() {
        return scaleList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private RowScaleBinding binding;

        public ViewHolder(RowScaleBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }

        public void binding() {
            binding.txtTitle.setText(String.valueOf(getAdapterPosition()));
        }
    }

}

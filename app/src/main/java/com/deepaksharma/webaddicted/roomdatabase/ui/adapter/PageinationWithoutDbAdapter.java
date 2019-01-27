package com.deepaksharma.webaddicted.roomdatabase.ui.adapter;

import android.arch.paging.PagedListAdapter;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.deepaksharma.webaddicted.roomdatabase.R;
import com.deepaksharma.webaddicted.roomdatabase.databinding.RowPagingItemBinding;
import com.deepaksharma.webaddicted.roomdatabase.db.entity.Pagination;

import static android.support.constraint.Constraints.TAG;

public class PageinationWithoutDbAdapter extends PagedListAdapter<Pagination.ArticlesBean, PageinationWithoutDbAdapter.MyViewHolder> {

    public PageinationWithoutDbAdapter() {
        super(DIFF_CALLBACKS);
    }
    public static DiffUtil.ItemCallback<Pagination.ArticlesBean> DIFF_CALLBACKS = new DiffUtil.ItemCallback<Pagination.ArticlesBean>() {
        @Override
        public boolean areItemsTheSame(@NonNull Pagination.ArticlesBean oldCoupon, @NonNull Pagination.ArticlesBean newCoupon) {
            return oldCoupon.getId() == newCoupon.getId();//if id is int
//            return oldCoupon.getId().equals(newCoupon.getId());//if id is string
        }

        @Override
        public boolean areContentsTheSame(@NonNull Pagination.ArticlesBean oldCoupon, @NonNull Pagination.ArticlesBean newCoupon) {
            return oldCoupon.equals(newCoupon);//if id is int
//            return oldCoupon.getId().equals(newCoupon.getId());//if id is string object compare on bases of id
        }
    };
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowPagingItemBinding itemBinding = DataBindingUtil.
                inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.row_paging_item,
                        parent, false);
        return new MyViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        Pagination.ArticlesBean coupon = getItem(position);
        if(coupon != null) {
            holder.bindTO(coupon);
        }
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        RowPagingItemBinding binding;

        MyViewHolder(RowPagingItemBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }
        public void bindTO(Pagination.ArticlesBean coupon){
            binding.txtTitle.setText(coupon.getTitle());
            binding.txtDesc.setText(coupon.getDescription()+"");
            Glide.with(binding.imgUrl.getContext()).load(coupon.getUrlToImage()).into(binding.imgUrl);
            Log.d(TAG, "bindTO: "+coupon.getUrl());

    }
    }
}

package com.deepaksharma.webaddicted.roomdatabase.ui.adapter;

import android.app.Activity;
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

public class NewsAdapterList extends PagedListAdapter<Pagination.ArticlesBean, NewsAdapterList.NewsViewHolder> {

    private final Activity mActivity;

    public NewsAdapterList(Activity activity) {
        super(DIFF_CALLBACKS);
        this.mActivity = activity;
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
    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RowPagingItemBinding navigationBinding = DataBindingUtil.
                inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.row_paging_item,
                        parent, false);
        return new NewsViewHolder(navigationBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        Pagination.ArticlesBean coupon = getItem(position);
        if(coupon != null) {
            holder.bindTO(coupon);
        }
    }
    public class NewsViewHolder extends RecyclerView.ViewHolder {
        private RowPagingItemBinding binding;
        public NewsViewHolder(RowPagingItemBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
        public void bindTO(Pagination.ArticlesBean coupon){
            binding.txtTitle.setText(coupon.getTitle());
            binding.txtDesc.setText(coupon.getDescription()+"");
            Glide.with(mActivity).load(coupon.getUrlToImage()).into(binding.imgUrl);
            Log.d(TAG, "bindTO: "+coupon.getUrl());
        }
    }

}

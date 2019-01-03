package com.deepaksharma.webaddicted.roomdatabase.ui.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.databinding.DataBindingUtil;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import com.deepaksharma.webaddicted.roomdatabase.R;
import com.deepaksharma.webaddicted.roomdatabase.databinding.ActivityPagingBinding;
import com.deepaksharma.webaddicted.roomdatabase.db.entity.Pagination;
import com.deepaksharma.webaddicted.roomdatabase.ui.adapter.NewsAdapterList;
import com.deepaksharma.webaddicted.roomdatabase.ui.viewmodel.PagingViewModel;

public class PagingActivity extends AppCompatActivity {
    ActivityPagingBinding mBinding;
    PagingViewModel pagingViewModel;
    private NewsAdapterList newsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_paging);
        pagingViewModel = ViewModelProviders.of(this).get(PagingViewModel.class);

        pagingViewModel.init();

        newsAdapter = new NewsAdapterList(this);
        mBinding.couponsRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mBinding.couponsRv.setAdapter(newsAdapter);

        pagingViewModel.newsLiveData.observe(this, new Observer<PagedList<Pagination.ArticlesBean>>() {
            @Override
            public void onChanged(@Nullable PagedList<Pagination.ArticlesBean> lists) {
//            Toast.makeText(PagingActivity.this, "change" + lists.size(), Toast.LENGTH_SHORT).show();
                newsAdapter.submitList(lists);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        newsAdapter.notifyDataSetChanged();
                    }
                }, 500);

            }
        });
    }
}

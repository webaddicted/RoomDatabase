package com.deepaksharma.webaddicted.roomdatabase.ui.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.deepaksharma.webaddicted.roomdatabase.R;
import com.deepaksharma.webaddicted.roomdatabase.databinding.ActivityPaginationWithoutDbBinding;
import com.deepaksharma.webaddicted.roomdatabase.db.entity.Pagination;
import com.deepaksharma.webaddicted.roomdatabase.ui.adapter.PageinationWithoutDbAdapter;
import com.deepaksharma.webaddicted.roomdatabase.ui.viewmodel.PagingViewModel;
import com.deepaksharma.webaddicted.roomdatabase.ui.viewmodel.PagingWithoutDbViewModel;

import java.util.Objects;

public class PaginationWithoutDbActivity extends AppCompatActivity {
    private ActivityPaginationWithoutDbBinding mBinding;
    private PagingWithoutDbViewModel pagingViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_pagination_without_db);
        pagingViewModel = ViewModelProviders.of(this).get(PagingWithoutDbViewModel.class);
        init();
    }

    private void init() {
        pagingViewModel.init(this);
        mBinding.rvPagination.setLayoutManager(new LinearLayoutManager(this));
        PageinationWithoutDbAdapter adapter = new PageinationWithoutDbAdapter();
        mBinding.rvPagination.setAdapter(adapter);

//        if (!Constant.checkInternetConnection(this)) {
//            Snackbar.make(findViewById(android.R.id.content), Constant.CHECK_NETWORK_ERROR, Snackbar.LENGTH_SHORT)
//                    .show();
//        }

        pagingViewModel.getArticResp().observe(this, new Observer<PagedList<Pagination.ArticlesBean>>() {
            @Override
            public void onChanged(@Nullable PagedList<Pagination.ArticlesBean> articlesBeans) {
                adapter.submitList(articlesBeans);
            }
        });
    }
}

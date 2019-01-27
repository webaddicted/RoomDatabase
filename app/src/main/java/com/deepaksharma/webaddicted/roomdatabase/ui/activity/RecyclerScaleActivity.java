package com.deepaksharma.webaddicted.roomdatabase.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.deepaksharma.webaddicted.roomdatabase.R;
import com.deepaksharma.webaddicted.roomdatabase.databinding.ActivityRecyclerScaleBinding;
import com.deepaksharma.webaddicted.roomdatabase.ui.adapter.ScaleAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecyclerScaleActivity extends AppCompatActivity {
ActivityRecyclerScaleBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_recycler_scale);
        setAdapter();
    }

    private void setAdapter() {
        mBinding.rvScaleItem.enableViewScaling(true);
        mBinding.rvScaleItem.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ScaleAdapter sampleAdapter = new ScaleAdapter(getSampleList());
        mBinding.rvScaleItem.setAdapter(sampleAdapter);
    }
    private List<String> getSampleList() {
        List<String> sampleList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            sampleList.add(i + "");
        }
        return sampleList;
    }
}

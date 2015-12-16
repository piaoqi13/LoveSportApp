package com.touna.lovesportapp.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.touna.lovesportapp.R;

/**
 * created by collin on 2015-12-16.
 */
public class SelectFilterView extends LinearLayout implements View.OnClickListener {
    private Context mContext = null;

    private LinearLayout mLlFilterClassify = null;
    private LinearLayout mLlFilterLocation = null;
    private LinearLayout mLlFilterOrder = null;

    private TextView mTvFilterClassify = null;
    private TextView mTvFilterLocation = null;
    private TextView mTvFilterOrder = null;

    private ImageView mIvFilterClassify = null;
    private ImageView mIvFilterLocation = null;
    private ImageView mIvFilterOrder = null;

    public SelectFilterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.select_filter_view, this, true);
        initView();
        setListener();
    }

    private void initView() {
        mLlFilterClassify = (LinearLayout) findViewById(R.id.ll_select_filter_classify);
        mLlFilterLocation = (LinearLayout) findViewById(R.id.ll_select_filter_location);
        mLlFilterOrder = (LinearLayout) findViewById(R.id.ll_select_filter_order);

        mTvFilterClassify = (TextView) findViewById(R.id.tv_select_filter_classify);
        mTvFilterLocation = (TextView) findViewById(R.id.tv_select_filter_location);
        mTvFilterOrder = (TextView) findViewById(R.id.tv_select_filter_order);

        mIvFilterClassify = (ImageView) findViewById(R.id.iv_select_filter_classify);
        mIvFilterLocation = (ImageView) findViewById(R.id.iv_select_filter_location);
        mIvFilterOrder = (ImageView) findViewById(R.id.iv_select_filter_order);
    }

    private void setListener() {
        mLlFilterClassify.setOnClickListener(this);
        mLlFilterLocation.setOnClickListener(this);
        mLlFilterOrder.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_select_filter_classify:
                break;
            case R.id.ll_select_filter_location:
                break;
            case R.id.ll_select_filter_order:
                break;
        }
    }
}

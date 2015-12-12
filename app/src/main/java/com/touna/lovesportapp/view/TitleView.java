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
 * created by collin on 2015-12-07.
 */
public class TitleView extends LinearLayout {
    private LinearLayout mLlLeftNavigation = null;
    private LinearLayout mLlRightNavigation = null;

    private ImageView mIvLeftNavigation = null;
    private ImageView mIvRightNavigation = null;

    private ImageView mIvCenterSearch = null;

    private TextView mTvLeftNavigation = null;
    private TextView mTvRightNavigation = null;

    private TextView mTvTitle = null;

    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.title_view, this, true);
        initView();
    }

    private void initView() {
        mLlLeftNavigation = (LinearLayout) findViewById(R.id.ll_left_navigation);
        mLlRightNavigation = (LinearLayout) findViewById(R.id.ll_right_navigation);
        mIvLeftNavigation = (ImageView) findViewById(R.id.iv_left_navigation_img);
        mIvRightNavigation = (ImageView) findViewById(R.id.iv_right_navigation_img);
        mIvCenterSearch = (ImageView) findViewById(R.id.iv_center_search_img);
        mTvLeftNavigation = (TextView) findViewById(R.id.tv_left_navigation_text);
        mTvRightNavigation = (TextView) findViewById(R.id.tv_right_navigation_text);

        mTvTitle = (TextView) findViewById(R.id.tv_title);
    }

    public void setLeftNavigationText(int id, OnClickListener listener) {
        mTvLeftNavigation.setText(id);
        mTvLeftNavigation.setVisibility(View.VISIBLE);
        mLlLeftNavigation.setOnClickListener(listener);
    }

    public void setLeftNavigationText(String str, OnClickListener listener) {
        mTvLeftNavigation.setText(str);
        mTvLeftNavigation.setVisibility(View.VISIBLE);
        mLlLeftNavigation.setOnClickListener(listener);
    }

    public void setLeftNavigationImg(int id, OnClickListener listener) {
        mIvLeftNavigation.setBackgroundResource(id);
        mIvLeftNavigation.setVisibility(View.VISIBLE);
        mLlLeftNavigation.setOnClickListener(listener);
    }

    public void setTitle(int id) {
        mTvTitle.setText(id);
        mTvTitle.setVisibility(View.VISIBLE);
    }

    public void setTitle(String str) {
        mTvTitle.setText(str);
        mTvTitle.setVisibility(View.VISIBLE);
    }

    public void setTitleSearch(OnClickListener listener) {
        mIvCenterSearch.setVisibility(View.VISIBLE);
        mIvCenterSearch.setOnClickListener(listener);
    }

    public void setRightNavigationText(int id, OnClickListener listener) {
        mTvRightNavigation.setText(id);
        mTvRightNavigation.setVisibility(View.VISIBLE);
        mLlRightNavigation.setOnClickListener(listener);
    }

    public void setRightNavigationText(String str, OnClickListener listener) {
        mTvRightNavigation.setText(str);
        mTvRightNavigation.setVisibility(View.VISIBLE);
        mLlRightNavigation.setOnClickListener(listener);
    }

    public void setRightNavigationImg(int id, OnClickListener listener) {
        mIvRightNavigation.setBackgroundResource(id);
        mIvRightNavigation.setVisibility(View.VISIBLE);
        mLlRightNavigation.setOnClickListener(listener);
    }
}

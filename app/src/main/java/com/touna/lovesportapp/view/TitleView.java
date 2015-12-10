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
        mTvLeftNavigation = (TextView) findViewById(R.id.tv_left_navigation_text);
        mTvRightNavigation = (TextView) findViewById(R.id.tv_left_navigation_text);

        mTvTitle = (TextView) findViewById(R.id.tv_title);
    }

    public void setLeftNavigationText(int id, OnClickListener listener) {
        mLlLeftNavigation.setVisibility(View.VISIBLE);
        mLlLeftNavigation.setOnClickListener(listener);
        mTvLeftNavigation.setText(id);
    }

    public void setLeftNavigationText(String str, OnClickListener listener) {
        mLlLeftNavigation.setVisibility(View.VISIBLE);
        mLlLeftNavigation.setOnClickListener(listener);
        mTvLeftNavigation.setText(str);
    }

    public void setLeftNavigationImg(int id, OnClickListener listener) {
        mLlLeftNavigation.setVisibility(View.VISIBLE);
        mLlLeftNavigation.setOnClickListener(listener);
        mIvLeftNavigation.setBackgroundResource(id);
    }

    public void setTitle(int id) {
        mTvTitle.setText(id);
    }

    public void setTitle(String str) {
        mTvTitle.setText(str);
    }

    public void setRightNavigationText(int id, OnClickListener listener) {
        mLlRightNavigation.setVisibility(View.VISIBLE);
        mLlRightNavigation.setOnClickListener(listener);
        mTvRightNavigation.setText(id);
    }

    public void setRightNavigationText(String str, OnClickListener listener) {
        mLlRightNavigation.setVisibility(View.VISIBLE);
        mLlRightNavigation.setOnClickListener(listener);
        mTvRightNavigation.setText(str);
    }

    public void setRightNavigationImg(int id, OnClickListener listener) {
        mLlLeftNavigation.setVisibility(View.VISIBLE);
        mLlLeftNavigation.setOnClickListener(listener);
        mIvRightNavigation.setBackgroundResource(id);
    }
}

package com.touna.lovesportapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.touna.lovesportapp.BaseFragment;
import com.touna.lovesportapp.R;
import com.touna.lovesportapp.mine.LoginActivity;
import com.touna.lovesportapp.mine.MyOrderActivity;
import com.umeng.analytics.MobclickAgent;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

/**
 * created by collin on 2015-12-09.
 */
@ContentView(R.layout.fragment_mine)
public class MineFragment extends BaseFragment {
    private final String mPageName = "MineFragment";

    @ViewInject(R.id.ll_mine_my_order)
    private LinearLayout mLlMyOrder;

    @ViewInject(R.id.ll_mine_my_collect)
    private LinearLayout mLlMyCollect;

    @ViewInject(R.id.ll_mine_my_feedback)
    private LinearLayout mLlFeedBack;

    @ViewInject(R.id.ll_mine_my_settings)
    private LinearLayout mLlSettings;

    @ViewInject(R.id.tv_mine_my_service_phone)
    private TextView mTvServicePhone;

    @ViewInject(R.id.tv_mine_login)
    private TextView mTvLogin;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Event(R.id.ll_mine_my_order)
    private void clickMyOrderEvent(View view) {
        Log.i("CollinWang", "clickMyOrderEvent is run");
        Intent intent = new Intent(mContext, MyOrderActivity.class);
        startActivity(intent);
    }

    @Event(R.id.ll_mine_my_collect)
    private void clickMyCollectEvent(View view) {
        Log.i("CollinWang", "clickMyorderEvent is run");
    }

    @Event(R.id.ll_mine_my_feedback)
    private void clickFeedbackEvent(View view) {
        Log.i("CollinWang", "clickFeedbackEvent is run");
    }

    @Event(R.id.ll_mine_my_settings)
    private void clickSettingsEvent(View view) {
        Log.i("CollinWang", "clickSettingsEvent is run");
    }

    @Event(R.id.tv_mine_my_service_phone)
    private void clickServicePhoneEvent(View view) {
        Log.i("CollinWang", "clickServicePhoneEvent is run");
    }

    @Event(R.id.tv_mine_login)
    private void clickLoginEvent(View view) {
        Intent intent = new Intent(mContext, LoginActivity.class);
        mContext.startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(mPageName);
    }

    @Override
    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(mPageName);
    }
}

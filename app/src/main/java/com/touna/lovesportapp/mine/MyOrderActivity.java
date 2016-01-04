package com.touna.lovesportapp.mine;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.touna.lovesportapp.BaseActivity;
import com.touna.lovesportapp.R;
import com.touna.lovesportapp.model.OrderInfo;
import com.touna.lovesportapp.stadium.ViewPagerAdapter;
import com.touna.lovesportapp.view.TitleView;
import com.umeng.analytics.MobclickAgent;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * created by collin on 2015-12-07.
 */
@ContentView(R.layout.activity_my_order)
public class MyOrderActivity extends BaseActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private final String mPageName = "MyOrderActivity";

    @ViewInject(R.id.tv_common_title)
    private TitleView mTitleView;

    @ViewInject(R.id.ll_my_order_not_pay)
    private LinearLayout mLlNotPay;

    @ViewInject(R.id.ll_my_order_pay)
    private LinearLayout mLlAlreadyPay;

    @ViewInject(R.id.ll_my_order_cancel)
    private LinearLayout mLlAlreadyCancel;

    @ViewInject(R.id.tv_my_order_not_pay)
    private TextView mTvNotPay;

    @ViewInject(R.id.tv_my_order_pay)
    private TextView mTvAlreadyPay;

    @ViewInject(R.id.tv_my_order_cancel)
    private TextView mTvAlreadyCancel;

    @ViewInject(R.id.v_my_order_not_pay_line)
    private View mVNotPayLine;

    @ViewInject(R.id.v_my_order_pay_line)
    private View mVAlreadyPayLine;

    @ViewInject(R.id.v_my_order_cancel_line)
    private View mVCancelLine;

    @ViewInject(R.id.vp_my_order)
    private ViewPager mVpOrderInfo = null;

    private List<View> mListViews = null;
    private List<OrderInfo> mOrderInfos = null;
    private ListView mLvNotPay = null;
    private ListView mLvAlreadyPay = null;
    private ListView mLvAlreadyCancel = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTitleView.setTitle(R.string.title_order_list);
        mTitleView.setLeftNavigationImg(R.drawable.back_normal, this);
        initData();
    }

    private void initData() {
        mLvNotPay = new ListView(mContext);
        mLvAlreadyPay = new ListView(mContext);
        mLvAlreadyCancel = new ListView(mContext);

        mLvNotPay.setDividerHeight(0);
        mLvAlreadyPay.setDividerHeight(0);
        mLvAlreadyCancel.setDividerHeight(0);

        mListViews = new ArrayList<View>();
        mListViews.add(mLvNotPay);
        mListViews.add(mLvAlreadyPay);
        mListViews.add(mLvAlreadyCancel);

        mOrderInfos = new ArrayList<OrderInfo>();
        mOrderInfos.add(new OrderInfo("id","普威羽毛球场","未付款","暂无","2016/01/06 11:56","11号场","50元"));
        mOrderInfos.add(new OrderInfo("id","普威羽毛球场","未付款","暂无","2016/01/06 11:56","11号场","50元"));
        mOrderInfos.add(new OrderInfo("id","普威羽毛球场","未付款","暂无","2016/01/06 11:56","11号场","50元"));
        mOrderInfos.add(new OrderInfo("id","普威羽毛球场","未付款","暂无","2016/01/06 11:56","11号场","50元"));
        mOrderInfos.add(new OrderInfo("id","普威羽毛球场","未付款","暂无","2016/01/06 11:56","11号场","50元"));
        mOrderInfos.add(new OrderInfo("id","普威羽毛球场","未付款","暂无","2016/01/06 11:56","11号场","50元"));

        mLvNotPay.setAdapter(new MyOrderAdapter(mContext, mOrderInfos));

        mVpOrderInfo.setAdapter(new ViewPagerAdapter(mListViews));
        mVpOrderInfo.setCurrentItem(0);
        mVpOrderInfo.setOnPageChangeListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(mPageName);
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(mPageName);
        MobclickAgent.onPause(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == 0) {
            mLvNotPay.setAdapter(new MyOrderAdapter(mContext, mOrderInfos));
            mTvNotPay.setTextColor(mContext.getResources().getColor(R.color.tab_pressed));
            mTvAlreadyPay.setTextColor(mContext.getResources().getColor(R.color.tab_normal));
            mTvAlreadyCancel.setTextColor(mContext.getResources().getColor(R.color.tab_normal));
            mVNotPayLine.setBackgroundColor(getResources().getColor(R.color.tab_pressed));
            mVAlreadyPayLine.setBackgroundColor(getResources().getColor(R.color.index_recommend_view));
            mVCancelLine.setBackgroundColor(getResources().getColor(R.color.index_recommend_view));
        } else if (position == 1) {
            mLvAlreadyPay.setAdapter(new MyOrderAdapter(mContext, mOrderInfos));
            mTvNotPay.setTextColor(mContext.getResources().getColor(R.color.tab_normal));
            mTvAlreadyPay.setTextColor(mContext.getResources().getColor(R.color.tab_pressed));
            mTvAlreadyCancel.setTextColor(mContext.getResources().getColor(R.color.tab_normal));
            mVNotPayLine.setBackgroundColor(getResources().getColor(R.color.index_recommend_view));
            mVAlreadyPayLine.setBackgroundColor(getResources().getColor(R.color.tab_pressed));
            mVCancelLine.setBackgroundColor(getResources().getColor(R.color.index_recommend_view));
        } else if (position == 2) {
            mLvAlreadyCancel.setAdapter(new MyOrderAdapter(mContext, mOrderInfos));
            mTvNotPay.setTextColor(mContext.getResources().getColor(R.color.tab_normal));
            mTvAlreadyPay.setTextColor(mContext.getResources().getColor(R.color.tab_normal));
            mTvAlreadyCancel.setTextColor(mContext.getResources().getColor(R.color.tab_pressed));
            mVNotPayLine.setBackgroundColor(getResources().getColor(R.color.index_recommend_view));
            mVAlreadyPayLine.setBackgroundColor(getResources().getColor(R.color.index_recommend_view));
            mVCancelLine.setBackgroundColor(getResources().getColor(R.color.tab_pressed));
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_left_navigation:
                Log.i("CollinWang", "ll_left_navigation is run");
                break;
            case R.id.ll_right_navigation:
                break;
        }
    }
}

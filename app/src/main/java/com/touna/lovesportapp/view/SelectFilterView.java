package com.touna.lovesportapp.view;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.touna.lovesportapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * created by collin on 2015-12-16.
 */
public class SelectFilterView extends LinearLayout implements View.OnClickListener {
    private Context mContext = null;

    private LayoutInflater mLayoutInflater = null;
    private PopupWindow mPopupWindow = null;
    private View mPopupWindowView = null;
    private ListView mLvSelectFilter = null;

    private LinearLayout mLlFilterClassify = null;
    private LinearLayout mLlFilterLocation = null;
    private LinearLayout mLlFilterOrder = null;

    private TextView mTvFilterClassify = null;
    private TextView mTvFilterLocation = null;
    private TextView mTvFilterOrder = null;

    private ImageView mIvFilterClassify = null;
    private ImageView mIvFilterLocation = null;
    private ImageView mIvFilterOrder = null;

    private List<String> mClassifys = new ArrayList<String>();
    private List<String> mLocations = new ArrayList<String>();
    private List<String> mOrders = new ArrayList<String>();

    public SelectFilterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mLayoutInflater.inflate(R.layout.select_filter_view, this, true);
        initView();
        initListener();
        initData();
        int[] location = new int[2];
        this.getLocationOnScreen(location);
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

    private void initListener() {
        mLlFilterClassify.setOnClickListener(this);
        mLlFilterLocation.setOnClickListener(this);
        mLlFilterOrder.setOnClickListener(this);
    }

    private void initData() {
        mClassifys.add("健身房");
        mClassifys.add("羽毛球");
        mClassifys.add("游泳馆");

        mLocations.add("中山区");
        mLocations.add("沙河口区");
        mLocations.add("甘井子区");
        mLocations.add("旅顺口区");
        mLocations.add("金州区");

        mOrders.add("时间排序");
        mOrders.add("距离排序");
    }

    private void showPopupWindow() {
        mPopupWindowView = mLayoutInflater.inflate(R.layout.select_filter_popup_window, null);
        mPopupWindow = new PopupWindow(mPopupWindowView, ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
        mPopupWindow.setContentView(mPopupWindowView);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        mPopupWindow.setFocusable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setWidth(WindowManager.LayoutParams.FILL_PARENT);
        mPopupWindow.setHeight(WindowManager.LayoutParams.FILL_PARENT);
        mPopupWindow.showAsDropDown(this, 0, 0);
    }

    private void updatePopupWindow(List<String> strTexts) {
        mLvSelectFilter = (ListView) mPopupWindowView.findViewById(R.id.lv_select_filter_list);
        mLvSelectFilter.setAdapter(new SelectFilterAdapter(strTexts));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_select_filter_classify:
                showPopupWindow();
                updatePopupWindow(mClassifys);
                updateSelectFilterTextView(mTvFilterClassify, mTvFilterLocation, mTvFilterOrder);
                updateSelectFilterImageView(mIvFilterClassify, mIvFilterLocation, mIvFilterOrder);
                break;
            case R.id.ll_select_filter_location:
                showPopupWindow();
                updatePopupWindow(mLocations);
                updateSelectFilterTextView(mTvFilterLocation, mTvFilterClassify, mTvFilterOrder);
                updateSelectFilterImageView(mIvFilterLocation, mIvFilterClassify, mIvFilterOrder);
                break;
            case R.id.ll_select_filter_order:
                showPopupWindow();
                updatePopupWindow(mOrders);
                updateSelectFilterTextView(mTvFilterOrder, mTvFilterLocation, mTvFilterClassify);
                updateSelectFilterImageView(mIvFilterOrder, mIvFilterLocation, mIvFilterClassify);
                break;
        }
    }

    private void updateSelectFilterTextView(TextView pressed, TextView normal1, TextView normal2) {
        pressed.setTextColor(mContext.getResources().getColor(R.color.tab_pressed));
        normal1.setTextColor(mContext.getResources().getColor(R.color.tab_normal));
        normal2.setTextColor(mContext.getResources().getColor(R.color.tab_normal));
    }

    private void updateSelectFilterImageView(ImageView pressed, ImageView normal1, ImageView normal2) {
        pressed.setBackgroundResource(R.drawable.select_filter_pressed);
        normal1.setBackgroundResource(R.drawable.select_filter_normal);
        normal2.setBackgroundResource(R.drawable.select_filter_normal);
    }

    private class SelectFilterAdapter extends BaseAdapter{
        private List<String> mSelectFilters = null;

        public SelectFilterAdapter(List<String> selectFilters) {
            this.mSelectFilters = selectFilters;
        }

        @Override
        public int getCount() {
            return mSelectFilters.size();
        }

        @Override
        public Object getItem(int position) {
            return mSelectFilters.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = mLayoutInflater.inflate(R.layout.select_filter_item, null);
                holder = new ViewHolder();
                holder.mTvSelectFilterText = (TextView) convertView.findViewById(R.id.tv_select_filter_text);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.mTvSelectFilterText.setText(mSelectFilters.get(position));
            return convertView;
        }

        private class ViewHolder{
            private TextView mTvSelectFilterText = null;
        }
    }
}

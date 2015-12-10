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
 * created by collin on 2015-12-09.
 */
public class FragmentIndicator extends LinearLayout implements View.OnClickListener {
    private Context mContext = null;

    private LinearLayout mLlStadiumLayout = null;
    private ImageView mIvStadium = null;
    private TextView mTvStadium = null;

    private LinearLayout mLlCoachLayout = null;
    private ImageView mIvCoach = null;
    private TextView mTvCoach = null;

    private LinearLayout mLlMineLayout = null;
    private ImageView mIvMine = null;
    private TextView mTvMine = null;

    private OnIndicateListener mOnIndicateListener = null;

    public FragmentIndicator(Context context) {
        super(context);
        this.mContext = context;
    }

    public FragmentIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
        setListener();
    }

    private void initView() {
        LayoutInflater.from(mContext).inflate(R.layout.fragment_tab_layout, this, true);
        mLlStadiumLayout = (LinearLayout) findViewById(R.id.ll_stadium_layout);
        mIvStadium = (ImageView) findViewById(R.id.iv_stadium);
        mTvStadium = (TextView) findViewById(R.id.tv_stadium);

        mLlCoachLayout = (LinearLayout) findViewById(R.id.ll_coach_layout);
        mIvCoach = (ImageView) findViewById(R.id.iv_coach);
        mTvCoach = (TextView) findViewById(R.id.tv_coach);

        mLlMineLayout = (LinearLayout) findViewById(R.id.ll_mine_layout);
        mIvMine = (ImageView) findViewById(R.id.iv_mine);
        mTvMine = (TextView) findViewById(R.id.tv_mine);
    }

    private void setListener() {
        mLlStadiumLayout.setOnClickListener(this);
        mLlCoachLayout.setOnClickListener(this);
        mLlMineLayout.setOnClickListener(this);
    }

    public void setIndicator(int which) {
        switch (which) {
            case 0:
                mIvStadium.setBackgroundResource(R.drawable.stadium_pressed);
                mIvCoach.setBackgroundResource(R.drawable.coach_normal);
                mIvMine.setBackgroundResource(R.drawable.mine_normal);
                mTvStadium.setTextColor(mContext.getResources().getColor(R.color.tab_pressed));
                mTvCoach.setTextColor(mContext.getResources().getColor(R.color.tab_normal));
                mTvMine.setTextColor(mContext.getResources().getColor(R.color.tab_normal));
                break;
            case 1:
                mIvStadium.setBackgroundResource(R.drawable.stadium_normal);
                mIvCoach.setBackgroundResource(R.drawable.coach_pressed);
                mIvMine.setBackgroundResource(R.drawable.mine_normal);
                mTvStadium.setTextColor(mContext.getResources().getColor(R.color.tab_normal));
                mTvCoach.setTextColor(mContext.getResources().getColor(R.color.tab_pressed));
                mTvMine.setTextColor(mContext.getResources().getColor(R.color.tab_normal));
                break;
            case 2:
                mIvStadium.setBackgroundResource(R.drawable.stadium_normal);
                mIvCoach.setBackgroundResource(R.drawable.coach_normal);
                mIvMine.setBackgroundResource(R.drawable.mine_pressed);
                mTvStadium.setTextColor(mContext.getResources().getColor(R.color.tab_normal));
                mTvCoach.setTextColor(mContext.getResources().getColor(R.color.tab_normal));
                mTvMine.setTextColor(mContext.getResources().getColor(R.color.tab_pressed));
                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_stadium_layout:
                setIndicator(0);
                mOnIndicateListener.onIndicate(v, 0);
                break;
            case R.id.ll_coach_layout:
                setIndicator(1);
                mOnIndicateListener.onIndicate(v, 1);
                break;
            case R.id.ll_mine_layout:
                setIndicator(2);
                mOnIndicateListener.onIndicate(v, 2);
                break;
            default:
                break;
        }
    }

    public interface OnIndicateListener {
        public void onIndicate(View v, int which);
    }

    public void setOnIndicateListener(OnIndicateListener listener) {
        mOnIndicateListener = listener;
    }
}

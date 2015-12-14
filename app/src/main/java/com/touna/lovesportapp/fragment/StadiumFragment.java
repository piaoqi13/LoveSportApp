package com.touna.lovesportapp.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.touna.lovesportapp.BaseFragment;
import com.touna.lovesportapp.R;
import com.touna.lovesportapp.model.RecommendStadiumInfo;
import com.touna.lovesportapp.stadium.RecommendStadiumAdapter;
import com.touna.lovesportapp.stadium.ViewPagerAdapter;
import com.touna.lovesportapp.view.TitleView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * created by collin on 2015-12-09.
 */
@ContentView(R.layout.fragment_stadium)
public class StadiumFragment extends BaseFragment implements View.OnClickListener, ViewPager.OnPageChangeListener {
    @ViewInject(R.id.tv_common_title)
    private TitleView mTitleView;

    @ViewInject(R.id.ll_stadium_fitness)
    private LinearLayout mLlStadiumFitness;

    @ViewInject(R.id.ll_stadium_badminton)
    private LinearLayout mLlStadiumBadminton;

    @ViewInject(R.id.ll_stadium_swim)
    private LinearLayout mLlStadiumSwim;

    @ViewInject(R.id.v_stadium_fitness_line)
    private View mVStadiumFitnessLine;

    @ViewInject(R.id.v_stadium_badminton_line)
    private View mVStadiumBadmintonLine;

    @ViewInject(R.id.v_stadium_swim_line)
    private View mVStadiumSwimLine;

    @ViewInject(R.id.vp_recommend_stadium)
    private ViewPager mVpRecommendStadium = null;

    private List<View> mListViews = null;
    private List<RecommendStadiumInfo> mStadiums = null;
    private ListView mLvFitness = null;
    private ListView mLvBadminton = null;
    private ListView mLvSwim = null;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mTitleView.setLeftNavigationText(R.string.index_default_city, this);
        mTitleView.setTitleSearch(this);
        mTitleView.setRightNavigationImg(R.drawable.index_message_normal, this);

        mLvFitness = new ListView(mContext);
        mLvBadminton = new ListView(mContext);
        mLvSwim = new ListView(mContext);

        mListViews = new ArrayList<View>();
        mListViews.add(mLvFitness);
        mListViews.add(mLvBadminton);
        mListViews.add(mLvSwim);

        mStadiums = new ArrayList<RecommendStadiumInfo>();
        mStadiums.add(new RecommendStadiumInfo("url", "大连腾飞软件园羽毛球馆", "高新园区", "￥50元"));
        mStadiums.add(new RecommendStadiumInfo("url", "大连中国华录羽毛球馆", "高新园区", "￥50元"));
        mStadiums.add(new RecommendStadiumInfo("url", "大连数码广场羽毛球馆", "甘井子区", "￥50元"));
        mStadiums.add(new RecommendStadiumInfo("url", "大连青泥洼桥羽毛球馆", "中山区", "￥50元"));
        mStadiums.add(new RecommendStadiumInfo("url", "大连东软信息学院羽毛球馆", "甘井子区", "￥50元"));
        mStadiums.add(new RecommendStadiumInfo("url", "大连创业大厦羽毛球馆", "高新园区", "￥50元"));

        mLvFitness.setAdapter(new RecommendStadiumAdapter(mContext, mStadiums));

        mVpRecommendStadium.setAdapter(new ViewPagerAdapter(mListViews));
        mVpRecommendStadium.setCurrentItem(0);
        mVpRecommendStadium.setOnPageChangeListener(this);
    }

    @Event(R.id.ll_stadium_fitness)
    private void showFitnessEvent(View view) {
        mVStadiumFitnessLine.setBackgroundColor(getResources().getColor(R.color.tab_pressed));
        mVStadiumBadmintonLine.setBackgroundColor(getResources().getColor(R.color.index_recommend_view));
        mVStadiumSwimLine.setBackgroundColor(getResources().getColor(R.color.index_recommend_view));
    }

    @Event(R.id.ll_stadium_badminton)
    private void showBadmintonEvent(View view) {
        mVStadiumFitnessLine.setBackgroundColor(getResources().getColor(R.color.index_recommend_view));
        mVStadiumBadmintonLine.setBackgroundColor(getResources().getColor(R.color.tab_pressed));
        mVStadiumSwimLine.setBackgroundColor(getResources().getColor(R.color.index_recommend_view));
    }

    @Event(R.id.ll_stadium_swim)
    private void showSwimEvent(View view) {
        mVStadiumFitnessLine.setBackgroundColor(getResources().getColor(R.color.index_recommend_view));
        mVStadiumBadmintonLine.setBackgroundColor(getResources().getColor(R.color.index_recommend_view));
        mVStadiumSwimLine.setBackgroundColor(getResources().getColor(R.color.tab_pressed));
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        if (position == 0) {
            mLvFitness.setAdapter(new RecommendStadiumAdapter(mContext, mStadiums));
            mVStadiumFitnessLine.setBackgroundColor(getResources().getColor(R.color.tab_pressed));
            mVStadiumBadmintonLine.setBackgroundColor(getResources().getColor(R.color.index_recommend_view));
            mVStadiumSwimLine.setBackgroundColor(getResources().getColor(R.color.index_recommend_view));
        } else if (position == 1) {
            mLvBadminton.setAdapter(new RecommendStadiumAdapter(mContext, mStadiums));
            mVStadiumFitnessLine.setBackgroundColor(getResources().getColor(R.color.index_recommend_view));
            mVStadiumBadmintonLine.setBackgroundColor(getResources().getColor(R.color.tab_pressed));
            mVStadiumSwimLine.setBackgroundColor(getResources().getColor(R.color.index_recommend_view));
        } else if (position == 2) {
            mLvSwim.setAdapter(new RecommendStadiumAdapter(mContext, mStadiums));
            mVStadiumFitnessLine.setBackgroundColor(getResources().getColor(R.color.index_recommend_view));
            mVStadiumBadmintonLine.setBackgroundColor(getResources().getColor(R.color.index_recommend_view));
            mVStadiumSwimLine.setBackgroundColor(getResources().getColor(R.color.tab_pressed));
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
                Log.i("CollinWang", "ll_right_navigation is run");
                break;
            case R.id.iv_center_search_img:
                Log.i("CollinWang", "iv_center_search_img is run");
                break;
        }
    }
}

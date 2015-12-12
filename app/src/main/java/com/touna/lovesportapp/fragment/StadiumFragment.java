package com.touna.lovesportapp.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.touna.lovesportapp.BaseFragment;
import com.touna.lovesportapp.R;
import com.touna.lovesportapp.view.TitleView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

/**
 * created by collin on 2015-12-09.
 */
@ContentView(R.layout.fragment_stadium)
public class StadiumFragment extends BaseFragment implements View.OnClickListener {
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

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mTitleView.setLeftNavigationText(R.string.index_default_city, this);
        mTitleView.setTitleSearch(this);
        mTitleView.setRightNavigationImg(R.drawable.index_message_normal, this);
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

package com.touna.lovesportapp.fragment;

import android.os.Bundle;
import android.view.View;

import com.touna.lovesportapp.BaseFragment;
import com.touna.lovesportapp.R;
import com.touna.lovesportapp.coach.CoachListAdapter;
import com.touna.lovesportapp.model.CoachInfo;
import com.touna.lovesportapp.view.PullPushXListView;
import com.touna.lovesportapp.view.TitleView;
import com.umeng.analytics.MobclickAgent;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * created by collin on 2015-12-09.
 */
@ContentView(R.layout.fragment_coach)
public class CoachFragment extends BaseFragment implements View.OnClickListener,PullPushXListView.OnRefreshListener, PullPushXListView.OnLoadMoreListener {
    private final String mPageName = "CoachFragment";

    @ViewInject(R.id.tv_common_title)
    private TitleView mTitleView;

    @ViewInject(R.id.pp_xlistview)
    private PullPushXListView mPullPushXListView;
    private List<CoachInfo> mCoachs = null;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mTitleView.setTitle(R.string.tab_coach);
        setData();
    }

    private void setData() {
        mCoachs = new ArrayList<CoachInfo>();
        mCoachs.add(new CoachInfo("url","罗纳尔多","大连腾飞软件园羽毛球馆","300/小时"));
        mCoachs.add(new CoachInfo("url","罗纳尔多","大连腾飞软件园羽毛球馆","300/小时"));
        mCoachs.add(new CoachInfo("url","罗纳尔多","大连腾飞软件园羽毛球馆","300/小时"));
        mCoachs.add(new CoachInfo("url","罗纳尔多","大连腾飞软件园羽毛球馆","300/小时"));
        mCoachs.add(new CoachInfo("url","罗纳尔多","大连腾飞软件园羽毛球馆","300/小时"));
        mCoachs.add(new CoachInfo("url","罗纳尔多","大连腾飞软件园羽毛球馆","300/小时"));
        mCoachs.add(new CoachInfo("url","罗纳尔多","大连腾飞软件园羽毛球馆","300/小时"));
        mCoachs.add(new CoachInfo("url","罗纳尔多","大连腾飞软件园羽毛球馆","300/小时"));

        mPullPushXListView.setOnRefreshListener(this);
        mPullPushXListView.setOnLoadListener(this);
        mPullPushXListView.setAdapter(new CoachListAdapter(mContext, mCoachs));
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_left_navigation:
                break;
        }
    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }
}

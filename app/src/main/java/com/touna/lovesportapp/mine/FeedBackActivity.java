package com.touna.lovesportapp.mine;

import com.touna.lovesportapp.BaseActivity;
import com.umeng.analytics.MobclickAgent;

/**
 * created by collin on 2015-12-07.
 */
public class FeedBackActivity extends BaseActivity {
    private final String mPageName = "FeedBackActivity";

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
}

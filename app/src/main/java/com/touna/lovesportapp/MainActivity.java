package com.touna.lovesportapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import com.touna.lovesportapp.event.ResultEvent;
import com.touna.lovesportapp.http.NetWorkUtils;
import com.touna.lovesportapp.http.RequestListener;
import com.touna.lovesportapp.view.FragmentIndicator;
import com.umeng.analytics.MobclickAgent;
import com.umeng.update.UmengUpdateAgent;

/**
 * created by collin on 2015-12-07.
 */
public class MainActivity extends FragmentActivity implements RequestListener {
    private Fragment[] mFragments = null;
    private FragmentIndicator mIndicator = null;

    private static final int mDefaultWhich = 0;
    private long mExitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UmengUpdateAgent.update(this);
        initView();
        initData();
    }

    private void setFragmentIndicator(int which) {
        mFragments = new Fragment[3];
        mFragments[0] = getSupportFragmentManager().findFragmentById(R.id.fm_stadium);
        mFragments[1] = getSupportFragmentManager().findFragmentById(R.id.fm_coach);
        mFragments[2] = getSupportFragmentManager().findFragmentById(R.id.fm_mine);

        showFragment(which);
        mIndicator.setIndicator(which);
        mIndicator.setOnIndicateListener(new FragmentIndicator.OnIndicateListener() {
            @Override
            public void onIndicate(View v, int which) {
                showFragment(which);
            }
        });
    }

    public void showFragment(int which) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.hide(mFragments[0]).hide(mFragments[1]).hide(mFragments[2]);
        fragmentTransaction.show(mFragments[which]).commitAllowingStateLoss();
    }

    private void initView() {
        mIndicator = (FragmentIndicator) findViewById(R.id.fm_indicator);
    }

    private void initData() {
        setFragmentIndicator(mDefaultWhich);
        NetWorkUtils.login(this, "collin", "123456");
    }

    @Override
    public void onUpdate(ResultEvent event, Object obj) {
        switch (event) {
            case EVENT_LOGIN_SUCCESS:
                break;
            case EVENT_LOGIN_FAIL:
                break;
        }
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            return doubleClickToExit();
        }
        return super.dispatchKeyEvent(event);
    }

    private boolean doubleClickToExit() {
        if ((System.currentTimeMillis() - mExitTime) > 2000) {
            Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            mExitTime = System.currentTimeMillis();
        } else {
            finish();
        }
        return true;
    }

    @Override
    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
}

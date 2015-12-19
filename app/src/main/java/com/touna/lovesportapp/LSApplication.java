package com.touna.lovesportapp;

import android.app.Application;

import com.umeng.analytics.MobclickAgent;

import org.xutils.x;

/**
 * created by collin on 2015-12-07.
 */
public class LSApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);
        MobclickAgent.openActivityDurationTrack(false);
        MobclickAgent.setCatchUncaughtExceptions(true);
    }
}

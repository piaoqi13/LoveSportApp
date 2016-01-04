package com.touna.lovesportapp;

import android.app.Activity;
import android.os.Bundle;

import org.xutils.x;

/**
 * created by collin on 2015-12-09.
 */
public class BaseActivity extends Activity {
    protected Activity mContext = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        x.view().inject(this);
    }
}

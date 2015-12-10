package com.touna.lovesportapp;

import android.app.Activity;
import android.os.Bundle;

import org.xutils.x;

/**
 * created by collin on 2015-12-09.
 */
public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }
}

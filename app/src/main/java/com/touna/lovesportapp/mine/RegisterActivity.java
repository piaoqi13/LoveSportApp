package com.touna.lovesportapp.mine;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.touna.lovesportapp.BaseActivity;
import com.touna.lovesportapp.R;
import com.touna.lovesportapp.view.ClearEditText;
import com.touna.lovesportapp.view.TitleView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

/**
 * created by collin on 2015-12-09.
 */

@ContentView(R.layout.activity_register)
public class RegisterActivity extends BaseActivity implements View.OnClickListener {
    @ViewInject(R.id.tv_common_title)
    private TitleView mTitleView;

    @ViewInject(R.id.cedt_register_phone)
    private ClearEditText mCedtPhone;

    @ViewInject(R.id.cedt_register_verification)
    private ClearEditText mCedtVerification;

    @ViewInject(R.id.tv_register_gain_verification)
    private TextView mTvGainVerification;

    @ViewInject(R.id.cedt_register_password)
    private ClearEditText mCedtPassword;

    @ViewInject(R.id.btn_register)
    private Button mBtnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTitleView.setTitle(R.string.title_register);
        mTitleView.setLeftNavigationImg(R.drawable.back_normal, this);
    }

    @Event(R.id.tv_register_gain_verification)
    private void gainVerificationEvent(View view) {
        Log.i("CollinWang", "gainVerificationEvent is run");
    }

    @Event(R.id.btn_register)
    private void registerEvent(View view) {
        Log.i("CollinWang", "registerEvent is run");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_left_navigation:
                Log.i("CollinWang", "ll_left_navigation is run");
                break;
        }
    }
}

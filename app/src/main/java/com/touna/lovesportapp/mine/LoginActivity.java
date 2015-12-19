package com.touna.lovesportapp.mine;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.touna.lovesportapp.BaseActivity;
import com.touna.lovesportapp.R;
import com.touna.lovesportapp.view.ClearEditText;
import com.touna.lovesportapp.view.TitleView;
import com.umeng.analytics.MobclickAgent;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;

/**
 * created by collin on 2015-12-09.
 */
@ContentView(R.layout.activity_login)
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private final String mPageName = "LoginActivity";

    @ViewInject(R.id.tv_common_title)
    private TitleView mTitleView;

    @ViewInject(R.id.cedt_login_phone)
    private ClearEditText mCedtPhone;

    @ViewInject(R.id.tv_login_forget_password)
    private TextView mTvForgetPassword;

    @ViewInject(R.id.cedt_login_password)
    private ClearEditText mCedtPassword;

    @ViewInject(R.id.btn_login)
    private Button mBtnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTitleView.setTitle(R.string.title_login);
        mTitleView.setLeftNavigationImg(R.drawable.back_normal, this);
        mTitleView.setRightNavigationText(R.string.title_register, this);
    }

    @Event(R.id.tv_login_forget_password)
    private void forgetPasswordEvent(View view) {
        Log.i("CollinWang", "forgetPasswordEvent is run");
    }

    @Event(R.id.btn_login)
    private void loginEvent(View view) {
        Log.i("CollinWang", "loginEvent is run");
    }

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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_left_navigation:
                Log.i("CollinWang", "ll_left_navigation is run");
                break;
            case R.id.ll_right_navigation:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }
}

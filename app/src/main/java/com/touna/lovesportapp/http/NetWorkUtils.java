package com.touna.lovesportapp.http;

import android.util.Log;

import com.google.gson.Gson;
import com.touna.lovesportapp.event.ResultEvent;
import com.touna.lovesportapp.model.LoginInfo;
import com.touna.lovesportapp.util.HttpParams;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * created by collin on 2015-12-07.
 */
public class NetWorkUtils {
    public static void login(final RequestListener listener, String name, String password) {
        HttpClient.getInstance().doWork(HttpParams.getLoginParam(name, password), new HttpClient.HttpCallBack() {
            @Override
            public void succeed(String result) {
                try {
                    JSONObject jsonObject = new JSONObject(result);
                    if (jsonObject.optInt("code") != 200) {
                        listener.onUpdate(ResultEvent.EVENT_LOGIN_FAIL, jsonObject.optString("msg"));
                        return;
                    }
                    Gson gson = new Gson();
                    Object obj = gson.fromJson(jsonObject.toString(), LoginInfo.class);
                    listener.onUpdate(ResultEvent.EVENT_LOGIN_SUCCESS, obj);
                } catch (JSONException e) {
                    Log.e("NetWorkUtil", "loginJsonCatch=", e);
                    listener.onUpdate(ResultEvent.EVENT_LOGIN_FAIL, e.toString());
                }
            }

            @Override
            public void failed(Throwable error, String content) {
                listener.onUpdate(ResultEvent.EVENT_LOGIN_FAIL, content);
            }
        });
    }
}

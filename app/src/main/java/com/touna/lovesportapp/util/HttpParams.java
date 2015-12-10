package com.touna.lovesportapp.util;

import org.xutils.http.RequestParams;

/**
 * created by collin on 2015-12-08.
 */
public class HttpParams {
    public static RequestParams getLoginParam(String name, String password) {
        RequestParams param = new RequestParams(ConstantUrls.getLoginUrl());
        param.addBodyParameter("name", name);
        param.addBodyParameter("password", password);
        return param;
    }
}

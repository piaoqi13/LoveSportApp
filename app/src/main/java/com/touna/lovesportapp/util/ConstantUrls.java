package com.touna.lovesportapp.util;

/**
 * created by collin on 2015-12-08.
 */
public class ConstantUrls {
    public static String Server_Uri = "http://www.baidu.com/lovesport";
    public static String Login_Url = "login";

    public static String getLoginUrl() {
        return Server_Uri + Login_Url;
    }
}

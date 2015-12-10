package com.touna.lovesportapp.http;

import org.xutils.common.Callback;
import org.xutils.ex.HttpException;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * created by collin on 2015-12-08.
 */
public class HttpClient {
    private static HttpClient mHttpClient = null;
    private Callback.Cancelable mCancelable = null;
    private HttpClient() {
        super();
    }

    public static HttpClient getInstance() {
        if (mHttpClient == null) {
            mHttpClient = new HttpClient();
        }
        return mHttpClient;
    }

    public void doWork(RequestParams param, final HttpCallBack callBack) {
        mCancelable = x.http().get(param,
                new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        callBack.succeed(result);
                    }

                    @Override
                    public void onError(Throwable ex, boolean isOnCallback) {
                        callBack.failed(ex, ex.toString());
                        if (ex instanceof HttpException) {
                            HttpException httpEx = (HttpException) ex;
                            int responseCode = httpEx.getCode();
                            String responseMsg = httpEx.getMessage();
                            String errorResult = httpEx.getResult();
                        } else {
                            //ToDo
                        }
                    }

                    @Override
                    public void onCancelled(CancelledException cex) {
                        //ToDo
                    }

                    @Override
                    public void onFinished() {
                        //ToDo
                    }
                });
    }

    public interface HttpCallBack {
        void succeed(String result);

        void failed(Throwable error, String content);
    }
}

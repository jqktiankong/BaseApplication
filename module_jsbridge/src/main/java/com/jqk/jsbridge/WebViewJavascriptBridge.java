package com.jqk.jsbridge;

/**
 * author : jiqingke
 * date : 2021/12/21 11:11
 * description :
 */
public interface WebViewJavascriptBridge {
    public void send(String data);

    public void send(String data, CallBackFunction responseCallback);
}

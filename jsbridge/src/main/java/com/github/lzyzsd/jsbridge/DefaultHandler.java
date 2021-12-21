package com.github.lzyzsd.jsbridge;

/**
 * author : jiqingke
 * date : 2021/12/21 11:10
 * description :
 */

public class DefaultHandler implements BridgeHandler {
    String TAG = "DefaultHandler";

    public DefaultHandler() {
    }

    public void handler(String data, CallBackFunction function) {
        if (function != null) {
            function.onCallBack("DefaultHandler response data");
        }

    }
}
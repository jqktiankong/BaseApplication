package com.github.lzyzsd.jsbridge;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.WebView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author : jiqingke
 * date : 2021/12/21 11:09
 * description :
 */
@SuppressLint({"SetJavaScriptEnabled"})
public class BridgeWebView extends WebView implements WebViewJavascriptBridge {
    private final String TAG = "BridgeWebView";
    public static final String toLoadJs = "WebViewJavascriptBridge.js";
    Map<String, CallBackFunction> responseCallbacks = new HashMap();
    Map<String, BridgeHandler> messageHandlers = new HashMap();
    BridgeHandler defaultHandler = new DefaultHandler();
    private List<Message> startupMessage = new ArrayList();
    private long uniqueId = 0L;

    public List<Message> getStartupMessage() {
        return this.startupMessage;
    }

    public void setStartupMessage(List<Message> startupMessage) {
        this.startupMessage = startupMessage;
    }

    public BridgeWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.init();
    }

    public BridgeWebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.init();
    }

    public BridgeWebView(Context context) {
        super(context);
        this.init();
    }

    public void setDefaultHandler(BridgeHandler handler) {
        this.defaultHandler = handler;
    }

    private void init() {
        this.setVerticalScrollBarEnabled(false);
        this.setHorizontalScrollBarEnabled(false);
        this.getSettings().setJavaScriptEnabled(true);
        if (Build.VERSION.SDK_INT >= 19) {
            WebView.setWebContentsDebuggingEnabled(true);
        }

        this.setWebViewClient(this.generateBridgeWebViewClient());
    }

    protected BridgeWebViewClient generateBridgeWebViewClient() {
        return new BridgeWebViewClient(this);
    }

    void handlerReturnData(String url) {
        String functionName = BridgeUtil.getFunctionFromReturnUrl(url);
        CallBackFunction f = (CallBackFunction)this.responseCallbacks.get(functionName);
        String data = BridgeUtil.getDataFromReturnUrl(url);
        if (f != null) {
            f.onCallBack(data);
            this.responseCallbacks.remove(functionName);
        }
    }

    public void send(String data) {
        this.send(data, (CallBackFunction)null);
    }

    public void send(String data, CallBackFunction responseCallback) {
        this.doSend((String)null, data, responseCallback);
    }

    private void doSend(String handlerName, String data, CallBackFunction responseCallback) {
        Message m = new Message();
        if (!TextUtils.isEmpty(data)) {
            m.setData(data);
        }

        if (responseCallback != null) {
            String callbackStr = String.format("JAVA_CB_%s", ++this.uniqueId + "_" + SystemClock.currentThreadTimeMillis());
            this.responseCallbacks.put(callbackStr, responseCallback);
            m.setCallbackId(callbackStr);
        }

        if (!TextUtils.isEmpty(handlerName)) {
            m.setHandlerName(handlerName);
        }

        this.queueMessage(m);
    }

    private void queueMessage(Message m) {
        if (this.startupMessage != null) {
            this.startupMessage.add(m);
        } else {
            this.dispatchMessage(m);
        }

    }

    void dispatchMessage(Message m) {
        String messageJson = m.toJson();
        messageJson = messageJson.replaceAll("(\\\\)([^utrn])", "\\\\\\\\$1$2");
        messageJson = messageJson.replaceAll("(?<=[^\\\\])(\")", "\\\\\"");
        String javascriptCommand = String.format("javascript:WebViewJavascriptBridge._handleMessageFromNative('%s');", messageJson);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.loadUrl(javascriptCommand);
        }

    }

    void flushMessageQueue() {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            this.loadUrl("javascript:WebViewJavascriptBridge._fetchQueue();", new CallBackFunction() {
                public void onCallBack(String data) {
                    List list = null;

                    try {
                        list = Message.toArrayList(data);
                    } catch (Exception var9) {
                        var9.printStackTrace();
                        return;
                    }

                    if (list != null && list.size() != 0) {
                        for(int i = 0; i < list.size(); ++i) {
                            Message m = (Message)list.get(i);
                            String responseId = m.getResponseId();
                            CallBackFunction responseFunction;
                            final String callbackId;
                            if (!TextUtils.isEmpty(responseId)) {
                                responseFunction = (CallBackFunction)BridgeWebView.this.responseCallbacks.get(responseId);
                                callbackId = m.getResponseData();
                                responseFunction.onCallBack(callbackId);
                                BridgeWebView.this.responseCallbacks.remove(responseId);
                            } else {
                                responseFunction = null;
                                callbackId = m.getCallbackId();
                                if (!TextUtils.isEmpty(callbackId)) {
                                    responseFunction = new CallBackFunction() {
                                        public void onCallBack(String data) {
                                            Message responseMsg = new Message();
                                            responseMsg.setResponseId(callbackId);
                                            responseMsg.setResponseData(data);
                                            BridgeWebView.this.queueMessage(responseMsg);
                                        }
                                    };
                                } else {
                                    responseFunction = new CallBackFunction() {
                                        public void onCallBack(String data) {
                                        }
                                    };
                                }

                                BridgeHandler handler;
                                if (!TextUtils.isEmpty(m.getHandlerName())) {
                                    handler = (BridgeHandler)BridgeWebView.this.messageHandlers.get(m.getHandlerName());
                                } else {
                                    handler = BridgeWebView.this.defaultHandler;
                                }

                                if (handler != null) {
                                    handler.handler(m.getData(), responseFunction);
                                }
                            }
                        }

                    }
                }
            });
        }

    }

    public void loadUrl(String jsUrl, CallBackFunction returnCallback) {
        this.loadUrl(jsUrl);
        this.responseCallbacks.put(BridgeUtil.parseFunctionName(jsUrl), returnCallback);
    }

    public void registerHandler(String handlerName, BridgeHandler handler) {
        if (handler != null) {
            this.messageHandlers.put(handlerName, handler);
        }

    }

    public void callHandler(String handlerName, String data, CallBackFunction callBack) {
        this.doSend(handlerName, data, callBack);
    }
}

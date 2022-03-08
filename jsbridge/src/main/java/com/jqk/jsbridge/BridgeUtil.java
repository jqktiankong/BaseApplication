package com.jqk.jsbridge;

import android.content.Context;
import android.webkit.WebView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * author : jiqingke
 * date : 2021/12/21 11:08
 * description :
 */
public class BridgeUtil {
    static final String YY_OVERRIDE_SCHEMA = "yy://";
    static final String YY_RETURN_DATA = "yy://return/";
    static final String YY_FETCH_QUEUE = "yy://return/_fetchQueue/";
    static final String EMPTY_STR = "";
    static final String UNDERLINE_STR = "_";
    static final String SPLIT_MARK = "/";
    static final String CALLBACK_ID_FORMAT = "JAVA_CB_%s";
    static final String JS_HANDLE_MESSAGE_FROM_JAVA = "javascript:WebViewJavascriptBridge._handleMessageFromNative('%s');";
    static final String JS_FETCH_QUEUE_FROM_JAVA = "javascript:WebViewJavascriptBridge._fetchQueue();";
    public static final String JAVASCRIPT_STR = "javascript:";

    public BridgeUtil() {
    }

    public static String parseFunctionName(String jsUrl) {
        return jsUrl.replace("javascript:WebViewJavascriptBridge.", "").replaceAll("\\(.*\\);", "");
    }

    public static String getDataFromReturnUrl(String url) {
        if (url.startsWith("yy://return/_fetchQueue/")) {
            return url.replace("yy://return/_fetchQueue/", "");
        } else {
            String temp = url.replace("yy://return/", "");
            String[] functionAndData = temp.split("/");
            if (functionAndData.length < 2) {
                return null;
            } else {
                StringBuilder sb = new StringBuilder();

                for(int i = 1; i < functionAndData.length; ++i) {
                    sb.append(functionAndData[i]);
                }

                return sb.toString();
            }
        }
    }

    public static String getFunctionFromReturnUrl(String url) {
        String temp = url.replace("yy://return/", "");
        String[] functionAndData = temp.split("/");
        return functionAndData.length >= 1 ? functionAndData[0] : null;
    }

    public static void webViewLoadJs(WebView view, String url) {
        String js = "var newscript = document.createElement(\"script\");";
        js = js + "newscript.src=\"" + url + "\";";
        js = js + "document.scripts[0].parentNode.insertBefore(newscript,document.scripts[0]);";
        view.loadUrl("javascript:" + js);
    }

    public static void webViewLoadLocalJs(WebView view, String path) {
        String jsContent = assetFile2Str(view.getContext(), path);
        view.loadUrl("javascript:" + jsContent);
    }

    public static String assetFile2Str(Context c, String urlStr) {
        InputStream in = null;

        try {
            in = c.getAssets().open(urlStr);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            String line = null;
            StringBuilder sb = new StringBuilder();

            do {
                line = bufferedReader.readLine();
                if (line != null && !line.matches("^\\s*\\/\\/.*")) {
                    sb.append(line);
                }
            } while(line != null);

            bufferedReader.close();
            in.close();
            String var6 = sb.toString();
            return var6;
        } catch (Exception var16) {
            var16.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException var15) {
                }
            }

        }

        return null;
    }
}
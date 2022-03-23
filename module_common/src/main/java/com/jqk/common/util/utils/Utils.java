package com.jqk.common.util.utils;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Log;

/**
 * author : jiqingke
 * date : 2021/11/29 19:03
 * description :
 */
public class Utils {
    @SuppressLint("StaticFieldLeak")
    private static Application sApp;

    public static void init(final Application app) {
        if (app == null) {
            Log.e("Utils", "app is null.");
            return;
        }
        if (sApp == null) {
            sApp = app;
            return;
        }
        if (sApp.equals(app)) return;
        sApp = app;
    }

    /**
     * Return the Application object.
     * <p>Main process get app by UtilsFileProvider,
     * and other process get app by reflect.</p>
     *
     * @return the Application object
     */
    public static Application getApp() {
        if (sApp != null) return sApp;
        if (sApp == null) throw new NullPointerException("reflect failed.");
        return sApp;
    }
}

package com.jqk.common.util.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;

import java.util.Locale;

/**
 * author : jiqingke
 * date : 2021/11/29 18:44
 * description :
 */
public class LanguageUtils {

    private static final String KEY_LOCALE          = "KEY_LOCALE";
    private static final String VALUE_FOLLOW_SYSTEM = "VALUE_FOLLOW_SYSTEM";

    private LanguageUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * Return the locale of context.
     *
     * @return the locale of context
     */
    public static Locale getContextLanguage(Context context) {
        return getLocal(context.getResources().getConfiguration());
    }

    /**
     * Return the locale of applicationContext.
     *
     * @return the locale of applicationContext
     */
    public static Locale getAppContextLanguage() {
        return getContextLanguage(Utils.getApp());
    }

    /**
     * Return the locale of system
     *
     * @return the locale of system
     */
    public static Locale getSystemLanguage() {
        return getLocal(Resources.getSystem().getConfiguration());
    }

    private static void updateConfiguration(Context context, Locale destLocal) {
        Resources resources = context.getResources();
        Configuration config = resources.getConfiguration();
        setLocal(config, destLocal);
        resources.updateConfiguration(config, resources.getDisplayMetrics());
    }

    private static String locale2String(Locale locale) {
        String localLanguage = locale.getLanguage(); // this may be empty
        String localCountry = locale.getCountry(); // this may be empty
        return localLanguage + "$" + localCountry;
    }

    private static Locale string2LocaleReal(String str) {
        if (!isRightFormatLocalStr(str)) {
            return null;
        }

        try {
            int splitIndex = str.indexOf("$");
            return new Locale(str.substring(0, splitIndex), str.substring(splitIndex + 1));
        } catch (Exception ignore) {
            return null;
        }
    }

    private static boolean isRightFormatLocalStr(String localStr) {
        char[] chars = localStr.toCharArray();
        int count = 0;
        for (char c : chars) {
            if (c == '$') {
                if (count >= 1) {
                    return false;
                }
                ++count;
            }
        }
        return count == 1;
    }

    private static boolean isSameLocale(Locale l0, Locale l1) {
        return StringUtils.equals(l1.getLanguage(), l0.getLanguage())
                && StringUtils.equals(l1.getCountry(), l0.getCountry());
    }

    private static Locale getLocal(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return configuration.getLocales().get(0);
        } else {
            return configuration.locale;
        }
    }

    private static void setLocal(Configuration configuration, Locale locale) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            configuration.setLocale(locale);
        } else {
            configuration.locale = locale;
        }
    }
}
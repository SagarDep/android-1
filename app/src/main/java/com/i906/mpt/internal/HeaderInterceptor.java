package com.i906.mpt.internal;

import android.os.Build;

import com.i906.mpt.BuildConfig;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author Noorzaini Ilhami
 */
class HeaderInterceptor implements Interceptor {

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request r = chain.request()
                .newBuilder()
                .removeHeader("User-Agent")
                .addHeader("User-Agent", getDefaultUserAgent(BuildConfig.VERSION_NAME))
                .build();

        return chain.proceed(r);
    }


    private String getDefaultUserAgent(String cversion) {
        StringBuilder result = new StringBuilder(64);

        if (cversion != null) {
            result.append("MalaysiaPrayerTimes/");
            result.append(cversion);
        } else {
            result.append("Dalvik/");
            result.append(System.getProperty("java.vm.version")); // such as 1.1.0
        }

        result.append(" (Linux; U; Android ");

        String version = Build.VERSION.RELEASE; // "1.0" or "3.4b5"
        result.append(version.length() > 0 ? version : "1.0");

        // add the model for the release build
        if ("REL".equals(Build.VERSION.CODENAME)) {
            String model = Build.MODEL;
            if (model.length() > 0) {
                result.append("; ");
                result.append(model);
            }
        }
        String id = Build.ID; // "MASTER" or "M4-rc20"
        if (id.length() > 0) {
            result.append(" Build/");
            result.append(id);
        }
        result.append(")");
        return result.toString();
    }
}

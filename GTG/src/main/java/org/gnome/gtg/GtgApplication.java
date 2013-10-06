package org.gnome.gtg;

import android.app.Application;
import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class GtgApplication extends Application {
    private static RequestQueue mVolleyRequestQueue = null;
    private static Context      mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static RequestQueue getVolleyRequestQueue() {
        if (mVolleyRequestQueue == null) {
            mVolleyRequestQueue = Volley.newRequestQueue(mContext);
            mVolleyRequestQueue.start();
        }
        return mVolleyRequestQueue;
    }

    @Override
    public void onTerminate() {
        mVolleyRequestQueue.stop();
        super.onTerminate();
    }
}

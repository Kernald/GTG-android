package org.gnome.gtg.sync;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.RequestFuture;

import org.gnome.gtg.GtgApplication;
import org.gnome.gtg.sync.methods.Login;

import java.util.concurrent.ExecutionException;

public class GtgOnlineServerAuthenticate implements IServerAuthenticate {
    // TODO: use exception types instead of string constants
    public final static String  INVALID_PASSWORD = "INVALID_PASSWORD";
    public final static String  NET_ERROR = "NET_ERROR";
    private final static String TAG = GtgOnlineServerAuthenticate.class.getSimpleName();

    @Override
    public String userSignUp(String name,
                             String email,
                             String pass,
                             String authType) throws Exception {
        // TODO: sign-up. If success, return auth-token. If fails, throw an exception.
        // Simulate network activity
        Thread.sleep(2000);

        return "authtoken";
    }

    @Override
    public String userSignIn(String user,
                             String pass,
                             String authType) throws Exception {
        // TODO: sign-in. If success, return auth-token. If fails, throw an exception.
        RequestQueue rq = GtgApplication.getVolleyRequestQueue();
        RequestFuture<String> future = RequestFuture.newFuture();
        Login loginRequest = new Login(user, pass, future, future);
        rq.add(loginRequest);

        try {
            String response = future.get();
            if ("1".equals(response))
                return "validtoken";
        } catch (Exception e) {
            throw new Exception(NET_ERROR);
        }
        throw new Exception(INVALID_PASSWORD);
    }
}

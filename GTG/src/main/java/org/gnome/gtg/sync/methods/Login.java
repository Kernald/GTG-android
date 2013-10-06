package org.gnome.gtg.sync.methods;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;

import java.util.HashMap;
import java.util.Map;

import static org.gnome.gtg.sync.AccountGeneral.API_URL;

public class Login extends Request<String> {
    private static final String         API_LOGIN_URL = API_URL + "user/auth/";
    private Map<String, String>         mParams;
    private Response.Listener<String>   mListener;

    public Login(String email, String password, Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(Method.POST, API_LOGIN_URL, errorListener);
        mListener = listener;
        mParams = new HashMap<String, String>();
        mParams.put("email", email);
        mParams.put("password", password);

    }

    @Override
    public Map<String, String> getParams() {
        return mParams;
    }

    @Override
    protected void deliverResponse(String response) {
        mListener.onResponse(response);
    }

    @Override
    protected Response<String> parseNetworkResponse(NetworkResponse response) {
        String string = new String(response.data);
        return Response.success(string, getCacheEntry());
    }
}

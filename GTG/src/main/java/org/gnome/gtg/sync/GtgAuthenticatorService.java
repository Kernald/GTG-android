package org.gnome.gtg.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class GtgAuthenticatorService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return new GtgAuthenticator(this).getIBinder();
    }
}

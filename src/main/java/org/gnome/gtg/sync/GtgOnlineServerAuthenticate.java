package org.gnome.gtg.sync;

public class GtgOnlineServerAuthenticate implements IServerAuthenticate {
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
    public String userSignIn(String user, String pass, String authType) throws Exception {
        // TODO: sign-in. If success, return auth-token. If fails, throw an exception.
        // Simulate network activity
        Thread.sleep(2000);

        //throw new Exception("Wrong login/password");
        return "authtoken";
    }
}

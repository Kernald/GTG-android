package org.gnome.gtg.sync;

public interface IServerAuthenticate {
    public String userSignUp(final String name,
                             final String email,
                             final String pass,
                             String authType) throws Exception;

    public String userSignIn(final String user,
                             final String pass,
                             String authType) throws Exception;
}

package org.gnome.gtg.sync;

public class AccountGeneral {
    // Account type ID
    public static final String  ACCOUNT_TYPE    = "org.gnome.gtg";
    // Account name
    public static final String  ACCOUNT_NAME    = "Getting Things GNOME!";

    // Token types
    // TODO: use strings for labels
    public static final String AUTHTOKEN_TYPE_FULL_ACCESS = "Full access";
    public static final String AUTHTOKEN_TYPE_FULL_ACCESS_LABEL = "Full access to a GTG account";

    public static final IServerAuthenticate sServerAuthenticate = new GtgOnlineServerAuthenticate();

}

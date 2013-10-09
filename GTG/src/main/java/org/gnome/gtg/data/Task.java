package org.gnome.gtg.data;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Task {
    private static final String TAG             = Task.class.getName();
    // Database
    public static final String  TABLE_NAME      = "tasks";
    public static final String  COL_ID          = "_id";
    public static final String  COL_PARENT_ID   = "parent";
    public static final String  COL_NAME        = "name";
    public static final String  COL_DESCRIPTION = "description";
    public static final String  COL_STATUS      = "status";
    public static final String  COL_START_DATE  = "start_date";
    public static final String  COL_DUE_DATE    = "due_date";
    public static final String  COL_CLOSED_DATE = "closed_date";
    public static final String  COL_OWNER       = "owner";

    private static final String DATABASE_CREATE = "create table "
            + TABLE_NAME
            + "("
            + COL_ID + " integer primary key, "
            + COL_PARENT_ID + " integer, "
            + COL_NAME + " text not null, "
            + COL_DESCRIPTION + " text not null, "
            + COL_STATUS + " integer, "
            + COL_START_DATE + " integer, "
            + COL_DUE_DATE + " integer, "
            + COL_CLOSED_DATE + " integer, "
            + COL_OWNER + " text not null, "
            + " FOREIGN KEY (" + COL_PARENT_ID + ") REFERENCES " + TABLE_NAME + " (" + COL_ID + ")"
            + ");";

    public static void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    public static void onUpgrade(SQLiteDatabase database, int oldVersion,
                                 int newVersion) {
        Log.w(TAG, "Upgrading database from version "
                + oldVersion + " to " + newVersion);
    }
}

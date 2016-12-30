package com.lab.ilham.databaseallowsharing;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ILHAM on 07/12/2016.
 */

public class SqlLiteDbHelper extends SQLiteOpenHelper {

    //table name
    public static final String TABLE_NAME = "ANDROID_OS_LIST";

    //table columns
    public static final String _ID = "_id";
    public static final String VERSION_NAME = "version_name";
    public static final String VERSION_NO = "version_no";

    //database information
    static final String DB_NAME = "android_os.db";

    // database version
    static final int DB_VERSION = 1;

    //creating table query
    private static final String CREATE_TABLE = "create table "
            + TABLE_NAME + "(" + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + VERSION_NAME + " TEXT, " + VERSION_NO + " TEXT);";

    public SqlLiteDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("Drop Table if Exist !" + TABLE_NAME);
        onCreate(database);
    }
}

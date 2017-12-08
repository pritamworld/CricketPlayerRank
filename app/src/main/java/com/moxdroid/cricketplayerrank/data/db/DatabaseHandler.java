package com.moxdroid.cricketplayerrank.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


class DatabaseHandler extends SQLiteOpenHelper
{

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "cricket";

    public DatabaseHandler(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String CREATE_PLAYER_TABLE = "CREATE TABLE " + DBPlayer.TABLE_PLAYER + "("
                + DBPlayer.KEY_ID + " INTEGER PRIMARY KEY,"
                + DBPlayer.KEY_PLAYER_NAME + " TEXT,"
                + DBPlayer.KEY_PLAYER_GENDER + " TEXT,"
                + DBPlayer.KEY_PLAYER_BIRTH_DATE + " TEXT,"
                + DBPlayer.KEY_PLAYER_CATEGORY + " TEXT,"
                + DBPlayer.KEY_PLAYER_COUNTRY + " TEXT,"
                + DBPlayer.KEY_NO_OF_TEST_MATCHES + " INTEGER,"
                + DBPlayer.KEY_NO_OF_ONE_DAY_MATCHES + " INTEGER,"
                + DBPlayer.KEY_NO_OF_CATCHES + " INTEGER,"
                + DBPlayer.KEY_NO_OF_RUNS + " INTEGER,"
                + DBPlayer.KEY_NO_OF_WICKETS + " INTEGER,"
                + DBPlayer.KEY_NO_OF_STUMPINGS + " INTEGER,"
                + DBPlayer.KEY_TOTAL_POINTS + " INTEGER"
                + ")";
        db.execSQL(CREATE_PLAYER_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + DBPlayer.TABLE_PLAYER);

        // Create tables again
        onCreate(db);
    }
}

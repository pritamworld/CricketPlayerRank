package com.moxdroid.cricketplayerrank.data.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.moxdroid.cricketplayerrank.data.model.Player;

import java.util.ArrayList;
import java.util.List;

public class DBPlayer
{
    // players table name
    static final String TABLE_PLAYER = "tblPlayer";

    // players Table Columns names
    static final String KEY_ID = "id";
    static final String KEY_PLAYER_NAME = "playerName";
    static final String KEY_PLAYER_GENDER = "gender";
    static final String KEY_PLAYER_BIRTH_DATE = "birthDate";
    static final String KEY_PLAYER_CATEGORY = "playerCategory";
    static final String KEY_PLAYER_COUNTRY = "teamCountry";
    static final String KEY_NO_OF_TEST_MATCHES = "noOfTestMatch";
    static final String KEY_NO_OF_ONE_DAY_MATCHES = "noOfOneDayMatch";
    static final String KEY_NO_OF_CATCHES = "noOfCatches";
    static final String KEY_NO_OF_RUNS = "noOfRuns";
    static final String KEY_NO_OF_WICKETS = "noOfWickets";
    static final String KEY_NO_OF_STUMPINGS = "noOfStumpings";
    static final String KEY_TOTAL_POINTS = "totalPoints";

    private DatabaseHandler databaseHandler;
    private final Context context;

    public DBPlayer(Context context)
    {
        this.context = context;
    }

    // Adding new player
    public void addPlayer(Player player)
    {
        databaseHandler = new DatabaseHandler(context);

        SQLiteDatabase db = databaseHandler.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PLAYER_NAME, player.getPlayerName()); // player Name
        values.put(KEY_PLAYER_GENDER, player.getGender());
        values.put(KEY_PLAYER_BIRTH_DATE, player.getBirthDate());
        values.put(KEY_PLAYER_CATEGORY, player.getPlayerCategory());
        values.put(KEY_PLAYER_COUNTRY, player.getTeamCountry());
        values.put(KEY_NO_OF_TEST_MATCHES, player.getNoOfTestMatch());
        values.put(KEY_NO_OF_ONE_DAY_MATCHES, player.getNoOfOneDayMatch());
        values.put(KEY_NO_OF_CATCHES, player.getNoOfCatches());
        values.put(KEY_NO_OF_RUNS, player.getNoOfRuns());
        values.put(KEY_NO_OF_WICKETS, player.getNoOfWickets());
        values.put(KEY_NO_OF_STUMPINGS, player.getNoOfStumpings());

        player.setTotalPoints(calculateTotalPoints(player));
        values.put(KEY_TOTAL_POINTS, player.getTotalPoints());


        // Inserting Row
        db.insert(TABLE_PLAYER, null, values);
        db.close(); // Closing database connection
    }

    // Getting single player
    public Player getPlayer(int id)
    {
        databaseHandler = new DatabaseHandler(context);
        SQLiteDatabase db = databaseHandler.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PLAYER, null, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        // return player
        return new com.moxdroid.cricketplayerrank.data.model.Player(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                Integer.parseInt(cursor.getString(6)),
                Integer.parseInt(cursor.getString(7)),
                Integer.parseInt(cursor.getString(8)),
                Integer.parseInt(cursor.getString(9)),
                Integer.parseInt(cursor.getString(10)),
                Integer.parseInt(cursor.getString(11)),
                Integer.parseInt(cursor.getString(12))
        );
    }

    // Getting All players
    public List<Player> getAllplayers()
    {
        databaseHandler = new DatabaseHandler(context);
        List<Player> playerList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_PLAYER + " ORDER BY " + KEY_TOTAL_POINTS + " DESC";

        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst())
        {
            do
            {

                Player player = new Player(Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        Integer.parseInt(cursor.getString(6)),
                        Integer.parseInt(cursor.getString(7)),
                        Integer.parseInt(cursor.getString(8)),
                        Integer.parseInt(cursor.getString(9)),
                        Integer.parseInt(cursor.getString(10)),
                        Integer.parseInt(cursor.getString(11)),
                        Integer.parseInt(cursor.getString(12))
                );
                // Adding player to list
                playerList.add(player);
            } while (cursor.moveToNext());
        }

        // return player list
        return playerList;
    }

    // Getting players Count
    public int getPlayersCount()
    {

        databaseHandler = new DatabaseHandler(context);
        String countQuery = "SELECT  * FROM " + TABLE_PLAYER;
        SQLiteDatabase db = databaseHandler.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    // Updating single player
    public int updateplayer(Player player)
    {

        databaseHandler = new DatabaseHandler(context);
        SQLiteDatabase db = databaseHandler.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PLAYER_NAME, player.getPlayerName()); // player Name
        values.put(KEY_PLAYER_GENDER, player.getGender());
        values.put(KEY_PLAYER_BIRTH_DATE, player.getBirthDate());
        values.put(KEY_PLAYER_CATEGORY, player.getPlayerCategory());
        values.put(KEY_PLAYER_COUNTRY, player.getTeamCountry());
        values.put(KEY_NO_OF_TEST_MATCHES, player.getNoOfTestMatch());
        values.put(KEY_NO_OF_ONE_DAY_MATCHES, player.getNoOfOneDayMatch());
        values.put(KEY_NO_OF_CATCHES, player.getNoOfCatches());
        values.put(KEY_NO_OF_RUNS, player.getNoOfRuns());
        values.put(KEY_NO_OF_WICKETS, player.getNoOfWickets());
        values.put(KEY_NO_OF_STUMPINGS, player.getNoOfStumpings());

        player.setTotalPoints(calculateTotalPoints(player));
        values.put(KEY_TOTAL_POINTS, player.getTotalPoints());


        // updating row
        return db.update(TABLE_PLAYER, values, KEY_ID + " = ?",
                new String[]{String.valueOf(player.get_id())});


    }

    // Deleting single player
    public void deletePlayer(Player player)
    {

        databaseHandler = new DatabaseHandler(context);
        SQLiteDatabase db = databaseHandler.getWritableDatabase();
        db.delete(TABLE_PLAYER, KEY_ID + " = ?",
                new String[]{String.valueOf(player.get_id())});
        db.close();
    }

    private int calculateTotalPoints(Player mPlayer)
    {
        int totalPoints = 0;
        totalPoints = totalPoints + mPlayer.getNoOfTestMatch() * 5;
        totalPoints = totalPoints + mPlayer.getNoOfOneDayMatch() * 2;
        totalPoints = totalPoints + mPlayer.getNoOfCatches() * 3;
        totalPoints = totalPoints + mPlayer.getTotalPoints();
        totalPoints = totalPoints + mPlayer.getNoOfWickets() * 5;
        totalPoints = totalPoints + mPlayer.getNoOfStumpings() * 3;

        return totalPoints;
    }
}

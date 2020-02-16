package com.example.energysurvival;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASENAME = "DbPlayer.sqlite";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_PLAYER = "player_table";

    private static final String USERNAME = "username";
    private static final String SCORE1 = "score1";
    private static final String SCORE2 = "score2";
    private static final String SCORE3 = "score3";

    private String TBL_CREATE_PLAYER = "CREATE TABLE " + TABLE_PLAYER + "(" +
            USERNAME + " TEXT PRIMARY KEY," +
            SCORE1 + " INTEGER," + SCORE2 + " INTEGER," + SCORE3 + " INTEGER" + ")";



    public DatabaseHelper(Context context) {
        super(context,DATABASENAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TBL_CREATE_PLAYER);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAYER);
        onCreate(sqLiteDatabase);
    }

    public String registerPlayer(Player p1) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(USERNAME, p1.getUsername());
        values.put(SCORE1,0);
        values.put(SCORE2,0);
        values.put(SCORE3,0);

        // insert row
        db.insert(TABLE_PLAYER, null, values);

        String id = p1.getUsername();

        // assigning tags to tbl create mengambil
        return id;
    }


    public Player getPlayer(String p1) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * FROM " + TABLE_PLAYER + " WHERE "
                + USERNAME + " = " + p1;

        Log.e(DATABASENAME, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null)
            c.moveToFirst();

        Player player = new Player();
        player.setUsername((c.getString(c.getColumnIndex(USERNAME))));

        return player;
    }

    public List<Player> getAllPlayer() {

        List<Player> players = new ArrayList<Player>();

        String selectQuery = " SELECT " + USERNAME + " FROM " + TABLE_PLAYER;
        Log.e(DATABASENAME, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {

            do {
                Player std = new Player();
                std.setUsername((c.getString(c.getColumnIndex(USERNAME))));
                players.add(std);

            } while (c.moveToNext());
        }

        if (c != null)
            c.moveToFirst();

        return players;
    }

    public int setScore1(String username, int score1 ){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SCORE1, score1);


        // updating row
        return db.update(TABLE_PLAYER, values, USERNAME + " = ?",
                new String[] { String.valueOf(username) });
    }

    public int setScore2(String username, int score2 ){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SCORE2, score2);


        // updating row
        return db.update(TABLE_PLAYER, values, USERNAME + " = ?",
                new String[] { String.valueOf(username) });

    }

    public int setScore3(String username, int score3 ){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SCORE2, score3);


        // updating row
        return db.update(TABLE_PLAYER, values, USERNAME + " = ?",
                new String[] { String.valueOf(username) });

    }



}

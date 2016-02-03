package com.example.suvp.test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by suvp on 1/8/2016.
 */
public class DbHelper extends SQLiteOpenHelper
{

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    private static final String LOG = "DB Helper";

    // Database Name
    private static final String DATABASE_NAME = "shopDatabase.db";

    // Product table name
    public static final String TABLE_PRODUCTS = "products1";

    // Contacts Table Columns names
    public static final String KEY_NAME = "name";
    public static final String KEY_HP = "hp";
    public static final String KEY_TYPE = "type";

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        Log.v(LOG, "OnCreate-> Creating the schema");
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_PRODUCTS + "("
                + KEY_NAME + " TEXT," + KEY_HP + " FLOAT,"
                + KEY_TYPE + " TEXT, " + "keyCoulumn"+ " INTEGER PRIMARY KEY AUTOINCREMENT " +  ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
        Log.v(LOG, "OnCreate<- Creating the schema");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        // Create tables again
        onCreate(db);
    }
}

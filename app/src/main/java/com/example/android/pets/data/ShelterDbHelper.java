package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.pets.data.ShelterContract.PetEntry;

/**
 * Created by manoj on 1/6/2017.
 */

public class ShelterDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "shelter.db";
    public static final int DATABASE_VERSION = 1;


    public ShelterDbHelper(Context context){
        super(context,DATABASE_NAME, null ,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // CREATE TABLE
       String str_CREATE_PETS_TABLE = "CREATE TABLE " + PetEntry.TABLE_NAME +"("
                + PetEntry._ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PetEntry.COLUMN_NAME+" TEXT NOT NULL, "
                + PetEntry.COLUMN_BREED + " TEXT, "
                + PetEntry.COLUMN_GENDER + " INTEGER NOT NULL, "
                + PetEntry.COLUMN_WEIGHT + " INTEGER NOT NULL DEFAULT 0);";

        db.execSQL(str_CREATE_PETS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}

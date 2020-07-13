package com.example.databaseappv2;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper implements BaseColumns {

    private static final String DATABASE_NAME = "mydatabase.db";
    private static final int DATABASE_VERSION = 7;
    private static final String DATABASE_TABLE = "cats";
    public static final String CAT_NAME_COLUMN = "cat_name";
    public static final String WEIGHT_COLUMN = "weight";
    public static final String AGE_COLUMN = "age";
    public static final String HEIGHT_COLUMN = "height";

    private static final String DATABASE_CREATE_SCRIPT = "create table "
            + DATABASE_TABLE + " (" + BaseColumns._ID
            + " integer primary key autoincrement," + CAT_NAME_COLUMN
            + " text not null," + WEIGHT_COLUMN + " integer," + AGE_COLUMN
            + " integer," + HEIGHT_COLUMN + " integer);";


    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                          int version){
        super(context,name,factory,version);
    }

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                          int version, DatabaseErrorHandler errorHandler){
        super(context,name,factory,version,errorHandler);
    }
    DataBaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_SCRIPT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w("SQLite","Обновляемся с версии " + oldVersion + " на новую " + newVersion);
        db.execSQL("DROP TABLE IF IT EXISTS" + DATABASE_TABLE);
        onCreate(db);

    }
}

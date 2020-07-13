package com.example.databaseappv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Random;

import static com.example.databaseappv2.DataBaseHelper.AGE_COLUMN;
import static com.example.databaseappv2.DataBaseHelper.HEIGHT_COLUMN;

public class MainActivity extends AppCompatActivity {

    private DataBaseHelper mDatabaseHelper;
    private SQLiteDatabase mSqLiteDatabase;
    private static final int COUNT_OF_STUDENTS = 15;

    public void onClick(View v){

        mDatabaseHelper = new DataBaseHelper(this,"mydatabase.db",null,7);


        TableLayout tl;
        tl = (TableLayout) findViewById(R.id.tb_v);
        int i = 0;

        Cursor query = mSqLiteDatabase.rawQuery("SELECT * FROM cats ORDER BY "+ AGE_COLUMN +";", null);

        if(query.moveToFirst()){
            do{
                i++;

                TableRow tr = new TableRow(this);
                tr.setId(i);
                tr.setBackgroundResource(R.color.bg);
                tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

                //TEXTVIEWS********
                TextView tv1 = new TextView(this);
                tv1.setText(query.getString(1));
                tv1.setId(i);
                tv1.setTextColor(Color.BLACK);
                tv1.setTextSize(20);
                tv1.setPadding(5, 5, 5, 5);
                tr.addView(tv1);

                TextView tv2 = new TextView(this);
                tv2.setText(query.getInt(2)+"             ");
                tv2.setId(i+i);
                tv2.setTextColor(Color.BLACK);
                tv2.setTextSize(20);
                tv2.setPadding(5, 5, 5, 5);
                tr.addView(tv2);

                TextView tv3 = new TextView(this);
                tv3.setText(query.getInt(3)+"             ");
                tv3.setId(i+i+i);
                tv3.setTextColor(Color.BLACK);
                tv3.setTextSize(20);
                tv3.setPadding(5, 5, 5, 5);
                tr.addView(tv3);

                TextView tv4 = new TextView(this);
                tv4.setText(query.getInt(4)+" ");
                tv4.setId(i+i+i+i);
                tv4.setTextColor(Color.BLACK);
                tv4.setTextSize(20);
                tv4.setPadding(5, 5, 5, 5);
                tr.addView(tv4);

                tl.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));

            }
            while(query.moveToNext());
        }
        query.close();
        mSqLiteDatabase.close();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        int w = 0;
        int h = 0;
        int a = 0;
        int n = 0;

        Random rnd = new Random(System.currentTimeMillis());

        mDatabaseHelper = new DataBaseHelper(this, "mydatabase.db", null, 7);

        mSqLiteDatabase = mDatabaseHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        for (int i = 0; i < COUNT_OF_STUDENTS; i++) {

            w = 50 + rnd.nextInt(100 - 50 + 1);
            h = 150 + rnd.nextInt(200 - 150 + 1);
            a = 17 + rnd.nextInt(25 - 17 + 1);
            n = 0 + rnd.nextInt(10 - 0 + 1);

            switch (n){
                case 0 :
                    values.put(DataBaseHelper.CAT_NAME_COLUMN, "Олег");
                    values.put(DataBaseHelper.WEIGHT_COLUMN, w);
                    values.put(DataBaseHelper.AGE_COLUMN, a);
                    values.put(DataBaseHelper.HEIGHT_COLUMN, h);
                    // Вставляем данные в таблицу
                    mSqLiteDatabase.insert("cats", null, values);
                    break;
                case 1 :
                    values.put(DataBaseHelper.CAT_NAME_COLUMN, "Мария");
                    values.put(DataBaseHelper.WEIGHT_COLUMN, w);
                    values.put(DataBaseHelper.AGE_COLUMN, a);
                    values.put(DataBaseHelper.HEIGHT_COLUMN, h);
                    // Вставляем данные в таблицу
                    mSqLiteDatabase.insert("cats", null, values);
                    break;
                case 2 :
                    values.put(DataBaseHelper.CAT_NAME_COLUMN, "Петр");
                    values.put(DataBaseHelper.WEIGHT_COLUMN, w);
                    values.put(DataBaseHelper.AGE_COLUMN, a);
                    values.put(DataBaseHelper.HEIGHT_COLUMN, h);
                    // Вставляем данные в таблицу
                    mSqLiteDatabase.insert("cats", null, values);
                    break;
                case 3 :
                    values.put(DataBaseHelper.CAT_NAME_COLUMN, "Иван");
                    values.put(DataBaseHelper.WEIGHT_COLUMN, w);
                    values.put(DataBaseHelper.AGE_COLUMN, a);
                    values.put(DataBaseHelper.HEIGHT_COLUMN, h);
                    // Вставляем данные в таблицу
                    mSqLiteDatabase.insert("cats", null, values);
                    break;
                case 4 :
                    values.put(DataBaseHelper.CAT_NAME_COLUMN, "Ольга");
                    values.put(DataBaseHelper.WEIGHT_COLUMN, w);
                    values.put(DataBaseHelper.AGE_COLUMN, a);
                    values.put(DataBaseHelper.HEIGHT_COLUMN, h);
                    // Вставляем данные в таблицу
                    mSqLiteDatabase.insert("cats", null, values);
                    break;
                case 5 :
                    values.put(DataBaseHelper.CAT_NAME_COLUMN, "Владислав");
                    values.put(DataBaseHelper.WEIGHT_COLUMN, w);
                    values.put(DataBaseHelper.AGE_COLUMN, a);
                    values.put(DataBaseHelper.HEIGHT_COLUMN, h);
                    // Вставляем данные в таблицу
                    mSqLiteDatabase.insert("cats", null, values);
                    break;
                case 6 :
                    values.put(DataBaseHelper.CAT_NAME_COLUMN, "Ирина");
                    values.put(DataBaseHelper.WEIGHT_COLUMN, w);
                    values.put(DataBaseHelper.AGE_COLUMN, a);
                    values.put(DataBaseHelper.HEIGHT_COLUMN, h);
                    // Вставляем данные в таблицу
                    mSqLiteDatabase.insert("cats", null, values);
                    break;
                case 7 :
                    values.put(DataBaseHelper.CAT_NAME_COLUMN, "Кирилл");
                    values.put(DataBaseHelper.WEIGHT_COLUMN, w);
                    values.put(DataBaseHelper.AGE_COLUMN, a);
                    values.put(DataBaseHelper.HEIGHT_COLUMN, h);
                    // Вставляем данные в таблицу
                    mSqLiteDatabase.insert("cats", null, values);
                    break;
                case 8 :
                    values.put(DataBaseHelper.CAT_NAME_COLUMN, "Светлана");
                    values.put(DataBaseHelper.WEIGHT_COLUMN, w);
                    values.put(DataBaseHelper.AGE_COLUMN, a);
                    values.put(DataBaseHelper.HEIGHT_COLUMN, h);
                    // Вставляем данные в таблицу
                    mSqLiteDatabase.insert("cats", null, values);
                    break;
                case 9 :
                    values.put(DataBaseHelper.CAT_NAME_COLUMN, "Евгений");
                    values.put(DataBaseHelper.WEIGHT_COLUMN, w);
                    values.put(DataBaseHelper.AGE_COLUMN, a);
                    values.put(DataBaseHelper.HEIGHT_COLUMN, h);
                    // Вставляем данные в таблицу
                    mSqLiteDatabase.insert("cats", null, values);
                    break;
                case 10 :
                    values.put(DataBaseHelper.CAT_NAME_COLUMN, "Александр");
                    values.put(DataBaseHelper.WEIGHT_COLUMN, w);
                    values.put(DataBaseHelper.AGE_COLUMN, a);
                    values.put(DataBaseHelper.HEIGHT_COLUMN, h);
                    // Вставляем данные в таблицу
                    mSqLiteDatabase.insert("cats", null, values);
                    break;
            }
        }
    }
}

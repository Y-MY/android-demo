package com.example.demo.six;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public static final String CREATE_BOOK = "CREATE table book(\n" +
            "\tid integer PRIMARY key AUTOINCREMENT,\n" +
            "\tauthor text,\n" +
            "\tprice real,\n" +
            "\tpages integer,\n" +
            "\tname text,\n" +
            "\tremark blob\n" +
            ")";

    public static final String CREATE_CATEGORY="CREATE table Category(\n" +
            "\tid integer PRIMARY key AUTOINCREMENT,\n" +
            "\tcategory_name text,\n" +
            "\tcategory_code integer\n" +
            ")";

    private Context mContext;

    public MyDatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_BOOK);
        sqLiteDatabase.execSQL(CREATE_CATEGORY);
        Toast.makeText(mContext,"Create succeeded",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists book ");
        sqLiteDatabase.execSQL("drop table if exists Category ");
        onCreate(sqLiteDatabase);

    }
}

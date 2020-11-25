package com.example.demo.six;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.demo.R;

public class SQLiteActivity extends AppCompatActivity {

    private static final String TAG = "SQLiteActivity";

    private MyDatabaseHelper myDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity6_sqlite);

        myDatabaseHelper = new MyDatabaseHelper(this,"BookStore.db",null,2);

        Button buttonCreate = (Button) findViewById(R.id.sqlite_create);
        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDatabaseHelper.getWritableDatabase();
            }
        });



        Button buttonAdd = (Button) findViewById(R.id.sqlite_add);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                //开始组装第一条数据
                values.put("name", "The Da Vinci Code");
                values.put("author", "Dan Brown");
                values.put("pages", 454);
                values.put("price", 16.96);
                db.insert("book",null,values);

                //开始组装第二条数据
                values.put("name", "The Lost Symbol");
                values.put("author", "Dan Brown");
                values.put("pages", 510);
                values.put("price", 19.95);
                db.insert("Book",null,values);
            }
        });

        Button buttonUpdate = (Button) findViewById(R.id.sqlite_update);
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("price", 520);
                db.update("BOOK",values,"name=?",new String[]{"The Da Vinci Code"});
            }
        });

        Button buttonDelete = (Button) findViewById(R.id.sqlite_delete);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("price", 520);
                db.delete("BOOK","pages>?",new String[]{"500"});
            }
        });

        Button buttonQuery = (Button) findViewById(R.id.sqlite_query);
        buttonQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = myDatabaseHelper.getWritableDatabase();
                Cursor cursor = db.query("BOOK",null,null,null,null,null,null);
                if (cursor.moveToFirst()){
                    do{
                        //遍历cursor对象，取出数据并打印
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));

                        Log.i(TAG, "name is  " + name);
                        Log.i(TAG, "author is  " + author);
                        Log.i(TAG, "pages is  " + pages);
                        Log.i(TAG, "price is  " + price);
                    }while (cursor.moveToNext());
                }
                cursor.close();
            }
        });



    }
}
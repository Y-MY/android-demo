package com.example.demo.six;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.VO.Book;
import com.example.demo.R;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class LitePalActivity extends AppCompatActivity {

    private static final String TAG = "LitePalActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity6_litepal);

        Button buttonLitePalCreate = (Button) findViewById(R.id.litepal_create);
        buttonLitePalCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Connector.getDatabase();
            }
        });

        Button buttonLitPalAdd = (Button) findViewById(R.id.litepal_add);
        buttonLitPalAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = new Book();
                book.setName("The Da Vinci Code");
                book.setAuthor("Dan Brown");
                book.setPages(454);
                book.setPrice(16.96);
                book.setPress("Unknow");
                book.save();


            }
        });

        Button buttonLitePalUpdate = (Button) findViewById(R.id.litepal_update);


        buttonLitePalUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  Book book = new Book();
                book.setName("The Lost Symbol");
                book.setAuthor("Dan Brown");
                book.setPages(510);
                book.setPrice(19.95);
                book.setPress("Unknow");
                book.save();
                book.setPrice(20.95);
                book.save();*/
                Book book = new Book();
                book.setPages(500);
                book.setPress("Anchor");
                book.updateAll("name=? and author=?", "The Lost Symbol", "Dan Brown");

            }
        });

        Button buttonLitePalSetDefault = (Button) findViewById(R.id.litepal_setDefault);
        buttonLitePalSetDefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = new Book();
                book.setToDefault("pages");
                book.updateAll();
            }
        });

        Button buttonLitePalDelete = (Button) findViewById(R.id.litepal_delete);
        buttonLitePalDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataSupport.deleteAll(Book.class, "price<?", "15");
            }
        });

        Button buttonLitePalQuery = (Button) findViewById(R.id.litepal_query);
        buttonLitePalQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 //List<Book> books = DataSupport.findAll(Book.class);
                List<Book> books = DataSupport.select("name", "author", "press")
                        .where("pages>?", "400")
                        .order("pages")
                        .limit(10)
                        .find(Book.class);
                for (Book book : books) {
                    Log.i(TAG, "book name is  " + book.getName());
                    Log.i(TAG, "book author is  " + book.getAuthor());
                    Log.i(TAG, "book press is  " + book.getPages());
                }
            }
        });


    }
}
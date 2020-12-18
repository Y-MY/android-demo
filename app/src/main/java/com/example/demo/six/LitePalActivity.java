package com.example.demo.six;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.demo.VO.Book;
import com.example.demo.R;
import com.example.demo.model.Comment;
import com.example.demo.model.News;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.Date;
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
               /* Book book = new Book();
                book.setName("The Da Vinci Code");
                book.setAuthor("Dan Brown");
                book.setPages(454);
                book.setPrice(16.96);
                book.setPress("Unknow");
                book.save();*/
/*
                News news = new News();
                news.setTitle("这是一条新闻标题");
                news.setContent("这是一条新闻内容");
                news.setPublishDate(new Date());

                Log.i(TAG, "news id is " + news.getId());
                if (news.save()) {
                    Log.i(TAG, "news id is " + news.getId());
                    Toast.makeText(LitePalActivity.this, "存储成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LitePalActivity.this, "存储失败", Toast.LENGTH_SHORT).show();
                }*/
                //news.saveThrows();

                Comment comment1 = new Comment();
                comment1.setContent("好评！");
                comment1.setPublishDate(new Date());
                comment1.save();
                Comment comment2 = new Comment();
                comment2.setContent("赞一个");
                comment2.setPublishDate(new Date());
                comment2.save();
                News news = new News();
                news.getCommentList().add(comment1);
                news.getCommentList().add(comment2);
                news.setTitle("第二条新闻标题");
                news.setContent("第二条新闻内容");
                news.setPublishDate(new Date());
                news.setCommentCount(news.getCommentList().size());
                news.save();

                //DataSupport.saveAll(newsList);
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

                /*Book book = new Book();
                book.setPages(500);
                book.setPress("Anchor");
                book.updateAll("name=? and author=?", "The Lost Symbol", "Dan Brown");*/

                ContentValues values = new ContentValues();
                values.put("title", "今日iPhone6发布");
                DataSupport.update(News.class, values, 2);

                News updateNews = new News();
                updateNews.setTitle("今日iPhone6发布");
                updateNews.update(2);

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
                //DataSupport.delete(News.class, 2);
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
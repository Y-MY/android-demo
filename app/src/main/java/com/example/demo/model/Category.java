package com.example.demo.model;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class Category extends DataSupport {

    private int id;

    private String name;

    private List<News> newsList = new ArrayList<News>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }
}

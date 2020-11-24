package com.example.demo.three;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.VO.Fruit;
import com.example.adapter.FruitRecyclerAdapter;
import com.example.demo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecyclerViewActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3_recycler_view);

        initFruits();

        /*RecyclerView recyclerView = (RecyclerView)  findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager =new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        FruitRecyclerAdapter  fruitRecyclerAdapter = new FruitRecyclerAdapter(fruitList);
        recyclerView.setAdapter(fruitRecyclerAdapter);*/

        //横向滚动
        /*RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);*/

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        FruitRecyclerAdapter fruitRecyclerAdapter = new FruitRecyclerAdapter(fruitList);
        recyclerView.setAdapter(fruitRecyclerAdapter);

    }

    private void initFruits() {
        for (int i = 0; i < 2; i++) {
            Fruit apple = new Fruit(getRandomLengthName("Apple"), R.drawable.apple);
            fruitList.add(apple);
            Fruit strawberry = new Fruit(getRandomLengthName("strawberry"), R.drawable.strawberry);
            fruitList.add(strawberry);
            Fruit orange = new Fruit(getRandomLengthName("orange"), R.drawable.orange);
            fruitList.add(orange);
            Fruit lemon = new Fruit(getRandomLengthName("lemon"), R.drawable.lemon);
            fruitList.add(lemon);
            Fruit grape = new Fruit(getRandomLengthName("grape"), R.drawable.grape);
            fruitList.add(grape);
            Fruit hawthorn = new Fruit(getRandomLengthName("hawthorn"), R.drawable.hawthorn);
            fruitList.add(hawthorn);

            Fruit cherry = new Fruit(getRandomLengthName("cherry"), R.drawable.cherry);
            fruitList.add(cherry);

            Fruit avocado = new Fruit(getRandomLengthName("avocado"), R.drawable.avocado);
            fruitList.add(avocado);

            Fruit watermelon = new Fruit(getRandomLengthName("watermelon"), R.drawable.watermelon);
            fruitList.add(watermelon);

            Fruit banana = new Fruit(getRandomLengthName("banana"), R.drawable.banana);
            fruitList.add(banana);
        }
    }

    private String getRandomLengthName(String name) {
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(name);
        }
        return builder.toString();
    }
}

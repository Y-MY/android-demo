package com.example.demo.three;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.demo.VO.Fruit;
import com.example.demo.adapter.FruitAdapter;
import com.example.demo.R;

import java.util.ArrayList;
import java.util.List;

public class ListviewActivity extends AppCompatActivity {

    /*private String[] data = {
            "apple", "banana", "orange", "watermelon", "pear", "grape", "pineapple", "strawberry", "cherry", "mango",
            "apple", "banana", "orange", "watermelon", "pear", "grape", "pineapple", "strawberry", "cherry", "mango"
    };*/

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3_listview);

       /* ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(ListviewActivity.this, android.R.layout.simple_expandable_list_item_1, data);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(arrayAdapter);*/

        initFruits();

        FruitAdapter fruitAdapter = new FruitAdapter(ListviewActivity.this,R.layout.activity3_fruit_item,fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(fruitAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(ListviewActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruits() {
        for (int i = 0; i < 2; i++) {
            Fruit apple = new Fruit("Apple", R.drawable.apple);
            fruitList.add(apple);
            Fruit strawberry = new Fruit("strawberry", R.drawable.strawberry);
            fruitList.add(strawberry);
            Fruit orange = new Fruit("orange", R.drawable.orange);
            fruitList.add(orange);
            Fruit lemon = new Fruit("lemon", R.drawable.lemon);
            fruitList.add(lemon);
            Fruit grape = new Fruit("grape", R.drawable.grape);
            fruitList.add(grape);
            Fruit hawthorn = new Fruit("hawthorn", R.drawable.hawthorn);
            fruitList.add(hawthorn);

            Fruit cherry = new Fruit("cherry", R.drawable.cherry);
            fruitList.add(cherry);

            Fruit avocado = new Fruit("avocado", R.drawable.avocado);
            fruitList.add(avocado);

            Fruit watermelon = new Fruit("watermelon", R.drawable.watermelon);
            fruitList.add(watermelon);

            Fruit banana = new Fruit("banana", R.drawable.banana);
            fruitList.add(banana);
        }
    }
}

package com.example.rjkyrobe.testing3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private List<Map<String, Object>> listItems;
    private String[] names = new String[]
            {"Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant"};
    private int[] imageIds = new int[]
            {R.drawable.lion, R.drawable.tiger, R.drawable.monkey,
                    R.drawable.dog, R.drawable.cat, R.drawable.elephant};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.setTitle("ListView");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainui);
        listItems = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> listItem = new HashMap<String, Object>();
            listItem.put("animalName", names[i]);
            listItem.put("image", imageIds[i]);
            listItems.add(listItem);
        }
        // 创建一个SimpleAdapter
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, listItems,
                R.layout.animals_layout,
                new String[]{"animalName", "image"},
                new int[]{R.id.animals_name, R.id.animals_image});
//        initAnimals();
//        AnimalsAdapter adapter = new AnimalsAdapter(AnimalsActivity.this,R.layout.animals_layout,animalsList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, names[position], Toast.LENGTH_SHORT).show();
//                Animals animals = (Animals) listItems.get(position);
//                Toast.makeText(AnimalsActivity.this,animals.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}

package com.example.rjkyrobe.testing3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    public static final String TAG = "lifecycle";
    float size[] = {40, 50, 60};
    String color[] = {"red", "black"};
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        Log.d(TAG, "oncreate");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        textView = findViewById(R.id.textView);
        switch (item.getItemId()) {
            case R.id.item_1:
                textView.setTextSize(size[0]);
                return true;
            case R.id.item_2:
                textView.setTextSize(size[1]);
                return true;
            case R.id.item_3:
                textView.setTextSize(size[2]);
                return true;
            case R.id.item2:
                Toast.makeText(this, textView.getText(), Toast.LENGTH_SHORT).show();
            case R.id.item3_1:
                textView.setTextColor(getResources().getColor(R.color.colorPrimary));
                return true;
            case R.id.item3_2:
                textView.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
                return true;
        }
        return true;
    }
}


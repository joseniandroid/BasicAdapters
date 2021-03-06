package com.training.android.basicadapters;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.training.android.basicadapters.activities.CustomGridActivity;
import com.training.android.basicadapters.activities.CustomListActivity;
import com.training.android.basicadapters.activities.SimpleAdapterActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private String[] mTopics = {
            "Simple Adapter",
            "ListView with Custom Adapter",
            "GridView with Custom Adapter"};

    private Class[] mClasses = {
            SimpleAdapterActivity.class,
            CustomListActivity.class,
            CustomGridActivity.class
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, mTopics);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Intent intent = new Intent(this, mClasses[position]);
        startActivity(intent);
    }
}

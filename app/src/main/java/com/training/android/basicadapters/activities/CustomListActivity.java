package com.training.android.basicadapters.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;

import com.training.android.basicadapters.R;
import com.training.android.basicadapters.adapters.MoviesAdapter;
import com.training.android.basicadapters.controllers.MoviesController;

public class CustomListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        initToolbar();

        ListView listView = (ListView) findViewById(R.id.listView);
        MoviesController controller = new MoviesController();
        MoviesAdapter adapter = new MoviesAdapter(this, R.layout.list_item_movie,
                controller.getMovies());
        listView.setAdapter(adapter);
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}

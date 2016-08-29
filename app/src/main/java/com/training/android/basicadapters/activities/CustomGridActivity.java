package com.training.android.basicadapters.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.GridView;

import com.training.android.basicadapters.R;
import com.training.android.basicadapters.adapters.MoviesAdapter;
import com.training.android.basicadapters.controllers.MoviesController;

public class CustomGridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_grid);

        initToolbar();

        GridView gridView = (GridView) findViewById(R.id.gridView);
        MoviesController controller = new MoviesController();
        MoviesAdapter adapter = new MoviesAdapter(this,
                R.layout.grid_item_movie, controller.getMovies());
        gridView.setAdapter(adapter);
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}

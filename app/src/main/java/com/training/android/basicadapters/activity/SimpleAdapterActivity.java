package com.training.android.basicadapters.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.training.android.basicadapters.R;

import java.util.ArrayList;

public class SimpleAdapterActivity extends AppCompatActivity implements
        AdapterView.OnItemClickListener, View.OnClickListener {

    private ArrayAdapter<String> mAdapter;
    private EditText             mEtInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);

        initToolbar();

        mEtInput = (EditText) findViewById(R.id.etInput);
        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        ListView listView = (ListView) findViewById(R.id.listView);

        mAdapter = new ArrayAdapter<>(
                this,                                   // context
                android.R.layout.simple_list_item_1,    // layout resource
                new ArrayList<String>());               // datasource

        listView.setAdapter(mAdapter);

        // Set listeners
        btnAdd.setOnClickListener(this);
        listView.setOnItemClickListener(this);
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View view) {
        // Once the button add is clicked, we add the text data into the list
        String data = mEtInput.getText().toString();
        if (TextUtils.isEmpty(data)) {
            Toast.makeText(SimpleAdapterActivity.this, R.string.input_data_to_list,
                    Toast.LENGTH_SHORT).show();
            return;
        }

        mAdapter.add(data);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        // Once list item is clicked, we are going to remove it from the list
        String data = mAdapter.getItem(position);
        mAdapter.remove(data);
    }
}

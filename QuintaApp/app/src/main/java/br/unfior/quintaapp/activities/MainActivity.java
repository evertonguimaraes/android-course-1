package br.unfior.quintaapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import br.unfior.quintaapp.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCategory = (RecyclerView) findViewById(R.id.main_recyclerview_category);
        mCategory.setLayoutManager(new LinearLayoutManager(this));
        //mCategory.setAdapter();


    }
}

package br.unifor.sextaapp.activities;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import br.unifor.sextaapp.R;

public class MainActivityLayout extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        Intent intent = null;
        switch (item.getItemId()){
            case R.id.item_create_courses:
                intent = new Intent(MainActivityLayout.this, NewCourseScreen.class);
                startActivity(intent);
                break;

            case R.id.item_list_courses:
                intent = new Intent(MainActivityLayout.this, CourseListScreen.class);
                startActivity(intent);
                break;
        }

        return false;
    }
}

package br.unifor.sextaapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import br.unifor.sextaapp.R;
import br.unifor.sextaapp.adapter.ListCoursesAdapter;
import br.unifor.sextaapp.dao.CourseDAO;
import br.unifor.sextaapp.model.Course;

public class CourseListScreen extends AppCompatActivity {


    private List<Course> mCourseList;

    private ListView mListViewCourses;

    private ArrayAdapter<Course> adapter;

    //private ListCoursesAdapter adapter;

     private int adapterLayout = android.R.layout.simple_list_item_1;

    private CourseDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_screen_layout);

        mListViewCourses = (ListView) findViewById(R.id.listViewCourses);
        dao = new CourseDAO(this);
        mCourseList = dao.findAllCourses();
        adapter = new ArrayAdapter<>(this, adapterLayout, mCourseList);
        //adapter = new ListCoursesAdapter(this, mCourseList);
        mListViewCourses.setAdapter(adapter);
    }
}


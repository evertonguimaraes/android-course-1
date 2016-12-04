package br.unifor.sextaapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.unifor.sextaapp.R;
import br.unifor.sextaapp.dao.CourseDAO;
import br.unifor.sextaapp.dao.GenericDAO;
import br.unifor.sextaapp.model.Course;

public class NewCourseScreen extends AppCompatActivity implements View.OnClickListener{

    private EditText mEditTextName;
    private EditText mEditTextWorkingPlan;
    private EditText mEditTextCourseHours;
    private EditText mEditTextWorkShift;

    private Button mButtonInsert;
    private Button mButtonClean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_course_screen_layout);

        mEditTextName = (EditText) findViewById(R.id.editTextName);
        mEditTextWorkingPlan = (EditText) findViewById(R.id.editTextWorkingPlan);
        mEditTextCourseHours = (EditText) findViewById(R.id.editTextCourseHours);
        mEditTextWorkShift = (EditText) findViewById(R.id.editTextWorkingShift);

        mButtonInsert = (Button) findViewById(R.id.buttonNewCourseInsert);
        mButtonClean = (Button) findViewById(R.id.buttonNewCourseClean);

        mButtonInsert.setOnClickListener(this);
        mButtonClean.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.buttonNewCourseInsert:
                CourseDAO dao = new CourseDAO(this);
                Course course = new Course(
                        mEditTextName.getText().toString(),
                        mEditTextWorkingPlan.getText().toString(),
                        mEditTextCourseHours.getText().toString(),
                        mEditTextWorkShift.getText().toString()
                );
                dao.insert(course);


                break;

            case R.id.buttonNewCourseClean:
                mEditTextName.setText("");
                mEditTextWorkingPlan.setText("");
                mEditTextCourseHours.setText("");
                mEditTextWorkShift.setText("");
                break;
        }
    }
}

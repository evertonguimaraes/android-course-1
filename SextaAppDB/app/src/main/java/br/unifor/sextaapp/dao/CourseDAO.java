package br.unifor.sextaapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.unifor.sextaapp.model.Course;

/**
 * Created by Everton on 12/3/16.
 */

public class CourseDAO extends GenericDAO<Course> {

    public CourseDAO(Context context) {
        super(context);
    }

    @Override
    public ContentValues getContentValues(Course obj) {
        ContentValues contentValues = new ContentValues();

        contentValues.put("id", obj.getId());
        contentValues.put("name", obj.getName());
        contentValues.put("working_plan", obj.getWorkingPlan());
        contentValues.put("course_hours", obj.getCourseHours());
        contentValues.put("work_shift", obj.getWorkShift());;

        return contentValues;
    }
}

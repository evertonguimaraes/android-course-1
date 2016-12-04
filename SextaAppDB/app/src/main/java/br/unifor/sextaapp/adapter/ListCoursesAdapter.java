package br.unifor.sextaapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.unifor.sextaapp.R;
import br.unifor.sextaapp.model.Course;

/**
 * Created by Everton on 12/2/16.
 */

public class ListCoursesAdapter extends BaseAdapter {

    private Context mContext;

    private List<Course> mCourseList;

    private LayoutInflater layoutInflater;

    public ListCoursesAdapter(Context mContext, List<Course> courseList) {
        this.mContext = mContext;
        this.mCourseList = courseList;
        this.layoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {

        return mCourseList.size();
    }

    @Override
    public Object getItem(int position) {
        return mCourseList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return mCourseList.get(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View v = layoutInflater.inflate(R.layout.first_screen_listview_item, null);

        TextView textViewName = (TextView) v.findViewById(R.id.textView_course_name);
        TextView textViewHours = (TextView) v.findViewById(R.id.textView_course_hours);
        TextView textViewWorkingShift = (TextView) v.findViewById(R.id.textView_work_shift);

        textViewName.setText("Name: "+mCourseList.get(position).getName());
        textViewHours.setText("Course Hours: "+mCourseList.get(position).getCourseHours());
        textViewWorkingShift.setText("Shift: "+mCourseList.get(position).getWorkShift());

        return v;
    }
}

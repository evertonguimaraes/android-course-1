package br.unifor.sextaapp.model;

import java.io.Serializable;

/**
 * Created by Everton on 12/2/16.
 */

public class Course implements IModel, Serializable{

    private Long id;
    private String name;
    private String workingPlan;
    private String courseHours;
    private String workShift;

    public Course(){

    }

    public Course(Long id, String name, String workingPlan, String courseHours, String workShift) {
        this.id = id;
        this.name = name;
        this.workingPlan = workingPlan;
        this.courseHours = courseHours;
        this.workShift = workShift;
    }

    public Course(String name, String workingPlan, String courseHours, String workShift) {
        this.name = name;
        this.workingPlan = workingPlan;
        this.courseHours = courseHours;
        this.workShift = workShift;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkingPlan() {
        return workingPlan;
    }

    public void setWorkingPlan(String workingPlan) {
        this.workingPlan = workingPlan;
    }

    public String getCourseHours() {
        return courseHours;
    }

    public void setCourseHours(String courseHours) {
        this.courseHours = courseHours;
    }

    public String getWorkShift() {
        return workShift;
    }

    public void setWorkShift(String workShift) {
        this.workShift = workShift;
    }

    @Override
    public String toString() {
        return this.name + "(Hours: " + this.courseHours+")";
    }
}

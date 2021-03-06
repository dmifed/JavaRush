package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Student extends UniversityPerson{
    private int course;
    private double averageGrade;
    //private String university;
    private Date beginningOfSession;
    private Date endOfSession;

    public Student(String name, int age, double averageGrade) {
        super(name, age);
        this.averageGrade = averageGrade;
    }

    public void live() {
        learn();
    }

    public void learn() {    }

    public void incAverageGrade(double delta){
        setAverageGrade(getAverageGrade()+delta);
    }

    public int getCourse() {        return course;    }

    //setCourse и setAverageGrade.

    public void setCourse(int value){
        course = value;
        return;
    }

    public void setAverageGrade (double value){
        averageGrade = value;
        return;
    }

    public void setBeginningOfSession(Date date) {
        beginningOfSession = date;
    }

    public void setEndOfSession(Date date) {
        endOfSession = date;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    @Override
    public String getPosition(){return "Студент";}
}
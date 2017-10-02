package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Student> students = new ArrayList<Student>();
    private String name;
    private int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public List<Student> getStudents() {        return students;    }

    public void setStudents(List<Student> students) {        this.students = students;    }

    public String getName() {        return name;    }

    public void setName(String name) {        this.name = name;    }

    public int getAge() {        return age;    }

    public void setAge(int age) {        this.age = age;    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for(int i = 0; i<students.size(); i++){
            if(students.get(i).getAverageGrade() == averageGrade){
                return students.get(i);
            }
        }
        //TODO:
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student studentMax = students.get(0);
        for(int i = 1; i < students.size(); i++){
            if(students.get(i).getAverageGrade() > studentMax.getAverageGrade()){
                studentMax = students.get(i);
            }
        }
        //TODO:
        return studentMax;
    }

    public Student getStudentWithMinAverageGrade() {
        Student studentMin = students.get(0);
        for(int i = 1; i < students.size(); i++){
            if(students.get(i).getAverageGrade() < studentMin.getAverageGrade()){
                studentMin = students.get(i);
            }
        }
        //TODO:
        return studentMin;
    }

    public void expel(Student student){
        students.remove(student);
    }
}
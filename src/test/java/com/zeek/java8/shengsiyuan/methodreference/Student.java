package com.zeek.java8.shengsiyuan.methodreference;

/**
 * @ClassName Student
 * @Description
 * @Author liweibo
 * @Date 2019/10/22 5:50 PM
 * @Version v1.0
 **/
public class Student {

    String name;

    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static int compareStudentByScore(Student student1, Student student2) {
        return student1.getScore() - student2.getScore();
    }

    public static int compareStudentByName(Student student1, Student student2) {
        return student1.getName().compareTo(student2.getName());
    }



}

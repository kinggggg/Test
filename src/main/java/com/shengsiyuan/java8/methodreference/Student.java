package com.shengsiyuan.java8.methodreference;

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

    boolean sex;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Student(String name, int score, boolean sex) {
        this.name = name;
        this.score = score;
        this.sex = sex;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
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

    public int compareByScore(Student student) {
        return this.score - student.getScore();
    }



}

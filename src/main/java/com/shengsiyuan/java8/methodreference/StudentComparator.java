package com.shengsiyuan.java8.methodreference;

/**
 * @ClassName StudentComparator
 * @Description
 * @Author liweibo
 * @Date 2019/10/24 11:07 AM
 * @Version v1.0
 **/
public class StudentComparator {

    public int compareStudentByscore(Student student1, Student student2) {

        return student1.score - student2.getScore();

    }

    public int compareStudentByName(Student student1, Student student2) {

        return student1.getName().compareTo(student2.getName());
    }
}

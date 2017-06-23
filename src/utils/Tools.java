package utils;

import Bean.Student;
import rules.NormalStartegy;
import rules.inter.IStrategy;

import java.util.HashMap;

/**
 * Created by apologizebao on 2017/6/23.
 */
public class Tools {

    public static HashMap<Student, IStrategy> createStudentsLine(int num) {
        HashMap<Student, IStrategy> hashMap = new HashMap<>();
        IStrategy normalStrategy = new NormalStartegy();  //创建基础的策略
        Student student = null;
        for (int i = 0; i < num; i++) {
            student = new Student(i + 1);
            hashMap.put(student, normalStrategy);
        }
        return hashMap;
    }
}

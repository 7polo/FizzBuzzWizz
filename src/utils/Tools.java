package utils;

import Bean.Student;
import rules.*;
import rules.inter.IStrategy;

import java.util.HashMap;
import java.util.TreeMap;

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

    public static TreeMap<Integer, IStrategy> bindStrategy(int[] array) {
        TreeMap<Integer, IStrategy> map = new TreeMap<>();
        map.put(array[0], new FirstStrategy());
        map.put(array[1], new SecondStrategy());
        map.put(array[2], new ThirdStrategy());
        map.put(array[0] * array[1], new FirstSecondStartegy());
        map.put(array[0] * array[2], new FirstThirdStartegy());
        map.put(array[1] * array[2], new SecondThirdStartegy());
        map.put(array[0] * array[1] * array[2], new ALLStartegy());
        return map;
    }
}

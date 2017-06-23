package utils;

import rules.*;
import rules.inter.IStrategy;

import java.util.TreeMap;

/**
 * Created by apologizebao on 2017/6/23.
 */
public class Tools {

    public static TreeMap<Integer, IStrategy> bindStrategy(int[] array) {
        TreeMap<Integer, IStrategy> map = new TreeMap<>();
        map.put(1, new NormalStartegy()); //最基础的
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

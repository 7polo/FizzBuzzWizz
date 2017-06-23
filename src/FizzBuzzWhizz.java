import Bean.Student;
import rules.HighestStartegy;
import rules.inter.IStrategy;
import utils.RandomTools;
import utils.Tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by apologizebao on 2017/6/23.
 */

public class FizzBuzzWhizz {

    public static void main(String[] agrs) {
        FizzBuzzWhizz fizzBuzzWhizz = new FizzBuzzWhizz();
        int[] array = fizzBuzzWhizz.array;

        System.out.println("三个特殊数字：" + array[0] + ", " + array[1] + ", " + array[2]);


        //打印
        HashMap<Student, IStrategy> map = fizzBuzzWhizz.getStuMap();
        for (Map.Entry<Student, IStrategy> entry : map.entrySet()) {
            entry.getKey().speak(entry.getValue());
        }
    }

    //两个map匹配策略
    private HashMap<Student, IStrategy> stuMap = null;
    private TreeMap<Integer, IStrategy> strategyMap = null;  //用于编号绑定策略,强调顺序性

    private int num = 100;  //学生个数 100
    private int[] array; //三个特殊数字


    public FizzBuzzWhizz() {
        stuMap = Tools.createStudentsLine(num); //生成学生集合
        array = RandomTools.creatNum();
        addStrategy();
    }

    //圈复杂度为 5
    private void addStrategy() {
        strategyMap = Tools.bindStrategy(array); //数字与策略绑定
        //倍数策略
        for (Map.Entry<Integer, IStrategy> entry : strategyMap.entrySet()) {
            int index = entry.getKey(); //基数
            IStrategy strategy = entry.getValue();
            for (int j = 1; index * j <= 100; j++) { //按倍率添加
                stuMap.put(new Student(index * j), strategy);
            }
        }

        // 特殊策略 包含第一个数字的
        IStrategy strategy = new HighestStartegy();  // 最高的策略
        for (int i = 0; i < 10; i++){
            //array[0]0 - array[0]9 如 40 - 49
            stuMap.put(new Student(array[0]*10+i), strategy);

            //0array[0] - 9array[0] 如： 04， 14， 24..94
            stuMap.put(new Student(i*10+array[0]), strategy);
        }
    }


    public HashMap<Student, IStrategy> getStuMap() {
        return stuMap;
    }

    public int[] getArray() {
        return array;
    }
}

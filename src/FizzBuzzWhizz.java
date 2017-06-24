import Bean.Student;
import Exceptions.NumberInvalidException;
import rules.HighestStartegy;
import rules.inter.IStrategy;
import utils.Tools;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by apologizebao on 2017/6/23.
 */

public class FizzBuzzWhizz {

    public static void main(String[] agrs) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("依次输入三个不相同的个位数:");
        int first = scanner.nextInt();
        int second = scanner.nextInt();
        int third = scanner.nextInt();
        try {
            FizzBuzzWhizz fizzBuzzWhizz = new FizzBuzzWhizz(first, second, third);
            fizzBuzzWhizz.print();

        } catch (NumberInvalidException e) {
            System.out.println("您的输入有误，请输入三个 个位数：[1,9]");
        }
    }

    //两个map匹配策略
    private HashMap<Student, IStrategy> stuMap = null;
    private TreeMap<Integer, IStrategy> strategyMap = null;  //用于编号绑定策略,强调顺序性

    private int maxSize = 100;  //学生个数 100
    private int[] array = new int[3];


    public FizzBuzzWhizz(int firstNum, int secondNum, int thirdNum) throws NumberInvalidException {

        array[0] = firstNum;
        array[1] = secondNum;
        array[2] = thirdNum;
        check(array[0], array[1], array[2]);
        stuMap = new HashMap<>(); //生成学生集合
        addStrategy();
    }

    //校验数字，非法抛出异常
    public static double check(int a, int b, int c) throws NumberInvalidException {
        double num = 0;

        if ((a < 1 || a > 9) || (b < 1 || b > 9) || (c < 1 || c > 9)) {
            throw new NumberInvalidException();
        }
        return num;
    }

    /**
     * 生成100个学生，并添加不同的策略
     * 优化：
     * 以前包含创建学生时的圈复杂度为 6，逻辑判断圈复杂度为 5
     * 现在包含创建学生时的圈复杂度为 5，逻辑判断圈复杂度为 5
     */
    private void addStrategy() {
        strategyMap = Tools.bindStrategy(array); //数字与策略绑定
        //倍数策略
        for (Map.Entry<Integer, IStrategy> entry : strategyMap.entrySet()) {
            int index = entry.getKey(); //基数
            IStrategy strategy = entry.getValue();
            for (int j = 1; index * j <= maxSize; j++) { //按倍率添加
                stuMap.put(new Student(index * j), strategy);
            }
        }

        // 特殊策略 包含第一个数字的
        IStrategy strategy = new HighestStartegy();  // 最高的策略
        for (int i = 0; i < 10; i++) {
            //array[0]0 - array[0]9 如 40 - 49
            stuMap.put(new Student(array[0] * 10 + i), strategy);

            //0array[0] - 9array[0] 如： 04， 14， 24..94
            stuMap.put(new Student(i * 10 + array[0]), strategy);
        }
    }

    public void print() {
        System.out.println("三个特殊数字：" + array[0] + ", " + array[1] + ", " + array[2]);
        //打印
        for (Map.Entry<Student, IStrategy> entry : stuMap.entrySet()) {
            entry.getKey().speak(entry.getValue());
        }
    }

    public HashMap<Student, IStrategy> getStuMap() {
        return stuMap;
    }

    public int[] getArray() {
        return array;
    }
}

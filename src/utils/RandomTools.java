package utils;

import java.util.Random;

/**
 * Created by apologizebao on 2017/6/23.
 */
public class RandomTools {

    private static final int num = 3;
    private static final int round = 9;

    /**
     * 生成三个不相同的随机数
     *
     * @return 三个int型数
     */
    public static int[] creatNum() {
        int[] array = new int[3];
        Random rd = new Random(System.currentTimeMillis());
        for (int i = 0; i < 3; i++) {
            array[i] = rd.nextInt(round) + 1;
            for (int j = 0; j < i; j++)
                if (array[i] == array[j]) {
                    i--;
                    break;
                }
        }
        return array;
    }
}

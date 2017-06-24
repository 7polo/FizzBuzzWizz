import Exceptions.NumberInvalidException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by apologizebao on 2017/6/24.
 */
@RunWith(Parameterized.class)
public class FizzBuzzWhizzTest {
    private int[] array;

    @Parameterized.Parameters
    @SuppressWarnings("rawtypes")
    public static Collection testData() {
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int[] array = RandomTools.creatNum();
            list.add(array);
        }
        return list;
    }

    public FizzBuzzWhizzTest(int[] array) {
        this.array = array;
    }

    @Test
    public void mainTest(){
        try {
            FizzBuzzWhizz fizzBuzzWhizz = new FizzBuzzWhizz(array[0],array[1],array[2]);
            fizzBuzzWhizz.print();
        } catch (NumberInvalidException e) {
            e.printStackTrace();
        }
    }
}

import Exceptions.NumberInvalidException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by apologizebao on 2017/6/24.
 */
@RunWith(Parameterized.class)
public class NumberCheckTest {
    private int a, b, c;

    public NumberCheckTest(String a, String b, String c) {
        this.a = Integer.parseInt(a);
        this.b = Integer.parseInt(b);
        this.c = Integer.parseInt(c);
    }

    @Parameterized.Parameters
    @SuppressWarnings("rawtypes")
    public static Collection testData() {
        return Arrays.asList(new String[][]{
                {"0", "0", "0"},
                {"1", "2", "3"},
                {"-1", "2", "10"},
                {"9", "9", "9"},
                {"1", "2", "10"},
        });
    }

    @Test
    public void checkTest() throws NumberInvalidException {

        System.out.println(a + ", " + b + ", " + c);
        FizzBuzzWhizz.check(a, b, c);
    }
}

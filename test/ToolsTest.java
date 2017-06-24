import Bean.Student;
import Exceptions.NumberInvalidException;
import org.junit.Test;
import rules.inter.IStrategy;
import utils.Tools;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by apologizebao on 2017/6/23.
 */
public class ToolsTest {

    @Test
    public void createStudent() throws NumberInvalidException {
        //测试基础策略
        HashMap<Student, IStrategy> map = new FizzBuzzWhizz(2,3,4).getStuMap();
        for (Map.Entry<Student, IStrategy> entry : map.entrySet()) {
            entry.getKey().speak(entry.getValue());
        }
    }

    @Test
    public void bindStrategyTest() {
        int array[] = RandomTools.creatNum();
        Tools.bindStrategy(array);
        System.out.println(-9.0/9);
    }
}

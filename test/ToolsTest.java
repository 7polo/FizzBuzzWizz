import Bean.Student;
import org.junit.Test;
import rules.inter.IStrategy;
import utils.RandomTools;
import utils.Tools;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by apologizebao on 2017/6/23.
 */
public class ToolsTest {

    @Test
    public void createStudent() {
        //测试基础策略
        HashMap<Student, IStrategy> map = new FizzBuzzWhizz().getStuMap();
        for (Map.Entry<Student, IStrategy> entry : map.entrySet()) {
            entry.getKey().speak(entry.getValue());
        }
    }

    @Test
    public void bindStrategyTest() {
        Tools.bindStrategy(RandomTools.creatNum());
    }
}

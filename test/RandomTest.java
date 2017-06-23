import org.junit.Test;
import utils.RandomTools;

/**
 * Created by apologizebao on 2017/6/23.
 */
public class RandomTest {

    @Test
    public void randomTest() {
        for (int i = 0; i < 1000; i++) {
            int[] nums = RandomTools.creatNum();
            System.out.println(nums[0]+","+nums[1]+","+nums[2]);
        }
    }
}

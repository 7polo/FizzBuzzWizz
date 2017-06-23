package rules.inter;

/**
 * Created by apologizebao on 2017/6/23.
 * 采用策略模式
 */
public interface IStrategy {

    String FIRST = "Fizz";
    String SECOND = "Buzz";
    String THIRD = "Whizz";

    String FIRST_CONTAIN = FIRST;
    String FIRST_SECOND = FIRST + SECOND;
    String FIRST_THIRD = FIRST + THIRD;
    String SECOND_THIRD = SECOND + THIRD;
    String ALL = FIRST + SECOND + THIRD;

    String speak(Integer num);
}

package rules;

import rules.inter.IStrategy;

/**
 * Created by apologizebao on 2017/6/23.
 */
public class FirstThirdStartegy implements IStrategy {
    @Override
    public String speak(Integer num) {
        return IStrategy.FIRST_THIRD;
    }
}

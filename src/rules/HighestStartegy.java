package rules;

import rules.inter.IStrategy;

/**
 * Created by apologizebao on 2017/6/23.
 * 最高策略，即包含第一个特殊数字
 */
public class HighestStartegy implements IStrategy {
    @Override
    public String speak(Integer num) {
        return IStrategy.FIRST_CONTAIN;
    }
}

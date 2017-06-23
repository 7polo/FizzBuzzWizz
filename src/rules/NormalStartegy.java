package rules;

import rules.inter.IStrategy;

/**
 * Created by apologizebao on 2017/6/23.
 * 普通策略
 */
public class NormalStartegy implements IStrategy {
    @Override
    public String speak(Integer num) {
        return num+"";
    }
}

package com.mashibing.tank;

/**
 * @description:
 * @author: yanxiaotian
 * @create: 2021-05-31 14:51
 **/
public class FireStrategyContext {
    private FireStrategy strategy;

    public FireStrategyContext(FireStrategy strategy) {
        this.strategy = strategy;
    }

    public void fire(Tank tank){
        strategy.fire(tank);
    }
}

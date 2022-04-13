package com.snail.demo1;

/**
 * 魔鬼角色
 *
 * @author : snail
 * @date : 2022-04-03 11:40
 **/
public class DevilBuilder implements ActorBuilder {
    @Override
    public void buildType() {
        actor.setType("魔鬼");
    }

    @Override
    public void buildSex() {
        actor.setSex("妖");
    }

    @Override
    public void buildFace() {
        actor.setFace("面目狰狞");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("破衣烂衫");
    }

    @Override
    public void buildHairstyle() {
        actor.setHairstyle("光头");
    }
}

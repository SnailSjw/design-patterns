package com.snail.demo1;

/**
 * 英雄角色
 *
 * @author : snail
 * @date : 2022-04-03 11:34
 **/
public class HeroBuilder implements ActorBuilder{
    @Override
    public void buildType() {
        actor.setType("英雄");
    }

    @Override
    public void buildSex() {
        actor.setSex("男");
    }

    @Override
    public void buildFace() {
        actor.setFace("英俊");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("盔甲");
    }

    @Override
    public void buildHairstyle() {
        actor.setHairstyle("如云飘逸");
    }
}

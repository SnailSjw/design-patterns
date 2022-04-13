package com.snail.demo1;

/**
 * 天使角色
 *
 * @author : snail
 * @date : 2022-04-03 11:38
 **/
public class AngelBuilder implements ActorBuilder{
    @Override
    public void buildType() {
        actor.setType("天使");
    }

    @Override
    public void buildSex() {
        actor.setSex("女");
    }

    @Override
    public void buildFace() {
        actor.setFace("美丽");
    }

    @Override
    public void buildCostume() {
        actor.setCostume("白色长裙");
    }

    @Override
    public void buildHairstyle() {
        actor.setHairstyle("长发飘飘");
    }
}

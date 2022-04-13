package com.snail.demo1;

/**
 * 指挥者
 *
 * @author : snail
 * @date : 2022-04-03 11:30
 **/
public class ActorController {
    public Actor construct(ActorBuilder ab){
        ab.buildType();
        ab.buildSex();
        ab.buildFace();
        ab.buildCostume();
        ab.buildHairstyle();
        return ab.createActor();
    }
}

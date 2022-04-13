package com.snail.demo1;

/**
 * 抽象建造者
 *
 * @author : snail
 * @date : 2022-04-03 11:24
 **/
public interface ActorBuilder {
    Actor actor = new Actor();

    /**
     * 构建type属性
     */
    void buildType();

    /**
     * 构建sex属性
     */
    void buildSex();

    /**
     * 构建face属性
     */
    void buildFace();

    /**
     * 构建costume属性
     */
    void buildCostume();

    /**
     * 构建hairstyle属性
     */
    void buildHairstyle();

    /**
     * 创建角色
     *
     * @return 角色
     */
    default Actor createActor(){
        return actor;
    }
}

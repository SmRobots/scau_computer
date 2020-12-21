package com.smrobot.domain;

/**
 * 定义玩家类
 * 成员变量：玩家进行游戏的次数，玩家成功的次数，玩家失败的次数，玩家的姓名
 * @author smrobot
 * @date 2020/10/28
 */

public class Player {

    /**
     * 玩家进行游戏的总次数
     */
    private int allTimes;

    /**
     * 玩家游戏成功的次数
     */
    private int successTimes;

    /**
     * 玩家失败的次数
     */
    private int failTimes;

    /**
     * 玩家的姓名
     */
    private String name;

    /**
     *  默认构造
     */
    public Player() {}

    /**
     * 传递玩家的姓名
     * @param name
     */
    public Player(String name) {
        this.name = name;
    }

    public int getAllTimes() {
        return allTimes;
    }

    public void setAllTimes(int allTimes) {
        this.allTimes = allTimes;
    }

    public int getSuccessTimes() {
        return successTimes;
    }

    public void setSuccessTimes(int successTimes) {
        this.successTimes = successTimes;
    }

    public int getFailTimes() {
        return failTimes;
    }

    public void setFailTimes(int failTimes) {
        this.failTimes = failTimes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "玩家：" + name + " 您一共进行了" + allTimes + "次游戏,成功" + successTimes + "次，失败" + failTimes + "次";
    }
}

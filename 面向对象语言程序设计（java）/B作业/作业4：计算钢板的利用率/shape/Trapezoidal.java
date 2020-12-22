package com.smrobot.shape;

/**
 * 梯形
 * @author smrobot
 */
public class Trapezoidal extends Shape{

    /**
     * 下底宽
     */
    private double bottomWidth;

    /**
     * 上底宽
     */
    private double topWidth;

    /**
     * 高度
     */
    private double height;

    public Trapezoidal() {}

    public Trapezoidal(double topWidth, double bottomWidth, double height) {
        this.bottomWidth = bottomWidth;
        this.topWidth = topWidth;
        this.height = height;
    }


    @Override
    public double getArea() {
        return ((bottomWidth + topWidth) * height) / 2;
    }

    public double getBottomWidth() {
        return bottomWidth;
    }

    public void setBottomWidth(double bottomWidth) {
        this.bottomWidth = bottomWidth;
    }

    public double getTopWidth() {
        return topWidth;
    }

    public void setTopWidth(double topWidth) {
        this.topWidth = topWidth;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}

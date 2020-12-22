package com.smrobot.shape;

/**
 * 矩形类
 * @author smrobot
 */
public class Rectangular extends Shape{

    /**
     * 矩形的宽度
     */
    private double width;

    /**
     * 矩形个高度
     */
    private double height;

    public Rectangular() {}

    public Rectangular(double width, double height) {
        this.height = height;
        this.width = width;
    }


    @Override
    public double getArea() {
        return width * height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}

package com.smrobot.shape;

/**
 * 圆形
 * @author smrobot
 */
public class Circle extends Shape{

    /**
     * 圆的半径
     */
    private double radius;

    public Circle() {}

    public Circle(double radius) {
        this.radius = radius;
    }


    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}

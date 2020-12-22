package com.smrobot;

/**
 * 钢板
 * @author smrobot
 */
public class Steel {

    /**
     * 钢板的宽度
     */
    private double width;

    /**
     * 钢板的高度
     */
    private double height;

    public Steel() {}

    public Steel(double width, double height) {
        this.width = width;
        this.height = height;
    }

    /**
     * 获取钢板的面积
     * @return
     */
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

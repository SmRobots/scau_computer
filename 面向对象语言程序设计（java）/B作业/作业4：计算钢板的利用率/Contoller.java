package com.smrobot;

import com.smrobot.shape.Circle;
import com.smrobot.shape.Rectangular;
import com.smrobot.shape.Shape;
import com.smrobot.shape.Trapezoidal;

/**
 * 模拟前端和后端的控制接口
 * 接口前端的数据数据
 * 将数据处理之后返回给前端
 * @author smrobot
 */
public class Contoller {

    /**
     * 根据类别创建对象并返回
     * @param line
     * @return
     */
    public Shape getChildObject(String line) {
        String[] strings = line.split(" ");
        if ("A".equals(strings[0])) {
            return new Rectangular(Double.parseDouble(strings[1]), Double.parseDouble(strings[2]));
        } else if ("B".equals(strings[0])) {
            return new Circle(Double.parseDouble(strings[1]));
        } else if ("C".equals(strings[0])) {
            return new Trapezoidal(Double.parseDouble(strings[1]), Double.parseDouble(strings[2]), Double.parseDouble(strings[3]));
        }
        return null;
    }
}

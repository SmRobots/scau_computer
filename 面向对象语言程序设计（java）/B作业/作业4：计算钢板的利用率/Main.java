package com.smrobot;

import com.smrobot.shape.Shape;

import java.util.Scanner;

/**
 * 模拟输入端
 * @author smrobot
 */
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Contoller contoller = new Contoller();
        System.out.println("请输入钢板的宽度：");
        double steelWidth = input.nextDouble();
        System.out.println("请输入钢板的高度");
        double steelHeight = input.nextDouble();
        Steel steel = new Steel(steelWidth, steelHeight);
        System.out.println("下面输入切割的形状。");
        System.out.println("先输入要输入多少行数据n");
        int n = input.nextInt();
        input.nextLine();
        System.out.println("接下去多行输入形状类别和其对应的切割尺寸(数据之间用空格隔开)");
        Shape[] shapes = new Shape[n];
        for (int i = 0; i < n; i++) {
            String line = input.nextLine();
            shapes[i] = contoller.getChildObject(line);
        }
        // 计算钢板的利用率
        double totalArea = 0;
        for (int i = 0; i < n; i++) {
            totalArea += shapes[i].getArea();
        }
        System.out.printf("钢板的利用率为：%.3f%%", totalArea / steel.getArea() * 100);
    }
}

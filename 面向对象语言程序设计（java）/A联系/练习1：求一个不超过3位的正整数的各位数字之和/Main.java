/**
 * 练习1：
 * 读取一个正整数，假设输入的正整数一定在0（包括）到1000（不包括）之间。
 * 计算并输出该整数的各位数字之和。
 */

import java.util.Scanner;
public class Exercise01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //程序是否继续执行的标志，输入的第一个字符为q或者Q则退出程序的运行
        String keepRunning = " ";
        do {
            System.out.println("请输入一个0到999的正整数：");
            int num = input.nextInt();
            if (num >= 1000) {
                System.out.println("输入的数据有误，请输入一个0到999的正整数");
                continue;
            }
            //最后输出的答案
            int ans = 0;
            //创建一个临时变量，只是为了将输入的num保存，用于后面的打印，也可以不保存
            int temp = num;
            //循环获取每个位数的值
            while (temp != 0) {
                ans += temp % 10;
                temp /= 10;
            }
            System.out.println(num + "的各个位数之和为：" + ans);
            System.out.print("输入q/Q退出程序运行，键入其他字符程序继续运行：");
            //这里直接读取输入的一行字符，后面判断是否继续执行时取第一元素即可
            keepRunning = input.next();
        } while(keepRunning.charAt(0) != 'q' && keepRunning.charAt(0) != 'Q');
    }
}

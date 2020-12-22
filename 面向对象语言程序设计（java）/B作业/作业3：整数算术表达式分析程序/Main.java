package cn.net.smrobot;


public class Main {

    public static void main(String[] args) {

        String expression = "32 + 5 * ( 30 - 40 ) / 3 - 12";
        System.out.println("表达式为：32 + 5 * ( 30 - 40 ) / 3 - 12");
        System.out.println("运算结果为：" +Arithmetic.caculate(expression));
        expression = "3 + 3 * ( 4 - ( ( 66 + 5 ) * 56 ) ) / 3 / 4";
        System.out.println("表达式为：3 + 3 * ( 4 - ( ( 66 + 5 ) * 56 ) ) / 3 / 4");
        System.out.println("运算结果为：" + Arithmetic.caculate(expression));

    }
}

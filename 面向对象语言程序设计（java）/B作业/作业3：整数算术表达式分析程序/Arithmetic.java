package cn.net.smrobot;

import java.util.*;

/**
 * 四则运算类
 */

public class Arithmetic {

    /**
     * 创建一个运算符栈对象
     */
    private static OperatorStack operatorStack = new OperatorStack();

    /**
     * 运算数栈对象
     */
    private static Stack<Integer> numStack = new Stack<>();

    /**
     * 计算字符串表达式的值
     * @param expresion
     * @return
     */
    public static int caculate(String expresion) {
        if (expresion == null) {
            throw new NullPointerException("表达式不能为空");
        }
        expresion = expresion + " #";
        String[] expresionArray = expresion.split(" ");
        //记录当前拿到字符的下标
        int counter = 0;
        operatorStack.push("#");
        String item = expresionArray[counter];
        while (!"#".equals(item) || !"#".equals(operatorStack.getTop())) {
            if (!isOperateor(item)) {
                numStack.push(Integer.parseInt(item));
                item = expresionArray[++counter];
            } else {
                switch (PrecedeCode.getPreCede(operatorStack.getTop(), item)) {
                    case -1:
                        operatorStack.push(item);
                        item = expresionArray[++counter];
                        break;
                    case 0:
                        operatorStack.pop();
                        item = expresionArray[++counter];
                        break;
                    case 1:
                        String operator = operatorStack.pop();
                        int num1 = numStack.pop();
                        int num2 = numStack.pop();
                        int temp = operate(num2, operator, num1);
                        numStack.push(temp);
                        break;
                    default:
                        System.out.println("语法有误");
                        System.exit(0);
                }
            }
        }
        return numStack.peek();
    }

    /**
     *
     * @return
     */
    private static int operate(int num1, String operator, int num2) {
        int temp = 0;
        if ("+".equals(operator)) {
            temp = num1 + num2;
        }
        if ("-".equals(operator)) {
            temp = num1 - num2;
        }
        if ("*".equals(operator)) {
            temp = num1 * num2;
        }
        if ("/".equals(operator)) {
            temp = num1 / num2;
        }
        return temp;
    }

    /**
     * 判断一个字符是否是运算符
     * @return
     */
    private static boolean isOperateor(String str) {
        if ("+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str) || "(".equals(str)
                || ")".equals(str) || "#".equals(str)) {
            return true;
        }
        return false;
    }


}


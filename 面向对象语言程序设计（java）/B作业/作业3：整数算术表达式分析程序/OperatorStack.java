package cn.net.smrobot;


/**
 * 自定义一个栈用来保存运算符
 */
public class OperatorStack {

    /**
     * 初始栈数组的最大空间
     */
    private final int maxInitCapacity = 32;

    /**
     * 当前栈对象的最大空间
     * 后续扩容的时候可能变化
     */
    private int currentMaxCapacity = 32;

    /**
     * 扩容因子
     */
    private int expansionFactor = 8;

    /**
     * 使用数组来保存运算符
     */
    private String[] operatorStack = new String[maxInitCapacity];
    /**
     * 栈顶指针
     */
    private int top = 0;

    /**
     * 入栈操作
     */
    public void push(String operator) {
        if (top >= currentMaxCapacity) {
            //如果栈顶指针超过当前栈数组的容量，则复制元素并且扩容
            alloc();
        }
        operatorStack[top++] = operator;
    }

    /**
     * 出栈操作
     * @return
     */
    public String pop() {
        if (isEmpty()) {
            return null;
        }
        return operatorStack[--top];
    }

    /**
     * 获取栈顶元素
     * @return
     */
    public String getTop() {
        if (isEmpty()) {
            return null;
        }
        return operatorStack[top - 1];
    }

    /**
     * 判断该栈是否为空
     * @return
     */
    public boolean isEmpty() {
        return top == 0 ? true : false;
    }

    /**
     * 重新分配空间
     */
    private void alloc() {
        String[] newOperatorStack = new String[currentMaxCapacity + expansionFactor];
        currentMaxCapacity += expansionFactor;
        System.arraycopy(operatorStack, 0, newOperatorStack, 0, top - 1);
        operatorStack = newOperatorStack;
    }


}

package cn.net.smrobot;

import java.util.HashMap;
import java.util.Map;

/**
 * 要来保存运算符之间关系的工具类
 * 用map集合来保存关系
 * 例如："++"=1这个键值对表示第一运算符+比第二个运算符+的优先级更高
 * "#"这个符号用来标注啊表达式的结尾
 */
public class PrecedeCode {

    /**
     * 使用map来提前保存运算符之间的优先关系
     */
    private static Map<String, Integer> precedeCode = new HashMap<>(24);
    static {
        precedeCode.put("++", 1);
        precedeCode.put("+-", 1);
        precedeCode.put("+*", -1);
        precedeCode.put("+/", -1);
        precedeCode.put("+(", -1);
        precedeCode.put("+)", 1);
        precedeCode.put("+#", 1);

        precedeCode.put("-+", 1);
        precedeCode.put("--", 1);
        precedeCode.put("-*", -1);
        precedeCode.put("-/", -1);
        precedeCode.put("-(", -1);
        precedeCode.put("-)", 1);
        precedeCode.put("-#", 1);

        precedeCode.put("*+", 1);
        precedeCode.put("*-", 1);
        precedeCode.put("**", 1);
        precedeCode.put("*/", 1);
        precedeCode.put("*(", -1);
        precedeCode.put("*)", 1);
        precedeCode.put("*#", 1);

        precedeCode.put("/+", 1);
        precedeCode.put("/-", 1);
        precedeCode.put("/*", 1);
        precedeCode.put("//", 1);
        precedeCode.put("/(", -1);
        precedeCode.put("/)", 1);
        precedeCode.put("/#", 1);

        precedeCode.put("(+", -1);
        precedeCode.put("(-", -1);
        precedeCode.put("(*", -1);
        precedeCode.put("(/", -1);
        precedeCode.put("((", -1);
        precedeCode.put("()", 0);
        //这种情况说明语法错误
        precedeCode.put("(#", -2);

        precedeCode.put(")+", 1);
        precedeCode.put(")-", 1);
        precedeCode.put(")*", 1);
        precedeCode.put(")/", 1);
        //这种情况下说明输入的表达式语法有误
        precedeCode.put(")(", -2);
        precedeCode.put("))", 1);
        precedeCode.put(")#", 1);

        precedeCode.put("#+", -1);
        precedeCode.put("#-", -1);
        precedeCode.put("#*", -1);
        precedeCode.put("#/", -1);
        precedeCode.put("#(", -1);
        precedeCode.put("#)", -2);
        precedeCode.put("##", 0);

    }

    /**
     * 判断两个运算符的优先级别
     * @param preOp
     * @param currOp
     * @return
     * 0 两个运算符优先级别相等，只有在两个分别是()才返回0
     * 1 preOp运算符优先级大于currOp运算符优先级
     * -1 currOp运算符优先级大于preOp运算符优先级
     */
    public static int getPreCede(String preOp, String currOp) {
        return precedeCode.get(preOp + currOp);
    }


}

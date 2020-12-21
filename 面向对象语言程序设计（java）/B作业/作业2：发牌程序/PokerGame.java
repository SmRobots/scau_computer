
/**
 * 发牌游戏的逻辑处理类
 * @author smrobot
 */

import java.util.*;

public class PokerGame {

    /** 洗牌的次数的倍率 */
    final static double RATE = 0.3;
    /** 扑克牌的花色 */
    final static String[] SUIT = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

    /** 扑克牌的牌数的大小 */
    final static int POKER_SIZE = 52;

    /**
     * 发牌方法
     * @param pokerNum
     * @param players
     */
    public static void pokerGame(int pokerNum, int players) {
        //计算交换牌数的次数
        int times = (int) (RATE * pokerNum * POKER_SIZE);
        //用来保存点数的数组的长度
        int arrayLength = pokerNum * POKER_SIZE;
        //用来保存所有点数的数组
        int[] allPoints = new int[arrayLength];
        for(int i = 0; i < arrayLength; i++) {
            allPoints[i] = i % POKER_SIZE;
        }
        //洗牌操作
        changePoint(allPoints, times);
        //发牌操作
        int[][] result = licensing(allPoints, players);
        //打印各个玩家发牌的结果
        print(result);
    }

    /**
     * 交换牌的点数
     * @param points
     * @param times 交换的次数
     * @return
     */
    public static void changePoint(int[] points, int times) {
        //两次交换的下标1
        int changeIndex1 = 0;
        //两次交换的下标2
        int changeIndex2 = 0;
        //交换数据的临时变量
        int temp = 0;
        for (int i = 0; i < times; i++) {
            //使用随机数产生两个下标
            changeIndex1 = (int)(Math.random() * points.length);
            changeIndex2 = (int)(Math.random() * points.length);
            temp = points[changeIndex1];
            points[changeIndex1] = points[changeIndex2];
            points[changeIndex2] = temp;
        }
    }

    /**
     * 发牌操作
     * @param points
     * @param players
     * @return 返回给每位玩家发牌的结果
     */
    public static int[][] licensing(int[] points, int players) {
        int[][] result = new int[players][];
        //每位玩家最少分配的牌数
        int divisorOfPoints = points.length / players;
        //额外多分发多一张牌的玩家的数量
        int modOfPoints = points.length % players;
        //给每个数组分配空间
        for (int i = 0; i < modOfPoints; i++) {
            result[i] = new int[divisorOfPoints + 1];
        }
        for (int i = modOfPoints; i < players; i++) {
            result[i] = new int[divisorOfPoints];
        }
        int i = 0;
        //计数器，用来统计已经分配了多少张牌了
        int counter = 0;
        //为每位玩家发牌
        while (i < points.length) {
            for (int j = 0; j < players && i < points.length; j++, i++) {
                result[j][counter] = points[i];
            }
            counter++;
        }
        return result;
    }

    /**
     * 打印各位玩家发牌的情况
     * @param result
     */
    private static void print(int[][] result) {
        int players = result.length;
        //黑桃
        List<String> spades = new ArrayList<String>();
        //红心
        List<String> redHearts = new ArrayList<String>();
        //草花
        List<String> sucks = new ArrayList<String>();
        //方块
        List<String> squares = new ArrayList<String>();
        for (int i = 0; i < players; i++) {
            System.out.printf("第%d个人:\n", i + 1);
            //先给每个玩家的点数数组排序
            Arrays.sort(result[i]);
            for (int j = result[i].length - 1; j >= 0; j--) {
                //点数
                int tempPoint = result[i][j];
                //花色
                String tempSuit = SUIT[tempPoint % 13];
                //根据不同的点数进行花色的转化
                if (tempPoint >= 39) {
                    //[39， 51] 表示黑桃
                    spades.add(tempSuit);
                } else if (tempPoint >= 26 && tempPoint <= 38) {
                    // [26, 38] 表示红心
                    redHearts.add(tempSuit);
                } else if (tempPoint >= 13 && tempPoint <= 25) {
                    // [13, 25] 表示草花
                    sucks.add(tempSuit);
                } else {
                    // [0, 12] 表示方块
                    squares.add(tempSuit);
                }
            }
            System.out.print("黑桃：");
            spades.stream().forEach(s -> System.out.print(s + " "));
            //打印完后将列表清空
            spades.clear();
            System.out.println();
            System.out.print("红心：");
            redHearts.stream().forEach(s -> System.out.print(s + " "));
            redHearts.clear();
            System.out.println();
            System.out.print("草花：");
            sucks.stream().forEach(s -> System.out.print(s + " "));
            sucks.clear();
            System.out.println();
            System.out.print("方块：");
            squares.stream().forEach(s -> System.out.print(s + " "));
            squares.clear();
            System.out.println();
        }

    }


}


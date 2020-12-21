
/**
 * 猜字游戏的控制类
 * @author smrobot
 * @date 2020-11-2
 */

import com.smrobot.domain.Player;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Guess {
    /**
     * 游戏运行控制中心
     * @param player    进行游戏的玩家
     */
    public void game(Player player) {
        int counter = 3;
        Scanner input = new Scanner(System.in);
        System.out.println("机器将随机产生[0-9]的数字~");
        //机器随机产生的数字
        int robotNum = (int)(Math.random() * 10);
        while (counter >= 1) {
            System.out.println("--提示：玩家  " + player.getName() + "  您本次游戏还有" + counter + "次机会--");
            System.out.print("请输入您猜测的数字：");
            int guessNum = 0;
            try {
                guessNum = input.nextInt();
                int status = compare(robotNum, guessNum);
                switch (status) {
                    case -1:
                        System.out.println("不好意思，您的数字偏小了！");
                        break;
                    case 0:
                        if (counter == 3) {
                            System.out.println("真棒！第一次就猜对了~");
                        } else {
                            System.out.println("恭喜您猜对了~");
                        }
                        System.out.println("-------游戏成功------");
                        player.setSuccessTimes(player.getSuccessTimes() + 1);
                        return ;
                    case 1:
                        System.out.println("不好意思，您的数字偏大了！");
                        break;
                    default:
                        break;
                }
                counter--;
            } catch (InputMismatchException e) {
                //清空错误输入的缓冲区
                input.nextLine();
                System.out.println("输入有误，请输入一个整数！");
            }
        }
        System.out.println("您一次都没有猜对，本轮游戏结束！正确答案为：" + robotNum);
        System.out.println("-------游戏失败------");
        player.setFailTimes(player.getFailTimes() + 1);
    }


    /**
     * 比较两个整型数字的大小
     * @param robotNum
     * @param playerNum
     * @return  0 表示两个数字相等；1 表示参数1小于参数2；-1 表示参数1大于参数2
     */
    public int compare(int num1, int num2) {
        if (num1 == num2) {
            return 0;
        } else if (num1 < num2) {
            return 1;
        } else {
            return -1;

        }
    }
}

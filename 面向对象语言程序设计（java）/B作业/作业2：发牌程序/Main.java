
import java.util.Scanner;

/**
 * 处理输入输出
 * @author smrobot
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("---------欢迎来到发牌游戏---------");
        Scanner input = new Scanner(System.in);
        //扑克牌的数量
        int pokerNum = 0;
        //参加游戏的人数
        int players = 0;
        //程序是否继续运行
        char keepRunning = '\0';
        do {
            System.out.print("请输入扑克牌的数量：");
            pokerNum = input.nextInt();
            System.out.print("请输入参与游戏的人数：");
            players = input.nextInt();
            System.out.println("--------发牌结果如下-------");
            PokerGame.pokerGame(pokerNum, players);
            System.out.println("--------------------------");
            System.out.println("是否继续发牌游戏？（输入y或n）");
            input.nextLine();
            keepRunning = input.nextLine().charAt(0);
        } while (keepRunning == 'Y' || keepRunning == 'y');
    }
}

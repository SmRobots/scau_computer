package com.smrobot;

import com.smrobot.control.Guess;
import com.smrobot.domain.Player;
import java.util.Scanner;

/**
 * 处理用户的输入输出
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("-----------欢迎来到猜数字游戏-----------");
        System.out.print("请输入您的游戏名称：");
        Scanner input = new Scanner(System.in);
        //输入玩家的姓名
        String name = input.next();
        Player player = new Player(name);
        Guess guess = new Guess();
        char keepGame = '\0';
        //游戏进行的总次数
        int allTimes = 1;
        do {
            System.out.println("------第" + allTimes + "轮游戏-------");
            guess.game(player);
            player.setAllTimes(allTimes);
            System.out.println("请问是否继续游戏（Y/N）");
            keepGame = input.next().charAt(0);
            allTimes++;
        } while (keepGame == 'Y' || keepGame == 'y');
        //输入玩家的游戏信息
        System.out.println(player);
    }
}

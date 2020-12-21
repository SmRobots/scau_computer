package com.smrobot.task01;

import java.util.Scanner;

/**
 * 练习3：
 * 打印十二个月份的日历
 * 给定输入一个年份和代表该年第一天时星期几的数字
 */

public class Exercise03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //程序是否继续执行的标志，输入的第一个字符为q或者Q则退出程序的运行
        String keepRunning = " ";
        do {
            System.out.print("请输入年份：");
            int year = input.nextInt();
            System.out.print("请输入这一年第一天是星期几：");
            int firstDayOfWeek = input.nextInt();
            //如果是闰年的话将其值设置为1，闰年为366天，不是闰年为355天
            int addDays = 0;
            //判断是否是闰年,闰年的话一年天数+1
            if (isLeap(year)) {
                addDays++;
            }
            //遍历生成12个月的日历
            for (int i = 1; i <= 12; i++) {
                switch (i) {
                    //一个月31天的情况
                    case 1:
                        printCalendar(31, 0, firstDayOfWeek, i);
                        break;
                    case 3:
                        printCalendar(31, 59 + addDays, firstDayOfWeek, i);
                        break;
                    case 5:
                        printCalendar(31, 120 + addDays, firstDayOfWeek, i);
                        break;
                    case 7:
                        printCalendar(31, 181 + addDays, firstDayOfWeek, i);
                        break;
                    case 8:
                        printCalendar(31, 212 + addDays, firstDayOfWeek, i);
                        break;
                    case 10:
                        printCalendar(31, 273 + addDays, firstDayOfWeek, i);
                        break;
                    case 12:
                        printCalendar(31, 334 + addDays, firstDayOfWeek, i);
                        break;
                    //2月份特殊情况
                    case 2:
                        printCalendar(28 + addDays, 31, firstDayOfWeek, i);
                        break;
                    //一个月30天的情况
                    case 4:
                        printCalendar(30, 90 + addDays, firstDayOfWeek, i);
                        break;
                    case 6:
                        printCalendar(30, 151 + addDays, firstDayOfWeek, i);
                        break;
                    case 9:
                        printCalendar(30, 243 + addDays, firstDayOfWeek, i);
                        break;
                    case 11:
                        printCalendar(30, 304 + addDays, firstDayOfWeek, i);
                        break;
                    default:
                        break;
                }
            }
            System.out.print("输入q/Q退出程序运行，键入其他字符程序继续运行：");
            keepRunning = input.next();
        } while (keepRunning.charAt(0) != 'q' && keepRunning.charAt(0) != 'Q');
    }

    /**
     * 判断一个年份是否是闰年
     * 闰年可以被4整除但是不能被100整除，或者可以被400整除
     * @param year
     * @return
     */
    public static boolean isLeap(int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }

    /**
     * 打印每个月的日历表
     * @param monthDays 当前月的总天数
     * @param totalDays 当前月之前已经经过了多少天 -- 用于和下面的week参数一起计算每个月开始是星期几
     * @param week  该年第一天是星期几
     * @param month 当前是第几月
     */
    public static void printCalendar(int monthDays, int totalDays, int week, int month) {
        System.out.println("--------------" + month + "月-----------");
        System.out.println("Sum\tMon\tTue\tWed\tThu\tFri\tSat");
        //计算该月的第一天是星期几
        int startWeek = (totalDays + week) % 7;
        //用来统计每一行打印了多少个数据了
        int cnt = 0;
        for (int i = 0; i < startWeek; i++) {
            System.out.print("\t");
            cnt++;
        }
        for (int i = 1; i <= monthDays; i++) {
            System.out.printf("%d\t", i);
            cnt++;
            if (cnt % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println("\n--------------------------");
    }

}

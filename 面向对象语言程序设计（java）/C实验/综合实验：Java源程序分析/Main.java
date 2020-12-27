
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        mainWhile:while (true) {
            System.out.println("------MENU--------");
            System.out.println("1.分析目录中的源程序");
            System.out.println("2.查看分析结果");
            System.out.println("0.退出程序");
            System.out.println("--------------------");
            System.out.print("请选择：");
            int type = input.nextInt();
            input.nextLine();
            switch (type) {
                case 1:
                    System.out.println("请输入要分析文件的完整路径名：");
                    String path = input.nextLine();
                    boolean analysisDirectory = Controller.analysisDirectory(path);
                    if (!analysisDirectory) {
                        System.out.println("错误：[" + path + "]不存在或者不是目录，请输入一个存在java源程序的目录~");
                        continue ;
                    }
                    System.out.println("文件分析结果以保存在项目的result文件夹中，请前往查看！");
                    break;
                case 2:
                    try {
                        if (!Controller.hasResult()) {
                            System.out.println("result文件夹中还没有分析结果！");
                            continue;
                        }
                        File[] files = Controller.getAllAnalysis();
                        System.out.println("--------已有的文件分析结果如果--------");
                        for (int i = 0; i < files.length; i++) {
                            System.out.printf("%d.%s\n", i + 1, files[i].getName());
                        }
                        System.out.println("--------------------------------------");
                        System.out.print("选择要查看的结果文件(0表示放弃):");
                        int fileId = input.nextInt();
                        if (fileId == 0) {
                            System.out.println("您没有查看任何结果，程序将退出本次查看！");
                        } else if (fileId > 0 && fileId <= files.length) {
                            System.out.println("分析的文件结果如下：");
                            String result = Controller.showAnalysis(files[fileId - 1]);
                            System.out.println(result);
                            System.out.println("----------------------------------");
                        } else {
                            System.out.println("您的输入有误！程序将退出本次查看！");
                        }


                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 0:
                    System.out.println("--------------");
                    System.out.println("程序已经退出！");
                    break mainWhile;
                default:
                    break ;
            }
        }

    }
}

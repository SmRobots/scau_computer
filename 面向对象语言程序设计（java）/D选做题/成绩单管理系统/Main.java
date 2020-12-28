import cn.net.smrobot.controller.TranscriptController;
import cn.net.smrobot.domain.Student;
import cn.net.smrobot.domain.Transcript;

import java.util.List;
import java.util.Scanner;

/**
 * @author smrobot
 */

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        mainWhile:while (true) {
            System.out.println("--------------------成绩单管理程序-------------------\n");
            System.out.print("成绩单：");
            List<Transcript> transcriptList = TranscriptController.getAllTranscript();
            if (transcriptList != null) {
                System.out.println("\n");
                int count = 1;
                for (Transcript  transcript : transcriptList) {
                    System.out.println("" + count + ".  " + transcript.getClassName() + "," + transcript.getCourseName() + ", 人数："
                            + transcript.getTotalStudentCount());
                    count++;

                }
            } else {
                System.out.println("空");
            }
            System.out.println("-----------------------------------------------------------");
            System.out.println("1.新建成绩单\t\t\t2.增加成绩项");
            System.out.println("3.按学号查询成绩\t\t4.按序号删除成绩");
            System.out.println("5.显示成绩单\t\t\t0.退出");
            System.out.println("-----------------------------------------------------------");
            System.out.print("请输入您的选择：");
            int choice = input.nextInt();
            input.nextLine();
            int transcriptId = -1;
            Student findStudent = null;
            String schoolId = "";
            switch (choice) {
                case 1:
                    Transcript transcript = new Transcript();
                    System.out.print("请输入该成绩单的班级名称：");
                    transcript.setClassName(input.nextLine());
                    System.out.print("请输入该成绩单的课程名称：");
                    transcript.setCourseName(input.nextLine());
                    if (TranscriptController.createNewTranscript(transcript)) {
                        System.out.println("成绩单创建成功！");
                    } else {
                        System.out.println("错误：成绩单创建失败！");
                    }
                    break;
                case 2:
                    if (transcriptList == null || transcriptList.size() == 0) {
                        System.out.println("当前成绩单为空，您可以先选择新建成绩单~");
                        break;
                    }
                    System.out.print("请输入成绩单编号，选择为哪张成绩单新建学生成绩项：");
                    transcriptId = input.nextInt();
                    input.nextLine();
                    if (transcriptId <= 0 || transcriptId > transcriptList.size()) {
                        System.out.println("输入的成绩单编号不合法！");
                        break ;
                    }
                    Student student = new Student();
                    System.out.print("输入该学生的学号：");
                    student.setSchoolId(input.nextLine());
                    System.out.print("输入该学生的姓名：");
                    student.setName(input.nextLine());
                    System.out.print("输入该学生的考勤成绩：");
                    student.setAttendanceScore(input.nextDouble());
                    System.out.print("输入该学生的平时成绩：");
                    student.setUsualScore(input.nextDouble());
                    System.out.print("输入该学生的期末成绩：");
                    student.setExamScore(input.nextDouble());
                    TranscriptController.addStudentItem(transcriptId, student);
                    System.out.println("已添加~");
                    break;
                case 3:
                    if (transcriptList == null || transcriptList.size() == 0) {
                        System.out.println("当前成绩单为空，您可以先选择新建成绩单~");
                        break;
                    }
                    System.out.print("请输入成绩单编号，选择从哪种成绩单中查找学生成绩：");
                    transcriptId = input.nextInt();
                    input.nextLine();
                    if (transcriptId <= 0 || transcriptId > transcriptList.size()) {
                        System.out.println("输入的成绩单编号不合法！");
                        break ;
                    }
                    System.out.print("输入该学生的学号：");
                    schoolId = input.nextLine();
                    findStudent = TranscriptController.findScoreById(transcriptId, schoolId);
                    if (findStudent == null) {
                        System.out.println("该成绩单没有找到该学生的信息， 请检查是否输入错误该学生的学号！");
                        break;
                    }
                    System.out.println("该学生信息如下：");
                    System.out.println("学号\t\t\t\t姓名\t\t考勤成绩\t平时成绩\t期末成绩\t总评成绩");
                    System.out.printf("%s\t%s\t%.2f\t%.2f\t%.2f\t%.2f\n", findStudent.getSchoolId(),
                            findStudent.getName(), findStudent.getAttendanceScore(), findStudent.getUsualScore(),
                            findStudent.getExamScore(), findStudent.getTotalScore());
                    break;
                case 4:
                    if (transcriptList == null || transcriptList.size() == 0) {
                        System.out.println("当前成绩单为空，您可以先选择新建成绩单~");
                        break;
                    }
                    System.out.print("请输入成绩单编号，选择从哪张成绩单中删除学生成绩：");
                    transcriptId = input.nextInt();
                    input.nextLine();
                    if (transcriptId <= 0 || transcriptId > transcriptList.size()) {
                        System.out.println("输入的成绩单编号不合法！");
                        break ;
                    }
                    System.out.print("输入该学生的学号：");
                    schoolId = input.nextLine();
                    findStudent = TranscriptController.findScoreById(transcriptId, schoolId);
                    if (findStudent == null) {
                        System.out.println("该成绩单没有找到该学生的信息， 请检查是否输入错误该学生的学号！");
                        break;
                    }
                    TranscriptController.deleteScoreById(transcriptId, schoolId);
                    System.out.println("该学生的信息已成功删除！");
                    break;
                case 5:
                    if (transcriptList == null || transcriptList.size() == 0) {
                        System.out.println("当前成绩单为空，您可以先选择新建成绩单~");
                        break;
                    }
                    System.out.println("请输入要查看的成绩单的编号：");
                    transcriptId = input.nextInt();
                    input.nextLine();
                    if (transcriptId <= 0 || transcriptId > transcriptList.size()) {
                        System.out.println("输入的成绩单编号不合法！");
                        break ;
                    }
                    String result = TranscriptController.showTranscript(transcriptId);
                    System.out.println("该成绩单信息如下：");
                    System.out.println(result);
                    break;
                case 0:
                    System.out.println("是否要将成绩单的数据写入文件中，如果要，请在本应用项目下创建一个result目录：");
                    System.out.println("是否写入文件(y/n):");
                    String write = input.nextLine();
                    if ("y".equals(write) || "Y".equals(write)) {
                        TranscriptController.writeResult();
                        System.out.println("请前往result目录下查看");
                    }
                    break mainWhile;
                default:
                    System.out.println("错误：输入选择有误！！！！");
                    break;
            }
        }



    }
}

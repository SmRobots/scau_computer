package cn.net.smrobot.dao;

import cn.net.smrobot.domain.Student;
import cn.net.smrobot.domain.Transcript;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 用来将数据进行保存
 * 每张成绩单保留一个文件
 * @author smrobot
 */
public class FileUtils {

    /**
     * 获取文件中所有的成绩单
     * @return
     */
    public static List<Transcript> getFileTranscriptList() throws FileNotFoundException{
        File file = new File("result/");
        if (!file.exists()) {
            throw new FileNotFoundException("建议您在项目目录中创建result文件夹(不创建也不影响您后续操作！)");
        }
        File[] files = file.listFiles();
        List<Transcript> transcriptList = new ArrayList<>();
        BufferedReader  bufferedReader = null;
        for (File file1 : files) {
            Transcript transcript = new Transcript();
            bufferedReader = new BufferedReader(new FileReader(file1));
            try {
                bufferedReader.readLine();
                String line = bufferedReader.readLine();
                transcript.setClassName(line.split("：")[1]);
                line = bufferedReader.readLine();
                transcript.setCourseName(line.split("：")[1]);
                bufferedReader.readLine();
                while (bufferedReader.ready()) {
                    line = bufferedReader.readLine();
                    String[] strings = line.split("\t");
                    Student student = new Student();
                    student.setSchoolId(strings[0]);
                    student.setName(strings[1]);
                    student.setAttendanceScore(Double.parseDouble(strings[2]));
                    student.setUsualScore(Double.parseDouble(strings[3]));
                    student.setExamScore(Double.parseDouble(strings[4]));
                    student.setTotalScore(Double.parseDouble(strings[5]));
                    transcript.getStudentList().add(student);
                }
                transcript.setTotalStudentCount(transcript.getStudentList().size());
                transcriptList.add(transcript);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
        return transcriptList.size() == 0 ? null : transcriptList;
    }

    /**
     * 将成绩单对象写入文件中
     */
    public static void writeTranscript(Transcript transcript) {
        String filePath = "result/" + transcript.getClassName() + "_" + transcript.getCourseName() + ".txt";
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write("成绩单\n");
            bufferedWriter.write("班级：" + transcript.getClassName() + "\n");
            bufferedWriter.write("课程：" + transcript.getCourseName() + "\n");
            bufferedWriter.write("学号\t\t\t\t姓名\t\t考勤成绩\t平时成绩\t期末成绩\t总评成绩\n");
            List<Student> studentList = transcript.getStudentList();
            for (Student student : studentList) {
                String item = String.format("%s\t%s\t%.2f\t%.2f\t%.2f\t%.2f\n", student.getSchoolId(),
                        student.getName(), student.getAttendanceScore(), student.getUsualScore(),
                        student.getExamScore(), student.getTotalScore());
                bufferedWriter.write(item);
            }
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}

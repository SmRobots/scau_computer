package cn.net.smrobot.controller;

import cn.net.smrobot.dao.FileUtils;
import cn.net.smrobot.domain.Student;
import cn.net.smrobot.domain.Transcript;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * 成绩单管理程序
 * @author smrobot
 */
public class TranscriptController {

    /**
     * 程序运行时所有的成绩单列表
     */
    private static List<Transcript> transcriptList;

    /**
     * 先读取文件中所有的成绩单
     */
    static {
        try {
            transcriptList = FileUtils.getFileTranscriptList();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取现有的所有成绩单
     * @return
     */
    public static List<Transcript> getAllTranscript() {
        return transcriptList;
    }

    /**
     * 创建新的成绩单
     * @param transcript 要创建的成绩单
     */
    public static boolean createNewTranscript(Transcript transcript) {
        if (transcriptList == null) {
            transcriptList = new ArrayList<>();
        }
        transcriptList.add(transcript);
        return true;
    }

    /**
     * 添加成绩项
     */
    public static void addStudentItem(int transcriptId, Student student) {
        // 获取对应的成绩单
        Transcript transcript = transcriptList.get(transcriptId - 1);
        // 将该学生成绩添加进成绩单中
        transcript.getStudentList().add(student);
        transcript.setTotalStudentCount(transcript.getTotalStudentCount() + 1);
        transcript.setHasChange(true);
    }

    /**
     * 根据学号查找学生成绩
     */
    public static Student findScoreById(int transcriptId, String schoolId) {
        // 在成绩单列表中获取成绩单
        Transcript transcript = transcriptList.get(transcriptId - 1);
        List<Student> studentList = transcript.getStudentList();
        for (Student student : studentList) {
            if (student.getSchoolId().equals(schoolId)) {
                return student;
            }
        }
        return null;

    }

    /**
     * 根据学号删除学生扯你
     */
    public static void deleteScoreById(int transcriptId, String schoolId) {
        Transcript transcript = transcriptList.get(transcriptId - 1);
        List<Student> studentList = transcript.getStudentList();
        studentList.removeIf(student -> student.getSchoolId().equals(schoolId));
        transcript.setTotalStudentCount(transcript.getTotalStudentCount() - 1);
        transcript.setHasChange(true);
    }

    /**
     * 展示成绩单中的所有数据
     * @param transcriptId
     * @return
     */
    public static String showTranscript(int transcriptId) {
        Transcript transcript = transcriptList.get(transcriptId - 1);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("成绩单\n");
        stringBuffer.append("班级：").append(transcript.getClassName()).append("\n");
        stringBuffer.append("课程").append(transcript.getCourseName()).append("\n");
        stringBuffer.append("学号\t\t\t\t姓名\t\t考勤成绩\t平时成绩\t期末成绩\t总评成绩").append("\n");
        stringBuffer.append("---------------------------------------------------\n");
        List<Student> studentList = transcript.getStudentList();
        for (Student student : studentList) {
            String item = String.format("%s\t%s\t%.2f\t%.2f\t%.2f\t%.2f\n", student.getSchoolId(),
                    student.getName(), student.getAttendanceScore(), student.getUsualScore(),
                    student.getExamScore(), student.getTotalScore());
            stringBuffer.append(item);
        }
        stringBuffer.append("---------------------------------------------------\n");
        return stringBuffer.toString();
    }

    /**
     * 如果成绩单被修改过了
     * 则将成绩单重新写入文件中，
     * 否则不进行写入
     */
    public static void writeResult() {

        for (Transcript transcript : transcriptList) {
            if (transcript.isHasChange()) {
                FileUtils.writeTranscript(transcript);
            }
        }


    }
}

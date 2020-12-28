package cn.net.smrobot.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 成绩单对象
 * @author smrobot
 */
public class Transcript {

    /**
     * 成绩单的班级名称
     */
    private String className;

    /**
     * 成绩单的课程名称
     */
    private String courseName;

    /**
     * 成绩单中的学生信息
     */
    private List<Student> studentList;

    /**
     * 成绩单中的学生总人数
     */
    private Integer totalStudentCount;

    /**
     * 该成绩单是否被修改 - 如果修改过后，退出程序时需要将修改的进行覆盖写入，如果没有修改就不用再覆盖写入了
     */
    private boolean hasChange;

    public Transcript() {
        studentList = new ArrayList<>();
        totalStudentCount = 0;
        className = "";
        courseName = "";
    }


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Integer getTotalStudentCount() {
        return totalStudentCount;
    }

    public void setTotalStudentCount(Integer totalStudentCount) {
        this.totalStudentCount = totalStudentCount;
    }

    public boolean isHasChange() {
        return hasChange;
    }

    public void setHasChange(boolean hasChange) {
        this.hasChange = hasChange;
    }
}

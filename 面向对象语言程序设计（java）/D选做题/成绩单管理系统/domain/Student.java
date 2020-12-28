package cn.net.smrobot.domain;

/**
 * 学生实体类
 * @author zhangshaolong
 */
public class Student {

    /**
     * 学号
     */
    private String schoolId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 考勤成绩
     */
    private Double attendanceScore;

    /**
     * 平时成绩
     */
    private Double usualScore;

    /**
     * 期末成绩
     */
    private Double examScore;

    private Double totalScore;

    public Student() {}

    /**
     * 访问器和修改器
     */
    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAttendanceScore() {
        return attendanceScore;
    }

    public void setAttendanceScore(Double attendanceScore) {
        this.attendanceScore = attendanceScore;
    }

    public Double getUsualScore() {
        return usualScore;
    }

    public void setUsualScore(Double usualScore) {
        this.usualScore = usualScore;
    }

    public Double getExamScore() {
        return examScore;
    }

    public void setExamScore(Double examScore) {
        this.examScore = examScore;
    }

    /**
     * 计算期末总评成绩
     * @return
     */
    public Double getTotalScore() {
        if (examScore >= 60) {
            totalScore = attendanceScore * 0.1;
            totalScore += usualScore * 0.3;
            totalScore += examScore * 0.6;
            return  totalScore;
        }
        totalScore = examScore;
        return totalScore;
    }

    public void setTotalScore(Double totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return "Student{" +
                "schoolId='" + schoolId + '\'' +
                ", name='" + name + '\'' +
                ", attendanceScore=" + attendanceScore +
                ", usualScore=" + usualScore +
                ", examScore=" + examScore +
                '}';
    }
}

package top.mcso.sms.entity;

public class Teacher {
    private String jobNumber;
    private String teacherName;
    private String gender;
    private int age;
    private String duty;

    public Teacher(String jobNumber, String teacherName, String gender, int age, String duty) {
        this.jobNumber = jobNumber;
        this.teacherName = teacherName;
        this.gender = gender;
        this.age = age;
        this.duty = duty;
    }

    public String getjobNumber() {
        return jobNumber;
    }

    public void setjobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getteacherName() {
        return teacherName;
    }

    public void setteacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getduty() {
        return duty;
    }

    public void setduty(String duty) {
        this.duty = duty;
    }

    @Override
    public String toString() {
        return "教师 [工号=" + jobNumber + ", 姓名=" + teacherName + ", 性别=" + gender + ", 年龄=" + age + ", 职务=" + duty + "]";
    }
}

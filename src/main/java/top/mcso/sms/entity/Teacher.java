package top.mcso.sms.entity;

public class Teacher {
    private String employeeNumber;  // 工号
    private String name;         // 姓名
    private String gender;       // 性别
    private int age;            // 年龄
    private String position;     // 职务

    public Teacher(String employeeNumber, String name, String gender, int age, String position) {
        this.employeeNumber = employeeNumber;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.position = position;
    }

    public String getemployeeNumber() {
        return employeeNumber;
    }

    public void setemployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "教师 [工号=" + employeeNumber + ", 姓名=" + name + ", 性别=" + gender + ", 年龄=" + age + ", 职务=" + position + "]";
    }
}

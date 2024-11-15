package top.mcso.sms.entity;

public class Student {
    private String studentNumber ;
    private String name;
    private String gender;
    private int age;

    public Student(String studentNumber , String name, String gender, int age) {
        this.studentNumber  = studentNumber ;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getstudentNumber () {
        return studentNumber ;
    }

    public void setstudentNumber (String studentNumber ) {
        this.studentNumber  = studentNumber ;
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

    @Override
    public String toString() {
        return "学生 [学号=" + studentNumber  + ", 姓名=" + name + ", 性别=" + gender + ", 年龄=" + age + "]";
    }
}
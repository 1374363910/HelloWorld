package StuDB;

public class Student {
    private int StuID;
    private String StuName;
    private String StuSex;
    private int StuAge;
    private String StuTel;
    private int JavaGrade;


    public Student(int StuID,String StuName,String StuSex,int StuAge,String StuTel,int JavaGrade){
        this.StuID = StuID;
        this.StuName = StuName;
        this.StuSex = StuSex;
        this.StuAge = StuAge;
        this.StuTel = StuTel;
        this.JavaGrade = JavaGrade;
    }

    //返回StuID
    public int getStuID() {
        return StuID;
    }

    public String getStuName() {
        return StuName;
    }

    public String getStuSex() {
        return StuSex;
    }

    public int getStuAge() {
        return StuAge;
    }

    public String getStuTel() {
        return StuTel;
    }

    public int getJavaGrade() {
        return JavaGrade;
    }

    //设置StuID
    public void setStuID(int stuID) {
        StuID = stuID;
    }

    public void setStuName(String stuName) {
        StuName = stuName;
    }

    public void setStuSex(String stuSex) {
        StuSex = stuSex;
    }

    public void setStuAge(int stuAge) {
        StuAge = stuAge;
    }

    public void setStuTel(String stuTel) {
        StuTel = stuTel;
    }

    public void setJavaGrade(int javaGrade) {
        JavaGrade = javaGrade;
    }
}

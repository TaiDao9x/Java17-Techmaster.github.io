package encapsulation_demo;

public class Student {
    private String code;
    private double avgScore;
    private int age;
    private String lop;

    public Student() {
    }

    public Student(String code, double avgScore, int age, String lop) {
        this.code = code;
        this.avgScore = avgScore;
        this.age = age;
        this.lop = lop;
    }
//    public Student(String code, double score, int age, String lop) {
//        setCode(code);
//        setAvgScore(score);
//        setAge(age);
//        setLop(lop);
//    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if (code.length() != 8) {
            System.out.println("Mã sinh viên phải có độ dài 8 ký tự!");
            return;
        }
        this.code = code;
    }

    public double getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(double avgScore) {
        if (avgScore < 0 || avgScore > 10) {
            System.out.println("Điểm phải từ 0 đến 10");
            return;
        }
        this.avgScore = avgScore;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 18) {
            System.out.println("Tuổi phải lớn hơn hoặc bằng 18");
            return;
        }
        this.age = age;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        if (!lop.startsWith("A") && !lop.startsWith("C")) {
            System.out.println("Tên lớp phải bắt đầu bằng A hoặc C");
            return;
        }
        this.lop = lop;
    }

    public void showInfo() {
        System.out.println(this);
    }

    public boolean checkScholarship(Student code) {
        return code.avgScore >= 8;
    }

    @Override
    public String toString() {
        return "Student{" +
                "code='" + code + '\'' +
                ", avgScore=" + avgScore +
                ", age=" + age +
                ", lop='" + lop + '\'' +
                '}';
    }
}

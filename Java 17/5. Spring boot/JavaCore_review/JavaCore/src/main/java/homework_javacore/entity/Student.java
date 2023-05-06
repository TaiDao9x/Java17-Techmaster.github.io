package homework_javacore.entity;

public class Student extends Person {
    private int id;
    private String clazz;

    private static int AUTO_ID = 10000;

    public Student() {
        this.id = AUTO_ID;
        AUTO_ID++;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name=" + name +
                ", address=" + address +
                ", phone=" + phone +
                ", clazz='" + clazz + '\'' +
                '}';
    }

    @Override
    public void inputInfo() {
        super.inputInfo();
        System.out.print("Nhập vào tên lớp: ");
        this.setClazz(sc.nextLine());
    }
}

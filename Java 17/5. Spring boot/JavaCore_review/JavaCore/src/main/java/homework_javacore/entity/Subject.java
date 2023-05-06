package homework_javacore.entity;

import homework_javacore.statics.TypeSubject;
import homework_javacore.ultility.Ultility;

import java.util.Scanner;

public class Subject {
    private int id;
    private String name;
    private int unit;
    private TypeSubject typeSubject;

    private static int AUTO_ID = 100;

    public Subject() {
        this.id = AUTO_ID;
        AUTO_ID++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public TypeSubject getTypeSubject() {
        return typeSubject;
    }

    public void setTypeSubject(TypeSubject typeSubject) {
        this.typeSubject = typeSubject;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", số học trình=" + unit +
                ", typeSubject=" + typeSubject +
                '}';
    }

    Scanner sc = new Scanner(System.in);

    public void inputInfo() {
        System.out.print("Tên môn học: ");
        this.setName(sc.nextLine());
        System.out.print("Số đơn vị học trình: ");
        this.setUnit(Ultility.getUnitValid());
        getSubjectType();
    }

    private void getSubjectType() {
        System.out.println("Chọn loại môn: ");
        System.out.println("1. Đại cương");
        System.out.println("2. Cơ sở ngành");
        System.out.println("3. Chuyên ngành");
        int option = Ultility.getSubjectTypeValid();
        switch (option) {
            case 1 -> this.setTypeSubject(TypeSubject.DAI_CUONG);
            case 2 -> this.setTypeSubject(TypeSubject.CO_SO_NGANH);
            case 3 -> this.setTypeSubject(TypeSubject.CHUYEN_NGANH);
        }
    }

}

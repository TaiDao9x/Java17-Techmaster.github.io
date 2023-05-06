package homework_javacore.entity;

import homework_javacore.statics.TypeSubject;

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
                ", unit=" + unit +
                ", typeSubject=" + typeSubject +
                '}';
    }
}

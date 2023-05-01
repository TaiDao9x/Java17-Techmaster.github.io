package homework_01.entity;

import homework_01.statics.WorkerLevel;

public class Worker extends Person {

    private int id;
    private WorkerLevel level;

    private static int AUTO_ID = 1000;

    public Worker() {
        this.id = AUTO_ID;
        AUTO_ID++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id + ", name=" + super.name + ", address=" + super.address + ", phone=" + super.phone +
                ", level=" + level +
                '}';
    }
}

package Enum;

public class Task {
    String code;
    String name;

    public Task(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Task{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

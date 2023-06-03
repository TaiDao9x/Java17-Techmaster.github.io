package Enum;

public enum Status {
    TODO("TODO", "To Do"),
    IN_PROGRESS("IN_PROGRESS", "In progress"),
    REVIEWING("REVIEWING", "Reviewing"),
    COMPLETED("COMPLETED", "Completed");

    public String code;
    public String name;

    Status(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package athome;

import java.util.Calendar;

public class Person {
    public String name;
    public String code;
    public int birthday;

    //CONSTRUCTOR
//    public Person(String vName, String vCode, int vBirthday) {
//        this.name = vName;
//        this.code = vCode;
//        this.birthday = vBirthday;
//    }

    // SETTER
    public void setName(String name) {
        this.name = name;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    // GETTER
    public String getName() {
        return name;
    }
    public String getCode() {
        return code;
    }
    public int getBirthday() {
        return birthday;
    }


    public int getAge() {
        Calendar now = Calendar.getInstance();
        return now.get(Calendar.YEAR) - this.birthday;

    }

    // Show info
    public void showInfo() {
        System.out.println("Info:");
        System.out.println("Name \t\t: " + this.getName());
        System.out.println("Code \t\t: " + this.getCode());
        System.out.println("Birthday \t: " + this.getBirthday());
        System.out.println("Age \t\t: " + this.getAge());
    }
}

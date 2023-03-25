package athome;

public class Main {
    public static void main(String[] args) {

        Person personObj = new Person();
//        personObj.showInfo();

        Student studentObj = new Student();
        studentObj.setName("Linh Chi");
        studentObj.showInfo();

        Teacher teacherObj = new Teacher();
        teacherObj.setName("Tài");
        teacherObj.showInfo();

        for (char i = 0; i < 255; i++) {
            System.out.println(i);
        }
    }



}

package gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ObjJson {
    public static void main(String[] args) {
        // Tạo đối tượng gson
        // Gson gson = new Gson();

        // Nếu muốn format JSON cho đẹp
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        // Khởi tạo đối tượng từ class Student
        Student student = new Student(1, "Bùi Hiên", 25, "hien@techmaster.vn");

        // Convert Object to JSON
        String studentJson = gson.toJson(student);
        System.out.println(studentJson);

        Student student1 = gson.fromJson(studentJson, Student.class);
        System.out.println(student1);
    }
}

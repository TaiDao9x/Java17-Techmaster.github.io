package homework_10_student_managerment.repository;

import homework_10_student_managerment.database.StudentDatabase;
import homework_10_student_managerment.model.Student;

import java.util.ArrayList;

public class StudentRepository {
    public ArrayList<Student> allStudent(){
        return StudentDatabase.studentList;
    }




}

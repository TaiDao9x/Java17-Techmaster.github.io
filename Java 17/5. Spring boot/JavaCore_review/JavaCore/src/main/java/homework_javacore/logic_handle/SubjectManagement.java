package homework_javacore.logic_handle;

import homework_javacore.entity.Subject;
import homework_javacore.ultility.Ultility;

import java.util.ArrayList;
import java.util.List;

public class SubjectManagement {
    private List<Subject> subjects = new ArrayList<>();

    public void inputInfo() {
        System.out.println("Bạn muốn thêm bao nhiêu môn học?");
        int numberSubjuect = Ultility.getNumberValid();
        for (int i = 0; i < numberSubjuect; i++) {
            Subject subject = new Subject();
            subject.inputInfo();
            subjects.add(subject);
        }
        showSubject();
    }

    public void showSubject() {
        subjects.forEach(System.out::println);
    }
}

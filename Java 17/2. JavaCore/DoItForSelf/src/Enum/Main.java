package Enum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        List<Status> statuses = Arrays.asList(Status.values());

        System.out.println(Arrays.toString(Status.values()));
        for (Status st : statuses) {
            Task task = new Task(st.code, st.name);
            tasks.add(task);
        }

        tasks.forEach(System.out::println);
    }
}

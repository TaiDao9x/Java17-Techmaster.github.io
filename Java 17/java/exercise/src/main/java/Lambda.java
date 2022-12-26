import org.example.Staff;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lambda {
    public static void main(String[] args) {
        List<Staff> list = new ArrayList<>();
        list.addAll(Arrays.asList(
                new Staff("1","AnhNN"),
                new Staff("2","MinhNQ")
        ));

        list.forEach(e-> System.out.println("ID: "+e.getId()+" Tên: "+e.getName()));
    }
}

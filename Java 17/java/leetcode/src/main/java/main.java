import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Đào");
        list.add("Văn");
        list.add("Tài");
        list.add("abc");
        list.stream().limit(3).collect(Collectors.toList());
        System.out.println( list.stream().limit(3).collect(Collectors.toList()));
    }
}

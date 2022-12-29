package stream_api;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Practise {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(3, 10, 5, 3, 12, 6, 7, 5, 3);

//        1. Duyệt numbers
//        numbers.stream().forEach(System.out::println);

//        2. Tìm các giá trị chẵn trong list
//        numbers.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

//        3. Tìm các giá trị > 5 trong list
//        numbers.stream().filter(n -> n > 5).forEach(System.out::println);

//        4. Tìm giá trị max trong list
//        List<Integer> listSort = numbers.stream().sorted().toList();
//        Integer max = listSort.get(listSort.size() - 1);
//        System.out.println(max);
//
//        Optional<Integer> optionalMax = numbers.stream().max((a, b) -> a - b);
//        optionalMax.ifPresent(System.out::println);

//        5. Tìm giá trị min trong list
//        6. Tính tổng các phần tử của mảng
//        Integer total = numbers.stream().mapToInt(n -> n).sum();
//        System.out.println(total);


        // 0: giá trị ban đầu của biến hứng tổng, a: kết quả, b: các giá trị bên trong
//        int total1 = numbers.stream().reduce(0, (a, b) -> a + b);
//        System.out.println(total1);

//       7. Lấy danh sách các phần tử không trùng nhau
//        numbers.stream().distinct().forEach(System.out::println);

//       8. Lấy 5 phần tử đầu tiên trong mảng
//        numbers.stream().limit(5).forEach(System.out::println);

//       9. Lấy phần tử từ thứ 3 -> thứ 5
//        numbers.stream().skip(2).limit(3).forEach(System.out::println);

//       10.  Lấy phần tử đầu tiên > 5
//        numbers.stream().filter(n -> n > 5).findFirst().ifPresent(System.out::println);
//        List<Integer> list = numbers.stream().filter(n -> n > 5).limit(1).toList();
//        if (list.size() > 0) {
//            System.out.println(list.get(0));
//        }
//       11. Kiểm tra xem list có phải là list chẵn hay không
//        System.out.println(numbers.stream().allMatch(n -> n % 2 == 0));

//       12. Kiểm tra xem list có phần tử > 10 hay không
//        System.out.println(numbers.stream().anyMatch(n -> n > 10));

//       13. Có bao nhiêu phần tử > 5
//        System.out.println(numbers.stream().filter(n -> n > 5).count());

//       14. Nhân đôi các phần tủ trong list và trả về list mới
//        List<Integer> listX2 = numbers.stream().map(n -> n * 2).toList();
//        System.out.println(listX2);

//       15.   Kiểm tra xem list không chứa giá trị nào = 8 hay không
        System.out.println(numbers.stream().noneMatch(n -> n == 8));
    }
}

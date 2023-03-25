public class Main {
    // Phạm vi global: khai báo bên ngoài Method
    public static String globalVar = "Global Variable";
    // Phạm vi method: khai báo bên trong method
    // Phạm vi block: khai báo bên trong dấu ngoặc nhọn {}
    public static void main(String[] args) {

        System.out.println("Hello World");

        //Khai báo biến

        String firstName;
        String lastName;

        //Gán giá trị cho biến
        firstName= "Đào";
        lastName= "Tài";
        String fullName = firstName + " " +lastName;
        int age = 25;
        String address = "Vĩnh Phúc";


        System.out.println("firstNam = " + firstName);
        System.out.println("lastName = " + lastName);
        System.out.println("fullName = " + fullName);
        System.out.println("Xin chào, tôi tên là: " + fullName + ". Năm nay tôi");


        //        Khai báo các kiểu dữ liệu

        long salary = 1_000_000_000L;
        double height = 1.7;
        float weight = 30.6f;

        boolean isExit = true;
        boolean isMarry = false;

        char characterA = 'A';
        char characterB = 66;

        System.out.println(characterA);
        System.out.println(characterB);

        // Ép kiểu
        //Ép kiểu ngầm định: từ nhỏ sang lớn

        int number = 10;
        long numberOne = number;

        //Ép kiểu tường minh

        short numberTwo = (short) number;

        System.out.println(globalVar);

        //phạm vi block
        {
            String blockVar = "Block Variable";
            System.out.println(blockVar);
        }
//        System.out.println(blockVar); ngoài phạm vi sử dụng
    }
}
public class ForDemo {
    public static void main(String[] args) {
        //thức dậy 5h sáng mỗi ngày
//        for (int day = 1; day <= 30; day++) {
//            if (day % 2 == 0) {
//                System.out.println("Ngày " + day + " thức dậy lúc 5h");
//            } else {
//                System.out.println("Ngày " + day + " thức dậy lúc 7h");
//            }
//
//        }

        // Thực hiện đến ngày 20 chán không dậy nữa
//        for (int day = 1; day <= 30; day++) {
//            if (day == 20) {
//                System.out.println("Chán quá, từ bỏ");
//                break;
//            }
//            System.out.println("Ngày " + day + " thức dậy lúc 5h");
//        }

        // Cuối tuần nghỉ không thực hiện
//        for (int day = 1; day <= 30; day++) {
//            if (day % 7 == 0) {
//                System.out.println("Hôm nay nghỉ");
//                continue;
//            }
//            System.out.println("Ngày " + day + " thức dậy lúc 5h");
//        }

        // tính tiền tiết kiệm
        // TIết kiệm tiền trong 10 ngày, mỗi ngày 100k

        int total = 0;
//        for (int day = 1; day < 11; day++) {
//            total += 100_000;
//        }

        for (int day = 1; day < 11; day++) {
            if (day >= 5) {
                total += 200_000;
            } else {
                total += 100_000;
            }
        }
        System.out.println("Tổng tiền: " + total);
    }
}

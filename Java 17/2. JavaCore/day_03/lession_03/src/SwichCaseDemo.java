public class SwichCaseDemo {
    public static void main(String[] args) {
        int day = 6;

        switch (day) {
            case 0: {
                System.out.println("Hôm nay là chủ nhật");
                break;
            }
            case 1: {
                System.out.println("Hôm nay là thứ 2");
                break;
            }
            case 2: {
                System.out.println("Hôm nay là thứ 3");
                break;
            }
            case 3: {
                System.out.println("Hôm nay là thứ 4");
                break;
            }
            case 4: {
                System.out.println("Hôm nay là thứ 5");
                break;
            }
            case 5: {
                System.out.println("Hôm nay là thứ 6");
                break;
            }
            case 6: {
                System.out.println("Hôm nay là thứ 7");
                break;
            }
            default: {
                System.out.println("Không có nga phù hợp");
                break;
            }
        }

        int month = 9;
        switch (month) {
            case 1:
            case 2:
            case 3: {
                System.out.println("Mùa Xuân");
                break;
            }
            case 4:
            case 5:
            case 6: {
                System.out.println("Mùa Hạ");
                break;
            }
            case 7:
            case 8:
            case 9: {
                System.out.println("Mùa Thu");
                break;
            }
            case 10:
            case 11:
            case 12: {
                System.out.println("Mùa Đông");
                break;
            }
        }
    }
}


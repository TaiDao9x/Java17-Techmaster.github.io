package homework_javacore.logic_handle;

import homework_javacore.ultility.Ultility;

public class MenuManagement {
    private StudentManagement studentManagement = new StudentManagement();
    private SubjectManagement subjectManagement = new SubjectManagement();

//    public MenuManagement() {
//        this.studentManagement = new StudentManagement();
//    }

    public void runMenu() {
        while (true) {
            showMenu();
            int option = Ultility.getNumberValid();
            switch (option) {
                case 1:
                    studentManagement.inputInfo();
                    break;
                case 2:
                    subjectManagement.inputInfo();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 9:
                    return;
                default:
                    System.out.println("Lựa chọn không có. Hãy chọn lại!");
            }
        }

    }

    private void showMenu() {
        System.out.println("1. Nhập danh sách sinh viên mới. In ra danh sách sinh viên sau khi nhập.\n" +
                "2. Nhập danh sách môn học mới. In ra danh sách môn học sau khi nhập.\n" +
                "3. Nhập điểm cho mỗi sinh viên đã có và in danh sách ra màn hình.\n" +
                "4. Sắp xếp danh sách Bảng điểm\n" +
                "5. Tính điểm tổng kết chung cho mỗi sinh viên.\n" +
                "9. Thoát");

    }
}

package homework_book_managerment.controler;

import homework_book_managerment.model.Book;
import homework_book_managerment.service.BookService;

import java.util.Scanner;

public class BookControler {
    Scanner sc = new Scanner(System.in);
    BookService bookService = new BookService();

    public void runMenu() {

        boolean isQuit = true;

        while (isQuit) {
            showMenu();
            System.out.print("Nhập vào lựa chọn của bạn: ");
            String option = sc.nextLine();

            switch (option) {
                case "1":
                    System.out.println("\n*** DANH SÁCH THÔNG TIN TOÀN BỘ SÁCH: ");
                    bookService.getAllInfoBook();
                    break;
                case "2":
                    System.out.println("\n*** THÊM SÁCH MỚI: ");
                    bookService.addNewBook(newBook());
                    break;
                case "3":
                    findByName();
                    break;
                case "4":
                    findByCategory();
                    break;
                case "5":
                    findById();
                    break;
                case "6":
                    System.out.println("\n*** DANH SÁCH SÁCH ĐƯỢC SẮP XẾP THEO SỐ TRANG: ");
                    bookService.sortByPageNumber();
                    break;
                case "7":
                    System.out.println("\n*** DANH SÁCH SÁCH ĐƯỢC SẮP XẾP THEO SỐ NĂM XUẤT BẢN: ");
                    bookService.sortByReleaseYear();
                    break;

                case "0":
                    isQuit = false;
                    break;
                default:
                    System.out.println("Lựa chọn không tồn tại!");
                    break;
            }
        }
    }

    public void showMenu() {
        System.out.println("\n-------- MENU ---------");
        System.out.println("""
                1. Hiển thị thông tin toàn bộ sách
                2. Thêm sách mới
                3. Tìm sách theo tên
                4. Tìm sách theo thể loại
                5. Tìm sách theo id
                6. Sắp xếp theo số trang
                7. Sắp xếp theo năm xuất bản
                0. Thoát
                """);
    }

    public void subMenu(int id) {
        boolean isQuit = true;

        while (isQuit) {
            System.out.println("\nBạn muốn tiếp tục?");
            System.out.print("""
                    1. Xóa sách \t\t 2. Cập nhật sách\t\t 3. Trở về Menu
                    """);
            System.out.print("Bạn muốn: ");
            String option = sc.nextLine();

            switch (option) {
                case "1":
                    System.out.print("""
                            Bạn có thực sự muốn xóa sách này?
                            1. Có \t\t 2. Không
                            """);
                    System.out.print("Bạn chọn: ");
                    int yesOrNo = Integer.parseInt(sc.nextLine());

                    if (yesOrNo == 1) {
                        bookService.deleteById(id);
                        System.out.println("Đã xóa sách thành công!");
                        break;
                    } else {
                        break;
                    }
                case "2":
                    System.out.print("Nhập vào năm xuất bản bạn muốn cập nhật: ");
                    int newYear = Integer.parseInt(sc.nextLine());

                    bookService.updateYearById(id, newYear);
                    System.out.println("Đã cập nhật năm xuất bản thành công!");
                    break;
                case "3":
                    isQuit = false;
                    break;
                default:
                    System.out.println("Lựa chọn không tồn tại. Hãy chọn lại!");
                    break;
            }
        }
    }

    public Book newBook() {
        System.out.print("Nhập id: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập tên sách: ");
        String title = sc.nextLine();
        System.out.print("Sách mới theo mấy thể loại: ");
        int numOfCategory = Integer.parseInt(sc.nextLine());
        String[] category1 = new String[numOfCategory];
        for (int i = 0; i < numOfCategory; i++) {
            System.out.print("Thể loại thứ " + i + 1 + " : ");
            category1[i] = sc.nextLine();
        }
        System.out.print("Nhập tên Tác giả: ");
        String author = sc.nextLine();
        System.out.print("Nhập số trang: ");
        int pageNumber = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập năm xuất bản: ");
        int releaseYear = Integer.parseInt(sc.nextLine());
        Book book = new Book(id, title, category1, author, pageNumber, releaseYear);
        return book;
    }

    public void findByName() {
        System.out.print("Nhập vào tên sách muốn tìm: ");
        String findName = sc.nextLine();

        if (bookService.checkName(findName) > 0) {
            System.out.println("\n*** TÌM KIẾM SÁCH THEO TÊN: ");
            bookService.formattingDisplay();
            for (Book book : bookService.findByName(findName)) {
                System.out.println(book);
            }
        } else {
            System.out.println("Không có tên sách bạn muốn tìm!");
        }
    }

    public void findByCategory() {
        System.out.print("Nhập vào thể loại bạn muốn tìm: ");
        String category = sc.nextLine();

        if (bookService.checkCategory(category) > 0) {
            System.out.println("\n*** TÌM KIẾM SÁCH THEO THỂ LOẠI: ");
            bookService.formattingDisplay();
            for (Book book : bookService.findByCategory(category)) {
                System.out.println(book);
            }
        } else {
            System.out.println("Không có thể loại sách bạn muốn tìm!");
        }
    }

    public void findById() {
        System.out.print("Nhập vào id bạn muốn tìm: ");
        int id = Integer.parseInt(sc.nextLine());

        if (bookService.checkId(id) > 0) {
            System.out.println("\n*** TÌM KIẾM SÁCH THEO ID: ");
            bookService.formattingDisplay();
            for (Book book : bookService.findById(id)) {
                System.out.println(book);
            }
            subMenu(id);
        } else {
            System.out.println("Không có id bạn muốn tìm!");
        }
    }


}

package book_management.frontend.ui;

import book_management.backend.controler.BookControler;
import book_management.backend.exception.NotFoundException;
import book_management.backend.model.Book;
import book_management.backend.request.CreateBookRequest;
import book_management.backend.request.UpdateBookRequest;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.List;


public class BookUi {
    private final BookControler bookControler = new BookControler();

    public void runMenu() {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean isQuit = true;

        while (isQuit) {
            showMenu();
            try {
                System.out.print("Nhập vào lựa chọn của bạn: ");
                option = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("lựa chọn không hợp lệ!");
            }


            switch (option) {
                case 1: {
                    List<Book> books = bookControler.getBook();
                    if (books.isEmpty()) {
                        System.out.println("Không có quyển sách nào.");
                    } else {
                        System.out.println("Danh sách books: ");
                        for (Book b : books
                        ) {
                            System.out.println(b);
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.print("Nhập vào tên sách: ");
                    String name = sc.nextLine();

                    List<Book> books = bookControler.getBookByName(name);

                    if (books.isEmpty()) {
                        System.out.println("Không có quyển sách nào có tên là: " + name);
                    } else {
                        System.out.println("Danh sách books: ");
                        for (Book b : books
                        ) {
                            System.out.println(b);
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.print("Nhập id cần xóa: ");
                    int id = Integer.parseInt(sc.nextLine());

                    try {
                        bookControler.deleteBook(id);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }
                case 4: {
                    System.out.println("Nhập vào id cần sửa: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.println("Nhập vào tiêu đề: ");
                    String title = sc.nextLine();

                    System.out.println("Nhập vào tên tác giả: ");
                    String author = sc.nextLine();
                    UpdateBookRequest request = new UpdateBookRequest(title, author);

                    try {
                        Book book = bookControler.updateBook(id, request);
                        System.out.println("Thông tin sách sau khi cập nhật là: ");
                        System.out.println(book);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                }

                case 5:

                    System.out.println("Nhập vào tiêu đề: ");
                    String title = sc.nextLine();

                    System.out.println("Nhập vào tên tác giả: ");
                    String author = sc.nextLine();

                    System.out.println("Nhập vào số trang: ");
                    int pageNumber = Integer.parseInt(sc.nextLine());

                    System.out.println("Nhập vào năm xuất bản: ");
                    int releaseYear = Integer.parseInt(sc.nextLine());

                    CreateBookRequest createBookRequest = new CreateBookRequest(title, author, pageNumber, releaseYear);

                    Book book = bookControler.createBook(createBookRequest);
                    System.out.println("Sách mới bạn vừa thêm vào: ");
                    System.out.println(book);
                    break;
                case 0: {
                    isQuit = false;
                    break;
                }
                default: {
                    System.out.println("Lựa chọn không tồn tại!");
                    break;
                }
            }
        }
    }

    public void showMenu() {
        System.out.println("\n-------- MENU ---------");
        System.out.println("""
                1. Hiển thị thông tin toàn bộ sách
                2. Tìm sách theo tên
                3. Xóa sách theo id
                4. Thay đổi thông tin
                5. Thêm sách mới
                0.Thoát          
                """);
    }
}

package backend.ultils;

import backend.controler.BookControler;
import backend.model.Admin;
import backend.model.Book;
import backend.model.Item;
import backend.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class FileUltils {
    static Scanner sc = new Scanner(System.in);
    private static final BookControler bookControler = new BookControler();

    // Lấy data từ file json
    public static ArrayList<User> getUserDataFromFile(String fileName) {

        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(fileName));
            Type type = new TypeToken<ArrayList<User>>() {
            }.getType();
            ArrayList<User> users = gson.fromJson(reader, type);
            reader.close();
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static ArrayList<Book> getBookDataFromFile(String fileName) {

        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(fileName));
            Type type = new TypeToken<ArrayList<Book>>() {
            }.getType();
            ArrayList<Book> books = gson.fromJson(reader, type);
            reader.close();
            return books;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static ArrayList<Admin> getAdminDataFromFile(String fileName) {

        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(fileName));
            Type type = new TypeToken<ArrayList<Admin>>() {
            }.getType();
            ArrayList<Admin> admins = gson.fromJson(reader, type);
            reader.close();
            return admins;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static ArrayList<Item> getItemDataFromFile(String fileName) {

        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(fileName));
            Type type = new TypeToken<ArrayList<Item>>() {
            }.getType();
            ArrayList<Item> items = gson.fromJson(reader, type);
            reader.close();
            return items;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    // ghi data vào json
    public static void setDataToFile(String fileName, Object obj) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Writer writer = Files.newBufferedWriter(Paths.get(fileName));
            gson.toJson(obj, writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Các method định dạng in ra màn hình
    public static void printUser(User user) {
        System.out.printf("%-10s %-20s %-15s %-15s %-50s \n", "Username", "Email", "Password", "Phone", "Địa chỉ");
        System.out.println("--------------------------------------------------------------------------------------");

        System.out.printf("%-10s %-20s %-15s %-15s %-50s \n", user.getUserName(), user.getEmail(),
                user.getPassword(), user.getPhone(), user.getAddress().getDetail() + ", " + user.getAddress().getStreet() + ", " + user.getAddress().getDistrict() +
                        ", " + user.getAddress().getCity());

    }

    public static void printBook(ArrayList<Book> list) {
        System.out.printf("%-5s %-20s %-20s %-15s %-10s %-15s %-20s %-10s %-9s\n", "Id", "Tên sách", "Thể loại", "Tác giả",
                "Năm XB", "Giá", "Nhà xuất bản", "Số lượng", "Đánh giá");
        System.out.println("----------------------------------------------------------------------------------------------" +
                "-------------------------------------");
        for (Book book : list) {
            System.out.printf("%-5d %-20s %-20s %-15s %-10d %-15s %-20s %-10d %-9.1f\n", book.getId(), book.getTitle(), book.getCategory(),
                    book.getAuthor(), book.getReleaseYear(), formattingDisplay(book.getPrice()), book.getPublishCompany(),
                    book.getQuantity(), book.getRating());
        }
    }

    // Format số
    public static String formattingDisplay(int price) {
        DecimalFormat formatter = new DecimalFormat("###,###,### VND");
        return formatter.format(price);
    }


    // Lấy id sản phẩm
    public static int getId() {
        boolean back = false;
        int id = 0;

        while (!back) {
            try {
                System.out.print("Nhập id sản phẩm: ");
                id = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Hãy chọn lại!");
                continue;
            }
            if (bookControler.checkIdExist(id)) {
                back = true;
            } else {
                System.out.println("Id sản phẩm không tồn tại!");
            }
        }
        return id;
    }

    // Lấy option cho vòng lặp
    public static int getOption() {
        boolean checkOption = false;
        int option = 0;
        while (!checkOption) {
            try {
                System.out.print("Nhập lựa chọn của bạn: ");
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lựa chọn không hợp lệ. Hãy chọn lại!");
                continue;
            }
            checkOption = true;
        }
        return option;
    }
}

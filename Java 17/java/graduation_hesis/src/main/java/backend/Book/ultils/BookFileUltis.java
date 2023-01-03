package backend.Book.ultils;

import backend.Book.model.Book;
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

public class BookFileUltis {
    public static ArrayList<Book> getDataFromFile(String fileName) {

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

    public static String formattingDisplay(int price) {
        DecimalFormat formatter = new DecimalFormat("###,###,### VND");
        return formatter.format(price);
    }
}

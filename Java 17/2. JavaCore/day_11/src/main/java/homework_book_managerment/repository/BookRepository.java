package homework_book_managerment.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import homework_book_managerment.model.Book;

import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class BookRepository {

    public static List<Book> getListObjectFromJsonFile() {
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get("list-book.json"));

            List<Book> books = Arrays.asList(gson.fromJson(reader, Book[].class));

            reader.close();
            return books;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void convertObjectToJsonFile(Object obj) {

        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Writer writer = Files.newBufferedWriter(Paths.get("list-book.json"));

            gson.toJson(obj, writer);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
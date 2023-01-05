package backend.User.ultils;

import backend.User.model.Address;
import backend.User.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class UserFileUltils {
    public static ArrayList<User> getDataFromFile(String fileName) {

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

    public static void printUser(User user) {
        System.out.printf("%-10s %-20s %-15s %-15s %-50s \n", "Username", "Email", "Password", "Phone", "Địa chỉ");
        System.out.println("----------------------------------------------------------------------------------------------" +
                "---------------");

        System.out.printf("%-10s %-20s %-15s %-15s %-50s \n", user.getUserName(), user.getEmail(),
                user.getPassword(), user.getPhone(), user.getAddress().getDetail() + ", " + user.getAddress().getStreet() + ", " + user.getAddress().getDistrict() +
                        ", " + user.getAddress().getCity());

    }
}

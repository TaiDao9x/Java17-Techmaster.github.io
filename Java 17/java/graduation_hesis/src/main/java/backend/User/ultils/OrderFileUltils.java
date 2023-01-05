package backend.User.ultils;

import backend.User.model.Item;
import backend.User.model.Order;
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

public class OrderFileUltils {
    public static ArrayList<Order> getDataFromFile(String fileName) {

        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(fileName));
            Type type = new TypeToken<ArrayList<Order>>() {
            }.getType();
            ArrayList<Order> order = gson.fromJson(reader, type);
            reader.close();
            return order;
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

    public static void printPreOrder(Order order) {
        System.out.printf("%-5s %-20s %-10s %-15s %-20s \n", "Id", "Tên sách", "Số lượng", "Giá", "Thành tiền");
        System.out.println("---------------------------------------------------------------------");

        for (Item item : order.getItem()) {
            System.out.printf("%-5d %-20s %-10s %-15s %-20s \n", item.getId(), item.getBookName(), item.getCount(),
                    formattingDisplay(item.getPrice()), formattingDisplay(item.getCount() * item.getPrice()));
        }
        System.out.printf("Địa chỉ giao hàng: %-10s, %-20s, %-15s, %-15s, %-50s \n", order.getAddressShip().getDetail(),
                order.getAddressShip().getStreet(), order.getAddressShip().getDistrict(),
                order.getAddressShip().getCity());
    }

    public static String formattingDisplay(int price) {
        DecimalFormat formatter = new DecimalFormat("###,###,### VND");
        return formatter.format(price);
    }
}

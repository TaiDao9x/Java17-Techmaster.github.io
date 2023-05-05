package vehicle;

import java.util.Scanner;

public class Vehicle {
    Scanner sc = new Scanner(System.in);

    private String name;
    private int price;
    private int dungTich;

    public Vehicle() {
    }

    public Vehicle(String name, int price, int dungTich) {
        this.name = name;
        this.price = price;
        this.dungTich = dungTich;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDungTich() {
        return dungTich;
    }

    public void setDungTich(int dungTich) {
        this.dungTich = dungTich;
    }

    public double getTax() {
        if (this.dungTich > 200) {
            return (this.price * 0.05);
        } else if (this.dungTich > 100) {
            return this.price * 0.03;
        }
        return this.price * 0.01;
    }





    @Override
    public String toString() {
        return "Vehicle{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", dungTich=" + dungTich +
                '}';
    }
}

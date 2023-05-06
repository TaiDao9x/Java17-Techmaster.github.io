package homework_javacore.entity;

import java.util.Scanner;

public class Person implements InputInfo {
    protected String name;
    protected String address;
    protected String phone;


    public Person() {
    }

    public Person(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    Scanner sc = new Scanner(System.in);

    @Override
    public void inputInfo() {
        System.out.print("Nhập vào tên sinh viên: ");
        this.setName(sc.nextLine());
        System.out.print("Nhập vào địa chỉ: ");
        this.setAddress(sc.nextLine());
        System.out.print("Nhập vào số điện thoại: ");
        this.setPhone(sc.nextLine());
    }
}

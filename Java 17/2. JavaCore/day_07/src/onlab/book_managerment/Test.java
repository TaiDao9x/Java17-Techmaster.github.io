package onlab.book_managerment;

import onlab.book_managerment.controler.BookControler;

public class Test {
    public static void main(String[] args) {
        BookControler bookControler = new BookControler();
        bookControler.runMenu();
    }
}

package day09_linked_list;

public class Main {
    public static void main(String[] args) {
        DefaulDoublyLinkesList doublyLinkedList = new DefaulDoublyLinkesList();
        doublyLinkedList.add("Ahihi");
        doublyLinkedList.add("Ahuhu");

        System.out.println(doublyLinkedList.toString());
        doublyLinkedList.addFirst("first");
        doublyLinkedList.addLast("Last");
        System.out.println(doublyLinkedList.toString());

        System.out.println(doublyLinkedList.contain("Ahihi"));

        System.out.println(doublyLinkedList.indexOf("Ahihi"));

        doublyLinkedList.removeAt(2);
        System.out.println(doublyLinkedList.toString());

    }
}

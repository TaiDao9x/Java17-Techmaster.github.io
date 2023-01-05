import backend.User.controler.ItemController;

public class Test2 {
    public static void main(String[] args) {
        ItemController itemController = new ItemController();
        System.out.println(itemController.getCart("tai@gmail.com"));
    }
}

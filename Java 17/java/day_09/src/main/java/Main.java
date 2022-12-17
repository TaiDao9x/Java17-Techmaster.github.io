import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(8);

        ArrayList<Integer> b = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            int rand = random.nextInt(a.size() - 1);
            b.add(a.get(rand));
            a.remove(rand);
        }


        System.out.println(b);

        System.out.println(a);


    }
}

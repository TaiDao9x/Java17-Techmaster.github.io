import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class main {

    public static int findx(int x, int[] a, int i) {
        if (i >= a.length) {
            return -1;
        }
        if (a[i] == x) {
            return i;
        }
        return findx(x, a, i + 1);
    }

    public static int sum(int[] a, int i) {
        if (i >= a.length) {
            return 0;
        }

        return a[i] + sum(a, i+1);
    }

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5};
        System.out.println(sum(a, 0));
    }
}

package collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetInterfaceDemo {
    public static void main(String[] args) {

        Set<Integer> st = new HashSet<>();
        st.add(5);
        st.add(4);
        st.add(2);
        st.add(5);
        st.add(1);
        st.add(3);
        for (Integer i : st) {
            System.out.print(i + " ");
        }

        System.out.println();
        Set<Integer> st1 = new LinkedHashSet<>();
        st1.add(5);
        st1.add(4);
        st1.add(2);
        st1.add(5);
        st1.add(1);
        st1.add(3);
        for (Integer i : st1) {
            System.out.print(i + " ");
        }
    }

}

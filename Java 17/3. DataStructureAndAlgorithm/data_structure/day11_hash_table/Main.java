package day11_hash_table;

public class Main {
    public static void main(String[] args) {
        String s = "dao tai";

    }

    public static int myHashString(String s) {
        int hashCode = 0;

        for (char c : s.toCharArray()) {
            hashCode += c;
        }
        return hashCode;
    }
}

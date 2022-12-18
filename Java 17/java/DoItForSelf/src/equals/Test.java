package equals;

public class Test {
    public static void main(String[] args) {
        MyDate md1 = new MyDate(22, 11, "1992");

        MyDate md2 = new MyDate(25, 12, "1989");
        MyDate md3 = new MyDate(22, 11, "1992");

        System.out.println("So sánh md1 ới md2: " + md1.equals(md2));
        System.out.println("So sánh md1 ới md3: " + md1.equals(md3));

        if (md1.equals(md3)) {
            System.out.println("bằng nhau");
        } else {
            System.out.println("Không bằng");
        }
        if (md1.hashCode() == md2.hashCode()) {
            System.out.println("Bằng ");
        } else {
            System.out.println("no");
        }

        System.out.println(md1.getYear().equals(md3.getYear()));
        System.out.println(md1.getDay()==(md2.getDay()));
    }
}

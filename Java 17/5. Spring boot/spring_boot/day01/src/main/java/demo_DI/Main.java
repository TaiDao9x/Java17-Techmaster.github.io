package demo_DI;

public class Main {
    public static void main(String[] args) {
        Travel travel = new Travel(new Train() );
        travel.run();

    }

}

package demo_DI;

public class Travel {
    Vehicle vehicle;

    public Travel(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void run() {
        this.vehicle.move();
    }
}

package interface_demo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class Rectangle implements IShape {

    private double width;
    private double height;

    @Override
    public double getArea() {
        return this.width * this.height;
    }

    @Override
    public double getPerimeter() {
        return (this.width + this.height)*2;
    }

    @Override
    public void sayHello() {
        System.out.println("Hello, i am rectangle");
    }
}

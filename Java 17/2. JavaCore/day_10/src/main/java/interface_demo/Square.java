package interface_demo;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Square implements IShape {
    private double side;

    @Override
    public double getArea() {
        return this.side * this.side;
    }

    @Override
    public double getPerimeter() {
        return this.side * 4;
    }

    @Override
    public void sayHello() {
        System.out.println("square");
    }
}

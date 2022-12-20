package equals;


@FunctionalInterface
interface Hello {
    void sayHello();
}

public class LambdaExpression {
    public static void main(String[] args) {
        Hello h = () -> System.out.println("Xin chào các bạn");

        h.sayHello();
    }
}
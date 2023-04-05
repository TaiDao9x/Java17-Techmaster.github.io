import java.util.Arrays;

public class main {
    public static void main(String[] args) {
        System.out.println(sum());

    }
    public static int sum(){
        int result = 0;
        for (int i = 0; i <=10 ; i++) {
            if (i%5==0){
                result+=i;
            }
        }
        return result;
    }
}

package custom_exception;

public class Test {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        try {
            System.out.println(findIndexElement(arr, 4));
            System.out.println(findIndexElement(arr, 10));

        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    public static int findIndexElement(int[] arr, int ele) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == ele) {
                return i;
            }
        }
        throw new NotFoundException("Not found element with value = " + ele);
    }
}

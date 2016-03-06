public abstract class Utils {

    public static void validate(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void mark(int index, int width) {
        mark(index, width, '^');
    }

    public static void mark(int index, int width, char symbol) {
        for (int i = 0; i < index; i++) {
            System.out.print(' ');
        }
        for(int i = 0; i < width; i++) {
            System.out.print(symbol);
        }
        System.out.println();
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static void result(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("-");
        }
        System.out.println();
        print(arr);
    }

}

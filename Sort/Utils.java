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
        print(arr, "");
    }

    public static void print(int[] arr, String separator) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + separator);
        }
        System.out.println();
    }

    public static void print(int[] arr, String separator, int mark) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + separator);
            if(i == mark) {
                System.out.print("|" + separator);
            }
        }
        System.out.println();
    }

    public static void line() {
        System.out.println("--------------");
    }

    public static void result(int[] arr) {
        result(arr, "");
    }

    public static void result(int[] arr, String separator) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print("-");
        }
        System.out.println();
        print(arr, separator);
    }

}

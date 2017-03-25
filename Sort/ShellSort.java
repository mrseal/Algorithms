// Best Time Complexity: O(n)
// Worst TIme Complexity: O(nlog^2 n)

public class ShellSort {

    public static void sort(final int[] arr) {
        Utils.print(arr, " ");

        int d = arr.length / 2;
        while (d >= 1) {
            shellInsert(arr, d);
            d /= 2;
        }

        Utils.result(arr, " ");
    }

    public static void shellInsert(final int[] arr, final int d) {
        System.out.println("=============");
        System.out.println("====== d=" + d);
        for (int i = d; i < arr.length; i++) {
            System.out.println("====== i=" + i);
            int j = i - d;
            final int temp = arr[i];
            while (j >= 0 && arr[j] > temp) {
                arr[j + d] = arr[j];
                j -= d;
            }
            if (j != i - d) {
                arr[j + d] = temp;
            }
        }
        Utils.print(arr, " ");
    }

    public static void main(final String[] args) {
        final int[] arr = { 49, 38, 65, 97, 76, 13, 27, 49, 55, 4 };
        sort(arr);
    }

}

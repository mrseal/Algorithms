// Time Complexity: O(n)
// But it required a large heap size
import java.util.Arrays;

public class CountSort {

    public static void sort(int arr[]) {
        Utils.print(arr, " ");
        int max = max(arr);
        System.out.println("max=" + max);

        int[] count = new int[max + 1];
        for(int i=0; i<arr.length; i++) {
             count[arr[i]] ++;
        }
        Utils.print(count, ",");

        int k = 0;
        for (int i=0; i<=max; i++) {
            for (int j=0; j<count[i]; j++) {
                arr[k++] = i;
            }
        }
        Utils.result(arr, " ");
    }

    public static int max(int arr[]) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {49, 65, 38, 65, 97, 76, 13, 27};
        sort(arr);
    }

}

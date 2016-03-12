// Time Complexity  O(kn)  k is the bit of the max number
import java.util.*;

public class RadixSort {

    public static void sort(int[] arr) {
        Utils.print(arr, " ");
        int maxbit = getMaxBit(arr);
        System.out.println("max bit: " + maxbit);

        for (int i = 0; i < maxbit; i++) {
            List<List<Integer>> buf = distribute(arr, i);
            collect(arr, buf);
            Utils.print(arr, " ");
            Utils.line();
        }
    }

    public static List<List<Integer>> distribute(int[] arr, int bit) {
        List<List<Integer>> buf = new ArrayList<List<Integer>>();
        for(int j=0; j<10; j++) {
            buf.add(new LinkedList<Integer>());
        }
        for(int i=0; i<arr.length; i++) {
            buf.get(getBitAtN(arr[i], bit)).add(arr[i]);
        }
        return buf;
    }

    public static void collect(int[] arr, List<List<Integer>> buf) {
       int k=0; 
       for (int i=0; i<buf.size(); i++) {
            List<Integer> bucket = buf.get(i);
            System.out.println("bucket " + i + ": " + bucket);
            for (int element : bucket) {
                arr[k++] = element;
            }
        }
    }

    public static int getBitAtN(int x, int n) {
        int d=1;
        for (int i = 0; i < n; i++) {
            d *= 10;
        }
        return (x / d) % 10;
    }
 
    public static int getMaxBit(int[] arr) {
        int max = arr[0];
        for(int i=1; i<arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }
        return (max+"").length();
    }

    public static void main(String[] args) {
        int[] arr = {278, 109, 63, 930, 589, 184, 505, 269, 8, 83};
        sort(arr);
    }

}

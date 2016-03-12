// Time Complexity O(n + n*logn - n*logm)  'n' is the size of the arr, 'm' is the number of the bucket.  The best scenario would be m = n, then the time complexity is O(n)
// The key point of BucketSort is to find the appropriate f(n).  It should satisfy:  if n1<n2, then f(n1)<=f(n2).

import java.util.*;

public class BucketSort {

    public static void sort(int[] arr) {
        Utils.print(arr, " ");
        int bucketNum = 10; // Assume that the arr to be sorted is [0, 100)
        List<List<Integer>> buckets = new ArrayList<List<Integer>>();
        for (int i=0; i<bucketNum; i++) {
            buckets.add(new LinkedList<Integer>());
        }

        for (int i=0; i<arr.length; i++) {
            buckets.get(f(arr[i])).add(arr[i]);
        }

        for (int i=0; i<buckets.size(); i++) {
            List<Integer> bucket = buckets.get(i);
            System.out.println("bucket " + i + ": " + bucket);
            if(!bucket.isEmpty()) {
                Collections.sort(bucket);
            }
            System.out.println("After sort: " + bucket);
        }

        int k=0;
        for (List<Integer> bucket : buckets) {
            for (int element : bucket) {
                arr[k++] = element;
            }
        }

        Utils.result(arr, " ");
    }

    public static int f(int n) {
        return n/10;
    }

    public static void main(String[] args) {
        int[] arr = {49, 38, 35, 97, 76, 73, 27, 49};
        sort(arr);
    }

}

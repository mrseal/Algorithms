// 插入排序
// 时间复杂度 Time Complexity :  T(n) = O(n^2)

public class InsertSort {

    public static void sort(int[] arr) {
        Utils.validate(arr);

        System.out.println("Notes :");
        System.out.println("1. '^' means the target value to be inserted");
        System.out.println("2. '.' means the current value to be compared");
        System.out.println();

        for (int i = 1; i < arr.length; i++) { 
            Utils.print(arr);
            Utils.mark(i, 1);

            int target = arr[i];
            int j = i;
            while (j > 0 && target < arr[j-1]) {
                Utils.mark(j-1, 1, '.');
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = target;
        }

        Utils.result(arr);
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 9, 7, 5, 8, 3};
        sort(arr);
    }

}

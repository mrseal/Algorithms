// 冒泡排序
// 时间复杂度 Time Complexity :  T(n) = O(n^2)

public class BubbleSort {

    public static void sort(int[] arr) {
        Utils.validate(arr);

        for (int i = arr.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                Utils.print(arr);
                Utils.mark(j, 2);
                if (arr[j] > arr[j+1]) {
                    Utils.swap(arr, j, j+1);
                }
            }
        }

        Utils.result(arr);
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 9, 7, 5};
        sort(arr);
    }

}

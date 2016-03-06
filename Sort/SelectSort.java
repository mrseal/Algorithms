// 选择排序
// 时间复杂度 Time Complexity :  T(n) = O(n^2)

public class SelectSort {

    public static void sort(int[] arr) {
        Utils.validate(arr);

        System.out.println("Notes :");
        System.out.println("1. '^' means the target position to be selected");
        System.out.println("2. '*' means the minimize value");
        System.out.println("3. '.' means the current value to be compared");
        System.out.println();

        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                Utils.print(arr);
                Utils.mark(i, 1);
                if (arr[j] < arr[min]) {
                    min = j;
                }
                Utils.mark(min, 1, '*');
                Utils.mark(j, 1, '.');
            }
            if (min != i) {
                Utils.swap(arr, i, min);
            }
        }

        Utils.result(arr);
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 9, 7, 5};
        sort(arr);
    }

}

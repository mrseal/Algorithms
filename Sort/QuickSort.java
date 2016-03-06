// 快速排序
// 时间复杂度 Time Complexity :  T(n) = O(n*logn)

public class QuickSort {

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length-1);
        Utils.result(arr);
    }

    private static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            System.out.println("Complete! l="+left+", r="+right);
            return;
        }
        int pivot = partition(arr, left, right);
        sort(arr, left, pivot-1);
        sort(arr, pivot+1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int pivotIndex = left;

        printAndMark(arr, pivotIndex, left, right);

        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
                Utils.mark(right, 1, 'r');
            }
            while (left < right && arr[left] <= pivot) {
                left++;
                Utils.mark(left, 1, 'l');
            }            
            Utils.swap(arr, left, right);
            
            printAndMark(arr, pivotIndex, left, right);
        }
        Utils.swap(arr, pivotIndex, left);

        Utils.print(arr);
        Utils.mark(left, 1, '|');
        
        return left;
    }

    private static void printAndMark(int[] arr, int pivotIndex, int left, int right) {
        Utils.print(arr);
        Utils.mark(pivotIndex, 1);
        Utils.mark(left, 1, 'l'); 
        Utils.mark(right, 1, 'r');
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 2, 9, 7, 2, 5, 8, 3};
        sort(arr);
    }

}

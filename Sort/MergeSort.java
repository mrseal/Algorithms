// Time Complexity: O(nlogn)

public class MergeSort {

    public static void sort(int[] arr) {
        Utils.print(arr, " ");
        sort(arr, 0, arr.length-1);
        Utils.result(arr, " ");
    }

    public static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        Utils.print(arr, " ", mid);
        sort(arr, left, mid);
        sort(arr, mid+1, right);
        merge(arr, left, right, mid);
    }

    public static void merge(int[] arr, int left, int right, int mid) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while ( i<= mid) {
            temp[k++] = arr[i++];
        }
        
        while ( j<= right) {
            temp[k++] = arr[j++];
        }
        Utils.print(temp, ",");

        for(int p=0; p<temp.length; p++) {
            arr[left+p] = temp[p];
        }
        Utils.print(arr, " ");
        Utils.line();
    }

    public static void main(String[] args) {
        int[] arr = {49, 38, 65, 97, 76, 13, 27};
        sort(arr); 
    }

}

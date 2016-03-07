// 堆排序
// 时间复杂度 Time Complexity :  T(n) = O(nlogn)

public class HeapSort {

    public static void sort(int[] arr) {
        Utils.print(arr, " ");
        Utils.validate(arr);
        buildMaxHeap(arr);
        Utils.print(arr, " ");
        heapSort(arr);
        Utils.result(arr, " ");
    }

    private static void buildMaxHeap(int arr[]) {
        for(int i = arr.length/2-1; i>=0; i--) {
            maxify(arr, i, arr.length); //依次向上将当前子树最大堆化
        }
    }

    private static void heapSort(int[] maxHeap) {
        for(int i = maxHeap.length-1; i>0; i--) {
            Utils.swap(maxHeap, 0, i);
            maxify(maxHeap, 0, i);
            Utils.print(maxHeap, " ", i);
        }
    }

    private static void maxify(int[] arr, int i, int size) {
        int l = left(i);
        int r = right(i);
        int largest;
    
        if(l < size && arr[l] > arr[i]) {
            largest=l;
        } else {
            largest=i;
        }

        if(r < size && arr[r] > arr[largest]) {
            largest=r;
        }

        if(largest == i || largest >= size) { //如果largest等于i说明i是最大元素 largest超出heap范围说明不存在比i节点大的子女
            return;
        }
     
        Utils.swap(arr, i, largest);
     
        maxify(arr, largest, size);
    }

    private static int left(int i) {
        return 2*(i+1)-1;
    }

    private static int right(int i) {
        return 2*(i+1);
    }

    public static void main(String[] args) {
        int[] arr = {8, 9, 13, 1, 3, 6, 26, 2, 7, 8};
        sort(arr);
    }

}

public class SingleNumLookup {

    public static int find(int[] array) {
        int result = 0;
        for (int num : array) {
            result ^= num;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] array = new int[] {25, 3, 8, 3, 25, 21, 8, 15, 1, 2, 1, 15, 2};
        System.out.println(find(array));   
    }

}

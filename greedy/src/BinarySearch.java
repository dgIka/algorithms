public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(binarySeatch(new int[] {1,2,4,5,7,11,25,28}, 2));
        System.out.println(recBinarySearch(new int[] {1,2,4,5,7,11,25,28}, 2, 0, 7));
    }

    public static int binarySeatch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key < a[mid]) {
                high = mid - 1;
            } else if (key > a[mid]) {
                low = mid + 1;
            } else return mid;
        }
        return -1;
    }

    public static int recBinarySearch(int[] a, int key, int low, int high) {
        int high1 = high;
        int low1 = low;
        int mid = low1 + (high1 - low1) / 2;
        if (key < a[mid]) {
            high1 = mid;
            return recBinarySearch(a, key, low1, high1);
        } else if (key > a[mid]) {
            low1 = mid;
            return recBinarySearch(a, key, low1, high1);
        } else return mid;
    }
}

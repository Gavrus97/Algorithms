public class Main {

    public static void main(String[] args) {
                     //0  1   2  3  4   5   6  7  8  9
        int[] array = {5, 15, 6, 7, 10, 14, 8, 4, 5, 20};
        HeapService hp = new HeapService();
        hp.makeHeap(array);
        for (int j : array) {
            System.out.print(j + " ");
        }

        System.out.println();

        hp.heapSort(array);
        for (int j : array)
            System.out.print(j + " ");
    }
}

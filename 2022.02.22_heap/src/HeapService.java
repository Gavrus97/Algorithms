import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeapService {

    /**
     * делает массив таким образом что тот становится кучей
     * @param array массив
     */
    //если у узла в куче индекс в массиве раняется i, то индекс его детей в массиве равняется 2*i+1 и 2*i+2
    public void makeHeap(int[] array) {
        for (int i = (array.length - 1) / 2;i >= 0 ; i--) {
            siftDown(i, array);
        }
    }

    /**
     * сдвтгает жлемент с индексом i по куче таким образом, что он встает на свое место
     * (родитель больше него, а оба дочерних элемента меньше )
     * @param i an element in array
     * @param array array
     */
    private void siftDown(int i, int[] array) {

        int index = i;
        int leftChildIndex = 2 * index + 1;

        while(leftChildIndex < array.length) {

            int rightChildIndex = leftChildIndex + 1;
            int max = leftChildIndex;

            if (rightChildIndex < array.length) {
                if (array[rightChildIndex] > array[leftChildIndex])
                    max = rightChildIndex;
            }

            if (array[index] < array[max]) {
                int temp = array[index];
                array[index] = array[max];
                array[max] = temp;
                index = max;
                leftChildIndex = 2 * index + 1;
            }
            else
                break;
        }
    }


    public void heapSort(int[] array){
        makeHeap(array);

        List<Integer> res = new ArrayList<>();

        while(array.length != 0){

            if(array.length == 1) {
                res.add(array[0]);
                break;
            }
            else {
                res.add(array[0]);
                array[0] = array[array.length - 1];
                array = Arrays.copyOfRange(array, 0, array.length - 1);
                siftDown(0,array);
            }
        }

        int[] arr = new int[res.size()];

        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }

        array = arr;
    }
}

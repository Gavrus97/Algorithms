public class HeapService {

    /**
     * делает массив таким образом что тот становится куче
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
     * (ролитель больге него, а оба дочерних элемента меньше )
     * @param i
     * @param array
     */
    private void siftDown(int i, int[] array) {
        //TODO implement
    }

    public void heapSort(int[] array){
        makeHeap(array);

        //TODO complete. После того как массив приобрел структуру кучи необходимо вытаскивать из кучи
        // самый верхний элемент а затем ставить на нее место ставить самый последний элкемент и в итоге сдвинуть его вниз
        // на свое место (siftDown)
    }
}

/**
 * Алгоритмы класса Разделяй и властвуй (divide and conquer) сводятся к разделению задачи на подзадачи и их решению
 * Шаги:
 * 1. Разбить проблему на подпраьлемы того же типа
 * 2. Решить проблемы
 * 3. Собрать результаты решения подпроблем, чтобы получить решение проблемы
 */

public class Solution {
    /**
     * The method sorts the array via merge sort approach
     * @param numbers an array to be sorted
     */
    public void mergeSort(int[] numbers){
        mergeSortRecursively(numbers);
    }

    /**
     * the function recursively sorts the array from left index inclusively to right index exclusively
     * @param numbers
     */
    private void mergeSortRecursively (int[] numbers){
        int size = numbers.length;
        if(size == 1)
            return;

        int middleIndex = size / 2;
        int[] leftArray = new int[middleIndex];
        int[] rightArray = new int[size - middleIndex];

        for (int i = 0; i < middleIndex; i++) {
            leftArray[i] = numbers[i];
        }
        for (int i = middleIndex; i < size; i++) {
            rightArray[i - middleIndex] = numbers[i];
        }


        mergeSortRecursively(leftArray);
        mergeSortRecursively(rightArray);

        merge(numbers, leftArray, rightArray);
    }

    private void merge(int[] numbers, int[] leftArray, int[] rightArray) {

        int[] tempArray = new int[leftArray.length + rightArray.length]; //далее производим сляиние отсортированных кусков
        //массива numbers от leftIndex до middleIndex и от middleIndex до rightIndex во вспомогательный
        // массив tempArray. Тем самым получаем что tempArray это отсортированный массив длинны rightIndex-leftIndex
        //который надо скопировать в массив numbers между leftIndex и rightIndex

        int i = 0; //index in the left array
        int j = 0; // index in the right array
        int k = 0; // index in the tempArray
        while(i < leftArray.length && j < rightArray.length){
            if(leftArray[i] < rightArray[j]){
                tempArray[k] = leftArray[i];
                i++;
                k++;
            }else{
                tempArray[k] = rightArray[j];
                j++;
                k++;
            }
        }

        // для отставшихся элементов в левом
        for (int l = i; l < leftArray.length; l++) {
            tempArray[k] = leftArray[l];
            k++;
        }

        // для отставшихся элементов в правом массиве
        for (int r = j; r < rightArray.length; r++) {
            tempArray[k] = rightArray[r];
            k++;
        }

        System.arraycopy(tempArray, 0, numbers, 0, tempArray.length);
    }

}

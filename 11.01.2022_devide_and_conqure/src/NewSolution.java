public class NewSolution {
    /**
     * Алгоритмы класса "Разделяй и властвуй" (Divide and Conquer) сводятся к разделению задачи на подзадачи и их решению.
     * Шаги:
     * 1. разбить проблему на подпроблемы того же типа
     * 2. Решить подпроблемы
     * 3. Собрать результаты решения подпроблем, чтобы получить решение проблемы.
     */


    /**
     * The method sort the array via merge sort approach
     *
     * @param numbers
     */
    public void mergeSort(int[] numbers) {
        mergeSortRecursively(numbers, 0, numbers.length);
    }

    /**
     * The function recursively sorts the array from left index inclusively to right index exclusively
     *
     * @param numbers
     * @param leftIndex
     * @param rightIndex
     */
    private void mergeSortRecursively(int[] numbers, int leftIndex, int rightIndex) {
        if (rightIndex - leftIndex < 2)
            return;

        int middleIndex = (rightIndex + leftIndex) / 2;

        mergeSortRecursively(numbers, leftIndex, middleIndex);
        mergeSortRecursively(numbers, middleIndex, rightIndex);

        merge(numbers, leftIndex, rightIndex, middleIndex);
    }

    private void merge(int[] numbers, int leftIndex, int rightIndex, int middleIndex) {
        int[] tempArray = new int[rightIndex - leftIndex];//далее производим слияние отсортированных кусков

        int i = leftIndex;
        int j = middleIndex;

        int k = 0;

        while (i < middleIndex && j < rightIndex) {
            if (numbers[i] < numbers[j]) {
                tempArray[k] = numbers[i];
                i++;
            } else {
                tempArray[k] = numbers[j];
                j++;
            }
            k++;
        }

        if (i == middleIndex) {
            System.arraycopy(numbers, j, tempArray, k, rightIndex - j);
        } else if (j == rightIndex) {
            System.arraycopy(numbers, i, tempArray, k, middleIndex - i);
        }


        System.arraycopy(tempArray, 0, numbers, leftIndex, tempArray.length);

    }

    //нахождение доминантного элемента в массиве
    public int findDominant(int[] numbers) {
        return findDominantRecursively(numbers, 0, numbers.length);
    }

    private int findDominantRecursively(int[] numbers, int leftIndex, int rightIndex) {
        if (rightIndex - leftIndex == 1)
            return numbers[leftIndex];

        int middleIndex = (leftIndex + rightIndex) / 2;
        int leftDominant = findDominantRecursively(numbers, leftIndex, middleIndex);
        int rightDominant = findDominantRecursively(numbers, middleIndex, rightIndex);

        if (leftDominant >= 0) {
            if (checkDominant(numbers, leftIndex, rightIndex, leftDominant))
                return leftDominant;
        } else if (rightDominant >= 0) {
            if (checkDominant(numbers, leftIndex, rightIndex, rightDominant))
                return rightDominant;
        }


        return -1;
    }

    private boolean checkDominant(int[] numbers, int leftIndex, int rightIndex, int dominant) {
        int counter = 0;
        for (int i = leftIndex; i < rightIndex; i++) {
            if (numbers[i] == dominant)
                counter++;
        }
        return counter > (rightIndex - leftIndex) / 2;
    }

}


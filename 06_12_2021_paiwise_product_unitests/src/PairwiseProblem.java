public class PairwiseProblem {

    /**
     * The method must calculate the max pairwise product from the array with only non-negative numbers
     *
     * @param array the array to find the product from
     * @return max pairwise product
     * @throws IllegalArgumentException if the length of the array is lower then 2
     */

    public long solveWithFindMax(int[] array) {
        int firstMax = array[0];
        int indexOfFirstMax = 0;

        int secondMax = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > firstMax) {
                firstMax = array[i];
                indexOfFirstMax = i;
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] > secondMax && i != indexOfFirstMax) {
                secondMax = array[i];
            }
        }
        return (long)firstMax * secondMax;
    }

    public long solve(int[] array) {
        long result = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                long multiplication = (long) array[i] * array[j];
                if (multiplication > result)
                    result = multiplication;
            }
        }

        return result;
    }

    //пример решения с урока
    public long solveSolution(int[] array){
        if (array.length < 2)
            throw new IllegalArgumentException();

        //find the index of max element
        int maxNumberIndex = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[maxNumberIndex])
                maxNumberIndex = i;
        }

        int maxNumber = array[maxNumberIndex];
        array[maxNumberIndex] = array[0];
        array[0] = maxNumber;


        int prevNumberIndex = 1;
        for (int i = 2; i < array.length; i++) {
            if (array[i] > array[prevNumberIndex])
                prevNumberIndex = i;
        }


        return (long)maxNumber * array[prevNumberIndex];
    }
}

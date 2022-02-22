import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void testMergeSort() {
        int[] array1 = {1, 6, 3, -6, 4, 7, 9, 2, 5, -2};
        int[] array2 = {-6, -2, 1, 2, 3, 4, 5, 6, 7, 9};

        solution.mergeSort(array1);
        assertArrayEquals(array1, array2);
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");
            assertEquals(array1[i], array2[i]);
        }
    }

}
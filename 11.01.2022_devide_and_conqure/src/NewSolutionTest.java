import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewSolutionTest {

    NewSolution solution = new NewSolution();

    @Test
    public void testSortMerge(){
        int[] array1 = {1, 6, 3, -6, 4, 7, 9, 2, 5, -2};
        int[] array2 = {-6, -2, 1, 2, 3, 4, 5, 6, 7, 9};

        solution.mergeSort(array1);
        assertArrayEquals(array1, array2);
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + " ");
            assertEquals(array1[i], array2[i]);
        }
    }

    @Test
    public void testDominamt(){
        int[] array = {2,2,2,3,2,3};
        assertEquals(2, solution.findDominant(array));
    }

    @Test
    public void testDominamt_negative(){
        int[] array = {2,2,3,3,2,3};
        assertEquals(-1, solution.findDominant(array));
    }

    }

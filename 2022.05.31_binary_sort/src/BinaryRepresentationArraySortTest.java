import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryRepresentationArraySortTest {
    BinaryRepresentationArraySort b = new BinaryRepresentationArraySort();

    @Test
    public void test_binaryRepresentationSort1() {
        int[] array = {5, 8, 2, 4, 3, 128};
        int[] res = {2, 4, 8, 128, 3, 5};
        assertArrayEquals(res, b.sort(array));
    }

    @Test
    public void test_binaryRepresentationSort2() {
        int[] array = {6, 7, 1, 16, 2, 20};
        int[] res = {1, 2, 16, 6, 20, 7};
        assertArrayEquals(res, b.sort(array));
    }

    @Test
    public void test_binaryRepresentationSort3() {
        int[] array = {};
        int[] res = {};
        assertArrayEquals(res, b.sort(array));
    }

    @Test
    public void test_binaryRepresentationSort4() {
        int[] array = {2, 3, 1};
        int[] res = {1, 2, 3};
        assertArrayEquals(res, b.sort(array));
    }


}
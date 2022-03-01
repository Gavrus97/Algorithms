import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapServiceTest {

    HeapService hp = new HeapService();

    @Test
    public void testHeapService_1element(){
        int[] numbers = {5};

        hp.heapSort(numbers);
        assertEquals(5, numbers[0]);
    }

    @Test
    public void testHeapService_2unsortedElements(){
        int[] numbers = {5, 1};

        hp.heapSort(numbers);

        int[] expected = {1, 5};
        assertArrayEquals(expected, numbers);
    }

    @Test
    public void testHeapService_array() {
        int[] array = {5, 15, 6, 7, 10, 14, 8, 4, 5, 20};

        hp.heapSort(array);

        int[] expected = {4, 5, 5, 6, 7, 8, 10, 14, 15, 20};
        assertArrayEquals(expected,array);
    }


}
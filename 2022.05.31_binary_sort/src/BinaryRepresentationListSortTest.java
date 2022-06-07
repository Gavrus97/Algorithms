import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryRepresentationListSortTest {

    BinaryRepresentationListSort br = new BinaryRepresentationListSort();

    @Test
    public void test_sortByBinaryOnesAndValue(){
        List<Integer> start = Arrays.asList(6, 7, 1, 16, 2, 20);
        br.sortByBinaryOnesAndValue(start);
        List<Integer> res = List.of(1, 2, 16, 6, 20, 7);

        for(int i = 0; i < start.size(); i++){
            assertEquals(res.get(i), start.get(i));
        }
    }

    @Test
    public void test_sortByBinaryOnesAndValue2(){
        List<Integer> start = Arrays.asList(5, 8, 2, 4, 3, 128);
        br.sortByBinaryOnesAndValue(start);
        List<Integer> res = List.of(2, 4, 8, 128, 3, 5);

        for(int i = 0; i < start.size(); i++){
            assertEquals(res.get(i), start.get(i));
        }
    }

}
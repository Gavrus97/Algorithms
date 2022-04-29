import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PointServiceTest {

    PointService ps = new PointService();

    @Test
    public void test_getCoveringCutsNumberByPoint(){
        List<Integer> numbers = Arrays.asList(1, 2, 5, 6, 3, 7, 9);
        List<Cut> cuts = Arrays.asList(
                new Cut(2, 4),
                new Cut(2, 6),
                new Cut(1, 1),
                new Cut(1, 12),
                new Cut(5, 7),
                new Cut(8, 9));
        Map<Integer, Integer> res = new HashMap<>();
        res.put(1,2);
        res.put(2,3);
        res.put(3,3);
        res.put(5,3);
        res.put(6,3);
        res.put(7,2);
        res.put(9,2);
        assertEquals(res, ps.getCoveringCutsNumberByPoint(numbers,cuts));
    }
}
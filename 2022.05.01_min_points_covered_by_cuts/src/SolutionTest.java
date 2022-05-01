import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution sol = new Solution();

    @Test
    public void test_minPointsCoveredByCuts1(){
        List<Cut> cuts = Arrays.asList(new Cut(2, 9),
                new Cut(4, 13),
                new Cut(6, 12),
                new Cut(11, 19),
                new Cut(21, 24));
        assertEquals(3, sol.minPointsCoveredByCuts(cuts));
    }

    @Test
    public void test_minPointsCoveredByCuts2(){
        List<Cut> cuts = Arrays.asList(new Cut(2, 9),
                new Cut(4, 13),
                new Cut(6, 12),
                new Cut(15, 19),
                new Cut(21, 24));
        assertEquals(3, sol.minPointsCoveredByCuts(cuts));
    }

    @Test
    public void test_minPointsCoveredByCuts3(){
        List<Cut> cuts = Arrays.asList(new Cut(2, 9),
                new Cut(4, 13),
                new Cut(6, 12),
                new Cut(11, 19),
                new Cut(17, 24));
        assertEquals(2, sol.minPointsCoveredByCuts(cuts));
    }
}
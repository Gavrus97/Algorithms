import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CutsTest {
    Cuts cut = new Cuts();

    @Test
    public void testCuts(){
        List<Cut> cuts = Arrays.asList(
                new Cut(1,2),
                new Cut(2,5),
                new Cut(2,8),
                new Cut(4,9),
                new Cut(9,12)
        );
        assertEquals(3, cut.countMaxIntersectedCuts(cuts));
    }
}
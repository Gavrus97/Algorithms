import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapsMedianElementCollectionTest {
    HeapsMedianElementCollection col = new HeapsMedianElementCollection();

    @Test
    public void test_getMedianElt(){
        col.add(5);
        col.add(8);
        col.add(2);
        col.add(4);
        col.add(3);
        col.add(128);
        col.add(129);
        assertEquals(5, col.getMedian());
    }

}
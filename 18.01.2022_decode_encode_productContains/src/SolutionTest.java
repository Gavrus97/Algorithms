import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    Solution solution = new Solution();

    @Test
    public void testContainsProduct_36(){
        int[]array = {2,5,18,50};
        assertTrue(solution.containsProduct(array,36));
    }

    @Test
    public void testContainsProduct_1166(){
        int[]array = {2, 5, 18, 22, 26, 31, 39, 42, 53};
        assertTrue(solution.containsProduct(array,1166));
    }

    @Test
    public void testContainsProduct_1638(){
            int[]array = {2, 5, 18, 22, 39, 42, 53, 57};
        assertTrue(solution.containsProduct(array,1638));
    }

    @Test
    public void testContainsProduct_Throws(){
        int[]array = {};
        assertFalse(solution.containsProduct(array, 16));
    }

    @Test
    public void testContainsProduct_False(){
        int[]array = {2, 5, 18, 22, 39, 42, 53, 57};
        assertFalse(solution.containsProduct(array,16));
    }

    //encode
    @Test
    public void testEncode(){
        String str1 = "aaabbaacccbbabnn";
        String str2 = "3a2b2a3c2b1a1b2n";
        assertEquals(str2, solution.encode(str1));
    }

    @Test
    public void testEncode_empty(){
        String str1 = "";
        String str2 = "";
        assertEquals(str2, solution.encode(str1));
    }
    @Test
    public void testEncode_onlyA(){
        String str1 = "aaaaaaaaa";
        String str2 = "9a";
        assertEquals(str2, solution.encode(str1));
    }

    @Test
    public void testEncodeSolution(){
        String str1 = "aaabbaacccbbabnn";
        String str2 = "3a2b2a3c2bab2n";
        assertEquals(str2, solution.encodeSolution(str1));
    }

    @Test
    public void testEncodeSolution_empty(){
        String str1 = "";
        String str2 = "";
        assertEquals(str2, solution.encodeSolution(str1));
    }
    @Test
    public void testEncodeSolution_onlyA(){
        String str1 = "aaaaaaaaa";
        String str2 = "9a";
        assertEquals(str2, solution.encodeSolution(str1));
    }

    @Test
    public void testDecode(){
        assertEquals("aaaaabbaaccc", solution.decode("5a2b2a3c"));
        assertEquals("aaaaabbaac", solution.decode("5a2b2ac"));
        assertEquals("aaaa", solution.decode("4a"));
        assertEquals("a", solution.decode("a"));
        assertEquals("", solution.decode(""));
    }



}
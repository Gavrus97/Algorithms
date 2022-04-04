import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SequencesTest {

    Sequences seq = new Sequences();

    @Test
    public void test_isSubsequence(){
        assertTrue(seq.isSubsequence("hello", "hlo"));
    }

    @Test
    public void test_isSubsequence_false(){
        assertFalse(seq.isSubsequence("hello", "hoo"));
    }
}
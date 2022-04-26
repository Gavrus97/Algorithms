import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SequencesTest {

    Sequences seq = new Sequences();

    @Test
    public void test_isSubsequenceNonEff(){
        assertTrue(seq.isSubsequenceNonEffective("hello", "hlo"));
    }

    @Test
    public void test_isSubsequenceNonEff_false(){
        assertFalse(seq.isSubsequenceNonEffective("hello", "hoo"));
    }

    @Test
    public void test_isSubsequence(){
        assertTrue(seq.isSubsequence("hello", "hlo"));
    }

    @Test
    public void test_isSubsequence_false(){
        assertFalse(seq.isSubsequence("hello", "hoo"));
    }

    @Test
    public void test_isSubsequence_EmptyPattern(){
        assertTrue(seq.isSubsequence("hello", ""));
    }

    @Test
    public void test_isSubsequence_false_shorterText(){
        assertFalse(seq.isSubsequence("helo", "helllo"));
    }
}
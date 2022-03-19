import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyChangerTest {

    MoneyChanger changer = new MoneyChanger();

    @Test
    public void test_recursiveChange_zero() {
        int[] coins = {1, 7, 10};
        assertEquals(0, changer.recursiveChange(0, coins));
    }

    @Test
    public void test_recursiveChange_6() {
        int[] coins = {1, 7, 10};
        assertEquals(6, changer.recursiveChange(6, coins));
    }

    @Test
    public void test_recursiveChange_7_1() {
        int[] coins = {1, 7, 10};
        assertEquals(1, changer.recursiveChange(7, coins));
    }

    @Test
    public void test_recursiveChange_14() {
        int[] coins = {1, 7, 10};
        assertEquals(2, changer.recursiveChange(14, coins));
    }

    @Test
    public void test_recursiveChange_14_1() {
        int[] coins = {10, 1, 7};
        assertEquals(2, changer.recursiveChange(14, coins));
    }

    @Test
    public void test_recursiveChange_zero1() {
        int[] coins = {1, 7, 10};
        assertEquals(0, changer.DPChange(0, coins));
    }

    @Test
    public void test_recursiveChange_61() {
        int[] coins = {1, 7, 10};
        assertEquals(6, changer.DPChange(6, coins));
    }

    @Test
    public void test_recursiveChange_7_11() {
        int[] coins = {1, 7, 10};
        assertEquals(1, changer.DPChange(7, coins));
    }

    @Test
    public void test_recursiveChange_141() {
        int[] coins = {1, 7, 10};
        assertEquals(2, changer.DPChange(14, coins));
    }

    @Test
    public void test_recursiveChange_14_11() {
        int[] coins = {10, 1, 7};
        assertEquals(2, changer.DPChange(14, coins));
    }
}
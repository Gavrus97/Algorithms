import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnapsackTest {

    Knapsack knapsack;

    @Test
    public void test_knapsack1(){
        int[] weights = new int[]{3, 4, 5, 8, 9};
        int[] prices = new int[]{1, 6, 4, 7, 6};
        int sackVolume = 13;
        knapsack = new Knapsack(weights, prices, sackVolume);
        knapsack.resolve();
        assertEquals(13,knapsack.getPrice());
    }

    @Test
    public void test_knapsack2(){
        int[] weights = new int[]{3, 4, 5, 8, 9};
        int[] prices = new int[]{1, 15, 4, 9, 6};
        int sackVolume = 13;
        knapsack = new Knapsack(weights, prices, sackVolume);
        knapsack.resolve();
        assertEquals(24,knapsack.getPrice());
    }

    @Test
    public void test_knapsack3(){
        int[] weights = new int[]{3};
        int[] prices = new int[]{1};
        int sackVolume = 2;
        knapsack = new Knapsack(weights, prices, sackVolume);
        knapsack.resolve();
        assertEquals(0,knapsack.getPrice());
    }

    @Test
    public void test_knapsack4(){
        int[] weights = new int[]{3};
        int[] prices = new int[]{1};
        int sackVolume = 3;
        knapsack = new Knapsack(weights, prices, sackVolume);
        knapsack.resolve();
        assertEquals(1,knapsack.getPrice());
    }

    @Test
    public void test_knapsack5(){
        int[] weights = new int[]{3};
        int[] prices = new int[]{1};
        int sackVolume = 3;
        knapsack = new Knapsack(weights, prices, sackVolume);
        knapsack.resolve();
        assertEquals(1,knapsack.getPrice());
    }

    @Test
    public void test_knapsack6(){
        int[] weights = new int[]{10, 7, 4, 9};
        int[] prices = new int[]{11, 8, 13, 6};
        int sackVolume = 21;
        knapsack = new Knapsack(weights, prices, sackVolume);
        knapsack.resolve();
        assertEquals(32,knapsack.getPrice());
    }

}
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class PairwiseProblemTest {

    PairwiseProblem pp = new PairwiseProblem();

    @Test
    public void testSolve_twoElements1and2_2(){
        int []array = {1,2};

        assertEquals(2,pp.solve(array));
    }

    @Test
    public void testSolve_threeElements(){
        int []array = {1,2,10};

        assertEquals(20,pp.solve(array));
    }

    @Test
    public void testSolve_twoLargeElements(){
        int []array = {100000,1000000};

        assertEquals(100_000_000_000L,pp.solve(array));
    }

    @Test
    public void testSolve_twoElementsWithZero(){
        int []array = {0,100_000};

        assertEquals(0,pp.solveWithFindMax(array));
    }

    @Test
    public void testSolve_performanceTest(){

        int []array = new int[100000];
        Random rnd = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(Integer.MAX_VALUE);
        }

        long currentTime = System.currentTimeMillis();
        pp.solve(array);
        System.out.println(System.currentTimeMillis()-currentTime);

    }

    // tests of new Method

    @Test
    public void testSolveWithFindMax_performanceTest(){

        int []array = new int[100000];
        Random rnd = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(Integer.MAX_VALUE);
        }

        long currentTime = System.currentTimeMillis();
        pp.solveWithFindMax(array);
        System.out.println(System.currentTimeMillis()-currentTime);

    }

    @Test
    public void testSolveWithFindMax_tenElements() {
        int[] array = {10, 20, 15, 40, 30, 40, 39, 27, 10, 16};

        assertEquals(1600, pp.solveWithFindMax(array));
    }

    @Test
    public void testSolveWithFindMax_foveElements() {
        int[] array = {2, 4, 5, 3, 7};

        assertEquals(35, pp.solveWithFindMax(array));
    }

    @Test
    public void testSolveWithFindMax_threeElements() {
        int[] array = {2,2,2};

        assertEquals(4, pp.solveWithFindMax(array));
    }

    @Test
    public void testSolveWithFindMax_zero() {
        int[] array = {0, 0, 0, 0};

        assertEquals(0, pp.solveWithFindMax(array));
    }

}
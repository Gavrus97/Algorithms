import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Main main = new Main();

    @Test
    public void fuelStationsTest900(){
        int[] fuelStations = {200,375, 550,750};
        assertEquals(2,main.getFuelingNumber(900,400,fuelStations));
    }

    @Test
    public void fuelStationsTest200(){
        Main main = new Main();
        int[] fuelStations = {200,375, 550,750};
        assertEquals(4,main.getFuelingNumber(900,200,fuelStations));
    }

    @Test
    public void testSolve_severalElements_longSegment() {
        int[] numbers = {3, 5, 7, 9, 14};
        int res = main.getSegmentNumberSolution(numbers, 2);
        assertEquals(3,res);
    }

}
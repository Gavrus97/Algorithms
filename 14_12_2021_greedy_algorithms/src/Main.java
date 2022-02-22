import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println(exchangeMoney(46));
        int[] array = {1, 3, 8, 9, 10, 12, 13, 15, 16, 20};
        System.out.println(getSegmentNumber(array, 3));


    }


    /**
     * the method must return the min possible number of segment of the length l, so that all the numbers are covered
     * by these segments
     *
     * @param numbers an array of sorted numbers
     * @param l       the length of the segments
     * @return min possible number of occurrences of the segment in the array
     */
    public static int getSegmentNumber(int[] numbers, int l) {
        int leftSegmentEnd = numbers[0];
        int res = 0;

        Break:
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (leftSegmentEnd + l < numbers[j] || leftSegmentEnd + l == numbers[numbers.length - 1]) {
                    res++;
                    leftSegmentEnd = numbers[j];
                }
                if (leftSegmentEnd == numbers[numbers.length - 1]) {
                    res++;
                    break Break;
                }
                if (leftSegmentEnd + l > numbers[numbers.length - 1]) {
                    res++;
                    break Break;
                }
            }
        }
        return res;
    }

    /**
     * compose the money from the coins 1, 5, 10 cent, so that the number of coins is min possible
     *
     * @param money amount of money to compose
     * @return the min possible number of coins, which compose the amount of money
     */
    public static int exchangeMoney(int money) {
        int tens = money / 10;
        int fives = money % 10 / 5;
        int ones = money % 10 % 5;

        return tens + fives + ones;
    }

    /**
     * @param l            the length of the way
     * @param fuelStations the points for refueling (km from the start)
     * @param maxDistance  the distance that is reachable by one refueling
     * @return number of stops for refueling
     */
    //(950, 400, {200,375,550,750})

    public int getFuelingNumber(int l, int maxDistance, int[] fuelStations) {

        int[] points = new int[fuelStations.length + 2];
        points[0] = 0;
        points[points.length - 1] = l;

        System.arraycopy(fuelStations, 0, points, 1, fuelStations.length);

        int res = 0;
        int startingPosition = points[0];
        for (int i = 1; i < points.length; i++) {
            if (points[i] > startingPosition + maxDistance) {
                res++;
                startingPosition = points[i - 1];
            }
        }

        return res;
    }

    public static int getSegmentNumberSolution(int[] numbers, int l) {
        int leftSegmentNumber = numbers[0];
        int res = 1;

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > leftSegmentNumber + l) {
                res++;
                leftSegmentNumber = numbers[i];
            }
        }
        return res;
    }
}

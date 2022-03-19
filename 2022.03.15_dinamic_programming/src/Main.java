import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[] weights = new int[]{3, 4, 5, 8, 9};
        int[] prices = new int[]{1, 6, 4, 7, 6};
        int sackVolume = 13;

        Knapsack knapsack = new Knapsack(weights,prices,sackVolume);

        knapsack.resolve();

        System.out.println(knapsack.getPrice());

        List<Integer> list = knapsack.getObjects();
        System.out.println(list);

        knapsack.showTable();

    }
}

import java.util.ArrayList;
import java.util.List;

public class Knapsack {

    private final int[][] results;
    private final int[] weights;
    private final int[] prices;
    private final int sackVolume;
    private int elt;
    private int vol;
    private final List<Integer> res;

    public Knapsack(int[] weights, int[] prices, int sackVolume) {
        this.weights = weights;
        this.prices = prices;
        this.sackVolume = sackVolume;
        this.elt = weights.length;
        this.vol = sackVolume;
        this.results = new int[weights.length + 1][sackVolume + 1];
        this.res = new ArrayList<>();
    }

    public void resolve() {
        //заполнение таблицы с рузультатами
        for (int i = 0; i < results.length; i++) { //i - кол-во вещей
            for (int j = 0; j < results[i].length; j++) { //j - вместимость рюкзака в кг
                if (i == 0 || j == 0) // если 0 вещей или рюкзак вмещает 0 кг
                    results[i][j] = 0; // то результат 0 (цена)
                else {
                    if (j >= weights[i - 1]) // если вместимость рюкзака >= весу текущего предмета
                        // то рузультат максимальное из вариантов когда не кладется предмет (предыдущая стоимость)
                        // и когда предмет кладется в рюкзак (отнимается вес этого предмета)
                        // результат это предыдущая стоимость + стоимость этого предмета
                        results[i][j] = Math.max(results[i - 1][j], results[i - 1][j - weights[i - 1]] + prices[i - 1]);
                        // иначе результат равен предыдущему рузельтату (новый предмет не берется)
                    else results[i][j] = results[i - 1][j];
                }
            }
        }
        //ответ - последний эл-т двумерного массива (максимальная стоимость предметов)
    }

    public List<Integer> getObjects(){
        findElements();
        return res;
    }

    /**
     * Возвращает результат задачи с рюкзаком
     * @return последний эл-т
     */
    public int getPrice(){
        //ответ - последний эл-т двумерного массива (максимальная стоимость предметов)
        return results[weights.length][sackVolume];
    }

    private void findElements() {
        if (results[elt][vol] == 0)
            return;
        if (results[elt - 1][vol] == results[elt][vol]) {
            elt--;
            findElements();
        }
        else {
            res.add(elt);
            elt--;
            vol = vol - weights[elt];
            findElements();
        }
    }

    /**
     * распечатывает таблицу с результатами
     */
    public void showTable(){
        for (int[] result : results) {
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

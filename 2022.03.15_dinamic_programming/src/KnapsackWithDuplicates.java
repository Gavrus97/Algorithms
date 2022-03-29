public class KnapsackWithDuplicates {

    //Рюкзак с повторениями.
    // Пусть есть рещение для рюкзака объема V, тогда убрав из рюкзака любой предмет мы получим решение для рюкзака
    // объема V - v где v - жто объем убранного предмета.
    // Рассмотрим рещение для каждой из задач для рюкзака объемами V - v_i где v_i - объемы имеющихся предметов.
    // тогда рещение задачи с рюкзаком объема V будет максимум из решение для рюкзака объемом V - v_i + стоимомть
    // i-той вещи
    // res[V] = max(res[V - v_i] + p_i)

    public int resolve(int knapsackV, int[] volumes, int[] prices) {
        //решение задачи для задачи от 0 до knapsackV
        int[] res = new int[knapsackV + 1];

        for (int i = 1; i <= knapsackV; i++) {
            for (int j = 0; j < volumes.length; j++) {
                int lightenedKnapsack = i - volumes[j];
                if (lightenedKnapsack >= 0) {
                    int possibleRes = res[lightenedKnapsack + prices[j]];
                    if (res[i] < possibleRes)
                        res[i] = possibleRes;
                }
            }
        }
        return res[knapsackV];
    }

    public int resolveRecursively(int knapsackV, int[] volumes, int[] prices) {
        if (knapsackV == 0)
            return 0;

        int res = 0;

        for (int i = 0; i < volumes.length; i++) {
            if (knapsackV >= volumes[i]) {
                int possibleRes = resolveRecursively(knapsackV - volumes[i], volumes, prices) + prices[i];
                if (res <= possibleRes)
                    res = possibleRes;
            }
        }
        return res;
    }
}
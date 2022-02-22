import java.util.Arrays;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        long[] array = {1000000, 1200000, 1250000, 1300000, 1600000, 1700000, 1800000, 1850000, 1890000};
        System.out.println(Arrays.toString(sol.countOrdersNumber(array, 5)));
    }

    /**
     * Метод принимает массив состоящий из трех видов скобок "{}[]()". Необоходимо определить
     * является ли массив скобок корректным
     * {}([]) - корректный порядок
     * {}([]{()}) - корректный порядок
     * {(] - некорректный порядок
     * {}([])} - некорректный порядок
     * {}([])( - некорректный порядок
     * {(}) - некорректный пор
     *
     * @param brackets массив скобок
     * @return true false
     */
    public boolean areBracketsCorrect(char[] brackets) {
        if (brackets.length % 2 != 0)
            return false;
        Stack<Character> stack = new Stack<>();
        for (char bracket : brackets) {
            if (bracket == '{' || bracket == '(' || bracket == '[')
                stack.push(bracket);
            else if (bracket == '}' && stack.peek() == '{' || bracket == ')' && stack.peek() == '('
                    || bracket == ']' && stack.peek() == '[')
                stack.pop();
            else return false;
        }
        return stack.empty();
    }

    // В ретсторан периодически попадает заказ. У заказа есть время, когда он был сделан (milliseconds from 1970 1 Jan, UTC).
    // Для каждого заказа необходимо установить количество заказов, сделанных за 15 (20, N) минут до него.

    /**
     * @param orderTimes - массив отсортированных по времени моментов, когда происходили заказы.
     * @param minutes    min
     * @return для соответствующиего заказа - количество заказов, сделанных в предыдущие minutes минут
     */
    public int[] countOrdersNumber(long[] orderTimes, int minutes) {
        int[] res = new int[orderTimes.length];
        res[0] = 0;
        long milis = (long) minutes * 60 * 1000;

        Stack<Long> stack = new Stack<>();
        for (long l : orderTimes)
            stack.push(l);

        int count = 0;
        int indexRes = stack.size() - 1;
        int i = stack.size() - 1;
        while (indexRes >= 1 && i >= 1) {
            long temp = stack.peek() - milis;
            if (temp >= orderTimes[i - 1]) {
                res[indexRes] = count;
                stack.pop();
                count = 0;
                i = stack.size() - 1;
                indexRes--;
            } else {
                count++;
                i--;
                if (i == 0) {
                    res[indexRes] = count;
                    stack.pop();
                    count = 0;
                    i = stack.size() - 1;
                    indexRes--;
                }


            }
        }
        return res;
    }
}

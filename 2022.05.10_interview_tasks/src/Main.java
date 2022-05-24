import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        swapWithoutBuffer(-45,-67);

    }

    //1. Дана строка из разного кол-ва повторяющихся символов типа abbbcc -> bbb,
    // Найти длину максимальной подстроки повторяющихся символов.


    public static int findTheLongestSubstring(String line) {
        char[] chars = line.toCharArray();

        int res = 0;
        int count = 1;
        char first = chars[0];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == first) {
                count++;
            } else {
                first = chars[i];
                count = 1;
            }

            if (res < count) {
                res = count;
            }
        }
        return res;
    }

    //2. Написать метод, разворачивающий строку с использованием
    // рекурсии  I always do my homework -> krowemah ym od syawla I

    public static void reverseTheString(String s) {
        if (s.length() < 1) {
            return;
        }

        String temp = s.substring(s.length() - 1);
        System.out.print(temp);
        reverseTheString(s.substring(0, s.length() - 1));
    }

    //3.Написать метод, перемножающий два целых числа без использования умножения,
    // деления, побитовых операций и циклов
    public static int multiplyTwoIntegers(int a, int b) {
        if (b == 0)
            return 0;

        if (b > 0) {
            return (a + multiplyTwoIntegers(a, b - 1));
        }

        if (b < 0) {
            return -multiplyTwoIntegers(a, -b);
        }

        return -1;
    }

    // 4. Написать метод, проверяющий равно ли число  сумме кубов его цифр. 123 = 1+2^3+ 3^3
    public static boolean findIfSumEqualsToNumber(int n) {
        int sum = 0;
        int N = n;

        while (n != 0) {
            int temp = n % 10;
            for (int i = 0; i < 2; i++) {
                temp *= temp;
            }
            sum += temp;
            n = n / 10;
        }
        return sum == N;
    }

    //5. написать метод проверяющий, является ли число аутоморфным. В математике аутоморфные это числа
    // квадрат которых заканчивается теми же цчислами что и само число. 5^2=25, 6^2=36, 76^2=5776
    public static boolean authomorphicNumber(int a) {
        int qurt = a * a;

        int count = 0;
        int temp = a;

        while (temp != 0) {
            temp /= 10;
            count++;
        }
        int res = qurt % (int) Math.pow(10, count);
        return a == res;
    }

    //6. пусть есть строка являющаяся двоичным числом например "0101". Написать метод,
    // превращающий ее в десятичное число. Можно использовать только методы класса String (length, charAt) и
    // методы Math
    public static int toDecimal(String s) {
        String[] strings = s.split("");
        int[] array = new int[strings.length];

        for (int i = 0; i < array.length; i++) {
            if (strings[i].equals("1"))
                array[i] = (int) Math.pow(2, array.length - 1 - i);
            else
                array[i] = 0;
        }
        int sum = 0;
        for (int a : array)
            sum += a;
        return sum;
    }

    //7 написать метод, меняющий местами значения  двух целых переменных без использования буфера
    // public void swapWithoutBuffer (int a, int b)
    // a=2 b=3 -> a=3 b=2
    public static void swapWithoutBuffer(int a, int b){
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a = " + a + " b = " + b);
    }
}

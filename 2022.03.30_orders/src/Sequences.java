import java.util.ArrayList;
import java.util.List;

public class Sequences {

    // решение рекурсией в данном случае лучше!!

//    public boolean isSubsequence(String sequence, String pattern){
//
//        int textLength = sequence.length();// текущая длинна последовательности
//        int patternLength = pattern.length();// текущая длинна паттерна
//
//        while(patternLength > 0){
//
//            if(textLength < patternLength)    // если размер строки меньше чем размер паттерна то не верно.
//                return false;
//
//            if(sequence.charAt(textLength - 1) == pattern.charAt(patternLength - 1)) { // если символ в строке совпадает с символом в
//                textLength--;                                              // паттерне то уменьшаем оба.
//                patternLength--;
//            } else{     // иначе уменьшаем только строку.
//                textLength--;
//            }
//        }
//
//        return true;
//    }

    public boolean isSubsequence(String text, String pattern) {
        return isSubsequenceRecursive(text, pattern, text.length(), pattern.length());
    }

    private boolean isSubsequenceRecursive(String text, String pattern, int textLength, int patternLength) {
        if (patternLength == 0)
            return true;
        if (textLength < patternLength)
            return false;

        if (text.charAt(textLength - 1) == pattern.charAt(patternLength - 1)) {
            return isSubsequenceRecursive(text, pattern, textLength - 1, patternLength - 1);
        }

        return isSubsequenceRecursive(text, pattern, textLength - 1, patternLength);
    }

    public boolean isSubsequenceNonEffective(String sequence, String pattern) {
        List<Character> list = new ArrayList<>();
        char[] chars = pattern.toCharArray();
        for (char c : chars) {
            list.add(c);
        }

        for (int i = 0; i < sequence.length(); i++) {
            char letter = sequence.charAt(i);
            if (!list.get(i).equals(letter)) {
                list.add(i, letter);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : list)
            sb.append(c);

        return sb.toString().equals(sequence);
    }

    //найти длину наибольшей общей подпоследовательности двух строк.
    // public int getLongestSharedSubsequence(String s1, String s2). (hello, hovard) -> 2

    public int getLongestSharedSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] res = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    res[i][j] = res[i - 1][j - 1 + 1];
                } else {
                    res[i][j] = Math.max(res[i - 1][j], res[i][j - 1]);
                }
            }
        }
        return res[m][n];
    }
}

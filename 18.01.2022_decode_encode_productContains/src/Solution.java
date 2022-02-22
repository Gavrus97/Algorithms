import java.util.*;

public class Solution {
    /**
     * The method must return true if there are two numbers from the numbers array whose multiplication is a product
     * {2,5,18,50}, product 36 true(18,2)
     *
     * @param numbers array of sorted numbers
     * @param product some number
     * @return true or false
     */
    public boolean containsProduct(int[] numbers, int product) {
        Deque<Integer> numbersDeque = new ArrayDeque<>();
        for (int number : numbers) {
            numbersDeque.addLast(number);
        }

        int i = 0;
        while (i < numbers.length) {
            if (numbersDeque.getFirst() * numbersDeque.getLast() > product)
                numbersDeque.removeLast();
            else if (numbersDeque.getFirst() * numbersDeque.getLast() < product)
                numbersDeque.removeFirst();
            else
                return true;

            i++;
        }
        return false;
    }


    //str - состоит только из маленьких букв.
    public String encode(String str) {
        List<Integer> listInt = new ArrayList<>();
        List<Character> listChar = new ArrayList<>();
        char[] chars = str.toCharArray();
        int i = 0;
        int j = i + 1;
        int sum = 1;
        while (i < chars.length) {
            if (j >= chars.length) {
                listInt.add(sum);
                listChar.add(chars[i]);
                break;
            }
            if (i == chars.length - 1) {
                listInt.add(1);
                listChar.add(chars[i]);
                break;
            }
            if (chars[i] == chars[j]) {
                j++;
                sum++;
            } else {
                listInt.add(sum);
                listChar.add(chars[i]);
                sum = 1;
                i = j;
                j = i + 1;
            }
        }
        String intString = intListToString(listInt);
        String charString = listToString(listChar);

        List<Character> temp = new ArrayList<>();
        int x = 0;
        while (x < intString.length()) {
            temp.add(intString.charAt(x));
            temp.add(charString.charAt(x));
            x++;
        }


        return listToString(temp);
    }

    public String encodeSolution(String str) {
        if (str.length() == 0)
            return "";

        int count = 1;
        StringBuilder builder = new StringBuilder();

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i - 1) != str.charAt(i)) {
                if (count > 1) {
                    builder.append(count).append(str.charAt(i - 1));
                    count = 1;
                } else {
                    builder.append(str.charAt(i - 1));
                }
            } else {
                count++;
            }
        }

        if (count == 1)
            builder.append(str.charAt(str.length() - 1));
        else
            builder.append(count).append(str.charAt(str.length() - 1));

        return builder.toString();
    }


    public String listToString(List<Character> temp) {
        String str = "";
        int i = 0;
        while (i < temp.size()) {
            if (temp.get(i) != ',' && temp.get(i) != '[' && temp.get(i) != ']') {
                str += temp.get(i);
                i++;
            } else i++;
        }
        return str;
    }

    public String intListToString(List<Integer> temp) {
        String str = "";
        int i = 0;
        while (i < temp.size()) {
            if (temp.get(i) != ',' && temp.get(i) != '[' && temp.get(i) != ']') {
                str += temp.get(i);
                i++;
            } else i++;
        }
        return str;
    }

    //str - состоит только из маленьких букв.
    // 4a2b4cd -> "aaaabbccccd"
    public String decode(String str) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            int digitsNumber = 0;
            while (Character.isDigit(str.charAt(i + digitsNumber))) {
                digitsNumber++;
            }

            if (digitsNumber > 0) {
                int charNumber = Integer.parseInt(str.substring(i, i + digitsNumber));
                i += digitsNumber;

                for (int j = 0; j < charNumber; j++) {
                    builder.append(str.charAt(i));
                }
            }
            else {
                builder.append(str.charAt(i));
            }
        }


        return builder.toString();
    }

}

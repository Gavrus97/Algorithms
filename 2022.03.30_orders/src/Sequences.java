import java.util.ArrayList;
import java.util.List;

public class Sequences {

    public boolean isSubsequence(String sequence, String pattern) {
        List<Character> list = new ArrayList<>();
        char[] chars = pattern.toCharArray();
        for(char c : chars){
            list.add(c);
        }

        for (int i = 0; i < sequence.length(); i++) {
            char letter = sequence.charAt(i);
            if (!list.get(i).equals(letter)) {
                list.add(i, letter);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c : list)
            sb.append(c);

        return sb.toString().equals(sequence);
    }
}

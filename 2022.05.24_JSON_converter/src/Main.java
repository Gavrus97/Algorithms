import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {


        Map<String, Object> map = new HashMap<>();
                map.put("make", "Oplel");
                map.put("model", "Astra");
                map.put("year_of_Assembling", 2022);

        System.out.println(changeJson(map));

    }

    public static Map<String, Object> changeJson(Map<String, Object> map) {
        Map<String, Object> res = new HashMap<>();

        for (String m : map.keySet() ){
            String newKey = convertKey(m);
            Object value = map.get(m);
            res.put(newKey,value);

        }
        return res;
    }

    public static String convertKey(String s) {
        String[] strings = s.split("_");

        if (strings.length > 1) {

            StringBuilder sb = new StringBuilder();
            sb.append(strings[0]);

            for (int i = 1; i < strings.length; i++) {
                String temp = strings[i];
                strings[i] = temp.substring(0, 1).toUpperCase() + temp.substring(1, temp.length());
                sb.append(strings[i]);
            }
            return sb.toString();
        }
        return s;
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

    }

    public Map<String, Object> changeJson(Map<String, Object> map) {
        Map<String, Object> res = new HashMap<>();

        for (String m : map.keySet()) {
            String newKey = convertKey(m);
            Object value = map.get(m);
            res.put(newKey, transformValue(value));
        }
        return res;
    }


    List<Object> transformListValue(List<Object> value) {
        List<Object> res = new ArrayList<>();

        for (Object elt : value) {
            res.add(transformValue(elt));
        }
        return res;
    }


    Object transformValue(Object value) {
        if (value instanceof Map) {
            return (changeJson((Map) value));
        } else if (value instanceof List) {
            return transformListValue((List) value);
        } else {
            return value;
        }
    }

    public String convertKey(String s) {
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

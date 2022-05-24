import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Main main = new Main();

    @Test
    public void test_jsonConverter() {
        Map<String, Object> map = new HashMap<>();
        map.put("make", "Oplel");
        map.put("model", "Astra");
        map.put("year_of_Assembling", 2022);

        Map<String, Object> res = Map.of(
                "make", "Oplel",
                "model", "Astra",
                "yearOfAssembling", 2022
        );

        assertEquals(res,main.changeJson(map));
    }

}
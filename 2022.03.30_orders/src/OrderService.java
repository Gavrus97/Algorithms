import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderService {

    /**
     * @param orders a list of orders
     * @param delta  time interval in millis
     * @return the number of orders from the same restaurant for every order for the previous delta millis before the oder.
     */
    public Map<String, Integer> countPreviousOrders(List<Order> orders, long delta) {
        Collections.sort(orders);
        Map<String, Integer> res = new HashMap<>();
        res.put(orders.get(0).getUuid(), 0);

        int count = 0;

        for (int i = orders.size() - 1; i > 0; i--) {
            int j = i - 1;
            while (j >= 0) {
                if (orders.get(i).getTimestamp() - delta <= orders.get(j).getTimestamp()) {
                    if (orders.get(j).getRestaurantId().equals(orders.get(i).getRestaurantId())) {
                        count++;
                        j--;
                    } else {
                        j--;
                    }
                }
                else {
                    break;
                }
            }
            res.put(orders.get(i).getUuid(), count);
            count = 0;
        }
        return res;
    }
}

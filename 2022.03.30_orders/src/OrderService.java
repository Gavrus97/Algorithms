import java.util.*;

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
                } else {
                    break;
                }
            }
            res.put(orders.get(i).getUuid(), count);
            count = 0;
        }
        return res;
    }

    public Map<String, Integer> countPreviousOrdersSolution(List<Order> orders, long delta) {
        List<Order> ordersCopy = new ArrayList<>(orders);
        ordersCopy.sort(Comparator.comparingLong(Order::getTimestamp));


        // mapping from restaurant ID to the deque of the timestamps of the orders, accommodated into the last delta
        //milliseconds
        Map<String, Deque<Long>> orderTimesByRestaurantId = new HashMap<>();

        //mapping orderId to the number of previous orders within delta milliseconds
        Map<String, Integer> res = new HashMap<>();

        for (Order order : ordersCopy) {
            Deque<Long> previousTimestamps = orderTimesByRestaurantId.get(order.getRestaurantId());
            if (previousTimestamps == null) {
                previousTimestamps = new ArrayDeque<>();
                orderTimesByRestaurantId.put(order.getRestaurantId(), previousTimestamps);
            }

            long currentTimestamp = order.getTimestamp();
            previousTimestamps.addLast(order.getTimestamp());
            while (currentTimestamp - previousTimestamps.getFirst() > delta)
                previousTimestamps.removeFirst();

            res.put(order.getUuid(), previousTimestamps.size() - 1);
        }
        return res;
    }
}

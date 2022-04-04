public class Order implements Comparable<Order> {
    private final String uuid;
    private final long timestamp;
    private final String restaurantId;

    public Order(String uuid, long timestamp, String restaurantId) {
        this.uuid = uuid;
        this.timestamp = timestamp;
        this.restaurantId = restaurantId;
    }

    public String getUuid() {
        return uuid;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    @Override
    public int compareTo(Order order) {
        return (int) this.getTimestamp() - (int) order.getTimestamp();
    }
}

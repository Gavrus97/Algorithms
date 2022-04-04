public class Order {

    private final String uuid;
    private final long timestamp;
    private final String restaurantId;

    public String getUuid() {
        return uuid;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getRestaurantId() {
        return restaurantId;
    }

    public Order(String uuid, long timestamp, String restaurantId) {
        this.uuid = uuid;
        this.timestamp = timestamp;
        this.restaurantId = restaurantId;
    }
}

import java.util.ArrayList;
import java.util.List;

public class Store {
    private static List<PhoneItem> items;
    private static List<Order> orders = new ArrayList<>();
    private static Long revenue = 0L;

    public static List<PhoneItem> getItems() {
        return items;
    }

    public static void setItems(List<PhoneItem> items) {
        Store.items = items;
    }

    public static List<Order> getOrders() {
        return orders;
    }

    public static void setOrders(List<Order> orders) {
        Store.orders = orders;
    }

    public static Long getRevenue() {
        return revenue;
    }

    public static void setRevenue(Long revenue) {
        Store.revenue = revenue;
    }
}

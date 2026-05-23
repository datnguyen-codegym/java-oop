import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Store {
    private static List<PhoneItem> items;
    private static List<Order> orders = new ArrayList<>();
    private static List<Customer> customers = new ArrayList<>();

    private static LinkedHashMap<PhoneType, List<PhoneItem>>  mapPhoneType = new LinkedHashMap();
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

    public static String listsPhoneType() {
        Store.setMapPhoneType();
        AtomicInteger index = new AtomicInteger(1);
        return mapPhoneType.sequencedKeySet()
                .stream()
                .map(e -> index.getAndIncrement() + ": " + e.getName())
                .collect(Collectors.joining("\n"));
    }

    public static String phoneTypeDetail(int phoneTypeIndex) {
        PhoneType phoneType = getPhoneType(phoneTypeIndex);
        return phoneType.toString();
    }

    private static PhoneType getPhoneType(int phoneTypeIndex) {
        List<PhoneType> keys = mapPhoneType.sequencedKeySet()
                .stream()
                .toList();
        PhoneType phoneType = keys.get(phoneTypeIndex);
        return phoneType;
    }

    public static List<Customer> getCustomers() {
        return customers;
    }

    public static void setCustomers(List<Customer> customers) {
        Store.customers = customers;
    }

    public static void setMapPhoneType() {
        Store.mapPhoneType = items.stream()
                .filter(item -> SaleStatus.AVAILABLE.equals(item.getSaleStatus()))
                .collect(
                        Collectors.groupingBy(
                                PhoneItem::getPhoneType,
                                LinkedHashMap::new,
                                Collectors.toList()
                        )
                );
    }

    public static PhoneItem getItem(int phoneTypeIndex) {
        PhoneType phoneType = Store.getPhoneType(phoneTypeIndex);
        return Store.mapPhoneType.get(phoneType).getFirst();
    }
}

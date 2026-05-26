package store;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private static List<Order> orders = new ArrayList<>();
    private static List<Customer> customers = new ArrayList<>();
    private static Long revenue = 0L;


    public static List<Order> getOrders() {
        return orders;
    }

    public static Long getRevenue() {
        return revenue;
    }

    public static void setRevenue(Long revenue) {
        Store.revenue = revenue;
    }

    public static List<Customer> getCustomers() {
        return customers;
    }

}

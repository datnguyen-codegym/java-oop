package store;

import store.laptop.LaptopItem;
import store.phone.PhoneItem;
import store.phone.PhoneType;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Store {
    private static List<PhoneItem> phoneItems;
    private static List<LaptopItem> laptopItems;
    private static List<Order> orders = new ArrayList<>();
    private static List<Customer> customers = new ArrayList<>();

    private static LinkedHashMap<ItemType, List<PhoneItem>>  mapPhoneType = new LinkedHashMap();
    private static LinkedHashMap<ItemType, List<LaptopItem>>  mapLaptopType = new LinkedHashMap();
    private static Long revenue = 0L;

    public static void setPhoneItems(List<PhoneItem> phoneItems) {
        Store.phoneItems = phoneItems;
    }

    public static void setLaptopItems(List<LaptopItem> laptopItems) {
        Store.laptopItems = laptopItems;
    }

    public static List<Order> getOrders() {
        return orders;
    }

    public static Long getRevenue() {
        return revenue;
    }

    public static void setRevenue(Long revenue) {
        Store.revenue = revenue;
    }

    public static String listsPhoneType() {
        Store.setMapPhoneType();
        return listItemType(mapPhoneType);
    }

    public static String listsLaptopType() {
        Store.setMapLaptopType();
        return listItemType(mapLaptopType);
    }

    private static <T extends ItemType, I extends Item> String listItemType(LinkedHashMap<T, List<I>> mapItemType) {
        AtomicInteger index = new AtomicInteger(1);
        return mapItemType.sequencedKeySet()
                .stream()
                .map(e -> index.getAndIncrement() + ": " + e.getName())
                .collect(Collectors.joining("\n"));
    }
    public static String phoneTypeDetail(int phoneTypeIndex) {
        PhoneType phoneType = (PhoneType) getPhoneType(phoneTypeIndex);
        return phoneType.toString();
    }

    public static ItemType getPhoneType(int phoneTypeIndex) {
        return getItemType(phoneTypeIndex, Store.mapPhoneType);
    }

    public static ItemType laptopTypeDetail(int laptopTypeIndex) {
        return getItemType(laptopTypeIndex, Store.mapLaptopType);
    }

    private static <I extends Item> ItemType getItemType(int itemType, LinkedHashMap<ItemType, List<I>> mapItemType ) {
        List<ItemType> keys = mapItemType.sequencedKeySet()
                .stream()
                .toList();
        return keys.get(itemType);
    }

    public static List<Customer> getCustomers() {
        return customers;
    }

    public static void setCustomers(List<Customer> customers) {
        Store.customers = customers;
    }

    public static void setMapPhoneType() {
        Store.mapPhoneType = setMapItemType(Store.phoneItems);
    }

    public static void setMapLaptopType() {
        Store.mapLaptopType = setMapItemType(Store.laptopItems);
    }

    private static <I extends Item> LinkedHashMap<ItemType, List<I>> setMapItemType(List<I> items) {
        return items.stream()
                .filter(item -> SaleStatus.AVAILABLE.equals(item.getSaleStatus()))
                .collect(
                        Collectors.groupingBy(
                                I::getType,
                                LinkedHashMap::new,
                                Collectors.toList()
                        )
                );
    }

    public static PhoneItem getItem(int phoneTypeIndex) {
        PhoneType phoneType = (PhoneType) Store.getPhoneType(phoneTypeIndex);
        return Store.mapPhoneType.get(phoneType).getFirst();
    }
}

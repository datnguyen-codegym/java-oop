package store;

import store.phone.PhoneItem;
import store.phone.PhoneType;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Seller<I extends Item> {
    private List<I> items;
    private LinkedHashMap<ItemType, List<I>> mapItemType;

    public Seller(List<I> items) {
        this.items = items;
    }

    public String listItemType() {
        this.setMapItemType();
        AtomicInteger index = new AtomicInteger(1);
        return mapItemType.sequencedKeySet()
                .stream()
                .map(e -> index.getAndIncrement() + ": " + e.getName())
                .collect(Collectors.joining("\n"));
    }

    public void setMapItemType() {
        this.mapItemType = this.items
                .stream()
                .filter(item -> SaleStatus.AVAILABLE.equals(item.getSaleStatus()))
                .collect(
                        Collectors.groupingBy(
                                I::getType,
                                LinkedHashMap::new,
                                Collectors.toList()
                        )
                );
    }

    public ItemType getItemType(int itemIndex) {
        List<ItemType> keys = mapItemType.sequencedKeySet()
                .stream()
                .toList();
        return keys.get(itemIndex);
    }

    public Item getItem(int phoneTypeIndex) {
        ItemType phoneType = this.getItemType(phoneTypeIndex);
        return this.mapItemType.get(phoneType).getFirst();
    }
}

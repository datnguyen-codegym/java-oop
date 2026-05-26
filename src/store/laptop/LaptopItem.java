package store.laptop;

import store.Item;
import store.SaleStatus;

public class LaptopItem extends Item {

    public LaptopItem(String itemCode, LaptopType laptopType, SaleStatus saleStatus) {
        super(itemCode, saleStatus, laptopType);
    }
}

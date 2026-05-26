package store.phone;

import store.Item;
import store.SaleStatus;

public class PhoneItem extends Item {

    public PhoneItem(String itemCode, PhoneType phoneType, SaleStatus saleStatus) {
        super(itemCode, saleStatus, phoneType);
    }

}

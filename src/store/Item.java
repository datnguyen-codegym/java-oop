package store;

public abstract class Item {
    protected String itemCode;
    protected SaleStatus saleStatus;
    protected ItemType type;

    public Item(String itemCode, SaleStatus saleStatus, ItemType type) {
        this.itemCode = itemCode;
        this.saleStatus = saleStatus;
        this.type = type;
    }

    public Item(){}

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public SaleStatus getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(SaleStatus saleStatus) {
        this.saleStatus = saleStatus;
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }
}

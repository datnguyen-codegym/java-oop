public class PhoneItem {
    private String itemCode;
    private PhoneType phoneType;
    private SaleStatus saleStatus;

    public PhoneItem(String itemCode, PhoneType phoneType, SaleStatus saleStatus) {
        this.itemCode = itemCode;
        this.phoneType = phoneType;
        this.saleStatus = saleStatus;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    public SaleStatus getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(SaleStatus saleStatus) {
        this.saleStatus = saleStatus;
    }
}

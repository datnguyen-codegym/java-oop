import java.util.List;

public class Order {
    private String orderCode;
    private String customerCode;
    private String date;
    private Long orderPrice;
    private String phoneItemCode;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Long orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getPhoneItemCode() {
        return phoneItemCode;
    }

    public void setPhoneItemCode(String phoneItemCode) {
        this.phoneItemCode = phoneItemCode;
    }
}

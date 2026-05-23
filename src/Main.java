import java.util.List;

public class Main {

    // tạo một ứng dụng bán điện thoại
    public static void main(String[] args) {
        // ** các tính năng chính của ứng dụng
        // tìm kiếm sản phẩm
        // mua sản phẩm
        // thanh toán

        //  ** các đối tượng / lớp
        // khách hàng
        // mẫu điện thoại
        // từng điện thoại
        // cửa hàng
        // đơn hàng

        // init phone type
        PhoneType iphoneProMax16 = new PhoneType(Branch.IPHONE, "PRO MAX", "16", 30000000L);
        PhoneType samsungNote10 = new PhoneType(Branch.SAMSUNG, "Note", "10", 28000000L);


        // init phone item
        PhoneItem item1 = new PhoneItem("iphoneProMax16_01", iphoneProMax16, SaleStatus.AVAILABLE);
        PhoneItem item2 = new PhoneItem("iphoneProMax16_02", iphoneProMax16, SaleStatus.AVAILABLE);
        PhoneItem item3 = new PhoneItem("iphoneProMax16_03", iphoneProMax16, SaleStatus.AVAILABLE);
        PhoneItem item4 = new PhoneItem("samsungNote10_01", samsungNote10, SaleStatus.AVAILABLE);
        PhoneItem item5 = new PhoneItem("samsungNote10_02", samsungNote10, SaleStatus.AVAILABLE);

        List<PhoneItem> items = List.of(item1, item2, item3, item4, item5);


        // init store
        Store.setItems(items);

        // list items


    }
}
import java.sql.SQLOutput;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

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

        // tạo các lựa chọn khi KH đến với của hàng của chúng ta
        // xem danh sách sản phẩm
        // xem chi tiết (phone type) của sp
        // mua hàng: nhập tên, nhập phone type muốn mua, confirm
        // thoát : cảm ơn quý khách

        System.out.println("Welcome");

        String commandList =        """
                        Vui lòng lựa chọn dịch vụ:
                        1. Xem danh sách sản phẩm
                        2. Xem chi tiết sản phẩm
                        3. Mua sản phẩm
                        4. Thoát
                        """
        ;

        String returnCommandList = "Nhấn phím 0 để quay lại màn hình chính";
        Scanner customerInput = new Scanner(System.in);

        while (true) {
            System.out.println(commandList);
            int command = customerInput.nextInt();
            switch (command) {
                case 1:
                    System.out.println(Store.listsPhoneType());

                    do {
                        System.out.println(returnCommandList);
                        command = customerInput.nextInt();
                        if (command == 0) break;
                    } while (command != 0);

                    continue;
                case 2: {
                    System.out.println("Lựa chọn mẫu điện thoại quan tâm hoặc 0 để quay về màn hình chính");
                    System.out.println(Store.listsPhoneType());
                    int phoneType = customerInput.nextInt();
                    if (0 == phoneType) {
                        continue;
                    }
                    System.out.println(Store.phoneTypeDetail(phoneType - 1));

                    do {
                        System.out.println(returnCommandList);
                        command = customerInput.nextInt();
                        if (command == 0) break;
                    } while (command != 0);
                    continue;
                }
                case 3:
                    customerInput.nextLine();
                    System.out.println("Vui lòng nhập tên KH hoặc 0 để quay về màn hình chính");
                    String customerName = customerInput.nextLine();
                    if ("0".equals(customerName)) {
                        continue;
                    }
                    Customer customer = new Customer(UUID.randomUUID().toString(), customerName);
                    System.out.println("Lựa chọn mẫu điện thoại muốn mua hoặc 0 để quay về màn hình chính");
                    System.out.println(Store.listsPhoneType());

                    int phoneTypeIndex = customerInput.nextInt();
                    if (phoneTypeIndex == 0) {
                        continue;
                    }

                    PhoneItem phoneItem = Store.getItem(phoneTypeIndex - 1);

                    Order order = new Order();
                    order.setCustomerCode(customer.getCustomerCode());
                    order.setOrderCode(UUID.randomUUID().toString());
                    order.setOrderPrice(phoneItem.getPhoneType().getPrice());
                    order.setPhoneItemCode(phoneItem.getItemCode());
                    order.setDate(new Date().toString());

                    phoneItem.setSaleStatus(SaleStatus.SOLD);
                    Store.getOrders().add(order);
                    Store.getCustomers().add(customer);
                    Store.setRevenue(Store.getRevenue() + order.getOrderPrice());

                    do {
                        System.out.println(returnCommandList);
                        command = customerInput.nextInt();
                        if (command == 0) break;
                    } while (command != 0);
                    continue;

                case 4:
                    System.out.println("Xin cảm ơn và hẹn gặp lại");
                    System.exit(0);
                default:
                    System.out.println("Dịch vụ chưa được hỗ trợ, vui lòng lựa chọn lại");
            }

        }
    }
}
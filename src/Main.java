
import store.laptop.LaptopBranch;
import store.laptop.LaptopItem;
import store.laptop.LaptopType;
import store.phone.PhoneBranch;
import store.phone.PhoneItem;
import store.phone.PhoneType;
import store.*;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    // tạo một ứng dụng bán điện thoại | laptop
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

        // init store.phone type
        PhoneType iphoneProMax16 = new PhoneType(PhoneBranch.IPHONE, "PRO MAX", "16", 30000000L);
        PhoneType samsungNote10 = new PhoneType(PhoneBranch.SAMSUNG, "Note", "10", 28000000L);


        // init store.phone item
        PhoneItem item1 = new PhoneItem("iphoneProMax16_01", iphoneProMax16, SaleStatus.AVAILABLE);
        PhoneItem item2 = new PhoneItem("iphoneProMax16_02", iphoneProMax16, SaleStatus.AVAILABLE);
        PhoneItem item3 = new PhoneItem("iphoneProMax16_03", iphoneProMax16, SaleStatus.AVAILABLE);
        PhoneItem item4 = new PhoneItem("samsungNote10_01", samsungNote10, SaleStatus.AVAILABLE);
        PhoneItem item5 = new PhoneItem("samsungNote10_02", samsungNote10, SaleStatus.AVAILABLE);

        List<PhoneItem> phoneItems = List.of(item1, item2, item3, item4, item5);

        Seller phoneSeller = new Seller(phoneItems);

        LaptopType macbookProM1 = new LaptopType(LaptopBranch.MACBOOK, "PRO M1", "BASE", 32000000L);
        LaptopType asusPro = new LaptopType(LaptopBranch.ASUS, "ASUS PRO", "BASE", 40000000L);


        LaptopItem laptopItem1 = new LaptopItem("macbookProM1_01", macbookProM1, SaleStatus.AVAILABLE);
        LaptopItem laptopItem2 = new LaptopItem("macbookProM1_02", macbookProM1, SaleStatus.AVAILABLE);
        LaptopItem laptopItem3 = new LaptopItem("asusPro_03", asusPro, SaleStatus.AVAILABLE);
        LaptopItem laptopItem4 = new LaptopItem("asusPro_04", asusPro, SaleStatus.AVAILABLE);

        List<LaptopItem> laptopItems = List.of(laptopItem1, laptopItem2, laptopItem3, laptopItem4);

        Seller laptopSeller = new Seller(laptopItems);
//        // init store
//        Store.setPhoneItems(phoneItems);
//        Store.setLaptopItems(laptopItems);



        // list phoneItems

        // tạo các lựa chọn khi KH đến với của hàng của chúng ta
        // xem danh sách sản phẩm
        // xem chi tiết (store.phone type) của sp
        // mua hàng: nhập tên, nhập store.phone type muốn mua, confirm
        // thoát : cảm ơn quý khách

        System.out.println("Welcome");

        String firstSentence = """
                Bạn muốn mua gì:
                        1. Điện thoại
                        2. Laptop
                        3. Thoát
                        4. Xem danh sách sản phẩm
                        5. Xem chi tiết sản phẩm
                        6. Mua sản phẩm laptop
                """;

        String commandList = """
                        Vui lòng lựa chọn dịch vụ:
                        4. Xem danh sách sản phẩm
                        5. Xem chi tiết sản phẩm
                        6. Mua sản phẩm laptop
                        """
        ;

        String returnCommandList = "Nhấn phím 0 để quay lại màn hình chính";
        Scanner customerInput = new Scanner(System.in);

        Seller seller = null;
        while (true) {
            System.out.println(firstSentence);
            int command = customerInput.nextInt();

            switch (command) {
                case 1: {
                    seller = phoneSeller;
                    continue;
                }
                case 2: {
                    seller = laptopSeller;
                    continue;
                }
                case 3:
                {
                    System.exit(0);
                }
                case 4: {
                    System.out.println(seller.listItemType());
                    do {
                        System.out.println(returnCommandList);
                        command = customerInput.nextInt();
                        if (command == 0) break;
                    } while (command != 0);

                    continue;
                }
                case 5: {
                    System.out.println("Lựa chọn mẫu sản phẩm quan tâm hoặc 0 để quay về màn hình chính");
                    System.out.println(seller.listItemType());
                    int phoneType = customerInput.nextInt();
                    if (0 == phoneType) {
                        continue;
                    }
                    System.out.println(seller.getItemType(phoneType - 1));

                    do {
                        System.out.println(returnCommandList);
                        command = customerInput.nextInt();
                        if (command == 0) break;
                    } while (command != 0);
                    continue;
                }
                case 6: {
                    customerInput.nextLine();
                    System.out.println("Vui lòng nhập tên KH hoặc 0 để quay về màn hình chính");
                    String customerName = customerInput.nextLine();
                    if ("0".equals(customerName)) {
                        continue;
                    }
                    Customer customer = new Customer(UUID.randomUUID().toString(), customerName);
                    System.out.println("Lựa chọn mẫu điện thoại muốn mua hoặc 0 để quay về màn hình chính");
                    System.out.println(seller.listItemType());

                    int phoneTypeIndex = customerInput.nextInt();
                    if (phoneTypeIndex == 0) {
                        continue;
                    }

                    Item phoneItem = seller.getItem(phoneTypeIndex - 1);

                    Order order = new Order();
                    order.setCustomerCode(customer.getCustomerCode());
                    order.setOrderCode(UUID.randomUUID().toString());
                    order.setOrderPrice(phoneItem.getType().getPrice());
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
                }
                default:
                    System.out.println("Dịch vụ chưa được hỗ trợ, vui lòng lựa chọn lại");
            }

        }
    }
}
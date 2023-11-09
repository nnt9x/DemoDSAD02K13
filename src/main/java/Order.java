import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private String orderDate;
    private String customerName;
    private String customerPhone;
    private int totalAmount;
    private boolean status = false;
    private List<OrderItem> itemList;

    public Order(int id, String orderDate, String customerName, String customerPhone) {
        this.id = id;
        this.orderDate = orderDate;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.itemList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<OrderItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<OrderItem> itemList) {
        this.itemList = itemList;
    }
    public void calculateTotalAmount(){
        // Tinh tong tien
        for (OrderItem orderItem: itemList) {
            totalAmount += orderItem.getItem().getPrice() * orderItem.getQuantity();
        }
    }
    public void printOrder(){
        System.out.println("----------------------");
        System.out.println("Order -- "+id);
        System.out.printf("Customer -- [%s - %s] \n", customerName, customerPhone);
        System.out.println("Total amount: " + totalAmount);
        System.out.println("Status: "+(status == true ? "Approved":"Pending"));
        // Danh sach san pham
        // Ma SP - Ten SP -Gia - So luong - Thanh tien
        //  1  - SP1  - 300 - 10   3000
        System.out.println("ID\tProduct\tPrice\tQuantity\tAmount");
        for (OrderItem o: itemList) {
            System.out.print(o.getItem().getId()+"\t");
            System.out.print(o.getItem().getName()+"\t");
            System.out.print(o.getItem().getPrice()+"\t");
            System.out.print(o.getQuantity()+"\t");
            System.out.print(o.getItem().getPrice() * o.getQuantity());
            System.out.println();
        }

        System.out.println("-----------------------");
    }
}

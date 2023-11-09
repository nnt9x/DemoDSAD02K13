public class Main {
    public static void main(String[] args) {
        // Tao truoc 5 san pham
        Product product1 = new Product(1, "Product 1", 1000);
        Product product2 = new Product(2, "Product 2", 2000);
        Product product3 = new Product(3, "Product 3", 3000);
        Product product4 = new Product(4, "Product 4", 4000);
        Product product5 = new Product(5, "Product 5", 5000);

        // Tao hoa don
        Order order1 = new Order(1, "2023-11-09",
                "Customer 1", "123456789");

        order1.getItemList().add(new OrderItem(1, product1, 2));
        order1.getItemList().add(new OrderItem(2, product2, 3));
        order1.calculateTotalAmount(); // tinh tien


        // Tao hoa don 2
        Order order2 = new Order(2, "2023-11-10",
                "Customer 2", "123456788");

        order2.getItemList().add(new OrderItem(2, product2, 2));
        order2.getItemList().add(new OrderItem(2, product3, 3));
        order2.calculateTotalAmount(); // tinh tien

        // Hang doi
        QueueADT<Order> orderQueueADT = new QueueADTImpl<>(100);
        orderQueueADT.enqueue(order2);
        orderQueueADT.enqueue(order1);

        // Duyet va in ra
        while(!orderQueueADT.isEmpty()){
            Order o = orderQueueADT.dequeue();
            o.setStatus(true);
            o.printOrder();
        }


    }
}

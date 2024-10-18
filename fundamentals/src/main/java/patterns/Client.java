package patterns;

public class Client {
    public static void main(String[] args) {
        // refactor the code according
        // so that `OrderService` should have additional logic of mock transaction management
        OrderService orderService = new OrderService();
        orderService.processOrders();
    }
}

package patterns;

public class Client {
    public static void main(String[] args) {
        // refactor the code according to task description in README.md file
        // so that `OrderService` should have additional logic of mock transaction management
        OrderService orderService = new OrderService();
        orderService.processOrders();
    }
}

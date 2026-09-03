package org.quickbite.orders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class OrdersController {
    private final OrderService os;
    public OrdersController(OrderService os) {
        this.os = os;
    }
    @GetMapping("/menu")
    public MenuDTO[] menu(){
        return os.menu();
    }
    @GetMapping("/placeOrder/{id}/{email}/{quantity}")
    public ResponseEntity<?> place(@PathVariable int id,@PathVariable String email,@PathVariable int quantity){
        return os.placeOrder(id,email,quantity);
    }
}

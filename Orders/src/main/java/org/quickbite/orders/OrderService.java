package org.quickbite.orders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class OrderService {
    private final OrderRepository or;
    private final RestTemplate rs;
    private final RestaurantClient rc;
    public OrderService(OrderRepository or,RestTemplate rs,RestaurantClient rc) {
        this.or = or;
        this.rs=rs;
        this.rc=rc;
    }
    public MenuDTO[] menu(){
        return rc.menu();
    }
    public ResponseEntity<?> placeOrder(int id, String email, int quantity){
        OrdersEntity oe=new OrdersEntity();
        MenuDTO item=rc.place(id);
        oe.setItemId(item.getId());
        oe.setUserEmail(email);
        oe.setRestaurantId(item.getRestaurantId());
        oe.setQuantity(quantity);
        oe.setItemPrice(item.getPrice());
        BigDecimal total=item.getPrice().multiply(BigDecimal.valueOf(quantity));
        System.out.println(total);
        oe.setTotalPrice(total);
        oe.setStatus("Ordered");
        or.save(oe);
        return  ResponseEntity.ok(oe);
    }
}

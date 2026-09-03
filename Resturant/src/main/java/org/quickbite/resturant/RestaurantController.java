package org.quickbite.resturant;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RestaurantController {
    private final RestaurantService rs;

    public RestaurantController(RestaurantService rs) {
        this.rs = rs;
    }
    @PostMapping("/addItem")
    public String addItem(@RequestBody RestaurantEntity re){
       return rs.addItems(re);
    }
    @GetMapping("/menu")
    public List<RestaurantEntity> menu(){
        return rs.showMenu();
    }
    @GetMapping("/itemDetails/{id}")
    public RestaurantEntity place(@PathVariable int id){
        return rs.placeOrder(id);
    }
}

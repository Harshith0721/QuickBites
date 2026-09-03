package org.quickbite.resturant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {
    private final RestaurantRepository rr;
    public RestaurantService(RestaurantRepository r) {
        this.rr = r;
    }
    public String addItems(RestaurantEntity re){
        RestaurantEntity r=new RestaurantEntity();
        r.setItem(re.getItem());
        r.setPrice(re.getPrice());
        rr.save(r);
        return "New Item Added to Menu";
    }
    public List<RestaurantEntity> showMenu(){
       return rr.findAllItems();
    }
    public RestaurantEntity placeOrder(int id){
        return rr.findById(id).orElseThrow(()->new RuntimeException("Item Not Found"));
    }
}

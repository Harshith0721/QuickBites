package org.quickbite.orders;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "RESTURANT")
public interface RestaurantClient {
    @GetMapping("/menu")
    public MenuDTO[] menu();
    @GetMapping("/itemDetails/{id}")
    public MenuDTO place(@PathVariable int id);
}

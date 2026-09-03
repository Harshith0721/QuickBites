package org.quickbite.users;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ORDERS")
public interface OrderClient {
    @GetMapping("/menu")
    public Menu[] menu();
    @GetMapping("/placeOrder/{id}/{email}/{quantity}")
    public ResponseEntity<?> place(@PathVariable int id, @PathVariable String email,@PathVariable int quantity);
}

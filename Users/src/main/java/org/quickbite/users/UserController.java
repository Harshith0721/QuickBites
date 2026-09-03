package org.quickbite.users;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserService us;
    public UserController(UserService us) {
        this.us = us;
    }
    @PostMapping("/register")
    public String registerUser(@RequestBody UsersEntity u){
        return us.register(u);
    }
    @GetMapping("/showMenu")
    public Menu[] getMenu(){
        return us.getMenu();
    }
    @PostMapping("/placeOrder/{id}/{quantity}")
    public ResponseEntity<?> place(@PathVariable int id,Authentication authentication, @PathVariable int quantity){
        String email= authentication.getName();
        return us.placOrder(id,email,quantity);
    }
}

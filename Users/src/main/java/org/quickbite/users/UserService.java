package org.quickbite.users;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService implements UserDetailsService{
    private final UserRepository r;
    private final RestTemplate rt;
    private final PasswordEncoder pe;
    private final OrderClient oc;

    public UserService(UserRepository r, RestTemplate rt, PasswordEncoder pe, OrderClient oc) {
        this.r = r;
        this.rt = rt;
        this.pe = pe;
        this.oc = oc;
    }

    public String register(UsersEntity u){
        UsersEntity ue=new UsersEntity();
        ue.setName(u.getName());
        ue.setEmail(u.getEmail());
        ue.setPassword(pe.encode(u.getPassword()));
        r.save(ue);
        return "You Are Registered";
    }
    public ResponseEntity<?> placOrder(int id, String email, int quantity){
            System.out.println(email);
           return oc.place(id,email,quantity);
    }
    public Menu[] getMenu(){
        return oc.menu();
    }
    @Override
    public UserDetails loadUserByUsername(String username){
        UsersEntity user=r.findByEmail(username)
                .orElseThrow(()->new RuntimeException("User not found Kindly check credentails"));
        return User.withUsername(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}

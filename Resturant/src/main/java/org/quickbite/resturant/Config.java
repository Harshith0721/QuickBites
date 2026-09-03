package org.quickbite.resturant;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Config {
    @Bean
    public PasswordEncoder pe(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService us(){
        UserDetails restaurant= User.withUsername("Biriyani")
                .password(pe().encode("123456"))
                .build();
        return new InMemoryUserDetailsManager(restaurant);
    }
    @Bean
    public SecurityFilterChain sfc(HttpSecurity http) {
        return http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth.requestMatchers("/addItem").authenticated().anyRequest()
                        .permitAll())
                .httpBasic(Customizer.withDefaults())
                .build();
    }
}

package org.quickbite.orders;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Configs {
    @Bean
    public RestTemplate rs(){
        return new RestTemplate();
    }
}

package com.example.demo.config;

import com.example.demo.cart.RestTemplateApiCart;
import com.example.demo.cart.cartApi;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebConfig {

    @Bean
    public cartApi cartApi(){
        return  new RestTemplateApiCart();
    }

    //provide enviroment details
    @Bean
    @Profile("local")
    public RestTemplate localRestTemplate(RestTemplateBuilder builder){
        return builder.build();
    }


}

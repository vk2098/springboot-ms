package com.microservices.student.loadbalancer;

import com.microservices.student.response.AddressResponse;
import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@LoadBalancerClient(value = "ADDRESS")
public class LoadBalancer {
    @Bean
    @LoadBalanced
    public Feign.Builder feignBuilder(){
        return  Feign.builder();
    }

}
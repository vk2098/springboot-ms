package com.microservices.student.feignclients;


import com.microservices.student.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(url = "${address.service.url}",name = "address-feign-client", path = "/api/address")
@FeignClient(value="ADDRESS", path = "/api/address")

public interface FeinClient {
    @GetMapping("/getById/{id}")
    public AddressResponse getById(@PathVariable long id);
}

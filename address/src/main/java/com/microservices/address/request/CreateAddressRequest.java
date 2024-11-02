package com.microservices.address.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateAddressRequest {
    private String street;

    private String city;
}

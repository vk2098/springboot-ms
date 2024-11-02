package com.microservices.address.response;

import com.microservices.address.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddressResponse {
    private long addressId;

    private String street;

    private String city;

    public AddressResponse(Address address) {
        this.addressId = address.getId();
        this.street = address.getStreet();
        this.city = address.getCity();
    }
}

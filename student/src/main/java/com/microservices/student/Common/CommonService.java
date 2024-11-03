package com.microservices.student.Common;

import com.microservices.student.feignclients.FeinClient;
import com.microservices.student.response.AddressResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommonService {

    Logger logger= LoggerFactory.getLogger(CommonService.class);
    @Autowired
    FeinClient feinClient;
    static int count=0;

    @CircuitBreaker(name = "addressService",fallbackMethod = "fallbackAddressService")
    public AddressResponse getAddressResponse(Long addressId) {
        logger.info("Call to Address No count:"+ count++);
        AddressResponse addressResponse= feinClient.getById(addressId);
        return addressResponse;
    }

    public AddressResponse fallbackAddressService(Long addressId,Throwable e){
        logger.info("Inside fallbackAddressService... returning dummy response: "+e);
        return new AddressResponse();
    }

}

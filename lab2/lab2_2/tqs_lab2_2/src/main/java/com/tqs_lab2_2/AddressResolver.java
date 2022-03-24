package com.tqs_lab2_2;

import java.util.Locale;
import java.util.Optional;

public class AddressResolver {

    private ISimpleHttpClient httpClient;

    public AddressResolver(ISimpleHttpClient httpClient) {
      this.httpClient = httpClient;
    }

    public Optional<Address> findAddressForLocation (double latitude, double longitude) {
        return null;
    }
    
}

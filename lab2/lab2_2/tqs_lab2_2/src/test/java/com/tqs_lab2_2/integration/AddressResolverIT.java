package com.tqs_lab2_2.integration;

import java.util.Optional;

import com.tqs_lab2_2.Address;
import com.tqs_lab2_2.AddressResolver;
import com.tqs_lab2_2.TqsHttpClient;

import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;


public class AddressResolverIT {

    private AddressResolver addrResolver = new AddressResolver(new TqsHttpClient());

    //final String response = "{\"info\":{\"statuscode\":0,\"copyright\":{\"text\":\"\u00A9 2022 MapQuest, Inc.\",\"imageUrl\":\"http://api.mqcdn.com/res/mqlogo.gif\",\"imageAltText\":\"\u00A9 2022 MapQuest, Inc.\"},\"messages\":[]},\"options\":{\"maxResults\":1,\"thumbMaps\":true,\"ignoreLatLngInput\":false},\"results\":[{\"providedLocation\":{\"latLng\":{\"lat\":40.6318,\"lng\":-8.658}},\"locations\":[{\"street\":\"Parque Estacionamento da Reitoria - Univerisdade de Aveiro\",\"adminArea6\":\"\",\"adminArea6Type\":\"Neighborhood\",\"adminArea5\":\"Gl\u00F3ria e Vera Cruz\",\"adminArea5Type\":\"City\",\"adminArea4\":\"\",\"adminArea4Type\":\"County\",\"adminArea3\":\"Centro\",\"adminArea3Type\":\"State\",\"adminArea1\":\"PT\",\"adminArea1Type\":\"Country\",\"postalCode\":\"3810-193\",\"geocodeQualityCode\":\"P1AAA\",\"geocodeQuality\":\"POINT\",\"dragPoint\":false,\"sideOfStreet\":\"N\",\"linkId\":\"0\",\"unknownInput\":\"\",\"type\":\"s\",\"latLng\":{\"lat\":40.631803,\"lng\":-8.657881},\"displayLatLng\":{\"lat\":40.631803,\"lng\":-8.657881},\"mapUrl\":\"http://open.mapquestapi.com/staticmap/v5/map?key=uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ&type=map&size=225,160&locations=40.6318025,-8.657881|marker-sm-50318A-1&scalebar=true&zoom=15&rand=70663981\",\"roadMetadata\":null}]}]}";

    @Test
    void testFindLocation(){
        Optional<Address> result = addrResolver.findAddressForLocation(40.640661, -8.656688);
        Optional<Address> realAddres = Optional.of(new Address("Parque Estacionamento da Reitoria - Univerisdade de Aveiro", "Centro", "Glória e Vera Cruz", "3810-193", ""));
        
        assertThat(result.toString(), is(realAddres.toString()));
    }

    void testBadCoordinates(){
        assertThrows(IndexOutOfBoundsException.class, () -> addrResolver.findAddressForLocation(-91, -8.656688));
    }
    
}
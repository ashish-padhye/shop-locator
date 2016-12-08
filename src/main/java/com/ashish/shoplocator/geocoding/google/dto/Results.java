package com.ashish.shoplocator.geocoding.google.dto;

public class Results {
    public String formatted_address ;
    public Geometry geometry ;
    public String[] types;
    public AddressComponent[] address_components;
    public String place_id;
}

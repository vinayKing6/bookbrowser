package com.example.model;

import java.util.ArrayList;
import java.util.List;

/**
 * BeerExpert
 */
public class BeerExpert {

    public List<String> getBrands(String color){
        List Brands=new ArrayList<String>();
        if (color.equals("amber")) {
            Brands.add("Jack Amber");
            Brands.add("Red moose");
        }
        else{
            Brands.add("Jail Pale Ale");
            Brands.add("Gout  Stdout");
        }
        return Brands;
    }
}

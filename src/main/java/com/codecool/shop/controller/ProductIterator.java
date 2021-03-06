package com.codecool.shop.controller;

import com.codecool.shop.model.Product;
import java.util.ArrayList;
import java.util.Iterator;


public class ProductIterator implements com.codecool.shop.controller.Iterator {

    private final ArrayList<Product> products;
    private Integer index;

    public ProductIterator(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public Iterator<Product> Iterator() {
        return products.iterator();
    }

    @Override
    public Boolean hasNext() {
        return index < products.size();
    }

    @Override
    public Object next() {
        if (this.hasNext()) {
            return products.get(index++);
        }
        return null;
    }
}

package com.codecool.shop.model;

import com.codecool.shop.controller.ProductIterator;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by marek on 25.04.17.
 */
public class Basket {

    private final ArrayList<Item> itemsList;

    public ArrayList<Item> getItemList() {
        return this.itemsList;
    }

    public Basket(ArrayList<Item> items) {
        this.itemsList = items;
    }


    public void addProduct(Item item) {
        itemsList.add(item);
    }

    public boolean removeProduct(Item item) {
        boolean found;
        if (itemsList.contains(item)) {
            itemsList.remove(item);
            found = true;
        } else {
            found = false;
        }
        return found;
    }

    private Iterator<Item> getIterator(ArrayList<Item> items) {
        return items.iterator();
    }

}

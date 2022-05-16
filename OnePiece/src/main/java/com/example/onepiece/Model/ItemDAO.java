package com.example.onepiece.Model;

import java.util.List;


public interface ItemDAO extends AutoCloseable{

    public void saveItem(Item i);
    public void deleteItem(Item i);
    public void updateItem(Item i);
    public List<Item> listItems();


    public default void saveCategory(Category dairy){
        throw new UnsupportedOperationException();
    }
    default public void close(){};
}

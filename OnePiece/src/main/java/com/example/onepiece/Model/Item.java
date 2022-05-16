package com.example.onepiece.Model;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "itemname")
    private String name;
    @Column(name = "Tesco")
    private int priceTesco;
    @Column(name = "Spar")
    private int priceSpar;
    @Column(name = "Aldi")
    private int priceAldi;

    public Item(String name, int priceTesco, int priceSpar, int priceAldi) {
        this.name = name;
        this.priceTesco = priceTesco;
        this.priceSpar = priceSpar;
        this.priceAldi = priceAldi;
    }

    public Item() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriceTesco() {
        return priceTesco;
    }

    public void setPriceTesco(int priceTesco) {
        this.priceTesco = priceTesco;
    }

    public int getPriceSpar() {
        return priceSpar;
    }

    public void setPriceSpar(int priceSpar) {
        this.priceSpar = priceSpar;
    }

    public int getPriceAldi() {
        return priceAldi;
    }

    public void setPriceAldi(int priceAldi) {
        this.priceAldi = priceAldi;
    }

    @Override
    public String toString() {
        return "Item{" + "Name=" + name + ",  Tesco=" + priceTesco + ", Spar=" + priceSpar + ", Aldi=" + priceAldi + ", ID=" + id + '}';
    }
}

package shoemanagementsystemiv;

import java.io.Serializable;

public class Shoe implements Serializable{
    private int shoe_id;
    private int sup_id;
    private String shoe_brand;
    private String shoe_model;
    private int shoe_size;
    private String shoe_color;
    private float shoe_price;
    public Shoe() {
    }
    public Shoe(int shoe_id, int sup_id, String shoe_brand, String shoe_model, int shoe_size, String shoe_color,
            float shoe_price) {
        this.shoe_id = shoe_id;
        this.sup_id = sup_id;
        this.shoe_brand = shoe_brand;
        this.shoe_model = shoe_model;
        this.shoe_size = shoe_size;
        this.shoe_color = shoe_color;
        this.shoe_price = shoe_price;
    }
    public int getShoe_id() {
        return shoe_id;
    }
    public void setShoe_id(int shoe_id) {
        this.shoe_id = shoe_id;
    }
    public int getSup_id() {
        return sup_id;
    }
    public void setSup_id(int sup_id) {
        this.sup_id = sup_id;
    }
    public String getShoe_brand() {
        return shoe_brand;
    }
    public void setShoe_brand(String shoe_brand) {
        this.shoe_brand = shoe_brand;
    }
    public String getShoe_model() {
        return shoe_model;
    }
    public void setShoe_model(String shoe_model) {
        this.shoe_model = shoe_model;
    }
    public int getShoe_size() {
        return shoe_size;
    }
    public void setShoe_size(int shoe_size) {
        this.shoe_size = shoe_size;
    }
    public String getShoe_color() {
        return shoe_color;
    }
    public void setShoe_color(String shoe_color) {
        this.shoe_color = shoe_color;
    }
    public float getShoe_price() {
        return shoe_price;
    }
    public void setShoe_price(float shoe_price) {
        this.shoe_price = shoe_price;
    }
    @Override
    public String toString() {
        return "Shoe [shoe_id=" + shoe_id + ", sup_id=" + sup_id + ", shoe_brand=" + shoe_brand + ", shoe_model="
                + shoe_model + ", shoe_size=" + shoe_size + ", shoe_color=" + shoe_color + ", shoe_price=" + shoe_price
                + "]";
    }
}

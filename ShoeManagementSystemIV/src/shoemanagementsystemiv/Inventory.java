package shoemanagementsystemiv;

import java.io.Serializable;

public class Inventory implements Serializable{
    private int inv_id;
    private int shoe_id;
    private int inv_quantity;
    private String inv_location;
    public Inventory() {
    }
    public Inventory(int inv_id, int shoe_id, int inv_quantity, String inv_location) {
        this.inv_id = inv_id;
        this.shoe_id = shoe_id;
        this.inv_quantity = inv_quantity;
        this.inv_location = inv_location;
    }
    public int getInv_id() {
        return inv_id;
    }
    public void setInv_id(int inv_id) {
        this.inv_id = inv_id;
    }
    public int getShoe_id() {
        return shoe_id;
    }
    public void setShoe_id(int shoe_id) {
        this.shoe_id = shoe_id;
    }
    public int getInv_quantity() {
        return inv_quantity;
    }
    public void setInv_quantity(int inv_quantity) {
        this.inv_quantity = inv_quantity;
    }
    public String getInv_location() {
        return inv_location;
    }
    public void setInv_location(String inv_location) {
        this.inv_location = inv_location;
    }
    @Override
    public String toString() {
        return "Inventory [inv_id=" + inv_id + ", shoe_id=" + shoe_id + ", inv_quantity=" + inv_quantity
                + ", inv_location=" + inv_location + "]";
    }

}

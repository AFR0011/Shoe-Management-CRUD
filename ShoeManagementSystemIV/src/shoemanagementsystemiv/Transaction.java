package shoemanagementsystemiv;

import java.io.Serializable;
import java.util.Date;

public class Transaction implements Serializable{
    private int trn_id;
    private int cus_id;
    private int shoe_id;
    private int trn_amount;
    private float trn_totalPrice;
    private Date trn_date;

    public Transaction() {
    }

    public Transaction(int trn_id, int cus_id, int shoe_id, int trn_amount, float trn_totalPrice, Date trn_date) {
        this.trn_id = trn_id;
        this.cus_id = cus_id;
        this.shoe_id = shoe_id;
        this.trn_amount = trn_amount;
        this.trn_totalPrice = trn_totalPrice;
        this.trn_date = trn_date;
    }

    public int getTrn_id() {
        return trn_id;
    }

    public void setTrn_id(int trn_id) {
        this.trn_id = trn_id;
    }

    public int getCus_id() {
        return cus_id;
    }

    public void setCus_id(int cus_id) {
        this.cus_id = cus_id;
    }

    public int getShoe_id() {
        return shoe_id;
    }

    public void setShoe_id(int shoe_id) {
        this.shoe_id = shoe_id;
    }

    public int getTrn_amount() {
        return trn_amount;
    }

    public void setTrn_amount(int trn_amount) {
        this.trn_amount = trn_amount;
    }

    public float getTrn_totalPrice() {
        return trn_totalPrice;
    }

    public void setTrn_totalPrice(float trn_totalPrice) {
        this.trn_totalPrice = trn_totalPrice;
    }

    public Date getTrn_date() {
        return trn_date;
    }

    public void setTrn_date(Date trn_date) {
        this.trn_date = trn_date;
    }

    @Override
    public String toString() {
        return "Transaction [trn_id=" + trn_id + ", cus_id=" + cus_id + ", shoe_id=" + shoe_id + ", trn_amount="
                + trn_amount + ", trn_totalPrice=" + trn_totalPrice + ", trn_date=" + trn_date + "]";
    }

}

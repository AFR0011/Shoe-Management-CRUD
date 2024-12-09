package shoemanagementsystemiv;

import java.io.Serializable;

public class Customer implements Serializable{
    private int cus_id;
    private String cus_name;
    private String cus_email;
    private String cus_phone;
    public Customer() {
    }
    public Customer(int cus_id, String cus_name, String cus_email, String cus_phone) {
        this.cus_id = cus_id;
        this.cus_name = cus_name;
        this.cus_email = cus_email;
        this.cus_phone = cus_phone;
    }
    public int getCus_id() {
        return cus_id;
    }
    public void setCus_id(int cus_id) {
        this.cus_id = cus_id;
    }
    public String getCus_name() {
        return cus_name;
    }
    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }
    public String getCus_email() {
        return cus_email;
    }
    public void setCus_email(String cus_email) {
        this.cus_email = cus_email;
    }
    public String getCus_phone() {
        return cus_phone;
    }
    public void setCus_phone(String cus_phone) {
        this.cus_phone = cus_phone;
    }
    @Override
    public String toString() {
        return "Customer [cus_id=" + cus_id + ", cus_name=" + cus_name + ", cus_email=" + cus_email + ", cus_phone="
                + cus_phone + "]";
    }

}

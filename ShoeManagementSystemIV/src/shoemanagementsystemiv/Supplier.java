package shoemanagementsystemiv;

import java.io.Serializable;

public class Supplier implements Serializable{
    private int sup_id;
    private String sup_name;
    private String sup_contactPerson;
    private String sup_email;
    private String sup_phone;
    private String sup_address;
    public Supplier() {
    }
    public Supplier(int sup_id, String sup_name, String sup_contactPerson, String sup_email, String sup_phone,
            String sup_address) {
        this.sup_id = sup_id;
        this.sup_name = sup_name;
        this.sup_contactPerson = sup_contactPerson;
        this.sup_email = sup_email;
        this.sup_phone = sup_phone;
        this.sup_address = sup_address;
    }
    public int getSup_id() {
        return sup_id;
    }
    public void setSup_id(int sup_id) {
        this.sup_id = sup_id;
    }
    public String getSup_name() {
        return sup_name;
    }
    public void setSup_name(String sup_name) {
        this.sup_name = sup_name;
    }
    public String getSup_contactPerson() {
        return sup_contactPerson;
    }
    public void setSup_contactPerson(String sup_contactPerson) {
        this.sup_contactPerson = sup_contactPerson;
    }
    public String getSup_email() {
        return sup_email;
    }
    public void setSup_email(String sup_email) {
        this.sup_email = sup_email;
    }
    public String getSup_phone() {
        return sup_phone;
    }
    public void setSup_phone(String sup_phone) {
        this.sup_phone = sup_phone;
    }
    public String getSup_address() {
        return sup_address;
    }
    public void setSup_address(String sup_address) {
        this.sup_address = sup_address;
    }
    @Override
    public String toString() {
        return "Supplier [sup_id=" + sup_id + ", sup_name=" + sup_name + ", sup_contactPerson=" + sup_contactPerson
                + ", sup_email=" + sup_email + ", sup_phone=" + sup_phone + ", sup_address=" + sup_address + "]";
    }
     
}

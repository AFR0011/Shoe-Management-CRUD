package shoemanagementsystemiv;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

/**
 *
 * @author Ali Farrokhnejad
 */
public class ShoeManagementIV {

    public static Connection connection;
    public static SimpleDateFormat sdf;

    /**
     * @param args the command line arguments
     * @throws SQLException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws SQLException {
        ShoeManagementIV.initializeConnection();
        sdf = new SimpleDateFormat("dd/MM/yyyy");

        create_customers();
        create_suppliers();
        create_shoes();
        create_inventory();
        create_transactions();

        new Menu().setVisible(true);

        System.out.printf("\n");
    }
    public static boolean checkCustomerExists(int customer_id) throws SQLException {
        try {
            String sql = "SELECT COUNT(*) FROM customers WHERE cus_id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, customer_id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean checkShoeExists(int shoe_id) throws SQLException {
        try {
            String sql = "SELECT COUNT(*) FROM shoes WHERE shoe_id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, shoe_id);
            ResultSet rs = stmt.executeQuery();
    
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean checkTransactionExists(int trn_id) throws SQLException {
        try {
            String sql = "SELECT COUNT(*) FROM transactions WHERE trn_id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, trn_id);
            ResultSet rs = stmt.executeQuery();
    
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean checkInventoryExists(int inv_id) throws SQLException {
        try {
            String sql = "SELECT COUNT(*) FROM inventory WHERE inv_id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, inv_id);
            ResultSet rs = stmt.executeQuery();
    
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean checkSupplierExists(int supplier_id) throws SQLException {
        try {
            String sql = "SELECT COUNT(*) FROM suppliers WHERE sup_id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, supplier_id);
            ResultSet rs = stmt.executeQuery();
    
            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static void create_shoes() throws SQLException {
        addShoe(1, 1, "Nike", "Air Max", 9, "Black", 150.00f);
        addShoe(2, 2, "Adidas", "Superstar", 8, "White", 120.00f);
        addShoe(3, 3, "Puma", "Suede", 7, "Red", 100.00f);
        addShoe(4, 4, "Reebok", "Classic", 10, "Blue", 130.00f);
        addShoe(5, 5, "Vans", "Old Skool", 9, "Checkerboard", 80.00f);
    }

    public static void create_customers() throws SQLException {
        addCustomer(1, "John Doe", "john@example.com", "123-456-7890");
        addCustomer(2, "Jane Smith", "jane@example.com", "987-654-3210");
        addCustomer(3, "Michael Brown", "michael@example.com", "111-222-3333");
        addCustomer(4, "Emily Johnson", "emily@example.com", "444-555-6666");
        addCustomer(5, "David Lee", "david@example.com", "777-888-9999");
    }

    public static void create_transactions() throws SQLException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            addTransaction(1, 1, 1, 2, 300.00f, sdf.parse("28/03/2002"));
            addTransaction(2, 2, 3, 1, 100.00f, sdf.parse("16/09/2003"));
            addTransaction(3, 3, 2, 1, 120.00f, sdf.parse("17/05/2002"));
            addTransaction(4, 4, 5, 3, 240.00f, sdf.parse("22/11/2001"));
            addTransaction(5, 5, 4, 2, 260.00f, sdf.parse("19/02/2002"));
        } catch (ParseException e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    public static void create_inventory() throws SQLException {
        addInventory(1, 1, 10, "Main Store");
        addInventory(2, 2, 15, "Warehouse");
        addInventory(3, 3, 20, "Branch A");
        addInventory(4, 4, 8, "Branch B");
        addInventory(5, 5, 25, "Online Stock");
    }

    public static void create_suppliers() throws SQLException {
        addSupplier(1, "ABC Shoes", "John Smith", "john@abcshoes.com", "123-456-7890",
                "123 Shoe Street, Cityville");
        addSupplier(2, "XYZ Footwear", "Jane Doe", "jane@xyzfootwear.com", "987-654-3210",
                "456 Footwear Avenue, Townsville");
        addSupplier(3, "Shoe Empire", "Mike Johnson", "mike@shoeempire.com", "111-222-3333",
                "789 Sneaker Road, Villageland");
        addSupplier(4, "Footprints Inc.", "Emily Brown", "emily@footprintsinc.com", "444-555-6666",
                "101 Boot Boulevard, Shoetown");
        addSupplier(5, "Sole Suppliers", "David Lee", "david@solesuppliers.com", "777-888-9999",
                "202 Sandal Street, Flipflop City");
    }

    // Add (create) methods
    public static void addCustomer(int cus_id, String cus_name, String cus_email, String cus_phone)throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Customers VALUES (?, ?, ?, ?)")) {
            pstmt.setInt(1, cus_id);
            pstmt.setString(2, cus_name);
            pstmt.setString(3, cus_email);
            pstmt.setString(4, cus_phone);
            pstmt.executeUpdate();
            System.out.println("Added successfully.\n");
        } catch (SQLException e) {
            System.out.print(e);
        }
    }

    public static void addInventory(int inv_id, int shoe_id, int inv_quantity, String inv_location)throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Inventory VALUES (?, ?, ?, ?)")) {
            pstmt.setInt(1, inv_id);
            pstmt.setInt(2, shoe_id);
            pstmt.setInt(3, inv_quantity);
            pstmt.setString(4, inv_location);
            pstmt.executeUpdate();
            System.out.println("Added successfully.\n");
        }catch (SQLException e) {
            System.out.print(e);
        }
    }

    public static void addSupplier(int sup_id, String sup_name, String sup_contactPerson, String sup_email,
            String sup_phone, String sup_address) {
        try (PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Suppliers VALUES (?, ?, ?, ?, ?, ?)")) {
            pstmt.setInt(1, sup_id);
            pstmt.setString(2, sup_name);
            pstmt.setString(3, sup_contactPerson);
            pstmt.setString(4, sup_email);
            pstmt.setString(5, sup_phone);
            pstmt.setString(6, sup_address);
            pstmt.executeUpdate();
            System.out.println("Added successfully.\n");
        }catch (SQLException e) {
            System.out.print(e);
        }
    }

    public static void addTransaction(int trn_id, int cus_id, int shoe_id, int trn_amount, float trn_totalPrice,
            Date trn_date)  {
        try (PreparedStatement pstmt = connection
                .prepareStatement("INSERT INTO Transactions VALUES (?, ?, ?, ?, ?, ?)")) {
            pstmt.setInt(1, trn_id);
            pstmt.setInt(2, cus_id);
            pstmt.setInt(3, shoe_id);
            pstmt.setInt(4, trn_amount);
            pstmt.setFloat(5, trn_totalPrice);
            pstmt.setDate(6, new java.sql.Date(trn_date.getTime()));
            pstmt.executeUpdate();
            System.out.println("Added successfully.\n");
        }catch (SQLException e) {
            System.out.print(e);
        }
    }

    public static void addShoe(int shoe_id, int sup_id, String shoe_brand, String shoe_model, int shoe_size,
            String shoe_color, float shoe_price)  {
        try (PreparedStatement pstmt = connection.prepareStatement("INSERT INTO Shoes VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            pstmt.setInt(1, shoe_id);
            pstmt.setInt(2, sup_id);
            pstmt.setString(3, shoe_brand);
            pstmt.setString(4, shoe_model);
            pstmt.setInt(5, shoe_size);
            pstmt.setString(6, shoe_color);
            pstmt.setFloat(7, shoe_price);
            pstmt.executeUpdate();
            System.out.println("Added successfully.\n");
        }catch (SQLException e) {
            System.out.print(e);
        }
    }

    // Delete methods
    public static void deleteCustomer(int cus_id) {
        try (PreparedStatement pstmt = connection.prepareStatement("DELETE FROM Customers WHERE cus_id = ?")) {
            pstmt.setInt(1, cus_id);
            pstmt.executeUpdate();
            System.out.println("Deleted successfully.\n");
        }catch (SQLException e) {
            System.out.print(e);
        }
    }

    public static void deleteInventory(int inv_id) throws SQLException {
        try (PreparedStatement pstmt = connection.prepareStatement("DELETE FROM Inventory WHERE inv_id = ?")) {
            pstmt.setInt(1, inv_id);
            pstmt.executeUpdate();
            System.out.println("Deleted successfully.\n");
        }
    }

    public static void deleteSupplier(int sup_id)  {
        try (PreparedStatement pstmt = connection.prepareStatement("DELETE FROM Suppliers WHERE sup_id = ?")) {
            pstmt.setInt(1, sup_id);
            pstmt.executeUpdate();
            System.out.println("Deleted successfully.\n");
        }catch (SQLException e) {
            System.out.print(e);
        }
    }

    public static void deleteTransaction(int trn_id) {
        try (PreparedStatement pstmt = connection.prepareStatement("DELETE FROM Transactions WHERE trn_id = ?")) {
            pstmt.setInt(1, trn_id);
            pstmt.executeUpdate();
            System.out.println("Deleted successfully.\n");
        }catch (SQLException e) {
            System.out.print(e);
        }
    }

    public static void deleteShoe(int shoe_id){
        try (PreparedStatement pstmt = connection.prepareStatement("DELETE FROM Shoes WHERE shoe_id = ?")) {
            pstmt.setInt(1, shoe_id);
            pstmt.executeUpdate();
            System.out.println("Deleted successfully.\n");
        }catch (SQLException e) {
            System.out.print(e);
        }
    }

    // Edit (update) methods
    public static void editCustomer(int cus_id, String cus_name, String cus_email, String cus_phone)
            {
        try (PreparedStatement pstmt = connection
                .prepareStatement("UPDATE Customers SET cus_name = ?, cus_email = ?, cus_phone = ? WHERE cus_id = ?")) {
            pstmt.setString(1, cus_name);
            pstmt.setString(2, cus_email);
            pstmt.setString(3, cus_phone);
            pstmt.setInt(4, cus_id);
            pstmt.executeUpdate();
            System.out.println("Edited successfully.\n");
        }catch (SQLException e) {
            System.out.print(e);
        }
    }

    public static void editInventory(int inv_id, int shoe_id, int inv_quantity, String inv_location)
            {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "UPDATE Inventory SET shoe_id = ?, inv_quantity = ?, inv_location = ? WHERE inv_id = ?")) {
            pstmt.setInt(1, shoe_id);
            pstmt.setInt(2, inv_quantity);
            pstmt.setString(3, inv_location);
            pstmt.setInt(4, inv_id);
            pstmt.executeUpdate();
            System.out.println("Edited successfully.\n");
        }catch (SQLException e) {
            System.out.print(e);
        }
    }

    public static void editSupplier(int sup_id, String sup_name, String sup_contactPerson, String sup_email, String sup_phone, String sup_address) {
        try (PreparedStatement pstmt = connection.prepareStatement("UPDATE Suppliers SET sup_name = ?, sup_contactPerson = ?, sup_email = ?, sup_phone = ?, sup_address = ? WHERE sup_id = ?")) {
            pstmt.setString(1, sup_name);
            pstmt.setString(2, sup_contactPerson);
            pstmt.setString(3, sup_email);
            pstmt.setString(4, sup_phone);
            pstmt.setString(5, sup_address);
            pstmt.setInt(6, sup_id);
            pstmt.executeUpdate();
            System.out.println("Edited successfully.\n");
        }
        catch (SQLException e) {
            System.out.print(e);
        }
    }
    public static void editTransaction(int trn_id, int cus_id, int shoe_id, int trn_amount, float trn_totalPrice,
            Date trn_date) {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "UPDATE Transactions SET cus_id = ?, shoe_id = ?, trn_amount = ?, trn_totalPrice = ?, trn_date = ? WHERE trn_id = ?")) {
            pstmt.setInt(1, cus_id);
            pstmt.setInt(2, shoe_id);
            pstmt.setInt(3, trn_amount);
            pstmt.setFloat(4, trn_totalPrice);
            pstmt.setDate(5, new java.sql.Date(trn_date.getTime()));
            pstmt.setInt(6, trn_id);
            pstmt.executeUpdate();
            System.out.println("Edited successfully.\n");
        }
        catch (SQLException e) {
            System.out.print(e);
        }
    }

    public static void editShoe(int shoe_id, int sup_id, String shoe_brand, String shoe_model, int shoe_size,
            String shoe_color, float shoe_price) {
        try (PreparedStatement pstmt = connection.prepareStatement(
                "UPDATE Shoes SET sup_id = ?, shoe_brand = ?, shoe_model = ?, shoe_size = ?, shoe_color = ?, shoe_price = ? WHERE shoe_id = ?")) {
            pstmt.setInt(1, sup_id);
            pstmt.setString(2, shoe_brand);
            pstmt.setString(3, shoe_model);
            pstmt.setInt(4, shoe_size);
            pstmt.setString(5, shoe_color);
            pstmt.setFloat(6, shoe_price);
            pstmt.setInt(7, shoe_id);
            pstmt.executeUpdate();
            System.out.println("Edited successfully.\n");
        }catch (SQLException e) {
            System.out.print(e);
        }
    }

    public static String dateToString(Date d_date) {
        String temp_date, conv_date = null;
        temp_date = sdf.format(d_date);
        // Required format is like: May 15, 2021
        switch (temp_date.substring(3, 5)) {
            case "01":
                conv_date = "January " + temp_date.substring(0, 2) + ", "
                        + temp_date.substring(6, 10);
                break;
            case "02":
                conv_date = "February " + temp_date.substring(0, 2) + ", "
                        + temp_date.substring(6, 10);
                break;
            case "03":
                conv_date = "March " + temp_date.substring(0, 2) + ", "
                        + temp_date.substring(6, 10);
                break;
            case "04":
                conv_date = "April " + temp_date.substring(0, 2) + ", "
                        + temp_date.substring(6, 10);
                break;
            case "05":
                conv_date = "May " + temp_date.substring(0, 2) + ", "
                        + temp_date.substring(6, 10);
                break;
            case "06":
                conv_date = "June " + temp_date.substring(0, 2) + ", "
                        + temp_date.substring(6, 10);
                break;
            case "07":
                conv_date = "July " + temp_date.substring(0, 2) + ", "
                        + temp_date.substring(6, 10);
                break;
            case "08":
                conv_date = "August " + temp_date.substring(0, 2) + ", "
                        + temp_date.substring(6, 10);
                break;
            case "09":
                conv_date = "September " + temp_date.substring(0, 2) + ", "
                        + temp_date.substring(6, 10);
                break;
            case "10":
                conv_date = "October " + temp_date.substring(0, 2) + ", "
                        + temp_date.substring(6, 10);
                break;
            case "11":
                conv_date = "November " + temp_date.substring(0, 2) + ", "
                        + temp_date.substring(6, 10);
                break;
            case "12":
                conv_date = "December " + temp_date.substring(0, 2) + ", "
                        + temp_date.substring(6, 10);
                break;
        }
        return conv_date;
    }

    public static void initializeConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/shoemanagement";
            String user = "root";
            String password = "";
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Database connection failed!", "Error", JOptionPane.ERROR_MESSAGE);
            System.exit(1); // Exit the application if the connection fails
        }
    }
}

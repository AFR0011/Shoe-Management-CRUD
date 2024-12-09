# Shoe Store Management System

This project is a **Shoe Store Management System** implemented in Java. It uses MySQL for data storage and Java Swing for the graphical user interface (GUI). The system allows for managing customers, inventory, shoes, suppliers, and transactions through a CRUD (Create, Read, Update, Delete) interface.

## Acknowledgements

This project was developed in **March, 2024** as part of a learning journey to implement CRUD operations in a Java application and integrate a MySQL database for persistent storage. It also demonstrates how to create a desktop application using Java Swing.

---

## Features
- **Customer Management**: Add, view, update, and delete customer records.
- **Shoe Management**: Manage shoe details, including stock levels and pricing.
- **Supplier Management**: Maintain information on shoe suppliers.
- **Inventory Management**: Track shoe stock levels and movements.
- **Transaction Management**: Record sales transactions.
- **Graphical User Interface (GUI)**: A clean and intuitive Java Swing interface for easy navigation and management.

---

## Directory Structure

```
shoe-store-management/
├──src/                     # Java source code files
│   ├── Customer.java        # Customer class definition
│   ├── Inventory.java       # Inventory class definition
│   ├── Shoe.java            # Shoe class definition
│   ├── Supplier.java        # Supplier class definition
│   ├── Transaction.java     # Transaction class definition
│   ├── Menu.java            # Main application entry point
│   ├── CustomerManage.java  # Customer management logic
│   ├── InventoryManage.java # Inventory management logic
│   ├── ShoeManage.java      # Shoe management logic
│   ├── SupplierManage.java  # Supplier management logic
│   ├── TransactionManage.java # Transaction management logic
│   ├── CustomerManage.form  # Customer management form (GUI)
│   ├── InventoryManage.form # Inventory management form (GUI)
│   ├── ShoeManage.form      # Shoe management form (GUI)
│   ├── SupplierManage.form  # Supplier management form (GUI)
│   ├── TransactionManage.form # Transaction management form (GUI)
│   ├── Menu.form            # Main menu form (GUI)
│   ├── CustomerPage.form    # Customer management page form
│   ├── ShoePage.form        # Shoe management page form
│   ├── InventoryPage.form   # Inventory management page form
│   ├── SupplierPage.form    # Supplier management page form
│   ├── TransactionPage.form # Transaction management page form
└── |── shoemanagement.sql   # Database initialization script
└── README.md                # Project documentation
```

---

## Getting Started

### Prerequisites
- **JDK (Java Development Kit)**: Ensure you have JDK installed (version 8 or above).
- **MySQL**: A MySQL database should be set up. The provided `create-db.sql` file will create the required tables.
- **IDE**: Use any Java IDE (such as IntelliJ IDEA, Eclipse) to run the application.

### How to Run
1. Clone or download the repository:
    ```
    git clone https://github.com/AFR0011/shoe-store-management.git
    ```
2. Set up the MySQL database:
    - Open MySQL and run the provided `shoemanagement.sql` script to create the necessary database and tables.
3. Open the project in your Java IDE.
4. Compile and run the `Menu.java` file to launch the application.

---

## Usage
This project can be used to:
- Manage customer, shoe, supplier, inventory, and transaction data for a shoe store.
- Learn how to connect Java applications with MySQL databases.
- Understand how to design and implement a CRUD-based desktop application using Java Swing.

---


## Possible Improvements
- Add User Authentication for security.
- Implement advanced search functionality for each class.
- Enhance the UI with more modern JavaFX components.
- Add reporting features, such as generating transaction history or inventory status reports.

--- 

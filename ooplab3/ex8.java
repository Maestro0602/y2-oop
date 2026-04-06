class Category {
    private int categoryId;
    private String categoryName;
    private String description;
    private int totalProducts;                                              
    private String department;
    
    public Category() {}
    
    public Category(int categoryId, String categoryName, String description, int totalProducts, String department) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
        this.totalProducts = totalProducts;
        this.department = department;
    }
    
    public void setValues(int categoryId, String categoryName, String description, int totalProducts, String department) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.description = description;
        this.totalProducts = totalProducts;
        this.department = department;
    }
    
    public void display() {
        System.out.println("Category ID: " + categoryId + ", Name: " + categoryName + ", Dept: " + department);
    }
    
    public String getCategoryName() {
        return categoryName;
    }
}

class Product {
    private int productId;
    private String productName;
    private double price;
    private int stock;
    private Category category;
    
    public Product() {}
    
    public Product(int productId, String productName, double price, int stock, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }
    
    public void setValues(int productId, String productName, double price, int stock, Category category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }
    
    public void display() {
        System.out.println("ID: " + productId + " Name: " + productName + " Price: " + price + " Stock: " + stock + " Category: " + category.getCategoryName());
    }
}

public class ex8 {
    public static void main(String[] args) {
        // Create related class objects (Category)
        Category cat1 = new Category();
        cat1.setValues(1, "Smartphones", "Mobile phones and accessories", 50, "Electronics");
        
        Category cat2 = new Category();
        cat2.setValues(2, "Laptops", "Computers and laptops", 30, "Computing");
        
        // Create Product objects with values assigned
        Product prod1 = new Product();
        prod1.setValues(101, "iPhone 14", 999.99, 15, cat1);
        
        Product prod2 = new Product();
        prod2.setValues(102, "Samsung S23", 799.99, 20, cat1);
        
        Product prod3 = new Product();
        prod3.setValues(201, "MacBook Pro", 2499.99, 8, cat2);
        
        // Create array and put all objects to that array
        Product[] products = new Product[3];
        products[0] = prod1;
        products[1] = prod2;
        products[2] = prod3;
        
        // Create a loop to display all objects in that array
        System.out.println("===== Phone Shop Inventory =====");
        for (Product prod : products) {
            prod.display();
        }
    }
}

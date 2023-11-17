public class Item {

    private int productId;
    private String name;

    public ProductCategory category;

    private double price;
    private String description;

    public Item(int productId, String name, double price, ProductCategory category, String description) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Item ID: " + productId + ", Name: " + name + ", Price: $" + price + ", Description: " + description;
    }

}

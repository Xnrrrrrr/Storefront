public class Item {

    private int productId;
    private String name;

    public ProductCategory category;

    private double price;
    private String description;

    /**
     *
     * @param productId
     * @param name
     * @param price
     * @param category
     * @param description
     */
    public Item(int productId, String name, double price, ProductCategory category, String description) {           // adding
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
        this.description = description;
    }

    /**
     *
     * @return
     */
    public int getProductId() {
        return productId;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public ProductCategory getCategory() {
        return category;
    }

    /**
     *
     * @return
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Item ID: " + productId + ", Name: " + name + ", Price: $" + price + ", Description: " + description;
    }

}

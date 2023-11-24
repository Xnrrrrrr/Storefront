import java.util.Date;
import java.util.List;
import org.bson.Document;
import java.util.ArrayList;


public class Invoice {
    private int orderNumber;
    private Date date;
    private String customerName;
    private String customerAddress;
    private List<Item> products;  // Assuming have a list of items in your invoice
    private double subtotal;
    private double shippingCost;
    private double taxRate;
    private double total;
    private String paymentMethod = "cash";
    private String transactionId;
    Main a = new Main();
    double amtPaid = a.amountPaid;
    Main b = new Main();
    double iTotal = b.total;
    private double newTotal = iTotal + Main.shipping;
    private double change = amtPaid - newTotal;

    private Customer customer;


    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // Constructors, getters, and setter



    private double calculateSubtotal() {
        double subtotal = 0.0;
        for (Item product : products) {
            subtotal += product.getPrice();
        }
        return subtotal;
    }

    public void setCustomerDetails(Customer customer) {
        if (customer != null) {
            this.customerName = customer.getcustomerName();
            this.customerAddress = customer.getshippingAddress().toString();
        }
    }

    public Document toDocument() {
        Document document = new Document();
        document.append("orderNumber", this.orderNumber)
                .append("date", this.date)
                .append("customerName", this.customerName)
                .append("customerAddress", this.customerAddress)
                .append("subtotal", this.subtotal)
                .append("customerAddress", this.customer != null ? this.customer.getshippingAddress().toDocument() : null)
                .append("shippingCost", this.shippingCost)
                .append("taxRate", this.taxRate)
                .append("total", this.total)
                .append("paymentMethod", this.paymentMethod)
                .append("transactionId", this.transactionId)
                .append("amountPaid", this.amtPaid);

        return document;
    }



    private double calculateShippingCost() {
        // Hardcoded shipping cost
        return 10.0;
    }

    private List<Document> productsToDocumentList(List<Item> products) {
        List<Document> documentList = new ArrayList<>();

        for (Item product : products) {
            Document productDocument = new Document()
                    .append("productId", product.getProductId())
                    .append("name", product.getName())
                    .append("price", product.getPrice())
                    .append("category", product.getCategory().toString())
                    .append("description", product.getDescription());

            documentList.add(productDocument);
        }

        return documentList;
    }

    private double calculateTotal() {
        double tax = subtotal * taxRate;
        return subtotal + shippingCost + tax;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public List<Item> getProducts() {
        return products;
    }

    public void setProducts(List<Item> products) {
        System.out.println("Set products: " + products);        //debug
        this.products = products;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public double getTotal() {
        return total;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmountPaid() {
        return amtPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amtPaid = amountPaid;
    }

    // Other methods

    public void calculateTotals() {
        // Calculate subtotal, shipping cost, tax, and total
        subtotal = calculateSubtotal();
        shippingCost = calculateShippingCost();
        iTotal = calculateTotal();
    }

    public void printInvoice() {
        // Print the invoice details

        System.out.println("-----------------------------------------------------------");
        System.out.println("|                        INVOICE                          |");
        System.out.println("| Order Number: " + orderNumber);
        System.out.println("| Date: " + date);
        System.out.println("| Customer: " + (customerName != null ? customerName : "null"));
        System.out.println("| Address: " + (customerAddress != null ? customerAddress : "null"));
        System.out.println("-----------------------------------------------------------");

        // Print product details
        System.out.println("|                   PURCHASED ITEMS                       |");
        // Debug print statement
        System.out.println("Products in invoice: " + products);                                     // debug

        for (Item product : products) {
            System.out.println("| " + product.getName() + " - $" + product.getPrice());
        }

        System.out.println("-----------------------------------------------------------");
        System.out.println("| Subtotal: $" + subtotal);
        System.out.println("| Shipping Cost: $" + shippingCost);
        System.out.println("| Tax: $" + (subtotal * taxRate));
        System.out.println("| Total: $" + newTotal);
        System.out.println("| Payment Method: " + paymentMethod);
        System.out.println("| Transaction ID: " + transactionId);
        System.out.println("| Amount Paid: $" + amtPaid);
        System.out.println("| Change: $" + Math.round(change * 100d) / 100d);
        System.out.println("-----------------------------------------------------------");
    }
}

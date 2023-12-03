import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import org.bson.Document;
import java.util.ArrayList;


public class Invoice {
    DecimalFormat df = new DecimalFormat("#.##");
    private long orderNumber;
    private Date date;
    private String customerName;
    private String customerAddress;
    private List<Item> products;  // Assuming have a list of items in your invoice
    private double subtotal;
    private double shippingCost;
    private double taxRate;
    private String taxString = "6%";
    private double total;
    private String paymentMethod = "Cash";
    private String transactionId;
    Main a = new Main();
    double amtPaid = a.amountPaid;
    Main b = new Main();
    double iTotal = b.total;
    private double newTotal = (iTotal + Main.shipping) * 1.06;
    private double nNewTotal = Double.parseDouble(df.format(newTotal));
    private double change = amtPaid - newTotal;

    private Customer customer;

    /**
     *
     * @param customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // Constructors, getters, and setter


    /**
     *
     * @return
     */
    private double calculateSubtotal() {
        double subtotal = 0.0;
        for (Item product : products) {
            subtotal += product.getPrice();
        }
        return subtotal;
    }

    /**
     *
     * @param customer
     */
    public void setCustomerDetails(Customer customer) {
        if (customer != null) {
            this.customerName = customer.getcustomerName();
            this.customerAddress = customer.getshippingAddress().toString();
        }
    }

    /**
     *
     * @return
     */
    public Document toDocument() {
        Document document = new Document();
        document.append("orderNumber", this.orderNumber)
                .append("date", this.date)
                .append("customerName", this.customerName)
                .append("customerAddress", (customerAddress != null ? customerAddress : "null"))
                .append("subtotal", this.subtotal)
                //.append("customerAddress", this.customer != null ? this.customer.getshippingAddress().toDocument() : null)
                .append("shippingCost", this.shippingCost)
                .append("taxRate", this.taxString)
                .append("total", this.nNewTotal)
                .append("paymentMethod", this.paymentMethod)
                .append("amountPaid", this.amtPaid);

        return document;
    }


    /**
     *
     * @return
     */
    private double calculateShippingCost() {
        // Hardcoded shipping cost
        return 10.0;
    }

    /**
     *
     * @param products
     * @return
     */
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

    /**
     *
     * @return
     */
    private double calculateTotal() {
        double tax = subtotal * taxRate;
        return subtotal + shippingCost + tax;
    }

    /**
     *
     * @param orderNumber
     */
    public void setOrderNumber(long orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     *
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *
     * @return
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     *
     * @param customerName
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     *
     * @return
     */
    public String getCustomerAddress() {
        return customerAddress;
    }

    /**
     *
     * @param customerAddress
     * @return
     */
    public Object setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
        return null;
    }

    /**
     *
     * @return
     */
    public List<Item> getProducts() {
        return products;
    }

    /**
     *
     * @param products
     */
    public void setProducts(List<Item> products) {
        //System.out.println("Set products: " + products);        //debug
        this.products = products;
    }

    /**
     *
     * @return
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     *
     * @return
     */
    public double getShippingCost() {
        return shippingCost;
    }

    /**
     *
     * @return
     */
    public double getTaxRate() {
        return taxRate;
    }

    /**
     *
     * @param taxRate
     */
    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    /**
     *
     * @return
     */
    public double getTotal() {
        return total;
    }

    /**
     *
     * @return
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     *
     * @param paymentMethod
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     *
     * @return
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     *
     * @param transactionId
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     *
     * @return
     */
    public double getAmountPaid() {
        return amtPaid;
    }

    /**
     *
     * @param amountPaid
     */
    public void setAmountPaid(double amountPaid) {
        this.amtPaid = amountPaid;
    }

    // Other methods

    /**
     *
     */
    public void calculateTotals() {
        // Calculate subtotal, shipping cost, tax, and total
        subtotal = calculateSubtotal();
        shippingCost = calculateShippingCost();
        iTotal = calculateTotal();
    }

    /**
     *
     */
    public void printInvoice() {
        // Print the invoice details

        double tax = ((subtotal + shippingCost) * 0.06);
        double total = ((subtotal + shippingCost) * 1.06);
        double nTax = Double.parseDouble(df.format(tax));
        double nTotal = Double.parseDouble(df.format(total));
        double nChange = amtPaid - nTotal;
        double newChange = Double.parseDouble(df.format(nChange));

        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("|                        INVOICE                                                              |");
        System.out.println("| Order Number: " + orderNumber);
        System.out.println("| Date: " + date);
        System.out.println("| Customer: " + (customerName != null ? customerName : "null"                                  ));
        System.out.println("| Address: " + (customerAddress != null ? customerAddress : "null"                             ));
        System.out.println("-----------------------------------------------------------------------------------------------");

        // Print product details
        System.out.println("|                   PURCHASED ITEMS                                                           |");
        // Debug print statement
        //System.out.println("Products in invoice: " + products);                                     // debug

        for (Item product : products) {
            System.out.println("| " + product.getName() + " - $" + product.getPrice());
        }

        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("| Subtotal: $" + subtotal);
        System.out.println("| Shipping Cost: $" + shippingCost);
        System.out.println("| Tax: $" + nTax);
        System.out.println("| Total: $" + nTotal);
        System.out.println("| Payment Method: " + paymentMethod);
        System.out.println("| Amount Paid: $" + amtPaid);
        System.out.println("| Change: $" + newChange);
        System.out.println("-----------------------------------------------------------------------------------------------");
    }
}
import org.bson.Document;

public class Customer {
    private String customerName;
    private String customerEmail;
    private Address shippingAddress;
    private Address billingAddress;

    // Constructors, getters, setters, and toString method remain unchanged...

    public Document toDocument() {
        Document document = new Document();
        document.append("customerName", this.customerName)
                .append("customerEmail", this.customerEmail)
                .append("shippingAddress", this.shippingAddress.toDocument())  // Assuming Address has a toDocument method
                .append("billingAddress", this.billingAddress.toDocument());  // Assuming Address has a toDocument method

        return document;
    }
}

import org.bson.Document;
import java.util.List;

public class Customer {
    private String customerName;
    private String customerEmail;
    private Address shippingAddress;
    private Address billingAddress;


    // Constructors, getters, setters, and toString methods remain unchanged...

    // New constructor for creating a customer with provided information

    /**
     *
     * @param customerName
     * @param customerEmail
     * @param shippingAddress
     * @param billingAddress
     */
    public Customer(String customerName, String customerEmail, Address shippingAddress, Address billingAddress) {
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
    }

    /**
     *
     * @return
     */
    public String getcustomerName() {
        return this.customerName;
    }

    /**
     *
     * @return
     */
    public Address getshippingAddress() {
        return this.shippingAddress;
    }

    /**
     *
     * @return
     */

    public Document toDocument() {
        Document document = new Document();
        document.append("customerName", this.customerName)
                .append("email", this.customerEmail)
                .append("shippingAddress", this.shippingAddress.toDocument())
                .append("billingAddress", this.billingAddress.toDocument());

        return document;
    }
}

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.bson.Document;


public class CustomerTest {

    @Test
    public void testToDocument() {
        // Create test addresses
        Address shippingAddress = new Address("123 Main St", "City", "State", "12345", "shipping@example.com");
        Address billingAddress = new Address("456 Oak St", "City", "State", "67890", "billing@example.com");

        // Create a test customer
        Customer customer = new Customer("John Doe", "john.doe@example.com", shippingAddress, billingAddress);

        // Create the expected Document
        Document expectedDocument = new Document()
                .append("customerName", "John Doe")
                .append("email", "john.doe@example.com")
                .append("shippingAddress", shippingAddress.toDocument())
                .append("billingAddress", billingAddress.toDocument());

        // Test the toDocument method
        assertEquals(expectedDocument, customer.toDocument());
    }

    // You can add more test cases for other methods or scenarios
}

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvoiceTest {

    @Test
    public void testInvoiceCalculation() {
        // Create some sample items for the invoice
        Item item1 = new Item(1, "Product 1", 100.0, ProductCategory.PERFORMANCE, "Description 1");

        // Create a sample address
        Address address = new Address("123 Main St", "City", "State", "12345", "customer@example.com");

        // Create a sample customer
        Customer customer = new Customer("John Doe", "john@example.com", address, address);

        // Create an instance of the Invoice
        Invoice invoice = new Invoice();
        invoice.setOrderNumber(123);
        invoice.setDate(new Date());
        invoice.setCustomer(customer);
        invoice.setProducts(List.of(item1));
        invoice.setTaxRate(0.08); // Set your desired tax rate

        // Calculate totals
        invoice.calculateTotals();

        // Assertions
        assertEquals(100.0, invoice.getSubtotal(), 0.01);
        assertEquals(8.0, invoice.getTaxRate() * invoice.getSubtotal(), 0.01);
        assertEquals(10.0, invoice.getShippingCost(), 0.01);
        assertEquals(0.0, invoice.getTotal(), 0.01);
    }

    @Test
    public void testInvoicePrint() {
        // You can create another test for printing if needed
    }
}

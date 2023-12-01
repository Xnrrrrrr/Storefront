import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {

    @Test
    public void testItemToString() {
        // Create an instance of Item
        Item item = new Item(1, "Test Product", 50.0, ProductCategory.PERFORMANCE, "Test Description");

        // Define the expected result
        String expectedToString = "Item ID: 1, Name: Test Product, Price: $50.0, Description: Test Description";

        // Perform the assertion
        assertEquals(expectedToString, item.toString());
    }

    @Test
    public void testItemGetters() {
        // Create an instance of Item
        Item item = new Item(2, "Another Product", 75.0, ProductCategory.LUXURY, "Another Description");

        // Perform the assertions for getters
        assertEquals(2, item.getProductId());
        assertEquals("Another Product", item.getName());
        assertEquals(ProductCategory.LUXURY, item.getCategory());
        assertEquals(75.0, item.getPrice(), 0.01); // Allowing for a small error in double comparison
        assertEquals("Another Description", item.getDescription());
    }

    // Add more test cases as needed
}

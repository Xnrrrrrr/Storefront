import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.bson.Document;


public class AddressTest {

    @Test
    public void testToString() {
        // Arrange
        Address address = new Address("123 Main St", "Cityville", "CA", "12345", "test@example.com");

        // Act
        String result = address.toString();

        // Assert
        assertEquals("123 Main St, Cityville, CA 12345", result);
    }

    @Test
    public void testToDocument() {
        // Arrange
        Address address = new Address("456 Oak St", "Townsville", "NY", "67890", "another@test.com");

        // Act
        Document document = address.toDocument();

        // Assert
        assertEquals("456 Oak St", document.get("street"));
        assertEquals("Townsville", document.get("city"));
        assertEquals("NY", document.get("state"));
        assertEquals("67890", document.get("zipCode"));
        assertEquals("another@test.com", document.get("email"));
    }
}

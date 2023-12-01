import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {

    @Test
    public void testGetItems() {
        Inventory inventory = new Inventory();
        Item[][][] items = inventory.getItems();

        // Check that the items array is not null
        assertNotNull(items);

        // Check the dimensions of the items array
        assertEquals(6, items.length);
        assertEquals(6, items[0].length);
        assertEquals(6, items[0][0].length);
    }

    @Test
    public void testGetItemById() {
        Inventory inventory = new Inventory();

        // Test with an existing item ID
        Item existingItem = inventory.getItemById(1);
        assertNotNull(existingItem);
        assertEquals(1, existingItem.getProductId());

        // Test with a non-existing item ID
        Item nonExistingItem = inventory.getItemById(100);
        assertNull(nonExistingItem);
    }

    // Add more test cases as needed

}

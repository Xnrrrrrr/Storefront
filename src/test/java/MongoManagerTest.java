import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MongoManagerTest {

    private static MongoManager mongoManager;

    @BeforeAll
    public static void setUp() {
        // Provide your MongoDB connection details
        String connectionString = "mongodb+srv://ganggang89001:oTyY2qgRa53B3Mm2@storefront.60uhwaz.mongodb.net/";
        String databaseName = "Storefront";
        String collectionName = "Products";

        // Create a MongoManager instance
        mongoManager = new MongoManager(connectionString, databaseName, collectionName);
    }

    @Test
    public void testRetrieveAllItems() {
        // Retrieve all items from the collection
        List<Item> allItems = mongoManager.getAllItems();

        // Assert that the number of retrieved items is as expected
        assertEquals(37, allItems.size());  // Update this based on the number of items you have inserted
    }

    @Test
    public void testGetSelectedProducts() {
        // Retrieve a list of selected products by providing a list of productIds
        List<Integer> productIds = Arrays.asList(1, 2, 3);
        List<Item> selectedProducts = mongoManager.getSelectedProducts(productIds);

        // Assert that the number of selected products is as expected
        assertEquals(3, selectedProducts.size());
    }

    // Add more test cases as needed

    @AfterAll
    public static void tearDown() {
        // Close the MongoDB client
        mongoManager.close();
    }
}

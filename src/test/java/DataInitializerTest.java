import org.junit.jupiter.api.Test;

public class DataInitializerTest {

    @Test
    public void testInitializeData() {
        // Provide your MongoDB connection details
        String connectionString = "mongodb+srv://ganggang89001:@storefront.60uhwaz.mongodb.net/";
        String databaseName = "Storefront";
        String collectionName = "Products";

        // Create a MongoManager instance
        MongoManager mongoManager = new MongoManager(connectionString, databaseName, collectionName);

        // Initialize and insert sample data
        DataInitializer.initializeData(mongoManager);

        // Close the MongoDB client
        mongoManager.close();
    }

    // Add more test cases as needed
}

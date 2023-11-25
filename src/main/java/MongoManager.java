import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

// Class responsible for managing MongoDB operations for the Item class
public class MongoManager {

    // MongoDB client, database, and collection instances
    private com.mongodb.client.MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    // Constructor to initialize the MongoDB client, connect to the specified database, and get the collection

    public MongoManager(String connectionString, String databaseName, String collectionName) {
        // Create a connection string with the provided MongoDB connection URI
        ConnectionString connString = new ConnectionString(connectionString);

        // Build MongoClientSettings using the connection string
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connString)
                .build();

        // Create the MongoDB client using the settings
        mongoClient = MongoClients.create(settings);

        // Get the specified database
        database = mongoClient.getDatabase(databaseName);

        // Get the specified collection within the database
        collection = database.getCollection(collectionName);
    }

    // Insert an Item into the MongoDB collection
    public void insertItem(Item item) {
        // Convert Item to MongoDB Document
        Document document = itemToDocument(item);

        // Insert the document into the collection
        collection.insertOne(document);
    }

    // Retrieve an Item by its productId from the MongoDB collection
    public Item getItemById(int productId) {
        // Create a query document to find the Item by productId
        Document query = new Document("productId", productId);

        // Execute the query and get the result
        FindIterable<Document> result = collection.find(query);

        // Check if the result is not empty and convert the Document to an Item
        if (result.first() != null) {
            return documentToItem(result.first());
        } else {
            return null; // Item not found
        }
    }

    // Retrieve all Items from the MongoDB collection
    public List<Item> getAllItems() {
        // List to store retrieved Items
        List<Item> items = new ArrayList<>();

        // Execute a query to retrieve all documents in the collection
        FindIterable<Document> result = collection.find();

        // Convert each document to an Item and add to the list
        for (Document document : result) {
            items.add(documentToItem(document));
        }

        // Return the list of Items
        return items;
    }

    public List<Item> getSelectedProducts(List<Integer> productIds) {
        List<Item> selectedProducts = new ArrayList<>();

        System.out.println("Product IDs: " + productIds);       // debug statement

        // Create a query document to find Items by productIds
        Document query = new Document("productId", new Document("$in", productIds));

        // Execute the query and get the result
        FindIterable<Document> result = collection.find(query);

        System.out.println("Query: " + query);      // debugging statement

        // Convert each document to an Item and add to the list
        for (Document document : result) {
            selectedProducts.add(documentToItem(document));

            System.out.println("Selected Products: " + selectedProducts);       // debugging statement
        }

        return selectedProducts;
    }

    // Update an existing Item in the MongoDB collection
    public void updateItem(Item item) {
        // Get the productId of the Item to be updated
        int productId = item.getProductId();

        // Create a query document to find the Item by productId
        Document query = new Document("productId", productId);

        // Create an update document with the modified values
        Document update = new Document("$set", itemToDocument(item));

        // Execute the update operation
        collection.updateOne(query, update);
    }

    // Delete an Item by its productId from the MongoDB collection
    public void deleteItem(int productId) {
        // Create a query document to find the Item by productId
        Document query = new Document("productId", productId);

        // Execute the delete operation
        collection.deleteOne(query);
    }

    // Helper method to convert an Item to a MongoDB Document
    private Document itemToDocument(Item item) {
        return new Document()
                .append("productId", item.getProductId())
                .append("name", item.getName())
                .append("price", item.getPrice())
                .append("category", item.getCategory().toString())
                .append("description", item.getDescription());
    }

    // Helper method to convert a MongoDB Document to an Item
    private Item documentToItem(Document document) {
        int productId = document.getInteger("productId");
        String name = document.getString("name");
        double price = document.getDouble("price");
        ProductCategory category = ProductCategory.valueOf(document.getString("category"));
        String description = document.getString("description");

        return new Item(productId, name, price, category, description);
    }

    // Insert an Invoice into the MongoDB collection
    public void insertInvoice(Invoice invoice) {
        // Convert Invoice to MongoDB Document
        Document document = invoiceToDocument(invoice);

        // Insert the document into the collection
        collection.insertOne(document);
    }

    // Helper method to convert an Invoice to a MongoDB Document
    private Document invoiceToDocument(Invoice invoice) {
        return invoice.toDocument();
    }


    // Method to close the MongoDB client when done
    public void close() {
        mongoClient.close();
    }
}



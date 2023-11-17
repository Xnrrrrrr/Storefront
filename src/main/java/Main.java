import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import com.mongodb.client.model.Filters;
import java.util.Date;
import java.util.List;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.ArrayList;


public class Main {

    private static String email;  // Add this line

    private static final String DATABASE_NAME = "Storefront";
    private static final String CUSTOMERS_COLLECTION_NAME = "Customers";

    private static final String MONGO_URI = "mongodb+srv://ganggang89001:@storefront.uzrfcey.mongodb.net/";

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println("Welcome to TRAVELGREEN Storefront!");

        while (true) {
            System.out.println("1. Sign In");
            System.out.println("2. Register");
            System.out.println("0. Exit");

            System.out.print("Please choose an option: ");
            int signInOrRegister = scanner.nextInt();

            if (signInOrRegister == 0) {
                break;
            } else if (signInOrRegister == 1) {
                if (signInUser(scanner)) {
                    showProductCategories(inventory, scanner, df);
                }
            } else if (signInOrRegister == 2) {
                signUpNewCustomer(scanner);
                System.out.println("Registration successful. You can now sign in.");
            } else {
                System.out.println("Invalid option. Please choose a valid option.");
            }
        }

        System.out.println("Goodbye!");
    }

    private static boolean signInUser(Scanner scanner) {
        System.out.println("Enter your sign-in information:");

        System.out.print("Email: ");
        String email = scanner.next();

        System.out.print("Password: ");  // You may need to handle password securely (e.g., use char[] and consider hashing)
        String password = scanner.next();

        try (MongoClient mongoClient = MongoClients.create(MONGO_URI)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> customersCollection = database.getCollection(CUSTOMERS_COLLECTION_NAME);

            Document query = new Document("email", email).append("password", password);
            Document user = customersCollection.find(query).first();

            if (user != null) {
                System.out.println("Sign-in successful. Welcome back!");
                return true;
            } else {
                System.out.println("Invalid email or password. Please try again.");
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error during sign-in: " + e.getMessage());
            return false;
        }
    }


    private static Customer signUpNewCustomer(Scanner scanner) {
        System.out.println("Enter your sign-up information:");

        System.out.print("Customer Name: ");
        String customerName = scanner.next();

        System.out.print("Email: ");
        String email = scanner.next();

        System.out.print("Password: ");
        String password = scanner.next();  // You may want to hash the password for security

        System.out.println("Enter your shipping address:");
        Address shippingAddress = getAddressInformation(scanner, "Shipping", email);

        System.out.println("Enter your billing address:");
        Address billingAddress = getAddressInformation(scanner, "Billing", email);

        // Create a new customer
        Customer newCustomer = new Customer(customerName, email, shippingAddress, billingAddress);
        String customerNameValue = newCustomer.getcustomerName();
        Address shippingAddressValue = newCustomer.getshippingAddress();

        try (MongoClient mongoClient = MongoClients.create(MONGO_URI)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> customersCollection = database.getCollection(CUSTOMERS_COLLECTION_NAME);

            // Check if the email already exists in the database
            if (customersCollection.find(Filters.eq("email", email)).first() != null) {
                System.out.println("Email already exists. Please use a different email or sign in.");
                return null;
            }

            // Create a new customer document
            Document newCustomerDocument = new Document("customerName", customerNameValue)
                    .append("email", email)
                    .append("shippingAddress", shippingAddressValue.toDocument())
                    .append("password", password)  // You may want to hash the password for security
                    .append("billingAddress", billingAddress.toDocument());

            // Insert the new customer document into the collection
            customersCollection.insertOne(newCustomerDocument);

            System.out.println("Sign-up successful. Welcome, " + customerNameValue + "!");
            return newCustomer;
        } catch (Exception e) {
            System.err.println("Error during sign-up: " + e.getMessage());
            return null;
        }
    }



    private static Address getAddressInformation(Scanner scanner, String addressType, String email) {
        System.out.println(addressType + " Address:");

        System.out.print("Street: ");
        String street = scanner.next();

        System.out.print("City: ");
        String city = scanner.next();

        System.out.print("State: ");
        String state = scanner.next();

        System.out.print("Zip Code: ");
        String zipCode = scanner.next();

        return new Address(street, city, state, zipCode, email);
    }


    private static void showProductCategories(Inventory inventory, Scanner scanner, DecimalFormat df) {
        // Your existing product category display logic
        // ...

        double total = 0.00;
        Item[][][] items = inventory.getItems();

        List<Item> selectedProducts = new ArrayList<>();

        System.out.println("--------------------------------------");
        System.out.println("|                                    |");
        System.out.println("| Welcome to TRAVELGREEN Storefront! |");
        System.out.println("|                                    |");
        System.out.println("|     TRAVELGREEN EcoMobility Hub    |");
        System.out.println("|     123 Progressive Parkway        |");
        System.out.println("|        Libertyville, CA            |");
        System.out.println("|            98765                   |");
        System.out.println("--------------------------------------");

        System.out.println("--------------------------------------");
        System.out.println("|                                    |");
        System.out.println("|       STORE DESCRIPTION!           |");
        System.out.println("|       Rated D by the BBB           |");
        System.out.println("|       We accept cash only!         |");
        System.out.println("|       No refunds, ever!            |");
        System.out.println("--------------------------------------");

        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("|                                                                             |");
        System.out.println("|               READ OUR PERSONAL MISSION STATEMENT                           |");
        System.out.println("|     At TRAVELGREEN, we are dedicated to promoting a lifestyle               |");
        System.out.println("|     that values environmental responsibility, personal freedom and          |");
        System.out.println("|     community engagement, through our sweet rides!                          |");
        System.out.println("-------------------------------------------------------------------------------");

        while (true) {                                          // inner loop for category selection
            // Display available categories
            System.out.println("-----------------------------");
            System.out.println("|    Available Categories    |");
            System.out.println("-----------------------------");

            System.out.println("1. Performance E-scooters");
            System.out.println("-------------");
            System.out.println("2. Off-road E-scooters");
            System.out.println("-------------");
            System.out.println("3. Urban commuter E-scooters");
            System.out.println("-------------");
            System.out.println("4. Luxury E-scooters");
            System.out.println("-------------");
            System.out.println("5. Cargo E-scooters");
            System.out.println("-------------");
            System.out.println("6. Long-range E-scooters");
            System.out.println("-------------");
            System.out.println("0. Exit");

            // Prompt the user to choose a category
            System.out.print("Please choose from one of our E-scooter categories (or press 0 to exit): ");
            int selectedCategory = scanner.nextInt();

            if (selectedCategory == 0) {
                break; // Exit the loop if the user chooses 0
            } else if (selectedCategory < 0 || selectedCategory > 6) {
                System.out.println("Invalid category number. Please enter a valid category number.");
                continue;
            }

            // Display items from the selected category
            // iterate through the three layers of the array
            System.out.println("Items in the selected category:");
            for (int x = 0; x < 6; x++) {
                for (int y = 0; y < 6; y++) {
                    for (int z = 0; z < 6; z++) {
                        Item item = items[x][y][z];     // Get the item at the specified coords
                        if (item != null && item.getCategory().ordinal() + 1 == selectedCategory) {     // Check if the item is not null and belongs to selected category, ordinality adds 1 to the enum bcuz starts at 0
                            System.out.println("Item ID: " + item.getProductId());
                            System.out.println("Name: " + item.getName());
                            System.out.println("Price: $" + item.getPrice());
                            System.out.println("Features: " + item.getDescription());
                            System.out.println();
                        }
                    }
                }
            }

            // Allow the user to select items from the chosen category
            while (true) {
                System.out.print("Enter item number (or press 0 to go back to category selection): ");
                int selectedItem = scanner.nextInt();

                if (selectedItem == 0) {
                    break; // Go back to category selection
                }

                Item selectedProduct = inventory.getItemById(selectedItem);
                if (selectedProduct != null && selectedProduct.getCategory().ordinal() == selectedCategory - 1) {
                    total += selectedProduct.getPrice();
                    System.out.println("Added " + selectedProduct.getName() + " to your cart.");
                } else {
                    System.out.println("Item not found in the selected category. Please enter a valid item number.");
                }
            }
        }

        // Prompt the user to enter the total amount paid
        System.out.print("Please Enter the total amount paid: ");
        double amountPaid = scanner.nextDouble();

        // Calculate the change
        double change = amountPaid - total;

        // Display the change to the user with two decimal places
        System.out.println("Change: $" + df.format(change));

        // Provide change in denominations
        provideChangeInDenominations(change);

        // Thank the user
        System.out.println("-----------------------------------------------------------");
        System.out.println("|    Thank you for using our Eco-friendly Storefront!     |");
        System.out.println("|        TRAVELGREEN appreciates your business!           |");
        System.out.println("|            The environment does too!                    |");
        System.out.println("|                                                         |");
        System.out.println("|              ENJOY YOUR NEW ESCOOTER                    |");
        System.out.println("-----------------------------------------------------------");
    }

    private static void provideChangeInDenominations(double change) {
        // Convert change to cents
        int changeInCents = (int) (change * 100);

        // Calculate and display change in denominations
        int dollars = changeInCents / 100;
        changeInCents %= 100;
        int quarters = changeInCents / 25;
        changeInCents %= 25;
        int dimes = changeInCents / 10;
        changeInCents %= 10;
        int nickels = changeInCents / 5;
        int pennies = changeInCents % 5;

        System.out.println("Your change in denominations:");
        System.out.println("Dollars: " + dollars);
        System.out.println("Quarters: " + quarters);
        System.out.println("Dimes: " + dimes);
        System.out.println("Nickels: " + nickels);
        System.out.println("Pennies: " + pennies);

        double total = 0.00;

        // Corrected method invocation
        List<Item> selectedProducts = new ArrayList<>();
        generateAndDisplayInvoice(email, selectedProducts, total);
    }

    // Corrected method signature
    private static void generateAndDisplayInvoice(String customerEmail, List<Item> selectedProducts, double amountPaid) {
        // Generate an invoice object
        Invoice invoice = new Invoice();
        invoice.setOrderNumber(generateOrderNumber());
        invoice.setDate(new Date());

        // Fetch customer details from the database based on email
        Customer customer = fetchCustomerDetails(customerEmail);

        // Check if customer details were successfully fetched
        if (customer != null) {
            // Set customer details using the setCustomerDetails method
            invoice.setCustomerDetails(customer);

            // Add selected products to the invoice
            invoice.setProducts(selectedProducts);

            // Calculate totals
            invoice.calculateTotals();

            // Display the invoice
            invoice.printInvoice();
        } else {
            System.out.println("Failed to fetch customer details. Unable to generate the invoice.");
        }
    }

    // Method to fetch customer details from the database based on email
    private static Customer fetchCustomerDetails(String customerEmail) {
        try (MongoClient mongoClient = MongoClients.create(MONGO_URI)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> customersCollection = database.getCollection(CUSTOMERS_COLLECTION_NAME);

            Document query = new Document("email", customerEmail);
            Document customerDoc = customersCollection.find(query).first();

            if (customerDoc != null) {
                // Parse the Document to create a Customer object
                String customerName = customerDoc.getString("customerName");
                String email = customerDoc.getString("email");
                Address shippingAddress = parseAddress((Document) customerDoc.get("shippingAddress"));
                Address billingAddress = parseAddress((Document) customerDoc.get("billingAddress"));

                return new Customer(customerName, email, shippingAddress, billingAddress);
            } else {
                return null;
            }
        } catch (Exception e) {
            System.err.println("Error fetching customer details: " + e.getMessage());
            return null;
        }
    }

    // Helper method to parse an Address Document
    private static Address parseAddress(Document addressDoc) {
        String street = addressDoc.getString("street");
        String city = addressDoc.getString("city");
        String state = addressDoc.getString("state");
        String zipCode = addressDoc.getString("zipCode");
        String email = addressDoc.getString("email");

        return new Address(street, city, state, zipCode, email);
    }

    private static int generateOrderNumber() {
        return 0;
    }

}

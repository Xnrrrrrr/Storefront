import com.mongodb.client.MongoClients;           // MongoDB client for establishing a connection to a MongoDB server.
import com.mongodb.client.MongoClient;            // MongoDB client interface for working with a MongoDB server.
import com.mongodb.client.MongoCollection;        // MongoDB collection interface for interacting with a collection in the database.
import com.mongodb.client.MongoDatabase;          // MongoDB database interface for working with a MongoDB database.
import org.bson.Document;                         // MongoDB Document class, representing BSON documents.
import com.mongodb.client.model.Filters;          // MongoDB Filters for building query filters.
import java.util.Date;                            // Date class for handling date and time information.
import java.text.DecimalFormat;                   // DecimalFormat class for formatting decimal numbers.
import java.util.Scanner;                         // Scanner class for reading user input from the console.
import java.util.List;                            // List interface for working with lists.
import java.util.ArrayList;                       // ArrayList class, an implementation of the List interface.
import java.util.concurrent.atomic.AtomicInteger;  // AtomicInteger class, providing an atomic integer.
import java.io.BufferedReader;                    // BufferedReader class for efficient reading of characters from the console.
import java.io.IOException;                       // IOException class for handling input/output exceptions.
import java.io.InputStreamReader;                  // InputStreamReader class for reading input streams efficiently.
import java.util.concurrent.atomic.AtomicLong;


public class Main {

    public static double amountPaid;

    public static double total;
    public static final double shipping = 10.00;

    private static String email;                                             //class level variable


    private static List<Item> selectedProducts = new ArrayList<>();         //class level variable intializing a blank list

    private static final String DATABASE_NAME = "Storefront";
    private static final String CUSTOMERS_COLLECTION_NAME = "Customers";       // access t the St

    private static final String MONGO_URI = "mongodb+srv://ganggang89001:@storefront.60uhwaz.mongodb.net/";

    public static void main(String[] args) throws IOException {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String BLUE = "\033[0;34m";
        final String RESET = "\033[0m";

        System.out.println(BLUE + " _____                                                                                 _____ ");
        System.out.println("( ___ )                                                                               ( ___ )");
        System.out.println(" |   |~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|   | ");
        System.out.println(" |   |                                                                                 |   | ");
        System.out.println(" |   |                                                                                 |   | ");
        System.out.println(" |   |                                                                                 |   | ");
        System.out.println(" |   |      __        _______ _     ____ ___  __  __ _____   _____ ___                 |   | ");
        System.out.println(" |   |      \\ \\      / / ____| |   / ___/ _ \\|  \\/  | ____| |_   _/ _ \\                |   | ");
        System.out.println(" |   |       \\ \\ /\\ / /|  _| | |  | |  | | | | |\\/| |  _|     | || | | |               |   | ");
        System.out.println(" |   |        \\ V  V / | |___| |__| |__| |_| | |  | | |___    | || |_| |               |   | ");
        System.out.println(" |   |         \\_/\\_/  |_____|_____/\\____\\___/|_|  |_|_____|   |_| \\___/               |   | ");
        System.out.println(" |   |       _____ ____      ___     _______ _     ____ ____  _____ _____ _   _        |   | ");
        System.out.println(" |   |      |_   _|  _ \\    / \\ \\   / / ____| |   / ___|  _ \\| ____| ____| \\ | |       |   | ");
        System.out.println(" |   |        | | | |_) |  / _ \\ \\ / /|  _| | |  | |  _| |_) |  _| |  _| |  \\| |       |   | ");
        System.out.println(" |   |        | | |  _ <  / ___ \\ V / | |___| |__| |_| |  _ <| |___| |___| |\\  |       |   | ");
        System.out.println(" |   |        |_| |_| \\_\\/_/   \\_\\_/  |_____|_____|\\____|_| \\_\\_____|_____|_| \\_|      |   | ");
        System.out.println(" |   |                                                                                 |   | ");
        System.out.println(" |   |                                                                                 |   | ");
        System.out.println(" |   |                                                                                 |   | ");
        System.out.println(" |___|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|___| ");
        System.out.println("(_____)                                                                               (_____)" + RESET);


        while (true) {
            final String GREEN = "\033[92m";
            System.out.println(GREEN + "╔══════════════════════════════════════════════════════════════════╗");
            System.out.println("║    ____ ___ ____ _   _   ___ _   _   __  __ _____ _   _ _   _    ║");
            System.out.println("║   / ___|_ _/ ___| \\ | | |_ _| \\ | | |  \\/  | ____| \\ | | | | |   ║");
            System.out.println("║   \\___ \\| | |  _|  \\| |  | ||  \\| | | |\\/| |  _| |  \\| | | | |   ║");
            System.out.println("║    ___) | | |_| | |\\  |  | || |\\  | | |  | | |___| |\\  | |_| |   ║");
            System.out.println("║   |____/___\\____|_| \\_| |___|_| \\_| |_|  |_|_____|_| \\_|\\___/    ║");
            System.out.println("╚══════════════════════════════════════════════════════════════════╝" + RESET);

            final String RED = "\033[91m";
            final String PURPLE_BRIGHT = "\033[0;95m";
            System.out.println(PURPLE_BRIGHT + "1. Sign In existing user");
            System.out.println(PURPLE_BRIGHT + "2. Register new user");
            System.out.println(RED + "0. Exit" + RESET);

            System.out.print("Please choose an option: ");
            int signInOrRegister = scanner.nextInt();

            if (signInOrRegister == 0) {
                break;
            } else if (signInOrRegister == 1) {
                if (signInUser(scanner)) {
                    showProductCategories(inventory, scanner, df);
                }
            } else if (signInOrRegister == 2) {
                final String PURPLE_BOLD = "\033[1;35m";
                signUpNewCustomer(br);
                System.out.println(PURPLE_BOLD + "Registration successful. You can now sign in." + RESET);
            } else {
                System.out.println("Invalid option. Please choose a valid option.");
            }
        }

        final String GREEN = "\033[92m";
        final String RED = "\033[91m";
        final String PURPLE_BOLD = "\033[1;35m";

        try {
            System.out.println(RED + "Executing early shutdown protocols...");
            Thread.sleep(2000); // Sleep for 2 seconds

            System.out.println("Terminating processes.....");
            Thread.sleep(2000); // Sleep for 2 seconds

            System.out.println("Shutting down inbound connections........");
            Thread.sleep(2000); // Sleep for 2 seconds

            System.out.println("Ceasing background operations..........");
            Thread.sleep(2000); // Sleep for 2 seconds

            System.out.println(GREEN + "Early shutdown protocols complete✔\uFE0F" + RESET);
            Thread.sleep(2000); // Sleep for 2 seconds

            System.out.println(RED + "Initiating secure shutdown procedures...........");
            Thread.sleep(2000); // Sleep for 2 seconds

            System.out.println("Closing active sessions............");
            Thread.sleep(2000); // Sleep for 2 seconds

            System.out.println("Disabling network access points............");
            Thread.sleep(2000); // Sleep for 2 seconds

            System.out.println("Wrapping up system tasks with precision..........");
            Thread.sleep(2000); // Sleep for 2 seconds

            System.out.println("Commencing shutdown sequence.............");
            Thread.sleep(2000); // Sleep for 2 seconds

            System.out.println("Finalizing security protocols.............");
            Thread.sleep(2000); // Sleep for 2 seconds

            System.out.println("Ending processes responsibly.............");
            Thread.sleep(2000); // Sleep for 2 seconds

            System.out.println("Executing termination commands.........");
            Thread.sleep(2000); // Sleep for 2 seconds

            System.out.println("Securing data before system exit...........");
            Thread.sleep(2000); // Sleep for 2 seconds

            System.out.println(GREEN + "Secure shutdown complete✔\uFE0F" + RESET);
            Thread.sleep(2000); // Sleep for 2 seconds

            System.out.println(PURPLE_BOLD + "Thank you for visiting TRAVELGREEN STOREFRONT!");
            Thread.sleep(2000); // Sleep for 2 seconds

            System.out.println(GREEN + "ALWAYS REMEMBER TO TRAVEL GREEN, WITH TRAVELGREEN!" + RESET);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private static boolean signInUser(Scanner scanner) {
        final String PURPLE_BOLD = "\033[1;35m";
        final String RESET = "\033[0m";
        final String RED = "\033[91m";
        System.out.println(PURPLE_BOLD + "Enter your sign-in information:" + RESET);

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        System.out.print("Email: ");
        email = scanner.next().toLowerCase();

        if (!email.matches(emailRegex)) {
            System.out.println(RED + "Invalid email format. Please enter a valid email address." + RESET);
            return false;
        }

        System.out.print("Password: ");  // You may need to handle password securely (e.g., use char[] and consider hashing, NEEDS OBFUSCATION)F
        String password = scanner.next();

        try (MongoClient mongoClient = MongoClients.create(MONGO_URI)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> customersCollection = database.getCollection(CUSTOMERS_COLLECTION_NAME);

            Document query = new Document("email", email).append("password", password);
            Document user = customersCollection.find(query).first();

            if (user != null) {
                System.out.println(PURPLE_BOLD + "Sign-in successful. Welcome back!" + RESET);
                return true;
            } else {
                System.out.println(RED + "Invalid email or password. Please try again." + RESET);
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error during sign-in: + " + e.getMessage());
            return false;
        }
    }


    private static Customer signUpNewCustomer(BufferedReader br) throws IOException {
        final String PURPLE_BOLD = "\033[1;35m";
        final String RESET = "\033[0m";
        boolean registrationConfirmed = false;

        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";


        do {
            System.out.println(PURPLE_BOLD + "Enter your sign-up information:" + RESET);

            System.out.print("Customer Name: ");
            String customerName = br.readLine();

            System.out.print("Email: ");
            String email = br.readLine().toLowerCase();
            if (!email.matches(emailRegex)) {
                System.out.println("Invalid email format. Please enter a valid email address.");
                continue;  // Continue to the next iteration of the loop
            }


            System.out.print("Password: ");
            String password = br.readLine();  // You may want to hash the password for security

            System.out.println(PURPLE_BOLD + "ENTER YOUR SHIPPING ADDRESS" + RESET);
            Address shippingAddress = getAddressInformation(br, "Shipping", email);

            System.out.println(PURPLE_BOLD + "ENTER YOUR BILLING ADDRESS" + RESET);
            Address billingAddress = getAddressInformation(br, "Billing", email);

            System.out.println(PURPLE_BOLD + "\nPlease confirm your entered information:" + RESET);
            System.out.println("Customer Name: " + customerName);
            System.out.println("Email: " + email);
            System.out.println("Password: " + password);
            System.out.println("Shipping Address: " + shippingAddress);
            System.out.println("Billing Address: " + billingAddress);

            System.out.print("Is the information correct? (Y/N): ");
            String confirmation = br.readLine();

            if (confirmation.equalsIgnoreCase("Y")) {
                registrationConfirmed = true;

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

                    System.out.println(PURPLE_BOLD + "Sign-up successful. Welcome, " + customerNameValue + "!" + RESET);
                    return newCustomer;
                } catch (Exception e) {
                    System.err.println("Error during sign-up: " + e.getMessage());
                    return null;
                }
            } else {
                System.out.println("Registration canceled. Please re-enter your information.");
            }

        } while (!registrationConfirmed);

        return null; // This should not be reached
    }


    private static Address getAddressInformation(BufferedReader br, String addressType, String email) throws IOException {
        System.out.println(addressType + " Address:");

        System.out.print("Street: ");
        String street = br.readLine();

        System.out.print("City: ");
        String city = br.readLine();

        System.out.print("State: ");
        String state = br.readLine().toUpperCase();

        System.out.print("Zip Code: ");
        String zipCode = br.readLine();

        return new Address(street, city, state, zipCode, email);
    }


    private static void showProductCategories(Inventory inventory, Scanner scanner, DecimalFormat df) {
        // Your existing product category display logic
        // ...
        final String RESET = "\033[0m";
        final String GREEN = "\033[92m";
        final String BLUE = "\033[0;34m";
        selectedProducts.clear();           // clears the class level variable preventing constant overlap of invoices
        Item[][][] items = inventory.getItems();

        System.out.println(BLUE + "--------------------------------------");
        System.out.println("|                                    |");
        System.out.println("| Welcome to TRAVELGREEN Storefront! |");
        System.out.println("|                                    |");
        System.out.println("|     TRAVELGREEN EcoMobility Hub    |");
        System.out.println("|     123 Progressive Parkway        |");
        System.out.println("|        Libertyville, CA            |");
        System.out.println("|            98765                   |");
        System.out.println("--------------------------------------" + RESET);

        System.out.println(BLUE + "--------------------------------------");
        System.out.println("|                                    |");
        System.out.println("|       STORE DESCRIPTION!           |");
        System.out.println("|       Rated D by the BBB           |");
        System.out.println("|       We accept cash only!         |");
        System.out.println("|       No refunds, ever!            |");
        System.out.println("--------------------------------------" + RESET);

        System.out.println(BLUE + "-------------------------------------------------------------------------------");
        System.out.println("|                                                                             |");
        System.out.println("|               READ OUR PERSONAL MISSION STATEMENT                           |");
        System.out.println("|     At TRAVELGREEN, we are dedicated to promoting a lifestyle               |");
        System.out.println("|     that values environmental responsibility, personal freedom and          |");
        System.out.println("|     community engagement, through our sweet rides!                          |");
        System.out.println("-------------------------------------------------------------------------------" + RESET);

        while (true) {                                          // inner loop for category selection
            // Display available categories
            System.out.println(GREEN + "╔══════════════════════════════════════════════════════════╗");
            System.out.println("║  ____    _  _____ _____ ____  ___  ____  ___ _____ ____  ║");
            System.out.println("║ / ___|  / \\|_   _| ____/ ___|/ _ \\|  _ \\|_ _| ____/ ___| ║");
            System.out.println("║| |     / _ \\ | | |  _|| |  _| | | | |_) || ||  _| \\___ \\ ║");
            System.out.println("║| |___ / ___ \\| | | |__| |_| | |_| |  _ < | || |___ ___) |║");
            System.out.println("║ \\____/_/   \\_\\_| |______\\____|\\___/|_| \\_\\___|_____|____/║");
            System.out.println("╚══════════════════════════════════════════════════════════╝" + RESET);

            final String RED = "\033[91m";
            final String PURPLE_BRIGHT = "\033[0;95m";
            System.out.println(PURPLE_BRIGHT + "1. Performance E-scooters   \uD83D\uDEF4");
            System.out.println("-----------------------------");
            System.out.println(PURPLE_BRIGHT + "2. Off-road E-scooters      \uD83D\uDEF4");
            System.out.println("-----------------------------");
            System.out.println(PURPLE_BRIGHT + "3. Urban commuter E-scooters\uD83D\uDEF4");
            System.out.println("-----------------------------");
            System.out.println(PURPLE_BRIGHT + "4. Luxury E-scooters        \uD83D\uDEF4");
            System.out.println("-----------------------------");
            System.out.println(PURPLE_BRIGHT + "5. Cargo E-scooters         \uD83D\uDEF4");
            System.out.println("-----------------------------");
            System.out.println(PURPLE_BRIGHT + "6. Long-range E-scooters    \uD83D\uDEF4");
            System.out.println("-----------------------------");
            System.out.println(PURPLE_BRIGHT + "7. Return Items             \uD83E\uDDFE");
            System.out.println("-----------------------------");
            System.out.println(RED + "0. Exit" + RESET);

            // Prompt the user to choose a category
            System.out.print("Please choose from one of our E-scooter categories(or press 0 to exit): ");
            int selectedCategory = scanner.nextInt();

            if (selectedCategory == 0) {
                break; // Exit the loop if the user chooses 0
            } else if (selectedCategory < 0 || selectedCategory > 7) {
                System.out.println("Invalid category number. Please enter a valid category number.");
                continue;
            } else if (selectedCategory == 7) {
                processReturns(scanner, inventory, df);
                break; // Exit the loop after processing returns
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

            total = 0;              // manually clears the total rolling to next invoice issue
            // Allow the user to select items from the chosen category
            while (true) {
                System.out.print("Enter item number (or press 0 to go back to category selection): ");
                int selectedItem = scanner.nextInt();

                if (selectedItem == 0) {
                    break; // Go back to category selection
                }

                if (!isProductAvailable(selectedItem)) {
                    System.out.println("Sorry, the selected product is not available. Please choose another item.");
                    continue;
                }

                Item selectedProduct = inventory.getItemById(selectedItem);
                if (selectedProduct != null && selectedProduct.getCategory().ordinal() == selectedCategory - 1) {
                    total += selectedProduct.getPrice();
                    System.out.println("Added " + selectedProduct.getName() + " to your cart.");
                    selectedProducts.add(selectedProduct);
                    markProductAsPurchased(selectedItem);
                } else {
                    System.out.println("Item not found in the selected category. Please enter a valid item number.");
                }
                // Prompt the user if they want to continue to checkout
                System.out.print(PURPLE_BRIGHT + "Would you like to continue to final checkout? (y/n): " + RESET);
                String continueToCheckout = scanner.next();

                System.out.println(GREEN + "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
                System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
                System.out.println("⠀⠈⠛⠻⠶⣶⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
                System.out.println("⠀⠀⠀⠀⠀⠈⢻⣆⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⠀⠀");
                System.out.println("⠀⠀⠀⠀⠀⠀⠀⢻⡏⠉⠉⠉⠉⢹⡏⠉⠉⠉⠉⣿⠉⠉⠉⠉⠉⣹⠇⠀⠀");
                System.out.println("⠀⠀⠀⠀⠀⠀⠀⠈⣿⣀⣀⣀⣀⣸⣧⣀⣀⣀⣀⣿⣄⣀⣀⣀⣠⡿⠀⠀⠀");
                System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠸⣧⠀⠀⠀⢸⡇⠀⠀⠀⠀⣿⠁⠀⠀⠀⣿⠃⠀⠀⠀");
                System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⢹⣧⣤⣤⣼⣧⣤⣤⣤⣤⣿⣤⣤⣤⣼⡏⠀⠀⠀⠀");
                System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⠀⠀⢸⡇⠀⠀⠀⠀⣿⠀⠀⢠⡿⠀⠀⠀⠀⠀");
                System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣷⠤⠼⠷⠤⠤⠤⠤⠿⠦⠤⠾⠃⠀⠀⠀⠀⠀");
                System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
                System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⢾⣷⢶⣶⠶⠶⠶⠶⠶⠶⣶⠶⣶⡶⠀⠀⠀⠀⠀⠀");
                System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣧⣠⡿⠀⠀⠀⠀⠀⠀⢷⣄⣼⠇⠀⠀⠀⠀⠀⠀");
                System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
                System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀" + RESET);

                if (continueToCheckout.equalsIgnoreCase("y")) {
                    // Prompt the user to enter the total amount paid
                    System.out.print("Please Enter the total amount paid: ");
                    double amountPaid = scanner.nextDouble();

                    // Calculate the change
                    double change = amountPaid - (total + shipping);
                    df.format(change);


                    System.out.println("-----------------------------------------------------------------------------------------------");
                    // Display the change to the user with two decimal places
                    System.out.println("Change: $" + df.format(change));

                    // Provide change in denominations
                    provideChangeInDenominations(change, amountPaid);

                    // Thank the user
                    System.out.println(GREEN + "-----------------------------------------------------------");
                    System.out.println("|    Thank you for using our Eco-friendly Storefront!     |");
                    System.out.println("|        TRAVELGREEN appreciates your business!           |");
                    System.out.println("|            The environment does too!                    |");
                    System.out.println("|                                                         |");
                    System.out.println("|              ENJOY YOUR NEW ESCOOTER                    |");
                    System.out.println("-----------------------------------------------------------" + RESET);

                    System.out.print("\033[0;34m"); // Set color to BLUE
                    System.out.print(
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠤⠤⠤⢒⣒⣶⣝⣦⠀⠀⠀⠀⠀\n" +
                                    "⠀⠀⠀⣀⣀⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣿⣾⣶⣻⣿⠿⠿⠿⠋⠀⠀⠀⠀⠀\n" +
                                    "⢮⣭⣷⣿⣾⣷⡴⡌⢷⣂⣀⡀⠀⠄⢁⡼⠁⠀⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                    "⠀⠉⠉⠀⠀⠀⠀⠘⣆⢳⡀⠀⠄⣠⠎⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                    "⠀⠀⠀⠀⠀⠀⠀⠀⠘⣾⠁⠁⡴⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣽⠀⢸⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                    "⠀⠀⠀⠀⠀⠀⠀ ⡇⠀⡞⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                    "⠀⠀⠀⠀⠀⠀ ⢠⠃⢀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                    "⠀⠀⠀⠀⠀⠀ ⢸⠀⢸⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                    "⠀⠀⠀⠀⠀⠀ ⡼⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                    "⠀⠀⠀⠀⠀⠀ ⡇⠀⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                    "⠀⠀⠀⠀⠀ ⢠⠁⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                    "⠀⠀⠀⠀⠀ ⣸⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                    "⠀⠀⠀⠀⠀⣿⣿⣿⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                    "⠀⠀⠀⠀⢠⣿⣿⡿⠇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                    "⠀⠀⠀⠀⢺⣿⣿⡷⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                    "⠀⠀⠀⠀⣿⡿⣿⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                    "⠀⠀⠀⢀⣿⣷⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣶⣶⡆⠀\n" +
                                    "⠀⠀⠀⢸⣿⢿⣿⣿⣿⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣤⣤⣤⣼⣿⣯⣾⣇⡀\n" +
                                    "⠀⠀⢀⣽⣿⣿⣿⢻⣿⣿⣷⣀⣤⣤⣴⣶⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃\n" +
                                    "⠀⠀⠸⠋⣿⣿⣿⣶⣿⣿⣿⣷⣿⣿⣿⣻⣿⣿⣷⣿⣿⠿⢿⣛⠛⠛⢫⣹⠿⠃⠀\n" +
                                    "⠀⢰⠁⣰⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠟⠛⠛⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                    "⠀⢸⠀⢯⣿⣿⢿⣯⣿⠿⠿⠛⠛⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"
                    );
                    System.out.print("\u001B[0m"); // Reset color
                    System.out.println("--------------------------------------------------------");

                    // Break out of the outer loop
                    break;
                } else if (continueToCheckout.equalsIgnoreCase("n")) {
                    // Continue to the next iteration of the outer loop
                    System.out.println("Returning to product selection...");
                } else {
                    System.out.println("Invalid input. Please enter 'y' to continue to checkout or 'n' to return to product selection.");
                }
            }
        }
    }

    private static void provideChangeInDenominations(double change, double amountPaid) {

        change = Math.round(change * 100d) / 100d;
        // Convert change to cents
        int changeInCents = (int) (change * 100);
        // Convert change to cents

        // Calculate and display change in denominations
        int dollars = changeInCents / 100;
        changeInCents %= 100;
        int quarters = changeInCents / 25;
        changeInCents = changeInCents - (quarters * 25);
        int dimes = changeInCents / 10;
        changeInCents = changeInCents - (dimes * 10);
        int nickels = changeInCents / 5;
        changeInCents = changeInCents - (nickels * 5);
        int pennies = changeInCents;

        System.out.println("Your change in denominations:");
        System.out.println("Dollars: " + dollars);
        System.out.println("Quarters: " + quarters);
        System.out.println("Dimes: " + dimes);
        System.out.println("Nickels: " + nickels);
        System.out.println("Pennies: " + pennies);


        generateAndDisplayInvoice(email, selectedProducts, amountPaid, total);

    }

    // Corrected method signature
    private static void generateAndDisplayInvoice(String customerEmail, List<Item> selectedProducts, double amountPaid, double total) {
        // Generate an invoice object
        Main.amountPaid = amountPaid;
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
            invoice.setProducts(selectedProducts);          /// not being set before this its a fucking issue and its aggravating as fuck

            // Debug print statement
            //System.out.println("Selected products: " + selectedProducts);         // debug statement

            // Calculate totals
            invoice.calculateTotals();
            //System.out.println("Invoice after calculateTotals:");                   // debug statement

            // Display the invoice
            invoice.printInvoice();

            // Insert the invoice into MongoDB
            MongoManager mongoManager = new MongoManager(MONGO_URI, DATABASE_NAME, "Invoices");
            mongoManager.insertInvoice(invoice);

            // Close the MongoDB client when done
            mongoManager.close();
            selectedProducts.clear();           // clears the class level variable preventing constant overlap of invoices
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

    private static final AtomicLong orderCounter = new AtomicLong(0);

    public static long generateOrderNumber() {
        long timestamp = System.currentTimeMillis();
        long uniqueId = orderCounter.getAndIncrement();
        return (timestamp % 1000000) * 10000 + uniqueId;
    }


    private static void processReturns(Scanner scanner, Inventory inventory, DecimalFormat df) {
        System.out.print("Enter the item ID you want to return (or press 0 to go back): ");
        int returnItemId = scanner.nextInt();

        if (returnItemId == 0) {
            // Log out and go back to the category selection
            signOut();
            return;
        }

        // Check if the item was purchased (unavailable) in the Products collection
        boolean isItemPurchased = isProductPurchased(returnItemId);

        if (isItemPurchased) {
            // Retrieve the original price of the returned product from the database
            double originalPrice = getOriginalPrice(returnItemId);

            // Optionally, you can remove the item from the selectedProducts list
            Item itemToReturn = findItemById(returnItemId);
            if (itemToReturn != null) {
                selectedProducts.remove(itemToReturn);
            }

            // Mark the product as available in the database
            markProductAsAvailable(returnItemId);

            final String GREEN = "\033[92m";
            final String RESET = "\033[0m";
            // Print the refunded amount
            System.out.println(GREEN + "Item pending return. Refunded Amount: $" + RESET + df.format(originalPrice));
        } else {
            final String RESET = "\033[0m";
            final String RED = "\033[91m";
            final String GREEN = "\033[92m";

            System.out.println(RED + "Checking database for product availability...");
            try {
                Thread.sleep(2000); // Sleep for 2 seconds (adjust the duration as needed)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Querying inventory for stock information...");
            System.out.println("Analyzing product availability...");
            System.out.println("Verifying stock levels for requested products...");

            try {
                Thread.sleep(2000); // Sleep for 2 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Processing database information for product availability...");
            System.out.println("Evaluating inventory status for the requested items...");
            System.out.println("Cross-referencing database records...");

            try {
                Thread.sleep(2000); // Sleep for 2 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(GREEN + "Database product return availability check complete✔\uFE0F");
            System.out.println(RED + "Item is currently available and not open for return❌ " + RESET);
        }


        // Log out after processing returns and go back to the category selection
        if (isItemPurchased) signOut();                             // conditional check for item purchased
        showProductCategories(inventory, scanner, df);
    }

    private static void signOut() {
        final String RED = "\033[91m";
        final String RESET = "\033[0m";
        final String GREEN = "\033[92m";

        System.out.println(RED + "Initiating encrypted data protocols for item return... 🔍");

        // Reset relevant variables or perform additional log-out actions here

        try {
            Thread.sleep(2000); // Sleep for 2 seconds (adjust the duration as needed)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(RED + "Checking database for product availability...");

        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Querying inventory for stock information...");

        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Analyzing product availability...");

        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Verifying stock levels for requested products...");

        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Processing database information for product availability...");

        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Evaluating inventory status for the requested items...");

        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Cross-referencing database records...");

        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(GREEN + "Database product return availability check complete✔\uFE0F");

        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(RED + "Initiating item return protocol");

        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(RED + "Executing decryption protocols for item return... 🔐");

        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Elevating security protocols for database reintegration... 🛡️" + RESET);

        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(RED + "Executing database reorganization protocols...\uD83C\uDF10");

        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(GREEN + "Item return protocol complete✔\uFE0F");
        System.out.println(GREEN + "Item successfully returned and database updated...✔\uFE0F" + RESET);
    }


    // Helper method to retrieve the original price of a product from MongoDB based on its ID
    private static double getOriginalPrice(int itemId) {
        try (MongoClient mongoClient = MongoClients.create(MONGO_URI)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> itemsCollection = database.getCollection("Products");

            // Query the database to get the product details
            Document query = new Document("productId", itemId);
            Document itemDocument = itemsCollection.find(query).first();

            if (itemDocument != null) {
                return itemDocument.getDouble("price"); // Replace "price" with the actual field name for the product price
            } else {
                return 0.0; // Default value if the item is not found
            }
        } catch (Exception e) {
            System.err.println("Error getting original price from MongoDB: " + e.getMessage());
            return 0.0; // Default value in case of an error
        }
    }


    // Helper method to check if a product was purchased (unavailable) in the database
    private static boolean isProductPurchased(int itemId) {
        try (MongoClient mongoClient = MongoClients.create(MONGO_URI)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> itemsCollection = database.getCollection("Products");

            // Query the database to check the purchase status of the product
            Document query = new Document("productId", itemId);
            Document itemDocument = itemsCollection.find(query).first();

            if (itemDocument != null) {
                // Check the "available" field
                return !itemDocument.getBoolean("available", true);
            } else {
                // Handle the case where the item is not found in the database
                System.out.println("Item not found in the Products collection.");
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error checking product purchase status: " + e.getMessage());
            return false;
        }
    }


    // Helper method to check the availability of a product in the database
    private static boolean isProductAvailable(int itemId) {
        try (MongoClient mongoClient = MongoClients.create(MONGO_URI)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> itemsCollection = database.getCollection("Products");

            // Query the database to check the availability status of the product
            Document query = new Document("productId", itemId);
            Document itemDocument = itemsCollection.find(query).first();

            if (itemDocument != null) {
                // Check the "available" field
                return itemDocument.getBoolean("available", true);
            } else {
                // Handle the case where the item is not found in the database
                System.out.println("Item not found in the Products collection.");
                return false;
            }
        } catch (Exception e) {
            System.err.println("Error checking product availability: " + e.getMessage());
            return false;
        }


    }// Method to mark a product as available in the database

    private static void markProductAsAvailable(int itemId) {
        try (MongoClient mongoClient = MongoClients.create(MONGO_URI)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> itemsCollection = database.getCollection("Products");

            // Update the availability status of the product in the database
            Document query = new Document("productId", itemId);
            Document update = new Document("$set", new Document("available", true));
            itemsCollection.updateOne(query, update);

            final String GREEN = "\033[92m";
            final String RESET = "\033[0m";
            System.out.println(GREEN + "Product with ID " + itemId + " is in the process of being returned." + RESET);
        } catch (Exception e) {
            System.err.println("Error marking product as available: " + e.getMessage());
        }
    }

    // Method to get the name of a product from MongoDB based on its ID
    private static String getItemNameFromMongoDB(int itemId) {
        try (MongoClient mongoClient = MongoClients.create(MONGO_URI)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> itemsCollection = database.getCollection("Products");

            // Query the database to get the product details
            Document query = new Document("productId", itemId);
            Document itemDocument = itemsCollection.find(query).first();

            if (itemDocument != null) {
                return itemDocument.getString("name"); // Replace "name" with the actual field name for the product name
            } else {
                return "Unknown Product";
            }
        } catch (Exception e) {
            System.err.println("Error getting product name from MongoDB: " + e.getMessage());
            return "Unknown Product";
        }
    }


    private static Item findItemById(int itemId) {
        for (Item item : selectedProducts) {
            if (item.getProductId() == itemId) {
                return item;
            }
        }
        return null;
    }


    private static void markProductAsPurchased(int itemId) {
        final String RESET = "\033[0m";
        final String RED = "\033[91m";
        final String GREEN = "\033[92m";
        try (MongoClient mongoClient = MongoClients.create(MONGO_URI)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            MongoCollection<Document> itemsCollection = database.getCollection("Products");

            // Update the availability status of the product in the database
            Document query = new Document("productId", itemId);
            Document update = new Document("$set", new Document("available", false));
            itemsCollection.updateOne(query, update);


            final String PURPLE_BRIGHT = "\033[0;95m";
            System.out.println(PURPLE_BRIGHT + "Product with ID " + itemId + " added to your shopping cart for final checkout." + RESET);
        } catch (Exception e) {
            System.err.println("Error marking product as purchased: " + e.getMessage());
        }
    }
}

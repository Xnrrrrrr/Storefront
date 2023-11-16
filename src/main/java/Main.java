import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

import java.text.DecimalFormat;                                 //Import the Decimal Formatter
import java.util.Scanner;                                       //Import the scanner

public class Main {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();                  //create an instance of the inventory class
        Scanner scanner = new Scanner(System.in);               //create a scanner object for user input
        DecimalFormat df = new DecimalFormat("#.##");    // Create a DecimalFormat object to format for two decimal places



        while (true) {                                          // Infinite loop for STOREFRONT
            double total = 0.00;                                // intialize a variable to keep track of total cost
            Item[][][] items = inventory.getItems();            // Get the items from the inventory

            System.out.println("--------------------------------------");   // Welcome message and format lines
            System.out.println("|                                    |");
            System.out.println("| Welcome to TRAVELGREEN Storefront! |");
            System.out.println("|                                    |");
            System.out.println("|     TRAVELGREEN EcoMobility Hub    |");
            System.out.println("|     123 Progressive Parkway        |");
            System.out.println("|        Libertyville, CA            |");     // add visual of scooter
            System.out.println("|            98765                   |");
            System.out.println("--------------------------------------");

            System.out.println("--------------------------------------");   // Welcome message and format lines
            System.out.println("|                                    |");
            System.out.println("|       STORE DESCRIPTION!           |"); // actually create a description
            System.out.println("|       Rated D by the BBB           |");
            System.out.println("|       We accept cash only!         |");
            System.out.println("|       No refunds, ever!            |");
            System.out.println("--------------------------------------");

            System.out.println("-------------------------------------------------------------------------------");   // Welcome message and format lines
            System.out.println("|                                                                             |");
            System.out.println("|               READ OUR PERSONAL MISSION STATEMENT                           |"); // actually create a description
            System.out.println("|     At TRAVELGREEN, we are dedicated to promoting a lifestyle               |");
            System.out.println("|     that values environmental responsibility, personal freedom and          |");
            System.out.println("|     community engagement, through our sweet rides!                          |");
            System.out.println("-------------------------------------------------------------------------------");


            //DESCRIPTION OF STORE
            // OUR STORE ONLY TAKES CASH
            // NO REFUNDS

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

            System.out.print(
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠤⠤⠤⢒⣒⣶⣝⣦⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⣀⣀⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣿⣾⣶⣻⣿⠿⠿⠿⠋⠀⠀⠀⠀⠀\n" +
                            "⢮⣭⣷⣿⣾⣷⡴⡌⢷⣂⣀⡀⠀⠄⢁⡼⠁⠀⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠉⠉⠀⠀⠀⠀⠘⣆⢳⡀⠀⠄⣠⠎⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠘⣾⠁⠁⡴⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣽⠀⢸⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⡾⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⢠⡇⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⢸⡀⢰⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⣼⠇⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⠀⣿⠆⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⢠⡏⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⢸⡇⢠⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⣼⠅⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⡇⠀⡞⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⢠⠃⢀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⢸⠀⢸⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⡼⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⡇⠀⡏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⢠⠁⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⣸⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
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

            System.out.println("--------------------------------------------------------");
        }
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
    }
}
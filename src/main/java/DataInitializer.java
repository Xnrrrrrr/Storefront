public class DataInitializer {

    public static void initializeData(MongoManager mongoManager) {
        // Create and insert sample items
        Item[][][] items = new Item[6][6][6];
        //items = new Item[6][6][6];            // possibly creating the twice intiailization error in MONGODB eat a bird fuckface
        // Initialize items here, creating 36 items and placing them in the 6x6x6 array.
        // add two to layer two


        items[0][0][0] = new Item(1, "APOLLO PRO", 199.99, ProductCategory.PERFORMANCE, "\n Tires: Michelin SPORT\n Suspension: Electronic\n Available colors: Grey\n Max Speed: 100 MPH\n Charge time:\n Weight limit:150\n Description: Thrilling scooter with SPORT tires, electronic suspension, grey color, 100 MPH speed, and 150 lb weight limit.");
        items[0][0][1] = new Item(2, "ZERO 10X", 299.99, ProductCategory.PERFORMANCE, "\n Tires: Bridgestone SPORT\n Suspension: Dual Shock\n Available colors: Black\n Max Speed: 100 MPH \n Range\n Weight limit:250\n Description: Top-tier scooter with SPORT tires, dual shock, black finish, 100 MPH speed, long range, 250 lb limit.");
        items[0][0][2] = new Item(3, "THE JOE OAKES", 1000.00, ProductCategory.PERFORMANCE, "\n Tires: Continental SPORT\n Suspension: Air\n Available colors: Pink\n Max Speed: 250 MPH\n Weight limit:350\n Description: Performance scooter with SPORT tires, air suspension, pink color, 250 MPH speed, 350 lb limit.");
        items[0][1][0] = new Item(4, "DUAL PED SCORPION", 499.99, ProductCategory.PERFORMANCE, "\n Tires: Pirelli SPORT\n Suspension: Inverted Front Forks\n Available colors: Yellow\n Max Speed: 300 MPH\n Weight limit:450\n Description: High-performance scooter with SPORT tires, inverted forks, yellow color, 300 MPH speed, 450 lb limit.");
        items[0][1][1] = new Item(5, "APOLLO", 599.99, ProductCategory.PERFORMANCE, "\n Tires: Dunlop SPORT\n Suspension: Gas Charged Rear Shocks\n Available colors: Green\n Max Speed: 350 MPH\n Weight limit:600\n Description: Electric scooter with sporty tires, shocks, green color, 350 MPH speed, and 600 pounds capacity.");
        items[0][1][2] = new Item(6, "WOLF WARRIOR 11", 699.99, ProductCategory.PERFORMANCE, "\n Tires: Kenda SPORT\n Suspension: Threadless Fork and Compression System\n Available colors: Purple\n Max Speed: 400 MPH\n Weight limit:650\n Description: Performance scooter with sporty tires, fork, purple color, 400 MPH speed, and 650 pounds limit. Be the beast!");

// Layer 1
        items[1][0][0] = new Item(7, "E MOVE CRUISER", 350.99, ProductCategory.OFFROAD, "\n Tires: Michelin OFF\n Suspension: Magnetic\n Available colors: Teal\n Max Speed: 30 MPH\n Weight limit: 190\n Description: Off-road scooter with Michelin tires, magnetic suspension, teal color, 30 MPH speed, and 190 pounds capacity. Explore the wild!");
        items[1][0][1] = new Item(8, "APOLLO PHANTOM", 360.99, ProductCategory.OFFROAD, "\n Tires: Bridgestone OFF\n Suspension: Telescopic Front Forks \n Available colors: Deep Blue\n Max Speed: 40 MPH\n Charge time:1Hr\n Weight limit: 200\n Description: Off-road scooter with Bridgestone tires, forks, blue color, 40 MPH speed, 1 hour charge, and 200 pounds limit. Conquer the challenges!");
        items[1][0][2] = new Item(9, "WOLF KING PRO", 370.99, ProductCategory.OFFROAD, "\n Tires: Continental OFF\n Suspension: Spring \n Available colors: Abyss Black\n Max Speed: 60 MPH\n Charge time:49min\n Weight limit: 300\n Description: Abyss black off-road beast with spring suspension, 60 MPH speed, 49 min charge, and 300 lbs capacity.");
        items[1][1][0] = new Item(10, "E CITY", 380.99, ProductCategory.OFFROAD, "\n Tires: Pirelli OFF\n Suspension: Monoshock\n Available colors: Matte Black\n Max Speed: 70 MPH\n Charge time:75min\n Weight limit: 350\n Description: Matte black off-road scooter with monoshock, 70 MPH speed, 75 min charge, and 350 lbs limit.");
        items[1][1][1] = new Item(11, "Q1 HUMMER", 390.99, ProductCategory.OFFROAD, "\n Tires: Dunlop OFF\n Suspension: Hydraulic Friction Dampers \n Available colors: Magenta\n Max Speed: 90 MPH\n Charge time:30min\n Weight limit: 450\n Description: Magenta off-road monster with hydraulic dampers, 90 MPH speed, 30 min charge, and 450 lbs capacity.");
        items[1][1][2] = new Item(12, "EGO G BOOSTER", 400.99, ProductCategory.OFFROAD, "\n Tires: Kenda OFF\n Suspension: Heavy-Duty Coil Springs\n Available colors: Silver\n Max Speed: 100 MPH\n Charge time:40min\n Weight limit: 500\n Description: With Kenda tires and heavy-duty springs, hits 100 MPH, charges in 40 min, supports 500 lbs, and is your stylish silver off-road thrill.");

// Layer 2
        items[2][0][1] = new Item(14, "URBAN CRUISER PRO", 560.99, ProductCategory.URBAN, "\n Tires: Bridgestone URB\n Suspension: Gas-Charged Rear Shocks\n Available colors: Platinum\n Max Speed: 150 MPH\n Charge time:50min\n Weight limit: 350\n Description: With Bridgestone tires and gas-charged shocks, offers a smooth ride at 150 MPH, charges in 50 min, and carries up to 350 lbs in platinum style.");
        items[2][0][2] = new Item(15, "URBAN CRUISER", 670.99, ProductCategory.URBAN, "\n Tires: Continental URB\n Suspension: Polyurethane\n Available colors: Inferno Red\n Max Speed: 160 MPH\n Charge time:45min\n Weight limit: 365\n Description: Zip through the city on the URBAN CRUISER, decked in inferno red with Continental tires, hitting 160 MPH, charging in 45 min, and supporting 365 lbs.");
        items[2][1][0] = new Item(16, "DOWNTOWN EXPRESS", 780.99, ProductCategory.URBAN, "\n Tires: Pirelli URB\n Suspension: Progressive Springs\n Available colors: Light Blue\n Max Speed: 170 MPH\n Charge time:40min\n Weight limit: 400\n Description: In light blue, features Pirelli tires, progressive springs, speeds up to 170 MPH, charges in 40 min, and has a 400 lb weight limit.");
        items[2][1][1] = new Item(17, "URBAN GLIDE 2", 890.99, ProductCategory.URBAN, "\n Tires: Dunlop URB\n Suspension: Hardtail\n Available colors: Off White\n Max Speed: 180 MPH\n Charge time:35min\n Weight limit: 500\n Description: With Dunlop tires, hardtail suspension, and off-white color, hits 180 MPH, charges in 35 minutes, and supports 500 pounds.");
        items[2][1][2] = new Item(18, "METRO JET", 900.99, ProductCategory.URBAN, "\n Tires: Kenda URB\n Suspension: Remote Reservoir\n Available colors: Egg Shell\n Max Speed: 190 MPH\n Charge time:30min\n Weight limit: 600\n Description: With Kenda tires and remote reservoir suspension in eggshell, speeds up to 190 MPH, charges in 30 minutes, and carries 600 pounds.");

// Layer 3
        items[3][0][0] = new Item(19, "MIDNIGHT CRUISER", 10000.99, ProductCategory.LUXURY, "\n Tires: Michelin LUX\n Suspension: Heavy-Duty Sidecar Suspension\n Available colors: Midnight Green\n Max Speed: 125 mph\n Charge time:20min\n Weight limit: 150\n Description: With Michelin LUX tires and heavy-duty sidecar suspension, offers a stylish ride in midnight green at 125 mph and charges in 20 minutes.");
        items[3][0][1] = new Item(20, "PEARL ELEGANCE", 11000.99, ProductCategory.LUXURY, "\n Tires: Bridgestone LUX\n Suspension: Anti-Dive Suspension\n Available colors: Pearl White\n Max Speed: 130 mph\n Charge time:25min\n Weight limit: 160\n Description: With Bridgestone LUX tires and anti-dive suspension in pearl white, reaches 130 mph, charges in 25 minutes, and has a 160-pound limit.");
        items[3][0][2] = new Item(21, "MAJESTIC VOYAGER", 12000.99, ProductCategory.LUXURY, "\n Tires: Continental LUX\n Suspension: Dual-Stage\n Available colors: Majestic Gold\n Max Speed: 150 mph\n Charge time:33min\n Weight limit: 170\n Description: In majestic gold with Continental LUX tires and dual-stage suspension, achieves 150 mph, charges in 33 minutes, and has a 170-pound limit.");
        items[3][1][0] = new Item(22, "BLOOD EXPLORER", 150000.99, ProductCategory.LUXURY, "\n Tires: Pirelli LUX\n Suspension: Adjustable Adventure\n Available colors: Blood Red\n Max Speed: 160 mph\n Charge time:38min\n Weight limit: 180\n Description: With Pirelli LUX tires and adjustable suspension, boasts a blood red color, 160 mph speed, 38-min charge, and 180 lbs weight limit.");
        items[3][1][1] = new Item(23, "SKY DREAMER", 200000.99, ProductCategory.LUXURY, "\n Tires: Dunlop LUX\n Suspension: Fork Cartridges\n Available colors: Sky Blue\n Max Speed: 170 mph\n Charge time:40min\n Weight limit: 200\n Description: Enchants with Dunlop LUX tires, fork cartridges suspension, sky blue color, 170 mph speed, 40-min charge, and a 200 lbs weight limit.");
        items[3][1][2] = new Item(24, "CRYSTAL PRESTIGE", 500500.99, ProductCategory.LUXURY, "\n Tires: Kenda LUX\n Suspension: Trike-Specific\n Available colors: Crystal White\n Max Speed: 180 mph\n Charge time:45min\n Weight limit: 400\n Description: Exudes luxury with Kenda LUX tires, trike-specific suspension, crystal white color, 180 mph max speed, 45-min charge, and 400 lbs limit.");

// Layer 4
        items[4][0][0] = new Item(25, "AURORA ELITE", 3350.99, ProductCategory.CARGO, "\n Tires: Michelin CAR\n Suspension: Progressive Damping \n Available colors: Cyan\n Max Speed: 50 mph\n Charge time:45min\n Weight limit:300\n Description: With Michelin CAR tires and progressive damping, offers cyan style, 50 mph speed, 45-min charge, and a 300 lbs cargo capacity.");
        items[4][0][1] = new Item(26, "CARGO VOYAGER", 3650.99, ProductCategory.CARGO, "\n Tires: Bridgestone CAR\n Suspension: Upside-Down (USD) Forks\n Available colors: Navy Blue\n Max Speed: 90 mph\n Charge time:30min\n Weight limit: 400\n Description: Designed for cargo adventures, features Bridgestone CAR tires, USD forks, navy blue elegance, 90 mph speed, 30-min charge, and 400 lbs limit.");
        items[4][0][2] = new Item(27, "REGAL SERIES", 3750.99, ProductCategory.CARGO, "\n Tires: Continental CAR\n Suspension: Remote Reservoir Suspensions\n Available colors: Deep Yellow\n Max Speed: 100 mph\n Charge time:36min\n Weight limit: 500\n Description: Cargo scooter, with Continental CAR tires and remote reservoir suspensions, boasts a deep yellow hue, 100 mph speed, 36-minute charge, and 500-pound limit.");
        items[4][1][0] = new Item(28, "ELYSIAN PRO", 3850.99, ProductCategory.CARGO, "\n Tires: Pirelli CAR\n Suspension: Electronically Adjustable\n Available colors: Orange\n Max Speed: 109 mph\n Charge time:20min\n Weight limit:600\n Description: Designed for cargo professionals, features Pirelli CAR tires, electronically adjustable suspension, an orange finish, 109 mph max speed, 20-min charge, and 600 lbs limit.");
        items[4][1][1] = new Item(29, "ELYSIAN MAX", 3950.99, ProductCategory.CARGO, "\n Tires: Dunlop CAR\n Suspension: Dual Rear\n Available colors: Red\n Max Speed: 170 mph\n Charge time:25min\n Weight limit:700\n Description: With its red Dunlop CAR tires, dual rear suspension, 170 mph speed, 25-minute charge, and 700-pound capacity, epitomizes cargo efficiency.");
        items[4][1][2] = new Item(30, "ELYSIAN GOLD", 4050.99, ProductCategory.CARGO, "\n Tires: Kenda CAR\n Suspension: Pneumatic Suspension\n Available colors: Blood Orange\n Max Speed: 180 mph\n Charge time:15min\n Weight limit:800\n Description: Cargo scooter, with Kenda CAR tires and pneumatic suspension, features a blood orange color, 180 mph speed, 15-minute charge, and 800-pound limit.");

// Layer 5
        items[5][0][0] = new Item(31, "ENDURANCE VOYAGER", 5050.99, ProductCategory.LONGRANGE, "\n Tires: Michelin LR\n Suspension: Lever-Link\n Available colors: Light Green\n Max Speed: 200 mph\n Charge time:30min\n Weight limit: 300\n Description: Designed for extended rides, features Michelin LR tires, Lever-Link suspension, a light green shade, 200 mph speed, and a 30-minute charge for a 300-pound load.");
        items[5][0][1] = new Item(32, "THE ODYSSEY", 6080.99, ProductCategory.LONGRANGE, "\n Tires: Bridgestone LR\n Suspension: Semi-Active\n Available colors: Light Grey\n Max Speed: 250 mph\n Charge time:33min\n Weight limit: 200\n Description: With Bridgestone LR tires and semi-active suspension, offers a light grey, 250 mph max speed adventure in just a 33-minute charge.");
        items[5][0][2] = new Item(33, "MARATHON EXPLORER PRO", 7050.99, ProductCategory.LONGRANGE, "\n Tires: Continental LR\n Suspension: Carbon Fiber Coil\n Available colors: Light Yellow\n Max Speed: 260 mph\n Charge time:36min\n Weight limit: 196\n Description: A light yellow speedster with Continental LR tires, carbon fiber coil suspension, 260 mph max, and a 36-minute charge time.");
        items[5][1][0] = new Item(34, "MARATHON EXPLORER", 8750.99, ProductCategory.LONGRANGE, "\n Tires: Pirelli LR\n Suspension: Progressive Linkage\n Available colors: Matte Yellow\n Max Speed: 270 mph\n Charge time:38min\n Weight limit: 155\n Description: Dazzles in matte yellow, boasting Pirelli LR tires, progressive linkage suspension, a swift 270 mph max, and a 38-minute quick charge.");
        items[5][1][1] = new Item(35, "RANGE MASTER", 9759.99, ProductCategory.LONGRANGE, "\n Tires: Dunlop LR\n Suspension: Rebound Adjustable\n Available colors: Matte White\n Max Speed: 280 mph\n Charge time:40min\n Weight limit:145\n Description: Excels in matte white, equipped with Dunlop LR tires, rebound adjustable suspension, a 280 mph peak, and a 40-minute recharge for extensive travel.");
        items[5][1][2] = new Item(36, "ECO CRUISE INFINITE", 10000.99, ProductCategory.LONGRANGE, "\n Tires: Kenda LR\n Suspension: Hybrid\n Available colors: Matte Grey\n Max Speed: 290 mph\n Charge time:45min\n Weight limit:135\n Description: In matte grey, with Kenda LR tires and hybrid suspension, hits 290 mph and recharges in 45 minutes for sustainable long-range travel.");

        //mongoManager.insertItem(item1);
        //mongoManager.insertItem(item2);

        for (Item[][] layer : items) {
            for (Item[] row : layer) {
                for (Item item : row) {
                    if (item != null) {
                        mongoManager.insertItem(item);
                    }
                }
            }
        }
    }

        // Add more items as needed

    public static void main(String[] args) {
        // Provide your MongoDB connection details
        String connectionString = "mongodb+srv://ganggang89001:@storefront.60uhwaz.mongodb.net/" +
                "\n";
        String databaseName = "Storefront";
        String collectionName = "Products";

        // Create a MongoManager instance
        MongoManager mongoManager = new MongoManager(connectionString, databaseName, collectionName);

        // Initialize and insert sample data
        initializeData(mongoManager);

        // Close the MongoDB client
        mongoManager.close();
    }
}

public class DataInitializer {

    public static void initializeData(MongoManager mongoManager) {
        // Create and insert sample items
        Item[][][] items = new Item[6][6][6];
        //items = new Item[6][6][6];            // possibly creating the twice intiailization error in MONGODB eat a bird fuckface
        // Initialize items here, creating 36 items and placing them in the 6x6x6 array.
        // add two to layer two


        // Layer 0
        items[0][0][0] = new Item(1, "APOLLO PRO", 199.99, ProductCategory.PERFORMANCE, "\n Tires: Michelin SPORT\n Suspension: Electronic\n Available colors: Grey\n Max Speed: 100 MPH\n Charge time: 30 min\n Weight limit: 150 lbs\n Description: APOLLO PRO: thrill-seekers’ dream. Michelin tires, 100 MPH, grey. Charge & zoom!\n ");
        items[0][0][1] = new Item(2, "ZERO 10X", 299.99, ProductCategory.PERFORMANCE, "\n Tires: Bridgestone SPORT\n Suspension: Dual Shock\n Available colors: Black\n Max Speed: 100 MPH \n Weight limit: 250 lbs\n Description: ZERO 10X: top performer. Bridgestone tires, dual shock, 100 MPH, black. Ride far!  ");
        items[0][0][2] = new Item(3, "THE JOE OAKES", 1000.00, ProductCategory.PERFORMANCE, "\n Tires: Continental SPORT\n Suspension: Air\n Available colors: Pink\n Max Speed: 250 MPH\n Weight limit: 350 lbs\n Description: THE JOE OAKES: pink performance scooter. Continental tires, air, 250 MPH. Wow! ");
        items[0][1][0] = new Item(4, "DUAL PED SCORPION", 499.99, ProductCategory.PERFORMANCE, "\n Tires: Pirelli SPORT\n Suspension: Inverted Front Forks\n Available colors: Yellow\n Max Speed: 300 MPH\n Weight limit: 450 lbs\n Description: DUAL PED SCORPION: yellow marvel. Pirelli tires, forks, 300 MPH. Thrill on! ");
        items[0][1][1] = new Item(5, "APOLLO", 599.99, ProductCategory.PERFORMANCE, "\n Tires: Dunlop SPORT\n Suspension: Gas Charged Rear Shocks\n Available colors: Green\n Max Speed: 350 MPH\n Weight limit: 600 lbs\n Description: APOLLO e-scooter: Dunlop tires, gas shocks, green, 350 MPH, 600 lbs limit.");
        items[0][1][2] = new Item(6, "WOLF WARRIOR 11", 699.99, ProductCategory.PERFORMANCE, "\n Tires: Kenda SPORT\n Suspension: Threadless Fork and Compression System\n Available colors: Purple\n Max Speed: 400 MPH\n Weight limit: 650 lbs\n Description: WOLF WARRIOR 11: Kenda tires, threadless fork, purple, 400 MPH, 650 lbs.");

// Layer 1
        items[1][0][0] = new Item(7, "E MOVE CRUISER", 350.99, ProductCategory.OFFROAD, "\n Tires: Michelin OFF\n Suspension: Magnetic\n Available colors: Teal\n Max Speed: 30 MPH\n Weight limit: 190 lbs\n Description: E MOVE CRUISER: Michelin tires, magnetic, teal, 30 MPH, 190 lbs. ");
        items[1][0][1] = new Item(8, "APOLLO PHANTOM", 360.99, ProductCategory.OFFROAD, "\n Tires: Bridgestone OFF\n Suspension: Telescopic Front Forks \n Available colors: Deep Blue\n Max Speed: 40 MPH\n Charge time: 1 Hr\n Weight limit: 200 lbs\n Description: APOLLO PHANTOM: off-road, Bridgestone, blue, 40 MPH, 1h charge, 200 lbs ");
        items[1][0][2] = new Item(9, "WOLF KING PRO", 370.99, ProductCategory.OFFROAD, "\n Tires: Continental OFF\n Suspension: Spring \n Available colors: Abyss Black\n Max Speed: 60 MPH\n Charge time: 49 min\n Weight limit: 300 lbs\n Description: WOLF KING PRO: Continental, spring, black, 60 MPH, 300 lbs, off-road ");
        items[1][1][0] = new Item(10, "E CITY", 380.99, ProductCategory.OFFROAD, "\n Tires: Pirelli OFF\n Suspension: Monoshock\n Available colors: Matte Black\n Max Speed: 70 MPH\n Charge time: 75 min\n Weight limit: 350 lbs\n Description: E CITY: Pirelli, monoshock, black, 70 MPH, 75m, 350 lbs, off-road ");
        items[1][1][1] = new Item(11, "Q1 HUMMER", 390.99, ProductCategory.OFFROAD, "\n Tires: Dunlop OFF\n Suspension: Hydraulic Friction Dampers \n Available colors: Magenta\n Max Speed: 90 MPH\n Charge time: 30 min\n Weight limit: 450 lbs\n Description: Q1 HUMMER: Dunlop, hydraulic, magenta, 90 MPH, 30m, 450 lbs, off-road ");
        items[1][1][2] = new Item(12, "EGO G BOOSTER", 400.99, ProductCategory.OFFROAD, "\n Tires: Kenda OFF\n Suspension: Heavy-Duty Coil Springs\n Available colors: Silver\n Max Speed: 100 MPH\n Charge time: 40 min\n Weight limit: 500 lbs\n Description: EGO G BOOSTER: 100 MPH, 40 min charge, 500 lbs. Off-road beast in silver. ");

// Layer 2
        items[2][0][0] = new Item(13, "Oae Joakes", 499.99, ProductCategory.URBAN, "\n Tires: Kenda URB \n Suspension: Hardtail \n Available colors: silver\n Max Speed: 125 MPH\n Charge time: 50 min\n Weight limit: 400 lbs\n Description: Oae Joakes: 125 MPH, 50 min charge, 400 lbs silver e-scooter.");
        items[2][0][1] = new Item(14, "URBAN CRUISER PRO", 560.99, ProductCategory.URBAN, "\n Tires: Bridgestone URB\n Suspension: Gas-Charged Rear Shocks\n Available colors: Platinum\n Max Speed: 150 MPH\n Charge time: 50 min\n Weight limit: 350 lbs\n Description: URBAN CRUISER PRO: 150 MPH, 50 min charge, 350 lbs. Platinum urban scooter. ");
        items[2][0][2] = new Item(15, "URBAN CRUISER", 670.99, ProductCategory.URBAN, "\n Tires: Continental URB\n Suspension: Polyurethane\n Available colors: Inferno Red\n Max Speed: 160 MPH\n Charge time: 45 min\n Weight limit: 365 lbs\n Description: URBAN CRUISER: 160 MPH, 45 min charge, 365 lbs. Inferno red city scooter. ");
        items[2][1][0] = new Item(16, "DOWNTOWN EXPRESS", 780.99, ProductCategory.URBAN, "\n Tires: Pirelli URB\n Suspension: Progressive Springs\n Available colors: Light Blue\n Max Speed: 170 MPH\n Charge time: 40 min\n Weight limit: 400 lbs\n Description: DOWNTOWN EXPRESS: 170 MPH, 40 min charge, 400 lbs. Light blue urban ride.");
        items[2][1][1] = new Item(17, "URBAN GLIDE 2", 890.99, ProductCategory.URBAN, "\n Tires: Dunlop URB\n Suspension: Hardtail\n Available colors: Off White\n Max Speed: 180 MPH\n Charge time: 35 min\n Weight limit: 500 lbs\n Description: URBAN GLIDE 2: sleek, fast, agile. Off-white, 180 MPH, 35 min charge, 500 lbs.");
        items[2][1][2] = new Item(18, "METRO JET", 900.99, ProductCategory.URBAN, "\n Tires: Kenda URB\n Suspension: Remote Reservoir\n Available colors: Egg Shell\n Max Speed: 190 MPH\n Charge time: 30 min\n Weight limit: 600 lbs\n Description: METRO JET: luxury, smoothness, sophistication. Eggshell, 190 MPH, 30 min, 600 lbs.");

// Layer 3
        items[3][0][0] = new Item(19, "MIDNIGHT CRUISER", 10000.99, ProductCategory.LUXURY, "\n Tires: Michelin LUX\n Suspension: Heavy-Duty Sidecar Suspension\n Available colors: Midnight Green\n Max Speed: 125 mph\n Charge time: 20 min\n Weight limit: 150 lbs\n Description: MIDNIGHT CRUISER: luxury, style, elegance. Midnight green, 125 MPH, LUX tires. ");
        items[3][0][1] = new Item(20, "PEARL ELEGANCE", 11000.99, ProductCategory.LUXURY, "\n Tires: Bridgestone LUX\n Suspension: Anti-Dive Suspension\n Available colors: Pearl White\n Max Speed: 130 mph\n Charge time: 25 min\n Weight limit: 160 lbs\n Description: PEARL ELEGANCE: sophistication, refinement, luxury. Pearl white, 130 MPH, LUX.");
        items[3][0][2] = new Item(21, "MAJESTIC VOYAGER", 12000.99, ProductCategory.LUXURY, "\n Tires: Continental LUX\n Suspension: Dual-Stage\n Available colors: Majestic Gold\n Max Speed: 150 mph\n Charge time: 33 min\n Weight limit: 170 lbs\n Description: MAJESTIC VOYAGER: opulent, gold, fast, comfy. LUX tires, dual suspension. ");
        items[3][1][0] = new Item(22, "BLOOD EXPLORER", 150000.99, ProductCategory.LUXURY, "\n Tires: Pirelli LUX\n Suspension: Adjustable Adventure\n Available colors: Blood Red\n Max Speed: 160 mph\n Charge time: 38 min\n Weight limit: 180 lbs\n Description: BLOOD EXPLORER: adventure, red, fast, fun. Pirelli LUX, adventure suspension.");
        items[3][1][1] = new Item(23, "SKY DREAMER", 200000.99, ProductCategory.LUXURY, "\n Tires: Dunlop LUX\n Suspension: Fork Cartridges\n Available colors: Sky Blue\n Max Speed: 170 mph\n Charge time: 40 min\n Weight limit: 200 lbs\n Description: SKY DREAMER: dreamy, blue, fast, luxe. Dunlop LUX, fork cartridges. ");
        items[3][1][2] = new Item(24, "CRYSTAL PRESTIGE", 500500.99, ProductCategory.LUXURY, "\n Tires: Kenda LUX\n Suspension: Trike-Specific\n Available colors: Crystal White\n Max Speed: 180 mph\n Charge time: 45 min\n Weight limit: 400 lbs\n Description: CRYSTAL PRESTIGE: luxury, white, fast, trike. Kenda LUX, trike suspension.");

// Layer 4
        items[4][0][0] = new Item(25, "AURORA ELITE", 3350.99, ProductCategory.CARGO, "\n Tires: Michelin CAR\n Suspension: Progressive Damping \n Available colors: Cyan\n Max Speed: 50 mph\n Charge time: 45 min\n Weight limit: 300 lbs\n Description: AURORA ELITE: cyan cargo scooter with CAR tires, 50 mph, 45 min charge.");
        items[4][0][1] = new Item(26, "CARGO VOYAGER", 3650.99, ProductCategory.CARGO, "\n Tires: Bridgestone CAR\n Suspension: Upside-Down (USD) Forks\n Available colors: Navy Blue\n Max Speed: 90 mph\n Charge time: 30 min\n Weight limit: 400 lbs\n Description: CARGO VOYAGER: navy cargo scooter, 90 mph, 30 min charge, CAR tires, USD forks.");
        items[4][0][2] = new Item(27, "REGAL SERIES", 3750.99, ProductCategory.CARGO, "\n Tires: Continental CAR\n Suspension: Remote Reservoir Suspensions\n Available colors: Deep Yellow\n Max Speed: 100 mph\n Charge time: 36 min\n Weight limit: 500 lbs\n Description: REGAL SERIES: yellow luxury cargo scooter, 100 mph, 36 min charge, CAR tires, RRS.");
        items[4][1][0] = new Item(28, "ELYSIAN PRO", 3850.99, ProductCategory.CARGO, "\n Tires: Pirelli CAR\n Suspension: Electronically Adjustable\n Available colors: Orange\n Max Speed: 109 mph\n Charge time: 20 min\n Weight limit: 600 lbs\n Description: ELYSIAN PRO: orange pro cargo scooter, 109 mph, 20 min charge, CAR tires, EAS.");
        items[4][1][1] = new Item(29, "ELYSIAN MAX", 3950.99, ProductCategory.CARGO, "\n Tires: Dunlop CAR\n Suspension: Dual Rear\n Available colors: Red\n Max Speed: 170 mph\n Charge time: 25 min\n Weight limit: 700 lbs\n Description: ELYSIAN MAX: Dunlop CAR tires, dual suspension, red, 170 mph, 25 min charge, 700 lbs cargo.");
        items[4][1][2] = new Item(30, "ELYSIAN GOLD", 4050.99, ProductCategory.CARGO, "\n Tires: Kenda CAR\n Suspension: Pneumatic Suspension\n Available colors: Blood Orange\n Max Speed: 180 mph\n Charge time: 15 min\n Weight limit: 800 lbs\n Description: ELYSIAN GOLD: Kenda tires, orange, 180mph, 15 min charge, 800 lbs cargo.");

// Layer 5
        items[5][0][0] = new Item(31, "ENDURANCE VOYAGER", 5050.99, ProductCategory.LONGRANGE, "\n Tires: Michelin LR\n Suspension: Lever-Link\n Available colors: Light Green\n Max Speed: 200 mph\n Charge time: 30 min\n Weight limit: 300 lbs\n Description: ENDURANCE VOYAGER: Michelin tires, Lever-Link suspension, green, 200 mph.");
        items[5][0][1] = new Item(32, "THE ODYSSEY", 6080.99, ProductCategory.LONGRANGE, "\n Tires: Bridgestone LR\n Suspension: Semi-Active\n Available colors: Light Grey\n Max Speed: 250 mph\n Charge time: 33 min\n Weight limit: 200 lbs\n Description: THE ODYSSEY: epic adventures, Bridgestone tires, 250 mph, light grey.");
        items[5][0][2] = new Item(33, "MARATHON EXPLORER PRO", 7050.99, ProductCategory.LONGRANGE, "\n Tires: Continental LR\n Suspension: Carbon Fiber Coil\n Available colors: Light Yellow\n Max Speed: 260 mph\n Charge time: 36 min\n Weight limit: 196 lbs\n Description: MARATHON EXPLORER PRO: long-range, Continental tires, 260 mph, yellow.");
        items[5][1][0] = new Item(34, "MARATHON EXPLORER", 8750.99, ProductCategory.LONGRANGE, "\n Tires: Pirelli LR\n Suspension: Progressive Linkage\n Available colors: Matte Yellow\n Max Speed: 270 mph\n Charge time: 38 min\n Weight limit: 155 lbs\n Description: MARATHON EXPLORER: Pirelli tires, 270 mph, matte yellow, long trips.");
        items[5][1][1] = new Item(35, "RANGE MASTER", 9759.99, ProductCategory.LONGRANGE, "\n Tires: Dunlop LR\n Suspension: Rebound Adjustable\n Available colors: Matte White\n Max Speed: 280 mph\n Charge time: 40 min\n Weight limit: 145 lbs\n Description: RANGE MASTER: Dunlop tires, 280 mph, matte white, long-range.");
        items[5][1][2] = new Item(36, "ECO CRUISE INFINITE", 10000.99, ProductCategory.LONGRANGE, "\n Tires: Kenda LR\n Suspension: Hybrid\n Available colors: Matte Grey\n Max Speed: 290 mph\n Charge time: 45 min\n Weight limit: 135 lbs\n Description: ECO CRUISE INFINITE: Kenda LR, hybrid, matte grey. 290 mph, eco-friendly. ");

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

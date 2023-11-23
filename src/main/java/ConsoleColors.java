public class ConsoleColors {
    // ANSI escape codes for text color
    public static final String RESET = "\033[0m";
    public static final String RED = "\033[91m";
    public static final String GREEN = "\033[92m";

    // ANSI escape codes for text formatting
    public static final String BOLD = "\033[1m";

    public static void main(String[] args) {
        System.out.println(RED + "This is red text" + RESET);
        System.out.println(GREEN + "This is green text" + RESET);
        System.out.println(BOLD + "This is bold text" + RESET);

        // You can combine formatting options
        System.out.println(BOLD + RED + "This is bold red text" + RESET);
    }
}

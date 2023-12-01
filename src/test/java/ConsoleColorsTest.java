import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsoleColorsTest {

    @Test
    public void testColorFormatting() {
        // Test red color formatting
        assertEquals("\033[91mThis is red text\033[0m", ConsoleColors.RED + "This is red text" + ConsoleColors.RESET);

        // Test green color formatting
        assertEquals("\033[92mThis is green text\033[0m", ConsoleColors.GREEN + "This is green text" + ConsoleColors.RESET);

        // Test bold formatting
        assertEquals("\033[1mThis is bold text\033[0m", ConsoleColors.BOLD + "This is bold text" + ConsoleColors.RESET);

        // You can add more test cases for other formatting options
    }
}

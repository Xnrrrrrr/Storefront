import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductCategoryTest {

    @Test
    public void testProductCategoryValues() {
        // Test if all values are present in the enum
        assertEquals(6, ProductCategory.values().length);

        // Test individual values
        assertEquals(ProductCategory.PERFORMANCE, ProductCategory.valueOf("PERFORMANCE"));
        assertEquals(ProductCategory.OFFROAD, ProductCategory.valueOf("OFFROAD"));
        assertEquals(ProductCategory.URBAN, ProductCategory.valueOf("URBAN"));
        assertEquals(ProductCategory.LUXURY, ProductCategory.valueOf("LUXURY"));
        assertEquals(ProductCategory.CARGO, ProductCategory.valueOf("CARGO"));
        assertEquals(ProductCategory.LONGRANGE, ProductCategory.valueOf("LONGRANGE"));
    }

    // Add more test cases as needed
}

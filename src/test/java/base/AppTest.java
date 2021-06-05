package base;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    public void output_string_is_formatted_properly() {
        App myApp = new App();

        double subtotal = 64;
        double tax = 3.52;
        double total = 67.52;

        String expectedOutput = String.format("Subtotal: $64.00%nTax: $3.52%nTotal: $67.52");
        String actualOutput = myApp.generateOutputString(subtotal, tax, total);

        assertEquals(expectedOutput, actualOutput);
    }


}
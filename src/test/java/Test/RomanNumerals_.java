package Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import model.RomanNumerals;
import org.junit.Before;
import org.junit.Test;

public class RomanNumerals_ {
    private String roman1;
    private int number1;
    private String roman2;
    private int number2;
    private RomanNumerals romanNumerals;
    @Before
    public void setUp() {
        romanNumerals = new RomanNumerals();
        roman1 = "X";
        number1 = 10;
        roman2 = "XX";
        number2= 20;
    }

    @Test
    public void is_X_equals_to_ten() {
        assertThat(romanNumerals.toInt(roman1)).isEqualTo(10);
    }
    @Test
    public void is_ten_equals_to_X() {
        assertThat(romanNumerals.toRoman(number1)).isEqualTo("X");
    }
    @Test
    public void is_XX_equals_to_twenty() {
        assertThat(romanNumerals.toInt(roman2)).isEqualTo(20);
    }
    @Test
    public void is_twenty_equals_to_XX() {
        assertThat(romanNumerals.toRoman(number2)).isEqualTo("XX");
    }

}
package Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import model.RomanNumerals;
import org.junit.Before;
import org.junit.Test;

public class RomanNumerals_ {
    private String roman1;
    private int number1;
    private String roman2;
    private int number2;
    private String roman3;
    private int number3;
    private RomanNumerals romanNumerals;

    @Before
    public void setUp() {
        romanNumerals = new RomanNumerals();
        roman1 = "X";
        number1 = 10;
        roman2 = "XX";
        number2 = 20;
        roman3 = "MDCLXVI";
        number3 = 1990;
    }

    @Test
    public void is_X_equals_to_ten() {
        assertThat(romanNumerals.toArabic(roman1)).isEqualTo(10);
    }

    @Test
    public void is_ten_equals_to_X() {
        assertThat(romanNumerals.toRoman(number1)).isEqualTo("X");
    }

    @Test
    public void is_XX_equals_to_twenty() {
        assertThat(romanNumerals.toArabic(roman2)).isEqualTo(20);
    }

    @Test
    public void is_twenty_equals_to_XX() {
        assertThat(romanNumerals.toRoman(number2)).isEqualTo("XX");
    }

    @Test
    public void is_MDCLXVI_equals_to_1666() {
        assertThat(romanNumerals.toArabic(roman3)).isEqualTo(1666);
    }

    @Test
    public void is_1990_equals_to_MCMXC() {
        assertThat(romanNumerals.toRoman(number3)).isEqualTo("MCMXC");
    }

}
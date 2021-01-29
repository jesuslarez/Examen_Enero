package model;

import java.util.TreeMap;

public class RomanNumerals {
    private final TreeMap<Integer, String> romanMap = new TreeMap<>();
    private final TreeMap<String, Integer> arabicMap = new TreeMap<>();
    private int arabicValue;
    private String romanValue;

    public RomanNumerals() {
        romanValue = "";
        arabicValue = 0;
        romanMap.put(1000, "M");
        romanMap.put(900, "CM");
        romanMap.put(500, "D");
        romanMap.put(400, "CD");
        romanMap.put(100, "C");
        romanMap.put(90, "XC");
        romanMap.put(50, "L");
        romanMap.put(40, "XL");
        romanMap.put(10, "X");
        romanMap.put(9, "IX");
        romanMap.put(5, "V");
        romanMap.put(4, "IV");
        romanMap.put(1, "I");

        arabicMap.put("M", 1000);
        arabicMap.put("CM", 900);
        arabicMap.put("D", 500);
        arabicMap.put("CD", 400);
        arabicMap.put("C", 100);
        arabicMap.put("XC", 90);
        arabicMap.put("L", 50);
        arabicMap.put("XL", 40);
        arabicMap.put("X", 10);
        arabicMap.put("IX", 9);
        arabicMap.put("V", 5);
        arabicMap.put("IV", 4);
        arabicMap.put("I", 1);
    }

    public String toRoman(int number) {
        int floorKey = romanMap.floorKey(number);
        if (number == floorKey) return romanMap.get(number);
        return romanMap.get(floorKey) + toRoman(number - floorKey);
    }

    public int toArabic(String roman) {
        romanValue = roman;
        for (int i = 0; i < romanValue.length(); i++) {
            int symbol1 = getIntegerValue(romanValue, i);
            i = getNextIncrement(i, symbol1);
        }
        return arabicValue;
    }

    private int getNextIncrement(int i, int symbol1) {
        if (i + 1 < romanValue.length()) {
            int symbol2 = getIntegerValue(romanValue, i + 1);
            i += compareValues(symbol1, symbol2);
        } else arabicValue += symbol1;
        return i;
    }

    private int compareValues(int s1, int s2) {
        if (s1 >= s2) arabicValue += s1;
        else {
            arabicValue += s2 - s1;
            return 1;
        }
        return 0;
    }

    private Integer getIntegerValue(String romanNumber, int i) {
        return arabicMap.get(String.valueOf(romanNumber.charAt(i)));
    }
}

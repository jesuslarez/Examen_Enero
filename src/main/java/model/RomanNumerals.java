package model;

import java.util.TreeMap;

public class RomanNumerals {
    /*
    Cree una clase RomanNumerals que pueda convertir un número romano en un valor entero, o un entero a números romanos

     */
    private TreeMap<Integer, String> romanMap = new TreeMap<>();
    private TreeMap<String, Integer> intMap = new TreeMap<>();
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

        intMap.put("M", 1000);
        intMap.put("CM", 900);
        intMap.put("D", 500);
        intMap.put("CD", 400);
        intMap.put("C", 100);
        intMap.put("XC", 90);
        intMap.put("L", 50);
        intMap.put("XL", 40);
        intMap.put("X", 10);
        intMap.put("IX", 9);
        intMap.put("V", 5);
        intMap.put("IV", 4);
        intMap.put("I", 1);
    }

    public String toRoman(int number) {
        int floorKey = romanMap.floorKey(number);
        if (number == floorKey) return romanMap.get(number);
        return romanMap.get(floorKey) + toRoman(number - floorKey);
    }

    public int toArabic(String s) {
        romanValue = s;
        for (int i = 0; i < romanValue.length(); i++) {
            int symbol1 = getIntegerValue(romanValue, i);
            i = getNexValue(i, symbol1);
        }
        return arabicValue;
    }

    private int getNexValue(int i, int symbol1) {
        if (i + 1 < romanValue.length()) {
            int symbol2 = getIntegerValue(romanValue, i + 1);
            i = compareValues(i, symbol1, symbol2);
        } else arabicValue += symbol1;
        return i;
    }

    private int compareValues(int i, int s1, int s2) {
        if (s1 >= s2) arabicValue += s1;
        else {
            arabicValue += s2 - s1;
            i++;
        }
        return i;
    }

    private Integer getIntegerValue(String romanNumber, int i) {
        return intMap.get(String.valueOf(romanNumber.charAt(i)));
    }
}

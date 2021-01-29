package model;

import java.util.TreeMap;

public class RomanNumerals {
    /*
    Cree una clase RomanNumerals que pueda convertir un número romano en un valor entero, o un entero a números romanos

     */
    private TreeMap<Integer, String> romanMap = new TreeMap<>();
    private TreeMap<String, Integer> intMap = new TreeMap<>();

    public RomanNumerals() {
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

    public int toArabic(String romanNumber) {
        int result = 0;
        for (int i = 0; i < romanNumber.length(); i++) {
            int s1 = getIntegerValue(romanNumber, i);
            if (i + 1 < romanNumber.length()) {
                int s2 = getIntegerValue(romanNumber, i + 1);
                if (s1 >= s2) {
                    result += s1;
                } else {
                    result += s2 - s1;
                    i++;
                }
            } else {
                result += s1;
            }
        }
        return result;
    }

    private Integer getIntegerValue(String romanNumber, int i) {
        return intMap.get(String.valueOf(romanNumber.charAt(i)));
    }

    public String toRoman(int number) {
        int l = romanMap.floorKey(number);
        if (number == l) return romanMap.get(number);
        return romanMap.get(l) + toRoman(number - l);
    }
}

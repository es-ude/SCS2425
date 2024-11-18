package org.example;

import kotlin.Pair;

import java.util.List;
import java.util.ArrayList;

public class RomanNumeralEncoder {
    private enum Numerals {
        Zero(' ', 0),
        One('I', 1),
        Five('V', 5),
        Ten('X', 10),
        Fifty('L', 50),
        Hundred('C', 100),
        FiveHundred('D', 500),
        Thousand('M', 1000);

        public final Character Label;
        public final Integer Value;

        Numerals(Character label, Integer value) {
            this.Label = label;
            this.Value = value;
        }
    }

    private static Pair<Numerals, Numerals>[] alphabet = new Pair[] {
            new Pair(Numerals.One, Numerals.Five),
            new Pair(Numerals.Ten, Numerals.Fifty),
            new Pair(Numerals.Hundred, Numerals.FiveHundred),
            new Pair(Numerals.Thousand, Numerals.Zero),
    };

    public static String encode(int number) {
        if (number < 0 || number > 3999) {
            throw new IllegalArgumentException("Invalid number: " + number);
        }

        int remainder = number;
        int decimalPlaces = String.valueOf(number).length() - 1;
        StringBuilder romanNumeral = new StringBuilder();

        while (remainder > 0) {
            int currentDecimalPlace = remainder / (int)Math.pow(10, decimalPlaces);

            romanNumeral.append(
                    numberToRomanNumeralString(currentDecimalPlace, decimalPlaces)
            );

            remainder = remainder % (int)Math.pow(10, decimalPlaces);
            decimalPlaces--;
        }
        return romanNumeral.toString();
    }

    public static int decode(String romanNumeral) {
        int totalSum = 0;
        int i = 0;

        while (i < romanNumeral.length()) {
            Numerals current = charToNumeral(romanNumeral.charAt(i));

            if (i == romanNumeral.length() - 1) {
                totalSum += current.Value;
                break;
            }

            // Look ahead to recognize patterns like `IV`
            Numerals next = charToNumeral(romanNumeral.charAt(i + 1));

            if (current.Value < next.Value) {
                totalSum += (next.Value - current.Value);
                i += 2;
            } else {
                // Can only add one to total, as to not destroy potential upcoming pattern
                totalSum += current.Value;
                i += 1;
            }
        }

        return totalSum;
    }

    private static String numberToRomanNumeralString(int number, int decimalPlace) throws NullPointerException {
        StringBuilder romanNumeralString = new StringBuilder();
        Pair<Numerals, Numerals> subAlphabet = alphabet[decimalPlace];
        Pair<Numerals, Numerals> nextSubAlphabet = null;

        if (decimalPlace + 1 < alphabet.length) {
            nextSubAlphabet = alphabet[decimalPlace + 1];
        }

        switch (number) {
            case 1, 2, 3:
                for (int i = 0; i < number; i++) {
                    romanNumeralString.append(subAlphabet.getFirst().Label);
                }
                break;
            case 4:
                romanNumeralString.append(subAlphabet.getFirst().Label);
                romanNumeralString.append(subAlphabet.getSecond().Label);
                break;
            case 5:
                romanNumeralString.append(subAlphabet.getSecond().Label);
                break;
            case 6, 7, 8:
                romanNumeralString.append(subAlphabet.getSecond().Label);
                for (int i = 0; i < number - 5; i++) {
                    romanNumeralString.append(subAlphabet.getFirst().Label);
                }
                break;
            case 9:
                romanNumeralString.append(subAlphabet.getFirst().Label);
                romanNumeralString.append(nextSubAlphabet.getFirst().Label);
                break;
            default:
                break;
        }
        return romanNumeralString.toString();
    }

    private static Numerals charToNumeral(char c) {
        return switch (c) {
            case 'I' -> Numerals.One;
            case 'V' -> Numerals.Five;
            case 'X' -> Numerals.Ten;
            case 'L' -> Numerals.Fifty;
            case 'C' -> Numerals.Hundred;
            case 'D' -> Numerals.FiveHundred;
            default -> Numerals.Zero;
        };
    }
}

package com.example.generaltemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class TwoNumMath {
    /*
    Precondition:
    User inputs 2 strings that could be integers or decimals

    returns if first string number is divisible by second string number
     */
    public String getIfAIsDivisibleByB(String num1, String num2) {
        // For some reason 2 is divisible by 6
        return "";
//        if (num2.equals("0")) {
//            return "false";
//        }
//        return String.valueOf(Integer.parseInt(num1) % Integer.parseInt(num2) == 0);
    }


    /*
    Precondition:
    User inputs 3 strings:
    The first two are the numbers to divide
    The third is the type of output the user wants (D is decimal, P is proper fraction, I is improper fraction)

    returns the first input divided by the second input in the 3rd input format
     */
    public String divide(String num1, String num2, String outputType) {
        return switch (outputType) {
            case "D" -> divideInDecimals(num1, num2);
            case "P", "I" -> divideInFractions(num1, num2, outputType);
            default -> null;
        };
    }

    private String divideInDecimals(String num1, String num2) {
        BigDecimal num1Decimal = new BigDecimal(num1);
        BigDecimal num2Decimal = new BigDecimal(num2);
        return num1Decimal.divide(num2Decimal, 2, RoundingMode.HALF_UP).stripTrailingZeros().toString();
    }

    private String divideInFractions(String numerator, String denominator, String type) {
        if (numerator.equals("12") && Objects.equals(type, "I")) {
            String foo = "1";
        }
        OneNumMath oneNumMath = new OneNumMath();
        String numeratorPrimeFactors = oneNumMath.primeFactorizationOfNum(numerator);
        String denominatorPrimeFactors = oneNumMath.primeFactorizationOfNum(denominator);
        if (!(numeratorPrimeFactors.equals("Not possible") || denominatorPrimeFactors.equals("Not possible"))) {
            ArrayList<String> numeratorPrimeFactorsArray = turnStringIntoArray(numeratorPrimeFactors);
            ArrayList<String> denominatorPrimeFactorsArray = turnStringIntoArray(denominatorPrimeFactors);
            ArrayList<String> NumToRemoveInNumeratorPrimeFactorsArray = new ArrayList<>();
            for (int numInd = 0; numInd < numeratorPrimeFactorsArray.size(); numInd++) {
                if (numInd > denominatorPrimeFactorsArray.size()) {
                    break;
                }
                if (denominatorPrimeFactorsArray.contains(numeratorPrimeFactorsArray.get(numInd))) {
                    denominatorPrimeFactorsArray.remove(numeratorPrimeFactorsArray.get(numInd));
                    NumToRemoveInNumeratorPrimeFactorsArray.add(numeratorPrimeFactorsArray.get(numInd));
                }
            }
            numeratorPrimeFactorsArray.removeAll(NumToRemoveInNumeratorPrimeFactorsArray);
            numerator = String.valueOf(multiplyAllNumsInAList(numeratorPrimeFactorsArray));
            denominator = String.valueOf(multiplyAllNumsInAList(denominatorPrimeFactorsArray));
        }

        int numeratorInt = Integer.parseInt(numerator);
        int denominatorInt = Integer.parseInt(denominator);
        if (type.equals("I") || (type.equals("P") && (numeratorInt<denominatorInt) || numeratorInt-(denominatorInt*(numeratorInt/denominatorInt)) == 0)) {
            return numerator + getBottomPart(numerator, denominator);
        } else if (type.equals("P")) {
            return (numeratorInt/denominatorInt) + " " + (numeratorInt-(denominatorInt*(numeratorInt/denominatorInt))) + getBottomPart(numerator, denominator);
        }
        return null;
    }

    private String getBottomPart(String numerator, String denominator) {
        if (denominator.equals("1") || (Integer.parseInt(numerator) % Integer.parseInt(denominator) == 0)) {
            return "";
        }
        return "/" + denominator;
    }

    private int multiplyAllNumsInAList(ArrayList<String> listToMultiply) {
        int result = 1;
        for (String element: listToMultiply) {
            result *= Integer.parseInt(element);
        }
        return result;
    }

    private ArrayList<String> turnStringIntoArray(String strInput) {
        ArrayList<String> result = new ArrayList<>(Arrays.asList(strInput.split(", ")));
        // Removes the brackets from split array
        result.set(0, result.get(0).substring(1));
        result.set(result.size()-1, result.get(result.size()-1).substring(0, result.get(result.size()-1).length()-1));
        return result;
    }

    public String getGCF(String num1, String num2) {
        return "";
    }
}

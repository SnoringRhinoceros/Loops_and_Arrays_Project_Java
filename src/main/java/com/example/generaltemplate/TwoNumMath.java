package com.example.generaltemplate;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class TwoNumMath {
    /*
    Precondition:
    User inputs 2 strings that could be integers or decimals

    returns if first string number is divisible by second string number
     */
    public String getIfAIsDivisibleByB(String num1, String num2) {
        return "";
    }

    public String divide(String num1, String num2, String outputType) {
        if (outputType.equals("D")) {
           return divideInDecimals(num1, num2);
        } else if (outputType.equals("P")) {
            return divideInReducedProperFractions(num1, num2);
        } else if (outputType.equals("I")) {
            return divideInReducedImproperFractions(num1, num2);
        }
        return null;
    }

    /*
    Precondition:
    User inputs 2 strings that could contain integers or decimals

    returns the first string divided by the second string
     */
    private String divideInDecimals(String num1, String num2) {
        BigDecimal num1Decimal = new BigDecimal(num1);
        BigDecimal num2Decimal = new BigDecimal(num2);
        return num1Decimal.divide(num2Decimal, 2, RoundingMode.HALF_UP).stripTrailingZeros().toString();
    }

    private String divideInReducedImproperFractions(String num1, String num2) {
        return "";
    }

    private String divideInReducedProperFractions(String num1, String num2) {
        return "";
    }

    public String getGCF(String num1, String num2) {
        return "";
    }
}

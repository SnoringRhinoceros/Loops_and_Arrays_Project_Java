package com.example.generaltemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;

public class TwoNumMath {
    /*
    Precondition:
    User inputs 2 strings that are integers

    returns if first string number is divisible by second string number
     */
    public String getIfAIsDivisibleByB(String num1, String num2) {
        if (num2.equals("0")) {
            return "false";
        }
        return String.valueOf(Integer.parseInt(num1) % Integer.parseInt(num2) == 0);
    }


    /*
    Precondition:
    User inputs 3 strings:
    The first two are the numbers to divide
    The third is the type of output the user wants (D means decimal, P means proper fraction, I means improper fraction)

    returns the first input divided by the second input in the 3rd input format
     */
    public String divide(String num1, String num2, String outputType) {
        if (num2.equals("0")) {
            return "Not possible";
        }
        return switch (outputType) {
            case "D" -> divideInDecimals(num1, num2);
            case "P", "I" -> divideInFractions(num1, num2, outputType);
            default -> "invalid 3rd parameter";
        };
    }

    private String divideInDecimals(String num1, String num2) {
        double num1Double = Double.parseDouble(num1);
        double num2Double = Double.parseDouble(num2);
        return round(num1Double/num2Double, 2);
    }

    private String round(double num, int nearestPlace) {
        String result = String.valueOf(Math.round(num*Math.pow(10, nearestPlace))/(Math.pow(10, nearestPlace)));
        return result.contains(".0") ? String.valueOf((int)Double.parseDouble(result)) : result;
    }


    private String divideInFractions(String numerator, String denominator, String type) {
        OneNumMath oneNumMath = new OneNumMath();
        int numeratorInt = Integer.parseInt(numerator);
        int denominatorInt = Integer.parseInt(denominator);
        String denominatorPrimeFactors = oneNumMath.primeFactorizationOfNum(denominator);
        ArrayList<String> denominatorPrimeFactorsArray = turnStringIntoArray(denominatorPrimeFactors);
        ArrayList<String> notCanceledDenominatorPrimeFactorsArray = new ArrayList<>();
        if (!denominatorPrimeFactors.equals("Not possible")) {
            for (String primeFactor: denominatorPrimeFactorsArray) {
                int primeFactorInt = Integer.parseInt(primeFactor);
                if (numeratorInt % primeFactorInt == 0) {
                    numeratorInt /= primeFactorInt;
                } else {
                    notCanceledDenominatorPrimeFactorsArray.add(primeFactor);
                }
            }
            denominatorInt = multiplyAllNumsInAList(notCanceledDenominatorPrimeFactorsArray);
        }
        if (type.equals("I")) {
            return getFractionPart(numeratorInt, denominatorInt);
        } else if (type.equals("P")) {
            return reduceFraction(numeratorInt, denominatorInt);
        }
        return null;
    }

    private String reduceFraction(int numerator, int denominator) {
        return getFrontNum(numerator, denominator) + getFractionPart(numerator-((numerator/denominator) * denominator), denominator);
    }

    private String getFractionPart(int numerator, int denominator) {
        if (numerator == 0) {
            return "";
        }
        return numerator + getBottomPart(denominator);
    }

    private String getFrontNum(int numerator, int denominator) {
        if (numerator/denominator == 0) {
            return "";
        }
        return numerator/denominator + " ";
    }

    private String getBottomPart(int denominator) {
        if (denominator == 1) {
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

    private ArrayList<String> getCommonPrimeFactors(String num1, String num2) {
        OneNumMath oneNumMath = new OneNumMath();
        String num1PrimeFactors = oneNumMath.primeFactorizationOfNum(num1);
        String num2PrimeFactors = oneNumMath.primeFactorizationOfNum(num2);
        ArrayList<String> num1PrimeFactorsArray = turnStringIntoArray(num1PrimeFactors);
        ArrayList<String> num2PrimeFactorsArray = turnStringIntoArray(num2PrimeFactors);
        ArrayList<String> commonPrimeFactors = new ArrayList<>();
        for (int numInd = 0; numInd < num1PrimeFactorsArray.size(); numInd++) {
            if (numInd > num2PrimeFactorsArray.size()) {
                break;
            }
            if (myOwnContainsMethod(num2PrimeFactorsArray, num1PrimeFactorsArray.get(numInd))) {
                num2PrimeFactorsArray.remove(num1PrimeFactorsArray.get(numInd));
                commonPrimeFactors.add(num1PrimeFactorsArray.get(numInd));
            }
        }
        return commonPrimeFactors;
    }

    private boolean myOwnContainsMethod(ArrayList<String> array1, String elementToFind) {
        for (String element: array1) {
            if (element.equals(elementToFind)) {
                return true;
            }
        }
        return false;
    }

    /*
    Precondition:
    User inputs 2 strings
    Both strings must be positive integers

    returns the greatest common factor of the two inputs or none if there is none
     */
    public String getGCF(String num1, String num2) {
        return String.valueOf(multiplyAllNumsInAList(getCommonPrimeFactors(num1, num2))).equals("1") ? "none" : String.valueOf(multiplyAllNumsInAList(getCommonPrimeFactors(num1, num2)));
    }
}

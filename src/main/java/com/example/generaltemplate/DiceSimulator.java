package com.example.generaltemplate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;

public class DiceSimulator {

    private int generateRandNum(int minInc, int maxInc) {
        return minInc + (int) (Math.random()*((maxInc - minInc) + 1));
    }
    /*
    Precondition:
    User inputs 3 strings:
    First string is a positive integer of how many faces there are on each die
    Second string is a positive integer of how many dice there are in total
    Third string is a positive integer of how many times they want to roll

    returns the sum of input2 dice with input1 faces input3 times as a string containing an array
     */
    public String roll(String faces, String numDice, String rolls) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int roll=0; roll < Integer.parseInt(rolls); roll++) {
            int sum = 0;
            for (int dice=0; dice < Integer.parseInt(numDice); dice++) {
                sum += generateRandNum(1, Integer.parseInt(faces));
            }
            result.add(sum);
        }
        return result.toString();
    }

    /*
    Precondition:
    User inputs 3 strings:
    First string is a positive integer of how many faces there are on each die
    Second string is a positive integer of how many dice there are in total
    Third string is a positive integer of how many times they want to roll

    Simulates rolling the die (the sum of input2 dice with input1 faces input3 times as a string containing an array)
    returns the minimum, maximum, and average of die rolled
     */
    public String minMaxAndAvg(String faces, String numDice, String rolls) {
        ArrayList<String> allRolls = turnStringIntoArray(roll(faces, numDice, rolls));
        int min = (int) Double.POSITIVE_INFINITY;
        int max = 0;
        int sum = 0;
        for (String roll: allRolls) {
            int rollInt = Integer.parseInt(roll);
            if (rollInt < min) {
                min = rollInt;
            }
            if (rollInt > max) {
                max = rollInt;
            }
            sum += rollInt;
        }
        BigDecimal avg = new BigDecimal(sum);
        avg = avg.divide(BigDecimal.valueOf(allRolls.size()), 2, RoundingMode.HALF_UP).stripTrailingZeros();
        return "Min=" + min + ", Max=" + max + " , Avg=" + avg;
    }

    private ArrayList<String> turnStringIntoArray(String strInput) {
        ArrayList<String> result = new ArrayList<>(Arrays.asList(strInput.split(", ")));
        // Removes the brackets from split array
        result.set(0, result.get(0).substring(1));
        result.set(result.size()-1, result.get(result.size()-1).substring(0, result.get(result.size()-1).length()-1));
        return result;
    }

    public String howManyOfEachSum(String faces, String dice, String rolls) {
        return "";
    }

    public String weightedRoll(String faces, String rolls, String probOfWeightedFace, String whichFaceIsWeighted) {
        return "";
    }

}

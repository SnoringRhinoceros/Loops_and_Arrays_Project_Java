package com.example.generaltemplate;

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

    returns the sum of input2 randomly rolled dice with input1 faces input3 times as a string containing an array
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

    Simulates rolling the die (the sum of input2 randomly rolled dice with input1 faces input3 times as a string containing an array)
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
        TwoNumMath twoNumMath = new TwoNumMath();
        String avg = twoNumMath.divide(String.valueOf(sum), String.valueOf(allRolls.size()), "D");
        return "Min=" + min + ", Max=" + max + ", Avg=" + avg;
    }

    private ArrayList<String> turnStringIntoArray(String strInput) {
        ArrayList<String> result = new ArrayList<>(Arrays.asList(strInput.split(", ")));
        // Removes the brackets from split array
        result.set(0, result.get(0).substring(1));
        result.set(result.size()-1, result.get(result.size()-1).substring(0, result.get(result.size()-1).length()-1));
        return result;
    }

    /*
    Precondition:
    User inputs 3 strings:
    First string is a positive integer of how many faces there are on each die
    Second string is a positive integer of how many dice there are in total
    Third string is a positive integer of how many times they want to roll

    Simulates rolling the die (the sum of input2 randomly rolled dice with input1 faces input3 times as a string containing an array)
    returns how many times the sum of the die is equal to each possible sum in a string containing an array

    Example: roll 2 die 20 times.
    Should give you an array with spots for sums 2-12
    and the numbers in those spots represent the total number rolls that produced that sum.
     */
    public String howManyOfEachSum(String faces, String numDice, String rolls) {
        ArrayList<String> allRolls = turnStringIntoArray(roll(faces, numDice, rolls));
        ArrayList<Integer> result = new ArrayList<>();
        String minAndMax = minMaxAndAvg(faces, numDice, rolls);
        int min = Integer.parseInt(minAndMax.substring(minAndMax.indexOf("Min=")+3+1, minAndMax.indexOf(", Max")));
        int max = Integer.parseInt(minAndMax.substring(minAndMax.indexOf("Max=")+3+1, minAndMax.indexOf(", Avg")));
        for (int currentNum = min; currentNum <= max; currentNum++) {
            int timesSame = 0;
            for (String roll: allRolls) {
                if (Integer.parseInt(roll) == currentNum) {
                    timesSame++;
                }
            }
            result.add(timesSame);
        }
        return result.toString();
    }

    private String howManyOfEachSum(String faces, String numDice, String rolls, ArrayList<String> allRolls) {
        ArrayList<Integer> result = new ArrayList<>();
        String minAndMax = minMaxAndAvg(faces, numDice, rolls);
        int min = Integer.parseInt(minAndMax.substring(minAndMax.indexOf("Min=")+3+1, minAndMax.indexOf(", Max")));
        int max = Integer.parseInt(minAndMax.substring(minAndMax.indexOf("Max=")+3+1, minAndMax.indexOf(", Avg")));
        for (int currentNum = min; currentNum <= max; currentNum++) {
            int timesSame = 0;
            for (String roll: allRolls) {
                if (Integer.parseInt(roll) == currentNum) {
                    timesSame++;
                }
            }
            result.add(timesSame);
        }
        return result.toString();
    }

    /*
    Precondition:
    User inputs 4 strings:
    First string is a positive integer of how many faces there are on each die
    Second string is a positive integer of how many dice there are in total
    Third string is a percentage between 1-100 inclusive (without the % sign) that the weighted face will show
    Fourth string is a positive integer between 1-First string inclusive that designates which face is weighted

    Simulates rolling a weighted die with input1 faces input2 times and a weighted face of input4 that appears input3 percent of the time
    returns a string containing an array of how many times each value is rolled
     */
    public String weightedRoll(String faces, String rolls, String probOfWeightedFace, String whichFaceIsWeighted) {
        ArrayList<String> allRolls = new ArrayList<>();
        for (int rollNum=0; rollNum<Integer.parseInt(rolls); rollNum++) {
            if (generateRandNum(1, 100) <= Integer.parseInt(probOfWeightedFace)) {
                allRolls.add(whichFaceIsWeighted);
            } else {
                int randNum = generateRandNum(1, Integer.parseInt(faces)-1);
                if (randNum >= Integer.parseInt(whichFaceIsWeighted)) {
                    randNum++;
                }
                allRolls.add(String.valueOf(randNum));
            }
        }

        return howManyOfEachSum(faces, "1", "1000000", allRolls);
    }
}

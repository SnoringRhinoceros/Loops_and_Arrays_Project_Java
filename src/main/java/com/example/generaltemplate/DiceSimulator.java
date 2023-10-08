package com.example.generaltemplate;

import java.util.ArrayList;

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
    public String roll(String faces, String diceNum, String rolls) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int roll=0; roll < Integer.parseInt(rolls); roll++) {
            int sum = 0;
            for (int placeholder=0; placeholder < Integer.parseInt(diceNum); placeholder++) {
                sum += generateRandNum(1, Integer.parseInt(faces));
            }
            result.add(sum);
        }
        return result.toString();
    }

    public String minMaxAndAvg(String faces, String dice, String rolls) {
        return "";
    }

    public String howManyOfEachSum(String faces, String dice, String rolls) {
        return "";
    }

    public String weightedRoll(String faces, String rolls, String probOfWeightedFace, String whichFaceIsWeighted) {
        return "";
    }

}

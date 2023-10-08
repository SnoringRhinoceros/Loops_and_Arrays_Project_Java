package com.example.generaltemplate;

import java.util.ArrayList;

public class OneNumMath {

    /*
    Method 1a

    Precondition:
    User inputs a string of the integer that they want the multiple of
    and another string of how many multiples of that number they want

    returns a string that contains an array of the first input2 multiples of input1 (not including 1)
    or No multiples if the first parameter isn't greater than 0.
     */
    public String multiplesOfNum(String numForMultiple, String numWanted) {
        int numForMultipleInt = Integer.parseInt(numForMultiple);
        if (numForMultipleInt > 0) {
            ArrayList<Integer> result = new ArrayList<>();
            for (int multipleNum = 1; multipleNum <= Integer.parseInt(numWanted); multipleNum++) {
                result.add(numForMultipleInt*multipleNum);
            }
            return result.toString();
        }
        return "No multiples";
    }

    /*
    Method 1b

    Precondition:
    User inputs one string that contains an integer

    returns a string of whether that input is even or odd
     */
    public String numIsEvenOrOdd(String num) {
        int numInt = Integer.parseInt(num);
        if (numInt % 2 == 0) {
            return "Even";
        }
        return "Odd";
    }

    /*
    Method 1c

    Precondition:
    User inputs one string that contains an integer

    returns a string containing an array of all the factorials of that input
     */
    public String factorialOfNum(String num) {
        int numInt = Integer.parseInt(num);
        if (numInt == 0) {
            return "1";
        } else if (numInt < -1) {
            return "Not possible";
        }
        int result = numInt;
        for (int timesToRun=numInt-1; timesToRun>0; timesToRun--) {
            result *= timesToRun;
        }
        return String.valueOf(result);
    }


    /*
    Method 1d
    Precondition:
    User inputs a string that contains an integer

    returns a string containing an array of all the prime factors of the input
     */
    public String primeFactorizationOfNum(String num) {
        int numInt = Integer.parseInt(num);
        if (numInt < 2) {
            return "Not possible";
        }
        ArrayList<Integer> factors = new ArrayList<>();
        factors.add(numInt);
        while (true) {
            for (int numToTest : factors) {
                int factorOfNumToTest = getFactor(numToTest);
                if (factorOfNumToTest != -1) {
                    factors.remove((Integer) numToTest);
                    factors.add(factorOfNumToTest);
                    factors.add(numToTest/factorOfNumToTest);
                    break;
                }
                if (factors.lastIndexOf(numToTest) == factors.size()-1) {
                    return factors.toString();
                }
            }
        }
    }

    private int getFactor(int num) {
        if (num<2) {
            return -1;
        }
        int testNum = 2;
        while (testNum<=Math.sqrt(num)) {
            if (num % testNum == 0) {
                return testNum;
            }
            testNum++;
        }
        return -1;
    }
}

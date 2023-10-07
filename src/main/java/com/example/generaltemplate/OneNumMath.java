package com.example.generaltemplate;

import java.util.ArrayList;

public class OneNumMath {

    /*
    Precondition:
    User inputs a string of the integer that they want the multiple of
    and another string of how many multiples of that number they want

    returns a string that contains an array of the multiples of a given number up to how many of that number wanted
    or No multiples if the first parameter isn't greater than 0.
     */
    public String multiplesOfNum(String numForMultiple, String numWanted) {
        int numForMultipleInt = Integer.parseInt(numForMultiple);
        if (numForMultipleInt > 0) {
            ArrayList<Integer> result = new ArrayList<>();
            for (int mutipleNum = 1; mutipleNum <= Integer.parseInt(numWanted); mutipleNum++) {
                result.add(numForMultipleInt*mutipleNum);
            }
            return result.toString();
        }
        return "No multiples";
    }

    public String numIsEvenOrOdd(String num) {
        int numInt = Integer.parseInt(num);
        if (numInt % 2 == 0) {
            return "Even";
        }
        return "Odd";
    }

    public String factorialOfNum(String num) {
        return "";
    }

    public String primeFactorizationOfNum(String num) {
        return "";
    }
}

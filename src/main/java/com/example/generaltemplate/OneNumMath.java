package com.example.generaltemplate;

import java.util.ArrayList;

public class OneNumMath {

    /*
    num is int
     */
    public String multiplesOfNum(String numForMultiple, String numWanted) {
        ArrayList<Integer> result = new ArrayList<>();
        int numForMultipleInt = Integer.parseInt(numForMultiple);
        for (int mutipleNum = 1; mutipleNum <= Integer.parseInt(numWanted); mutipleNum++) {
            result.add(numForMultipleInt*mutipleNum);
        }
        return result.toString();
    }

    public String numIsEvenOrOdd(String num) {
        return "";
    }

    public String factorialOfNum(String num) {
        return "";
    }

    public String primeFactorizationOfNum(String num) {
        return "";
    }
}

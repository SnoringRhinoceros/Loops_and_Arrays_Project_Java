package com.example.generaltemplate;

public class Driver {
    String v1;
    String v2;
    String v3;
    OneNumMath oneNumMath = new OneNumMath();
    TwoNumMath twoNumMath = new TwoNumMath();
    Cypher cypher = new Cypher();
    DiceSimulator diceSimulator = new DiceSimulator();
    WordArraySearch wordArraySearch = new WordArraySearch();

    public String run(String oneNumMathMethods, String twoNumMathMethods, String cypherMethods, String rollDiceMethods,String wordArraySearchMethods) {
        return "";
    }

    public void setV1(String v1) {
        this.v1 = v1;
    }

    public void setV2(String v2) {
        this.v2 = v2;
    }

    public void setV3(String v3) {
        this.v3 = v3;
    }
}

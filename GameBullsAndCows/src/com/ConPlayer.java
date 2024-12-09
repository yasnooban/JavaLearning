package com;import java.io.*;import java.nio.file.Files;import java.nio.file.Path;import java.util.Scanner;import static java.lang.System.in;import static java.lang.System.out;//взаимодействует через консольpublic class ConPlayer implements AbstractPlayer {    private String myname;    String mynumber; //секрет    String moveNumber;//ход    ConPlayer(String name) {        myname = name;    }    @Override    public void initialize(GameRules rules) {        Scanner scn = new Scanner(in);        String scnLine = scn.nextLine();        setMynumber(scnLine);    }    @Override    public Challenge getChallenge(GameRules rules) {        Scanner scn = new Scanner(in);        moveNumber = scn.nextLine();        return new Challenge(moveNumber);    }    @Override    public void processResponse(Challenge c, Response r) {    }    @Override    public Response getResponse(Challenge c) {        int bulls = 0;        int cows = 0;        String hisNumber = c.getChallenge();        for (int i = 0; i < mynumber.length(); i++) {            for (int j = 0; j < hisNumber.length(); j++) {                if (mynumber.charAt(i) != hisNumber.charAt(j)) continue;                if (i == j) {                    bulls++;                } else {                    cows++;                }            }        }        return new Response(cows, bulls);    }    @Override    public String getName() {        return myname;    }    void setMynumber(String a) {        mynumber = a;    }}
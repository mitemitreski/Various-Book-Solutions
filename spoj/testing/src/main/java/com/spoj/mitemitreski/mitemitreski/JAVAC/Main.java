package com.spoj.mitemitreski.mitemitreski.JAVAC;

import java.io.BufferedReader;

/*
long_and_mnemonic_identifier
anotherExample
i
long_and_mnemonic_identifier5
long_and_mnemonic_identifier_5
anotherExample6
long_and_5mnemonic_identifier_5
n_e_e_r_c
bad_Style
A_bad_start
AbadStart
bad_underscore_
multiple__underscore
multiple__a__underscore
__
_


----------
LongAndMnemonicIdentifier
another_example
i
Error!
LongAndMnemonicIdentifier5
LongAndMnemonicIdentifier5
another_example6
LongAnd5mnemonicIdentifier5

 */
public class Main {

    public static boolean isCppCode(String str) {
        if (str.matches(".*[A-Z].*")) return false;
        if (str.contains("_")) {
            String[] all = str.split("_");
            for (String word : all) {
                //multilple_underliner_is_error
                if (word.length() == 0) {
                    return false;
                }
                //is bad underscore error ??bad_underscore_
                if (!isStringLowerCase(word)) {
                    return false;
                }
            }
        } else {
            return false;
        }
        return true;
    }


    public static boolean isStringLowerCase(String str) {
        char[] charArray = str.toCharArray();
        for (char c : charArray) {
            //if any character is in upper case, return false
            if (Character.isUpperCase(c))
                return false;
        }
        return true;

    }

    public static String convertToCpp(String str) {
        final StringBuilder out = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                out.append("_").append(Character.toLowerCase(c));
            } else {
                out.append(c);
            }

        }

        return out.toString();
    }

    public static String convertToJava(String str) {
        String[] allWords = str.split("_");
        if (allWords.length < 2) {
            return str;
        }

        StringBuilder out = new StringBuilder();
        for (String s : allWords) {
            String inputWord = s.toLowerCase();

            if (inputWord.length() > 1) {
                out.append(Character.toUpperCase(inputWord.charAt(0)) + inputWord.substring(1));
            } else {
                out.append(Character.toUpperCase(inputWord.charAt(0)));
            }
        }
        //always start with lowercase
        out.setCharAt(0, Character.toLowerCase(out.charAt(0)));
        return out.toString();

    }

    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader r = new BufferedReader(new java.io.InputStreamReader(System.in));

        String line = "";
        while ((line = r.readLine()) != null) {
            if (line.length() > 0) {
                boolean startsUpercase = Character.isUpperCase(line.charAt(0));
                boolean endsLine = line.charAt(line.length() - 1) == '_';
                if (startsUpercase || endsLine) {
                    System.out.println("Error!");
                    continue;
                }
            }

            if (line.contains("_")) {
                if (Main.isCppCode(line)) {
                    System.out.println(convertToJava(line));
                } else {
                    System.out.println("Error!");
                }
            } else if (line.equals(line.toLowerCase())) {
                System.out.println(line);
            } else {
                System.out.println(Main.convertToCpp(line));
            }
        }
    }
}
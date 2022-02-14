package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {



    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String test = scan.nextLine();

        System.out.println(reverseString(test));
        System.out.println(isAnagram(test));
        System.out.println(mostChars(test));
        findSubString(test,"end");
        scan.close();


    }

    public static void findSubString(String mainString,String stringToFind){
        boolean isStringThere = false;
        for(int i = 0; i< mainString.length() - stringToFind.length() +1;i++){

            if(mainString.substring(i,i + stringToFind.length() ).equals(stringToFind)){
                isStringThere = true;
            }
        }
        if(isStringThere){
            System.out.println("SubString \"" + stringToFind + "\" found in the text!");
        }
        else{
            System.out.println("NOT FOUND");
        }
    }

    public static String reverseString(String str){
        String reverse = "";

        for(int i = 0 ; i < str.length() ; i++){
            reverse = reverse.concat(String.valueOf(str.charAt(str.length() - i -1 )));
        }

        return reverse;
    }

    public static boolean isAnagram(String str){
        boolean isAnagram = true;
        for(int i = 0; i < str.length()/2; i++){
            if(str.charAt(i) != str.charAt(str.length()-i -1)){
                isAnagram = false;
            }
        }

        return isAnagram;
    }

    public static String mostChars(String str){
        int bestAmount = 0;
        char bestChar = 0;
        char current ;
        ArrayList<String> multiples = new ArrayList<>();
        boolean hasDoubleBest = false;

        for(int i = 0; i < str.length(); i++){
            current = str.charAt(i);
            int temp = 1;
            if(str.charAt(i) == bestChar ){
                continue;
            }
            if(str.charAt(i) != ' ') {

                for(int j = i + 1; j < str.length(); j++){
                    if(str.charAt(i) == str.charAt(j)){
                        temp++;
                    }
                }
                if(temp == bestAmount){
                    hasDoubleBest = true;
                    multiples.add(String.valueOf(str.charAt(i)));
                }

                else if(temp > bestAmount){
                    bestAmount = temp;
                    bestChar = str.charAt(i);
                    hasDoubleBest = false;
                    multiples.clear();
                }
            }

        }
        String info = ("Best character: " + bestChar + " with " + bestAmount + " iterations");
        if(hasDoubleBest){
            return info + " but there are these chars with the same amount: " + multiples;
        }
        return info;

    }

}

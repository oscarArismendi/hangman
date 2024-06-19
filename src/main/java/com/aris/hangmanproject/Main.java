package com.aris.hangmanproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    static String makeUserWord(String word,int n){
        word = "_";
        for(int i = 0; i < n-1;i++){
            word += " _";
        }
        return word;
    }
    public static void main(String[] args) {
        //ArrayList declaration 
        ArrayList<String> wordList = new ArrayList<>(Arrays.asList("tiger", "cat", "snake","butterfly","spider","panda","elephant","fox","chicken","rhino"));
        ArrayList<Character> inLetters = new ArrayList<>();
        
        //Variables declarations 
        int lives = 0;
        String userWord = "";
        int wordChoice = 0;
        int correctLetters = 0;
        Scanner sc = new Scanner(System.in);// initializing the scanner
        while(true){
            try {
                System.out.println("Input a number between 1 and 10:");
                wordChoice = sc.nextInt();
                if(wordChoice > 10 || wordChoice < 1){
                    throw new Exception("Number not in the range");
                }
                break;
            } catch (Exception e) {
                System.err.println("Wrong input, try a number that is between 1 and 10: ");
                sc.next();
                continue;
            }
        }
        sc.nextLine();
        String word = wordList.get(wordChoice-1);
        int n = word.length();
        userWord = makeUserWord(word, n);

        
        while(lives < 3 && correctLetters < n){
            System.out.println("Your word: "+userWord + " lives: " + (3 -lives));
            System.out.println("Enter a letter:");
            String holder = sc.nextLine();
            char c = holder.charAt(0);
            boolean isInsert = false;
            for(int i = 0; i < inLetters.size();i++){
                if(inLetters.get(i) == c ){
                    isInsert = true;
                }
            }
            if(isInsert == true){
                System.out.println("You have already try this letter, try another one");
                continue;
            }
            boolean isCorrect = false;
            for(int i = 0; i < n;i++){
                if(c == word.charAt(i)){
                    userWord = userWord.substring(0, i*2) + c + userWord.substring((i*2)+1);
                    isCorrect = true;
                    correctLetters++;
                }
            }
            if(isCorrect == false){
                System.out.println("Wrong one");
                lives++;
            }
            inLetters.add(c);
        }
        sc.close();
        if(correctLetters == n){
            System.out.println("Your word: "+userWord + " lives: " + (3 -lives));
            System.out.println("Congratulations!!!");
        }else{
            System.out.println("Better luck next time");
        }
    }
}
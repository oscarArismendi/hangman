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


    static int option_validation(String statement, int lower,int upper,Scanner sc){//return a int >= lower and <= upper
        while(true){
            try {
                System.out.println(statement);
                int option = sc.nextInt();
                if (option>=lower && option<=upper){
                    return option;
                }else{
                    System.out.println(String.format("The option is not in the interval: %1$d-%2$d", lower,upper));
                }
                
            } catch (Exception e) {
                System.out.println("Please, type a valid number.");
                sc.nextLine();
            }
        }
    }

    static int mainMenu(Scanner sc){
        cleanScreen(sc);
        System.out.println("-----------------MAIN MENU-------------------");
        System.out.println("What do you wanna do?");
        System.out.println("1.Play");
        System.out.println("2.Exit");

        int op = option_validation("Option:", 1, 2, sc);
        return op;

    }


    static void pause(Scanner sc){
        System.out.println("Press enter to continue");
        sc.nextLine();
    }

    static void cleanScreen(Scanner sc){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void hangmanGame(ArrayList<String> wordList,ArrayList<Character> inLetters,Scanner sc){
                //Variables declarations 
                int lives = 0;
                String userWord = "";
                int wordChoice = 0;
                int correctLetters = 0;
                int limitLives = 3;
                wordChoice = option_validation("Input a number between 1 and 10:", 1, 10, sc);
        
                sc.nextLine();
                String word = wordList.get(wordChoice-1);
                int n = word.length();
                userWord = makeUserWord(word, n);
        
                
                while(lives < limitLives && correctLetters < n){
                    System.out.println("---------------------------------------------");
                    System.out.println("Your word: "+userWord + " lives: " + (limitLives -lives));
                    System.out.println("Enter a letter:");
                    String holder = sc.nextLine();
                    if(holder.length() > 1){
                        System.out.println("It has to be only one letter");
                        continue;
                    }
                    char c = holder.charAt(0);
                    c = Character.toLowerCase(c);
                    if(!Character.isLetter(c)){
                        System.out.println("Please enter a letter");
                        continue;
                    }
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
                    // charAt(i*2) = 
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
                    } else{
                        System.out.println("Correct!!! keep going");
                    }
                    inLetters.add(c);
                }
                if(correctLetters == n){
                    System.out.println("Your word: "+userWord + " lives: " + (limitLives -lives));
                    System.out.println("Congratulations!!!");
                }else{
                    System.out.println("Better luck next time");
                }
    }
    public static void main(String[] args) {
        //ArrayList declaration 
        ArrayList<String> wordList = new ArrayList<>(Arrays.asList("tiger", "cat", "snake","butterfly","spider","panda","elephant","fox","chicken","rhino"));
        ArrayList<Character> inLetters = new ArrayList<>();
        
        Scanner sc = new Scanner(System.in);// initializing the scanner        
        while(true){// main menu while
            int op = mainMenu(sc);
            if(op == 1){
                cleanScreen(sc);
                System.out.println("-----------------PLAY MENU-------------------");
                hangmanGame(wordList,inLetters,sc);
                inLetters.clear();
                pause(sc);
            }
            else{
                break;
            }
        }
        System.out.println("Hope you come back!");
        sc.close();
        

    }
}
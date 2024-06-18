package com.aris.hangmanproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        //ArrayList declaration 
        ArrayList<String> wordList = new ArrayList<>(Arrays.asList("tiger", "cat", "snake","butterfly","spider","panda","elephant","fox","chicken","rhino"));
        ArrayList<Character> inLetters = new ArrayList<>();
        
        //Variables declarations 
        int lives = 0;
        
        Scanner sc = new Scanner(System.in);// initializing the scanner
        
        while(lives < 3){
            System.out.println("Enter a letter:");
            String holder = sc.nextLine();
        }

        sc.close();
    }
}
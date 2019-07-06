package com.company;

import java.io.CharArrayReader;
import java.util.Scanner;
import java.util.Stack;

/**
 * Solves the balanced brackets problem by use of a stack and conditional control
 *
 * The problem. A user enters n indicating the number of strings the class is going to iterate over
 * and determine if it is a balanced bracket or not.  e.g
 * 3
 * {[()]} => YES
 * {{)}} => NO
 * {]()[} => NO
 */

public class BalancedBrackets {

    BalancedBrackets(){}

    public void isBalanced(){

        int counter;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the number of strings to test: ");
        counter = scanner.nextInt();
        // iterate the number of times equal to the counter while getting a string as input and
        // testing if it is a balanced bracket
        for(int i = 0; i < counter; i++){

            System.out.print("Please enter string to test: ");
            String bracketsToTest = scanner.next();
            // loop through the bracketsToTest string one character at a time and since
            // it should be balanced the first half of the string (which should be opening brackets)
            // will be placed in a stack while the
            // other part will be tested if they are the closing brackets
            Stack<Character> characterStack = new Stack<>();
            String isBal = "YES";
            for(int j = 0; j < bracketsToTest.length(); j++){
                Character currentChar = bracketsToTest.charAt(j);
                if(currentChar =='(' || currentChar =='[' || currentChar == '{'){
                    characterStack.push(currentChar);
                } else { // we are in the second half of the string if it is likely to be a balanced bracket
                   if(!characterStack.empty()){ // check since we will be poping chars from stack

                       Character openingChar = characterStack.pop();
                       if(openingChar=='(' && currentChar!=')'){
                           isBal = "NO";
                           break;
                       }
                       if(openingChar=='[' && currentChar!=']'){
                           isBal = "NO";
                           break;
                       }
                       if(openingChar=='{' && currentChar!='}'){
                           isBal = "NO";
                           break;
                       }
                       if(characterStack.isEmpty() && j+1< bracketsToTest.length()){ // if the stack is empty and there are
                           // still more characters in the bracketsToTest string then that means it is no longer a balanced
                           // bracket
                           isBal = "NO";
                           break;
                       }

                   }
                }
            }

                System.out.println(isBal); // isBal is still YES
        }
    }
}

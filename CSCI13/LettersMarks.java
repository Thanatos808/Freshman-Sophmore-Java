/*
Name:Matthew Marks 
Description
date:2/2/2024
*/
import java.util.*;
public class LettersMarks 
{
    // No additional code here
}

class Letters {
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        desc(); // Call the desc method

        char[] letters = new char[5]; // Declare an array of char with size 5

        populate(letters, scanner); //populate array from users input

        print(letters); 
        scanner.close();
    }

    // Method for displaying program description
    public static void desc() 
    {
        for (int i = 0; i < 50; i++)
         {
            System.out.print("*");
        }
        System.out.println("\nYou will be asked to enter letters, upper case and lower case will be considered the same");
        System.out.println("The program will filter out the repeated letters. Then display the distinct letters entered by the user");//created header and instructions
        for (int i = 0; i < 50; i++)
         {
            System.out.print("*");
        }
        System.out.println(); 
    }

    // Method for checking if the array contains a specific letter
    public static boolean found(char[] letters, char input) 
    {
        for (char letter : letters)
         {
            if (letter == input)
            {
                return true; //return true if letters found
            }
        }
        return false;// return false if letter not found 
    }

    // Method for validating user input
    public static char validateInput(Scanner kb) 
    {
        String input = "";
        char firstLetter = ' ';
        boolean done = false;
        while (!done) {
            System.out.println("Enter a letter a-z or A-Z: ");// this is where the user is prompted for input
            input = kb.next();
            if (input.length() > 1) {
                System.out.println("You must enter a single letter\n");//correct user prompt if input is not single letter
                continue;
            }
            input = input.toUpperCase(); 
            firstLetter = input.charAt(0);
            if (firstLetter >= 'A' && firstLetter <= 'Z') 
            {
                done = true;
            } else
             {
                System.out.println("You did not enter a valid letter\n");// message if user tries invalid character
            }
        }
        return firstLetter;
    }

    // Method for populating the array with unique letters
    public static void populate(char[] letters, Scanner kb) {
        for (int i = 0; i < letters.length; i++) {
            char letter = validateInput(kb);//validate input
            if (!found(letters, letter)) 
            { 
                letters[i] = letter;
                System.out.println("The letter " + letter + " was added to the array");
                System.out.println("You have " + (i + 1) + " letters in the array");
            } 
            else
            {
                System.out.println("You already entered this letter. Try again");// prompt if letter is repeated
                i--; 
            }
        }
    }

    // Method for printing the array contents
    public static void print(char[] letters) 
    {
        System.out.print("\nHere is the list of the distinct letters you entered: {");
        for (int i = 0; i < letters.length; i++)
         {
            System.out.print(letters[i]); //print each letter
            if (i < letters.length - 1) 
            {
                System.out.print(",");
            }
        }
        System.out.println("}"); 
 }
}
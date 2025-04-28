import java.util.*; // Import the Java utility package

public class LettersMarks {
    // This class currently does not contain any methods or properties
}

class Letters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object to read input

        desc(); // Call the method to display the program description

        char[] letters = new char[5]; // Initialize an array to store up to 5 unique letters

        populate(letters, scanner); // Populate the array with letters from user input

        print(letters); // Print the unique letters
        scanner.close(); // Close the scanner object to prevent resource leak
    }

    // Display a description of the program to the user
    public static void desc() {
        // Print a header line
        for (int i = 0; i < 50; i++) {
            System.out.print("*");
        }
        System.out.println();
        // Print the program instructions
        System.out.println("You will be asked to enter letters, upper case and lower case will be considered the same");
        System.out.println("The program will filter out the repeated letters. Then display the distinct letters entered by the user");
        // Print a footer line
        for (int i = 0; i < 50; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    // Check if the specified letter is already in the array
    public static boolean found(char[] letters, char input) {
        for (char letter : letters) {
            if (letter == input) {
                return true; // Return true if letter is found
            }
        }
        return false; // Return false if letter is not found
    }

    // Validate the user's input and return a valid uppercase letter
    public static char validateInput(Scanner kb) {
        String input;
        char firstLetter = ' ';
        boolean done = false;
        while (!done) {
            System.out.println("Enter a letter a-z or A-Z: "); // Prompt user for input
            input = kb.next(); // Read user input
            if (input.length() > 1) { // Check if input is a single character
                System.out.println("You must enter a single letter\n");
                continue; // Prompt again if not a single character
            }
            input = input.toUpperCase(); // Convert input to uppercase
            firstLetter = input.charAt(0); // Get the first character
            if (firstLetter >= 'A' && firstLetter <= 'Z') { // Check if character is a letter
                done = true; // Exit loop if valid letter
            } else {
                System.out.println("You did not enter a valid letter\n"); // Inform user of invalid input
            }
        }
        return firstLetter; // Return the validated letter
    }

    // Populate the array with unique letters from user input
    public static void populate(char[] letters, Scanner kb) {
        for (int i = 0; i < letters.length; i++) {
            char letter = validateInput(kb); // Validate each input
            if (!found(letters, letter)) { // Check if letter is not already added
                letters[i] = letter; // Add letter to array
                System.out.println("The letter " + letter + " was added to the array");
                System.out.println("You have " + (i + 1) + " letters in the array");
            } else {
                System.out.println("You already entered this letter. Try again"); // Prompt if letter is repeated
                i--; // Decrement i to retry input
            }
        }
    }

    // Print the distinct letters entered by the user
    public static void print(char[] letters) {
        System.out.print("\nHere is the list of the distinct letters you entered: {");
        for (int i = 0; i < letters.length; i++) { // Iterate through the array
            System.out.print(letters[i]); // Print each letter
            if (i < letters.length - 1) {
                System.out.print(","); // Print comma between letters
            }
        }
        System.out.println("}");
    }
}

/*
Date:4/11/2023
name:Matthew Marks
description: A program that simulates a person trying to climb up a mountain. The person starts on the
ground, at height 0. Each iteration, the person climbing up the mountain either moves up a
random number of steps between 20 and 30. Or the person slips down 
*/
import java.util.*;

public class ClimbMarks {
   // Change this name to include your last name, for example: ClimbMarksSmith
}

class RockClimb {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      Random rand = new Random();
      execute(rand, scan);
   }

   // This method calls the other methods to run the program
   public static void execute(Random rand, Scanner scan) {
      boolean repeat = true;
      int height = 0;
      while (repeat) {
         height = input(scan);
         int slips = climb(height, rand);
         System.out.println("While climbing up the mountain with the height " + height + ", you slipped " + slips + " times\nAnother run?");
         String s = scan.next();
         if (s.equals("yes")) {
            repeat = true;
         } else {
            repeat = false;
            System.out.println("Goodbye");
         }
      }
   }

   /*
    * This method asks the height of the mountain that a person will climb. Data
    * validation must be done to ensure that the height is a positive integer. While
    * loop and do-while loop must be used.
    */
   public static int input(Scanner scan) {
      boolean input_check = true;
      int height = 0;
      do {
         System.out.print("What is the height of the mountain: ");
         String height1 = scan.next();
         try {
            height = Integer.parseInt(height1);
            if (height > 0) {
               input_check = true;
            } else {
               input_check = false;
            }
         } catch (NumberFormatException e) {
            input_check = false;
         }
      } while (!input_check);
      return height;
   }

   /*
    * This method simulates the climbing of the mountain. It takes the height of
    * the mountain and a random number generator as input. It returns the number of
    * slips that occurred while climbing.
    */
   public static int climb(int height, Random rand) {
      int distance = 0, slip = 0;
      do {
         int choice = rand.nextInt(2);
         if (choice == 1) {
            int max = 30;
            int min = 20;
            int steps = rand.nextInt(max + 1 - min) + min;
            if (height - distance < steps) {
            } else {
               distance += steps;
               System.out.println(steps + " steps have been climbed");
            }
         } else {
            int max = 5;
            int min = 1;
            int steps = rand.nextInt(max + 1 - min) + min;
            if (distance != 0) {
               distance -= steps;
               slip += steps;
               System.out.println("Sorry, you slipped down " + steps + " step(s)");
            }
         }
      } while (distance != height);
      return slip;
   }

   /*
    * Displays the information about the program such as the number of steps moving
    * up, number of the steps slipping:
    */
   public static void description() {
   }
}

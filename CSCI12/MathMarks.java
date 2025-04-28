/*
Name:Matthew Marks   
date:4/18/2023
description: create a program so that the
student can take Math quizzes. Each student should answer 5 random math questions. The program
keeps track of the score of each student and displays the score at the end of the quiz. The questions will
be displayed one at a time and the student will be given the chance to answer the question. If the
student is correct the points will be added to the score else a message will be displayed indicating the
incorrect answer. 
*/
import java.util.Scanner;
import java.util.Random;

public class MathMarks
{
   public static void main(String[] args) 
   {
      Scanner in = new Scanner(System.in);
      Random rand = new Random();
      String[] quiz = new String[5];
      int[] answer = new int[5];
      int[] points = new int[5];
      int score = 0;
      String playAgain = "yes";
      while (playAgain.equalsIgnoreCase("yes")) 
      {
         prep();
         populate(quiz, answer, points, 50, 1);
         score = test(quiz, answer, points);
         System.out.println("Your score is: " + score);
         System.out.print("Do you want to play again? ");
         playAgain = in.next();
      }
      System.out.println("Good bye");
   }

   public static void prep() //This method creates the header/display for the quiz
   {
      System.out.println("****************************************");
      System.out.println("There are 5 questions in this quiz.");
      System.out.println("You get certain points if you answer it correctly");
      System.out.println("let's take the quiz");
      System.out.println("****************************************");
   }

   public static void populate(String[] quiz, int[] answer, int[] points, int max, int min) 
   {
    Random rand = new Random();
    int num1, num2, temp;
    char op;
    for (int i = 0; i < quiz.length; i++) 
    {
        num1 = rand.nextInt(max - min + 1) + min;
        num2 = rand.nextInt(max - min + 1) + min;
        op = rand.nextInt(4) == 0 ? '+' : rand.nextInt(3) == 0 ? '-' : rand.nextInt(2) == 0 ? '*' : '/';
        if (op == '-') 
        {
            if (num1 < num2) 
            {
                temp = num1;
                num1 = num2;
                num2 = temp;
            }
        } else if (op == '/') {
            while (num2 == 0 || num1 % num2 != 0)
            {
                num1 = rand.nextInt(max - min + 1) + min;
                num2 = rand.nextInt(max - min + 1) + min;
            }
        }
        quiz[i] = num1 + " " + op + " " + num2;
        answer[i] = calculate(num1, op, num2);
        points[i] = rand.nextInt(10 - 1 + 1) + 1;
    }
   }

   public static int calculate(int num1, char op, int num2) //calculates the answer for the question
   {
      int result = 0;
      switch (op) 
      {
         case '+':
            result = num1 + num2;
            break;
         case '-':
            result = num1 - num2;
            break;
         case '*':
            result = num1 * num2;
            break;
         case '/':
            result = num1 / num2;     
      }
      return result;
   }

   public static int test(String[] questions, int[] answers, int[] values) //displays the test question and asks for user input
   {
      Scanner in = new Scanner(System.in);
      int score = 0;
      int userAnswer;
      for (int i = 0; i < questions.length; i++)
       {
         System.out.print(questions[i] + " = ");
         userAnswer = in.nextInt();
         if (userAnswer == answers[i]) 
         {
            System.out.println("You earned " + values[i] + " points");//if answered correct they get points
            score += values[i];
         } else 
         {
            System.out.println("Incorrect answer");//else they got the answer wrong and no points
         }
      }
      return score;
   }
}
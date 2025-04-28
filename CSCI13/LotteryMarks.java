/*
Name:Matthew Marks   
Date:2/10/2024
Description:Program simulates the number matching game in which two 5-digit numbers will be generated. Then scans the generated numbers to find the 
number of the digits thatappears in both numbers
Self-grade:B+, Program completes the requirements and gives correct output. I was also able to fix my own error that was causing
the matching numbers to not properly space in the output.Mark down for comments since I did leave the shell's instructions because it already effectively comments
what was done in each method of the program. 
Correct output: I have checked the output and it is working correctly based on the given requirments otherwise I will lose 50 points. Name: 
Testimony: I have not recived the code from any AI websites or any other websites. I have written the code myself. Name: 


Feel free to start your program from the scratch if you don't want to use the given shell.
*/


import java.util.*;
public class LotteryMarks
{
   //no code here
}
class LotteryMachine
{
   public static void main(String[] args)
   {
      run();
   }
   /*
   This method calls the other methods to start the excution
   */
   public static void run()
   {        
     
      Scanner kb = new Scanner(System.in);
      Random rand = new Random();                    
      String answer = " ";
      while (!answer.equalsIgnoreCase("q"))
      {
         description();
         System.out.print("\nWhat is your name: ");
         String name = kb.nextLine();
         System.out.println("\nHello " + name + " lets start playing\n");
         play(rand);
         System.out.print("Hit enter to let another person play or enter Q to quit the program");
         answer = kb.nextLine();
        // more = answer.equalsIgnoreCase("yes");
      }
      System.out.println("Good Bye! Come Back soon to play again");
   }
  //********************************First method to implement****************************************************************************** 
    /*
  This method finds the amount of the prize based on the matches found in the
  two big integer values generate. The user will win 100$ per match. For example if the
  generated numbers are 456789 and 912300 the person will win 100 since the digit 9 has appeard in both numbers
  */

   public static int prize(int match)
   {
     int prizeAmount; //declare a variable of int to hold the prize amount
     
     prizeAmount = match * 100; //set the variable you declared to match * 100
       
      
     System.out.println("You won: $" + prizeAmount); //display the content of the variable with the message "You won: "
       
      //return the amount of the prize
      return prizeAmount;   // must change to return the prize you calculated
   }
   
   
   
//***************************************Second method to implement*******************************************************************************   
   
  /*
  This method generates a big number based on the parameter digitCounts. For example if the
   digitCounts is three then the method will generate a three-digit number such as 123. If the digitCounts is five then 
   this method generates a five-digit integer number such as 12456. 
   12456 can be written as :
   1 * 10000 + 2 * 1000 + 4 * 100 + 5 * 10 + 6. this algorithm is used in the method below to create a 5-digits number 
  */
   public static int bigNumber(Random rand, int digitCounts)
   {
      int num = 0;
      for (int i = digitCounts; i > 0; i--)//for int i = digitCounts to 1
      {
        int a = rand.nextInt(10); //generate a random number 0-9 inclusive and store it in the variable called a
         
        num += (int)Math.pow(10, i - 1) * a;//set num to num + (int)Math.pow(10,i-1) * a 
         
      }
      return num;
   }
   
   
   //**********************************************Third method to implement*************************************
  /*
  This method checks to see if there are any matchig digits in the two big number.
  returns the numbers that are matched. This method gets two parameters of type int. Scan through the numbers 
  to count the digits that are appeared in both numbers. This method will store each digit in the given numbers
  in two arrays in order to scan and find the matches.
  
  */
   public static int match(int n1, int n2)
   {
      String s1 = n1 +" ";  //type cast the integer n1  to a string
      String s2 = n2 +" ";  //type cast the integer n2 to a string
      int matchCount = 0;  // holds the number of the matched digits in n1 and n2
      char[] m1 = new char[s1.length()]; // array of char to hold each character in s1 
      char[] m2 = new char[s2.length()];//array of char to hold each character in s1
       
      for (int i = 0; i < s1.length(); i++)//for loop to store each char in s1 and s2 in the arrays m1 and m2
      {
         m1[i] = s1.charAt(i); //set m1 at the index i to s1.charAt(i)
      }
      for (int i = 0; i < s2.length(); i++)//for i = 0 to the last char in s1
      {
         m2[i] = s2.charAt(i); //set m2 at the index i to s2.charAt(i)
      }
      
           
      String s = " ";  // this holds the matched difits that was found      
      
       //nested loop to find the matches in array m1 and m2 
      for (int i = 0; i < m1.length; i++)//for i = 0 to the index of the last element in array m1   
      {
         boolean b = false; //set the variable b to false
         
         for (int j = 0; j < m2.length; j++)//for j = 0 to the last index of the array m2
         {
           //if the element at index i in m1 is equal to the element in m2 at the index j: means a match was found
            if (m1[i] == m2[j]) 
            {
              s += m2[j] + " "; //concatinate m2[j] to the variable s and add a space to the string to seperate the matched digits           
              b = true;//set b to true              
              m2[j] = ' '; //set m2[j] to ' '
              matchCount++; // matchCount++;
              break; //if b is true break: a match was found and need to break out of the inner loop    
            }
            //if b is true break: a match was found and need to break out of the inner loop
         }
      } 
      System.out.println("Here are the matching numbers: " + s);
      return matchCount;  
   }
  /*******************************************Fourth method to implement****************************************
  this method calls the bigNumbers method to generate two big random integers. then it calls the match method
  then it calls the prize method. and finally displays the amount the person won
  */ 
   public static void play(Random rand)
   {
      Scanner kb = new Scanner(System.in);
      boolean more = true; 
      int total = 0;
      String answer = "";
      while(!answer.equalsIgnoreCase("q"))
      {
       int n1 = bigNumber(rand, 5); //call the bigNember method and pass the parameters rand and 5 to create the first 5-digit random int
          
       int n2 = bigNumber(rand, 5);   //call the bigNember method and pass the parameters rand and 5 to create the second 5-digit random int
        
              
          
        System.out.println("Generated numbers: " + n1 + " and " + n2); //display the two random integers that was created     
         
         
         int matches = match(n1, n2); //call the match method and pass the two integers to it to find out the number of matches, store the result in a variable
         
         int prizeAmount = prize(matches);//call the method prize and pass the numbers of matches to it to find out the amount of the prize
         
         total += prizeAmount;//add the amount of the prize to the variable total to keep track of the amount of the money that the person is winning
         
         
         System.out.print("\nHit enter to continue or press q/Q to quit  ");
         answer = kb.nextLine(); 
       
             
      }
      System.out.println("\nTotal amount you won: " + total);
      System.out.println("\n");
     
   }
   
   
   //***************************************************Fifth method to implement********************************

   public static void description()
   {
      System.out.println("*********************************************************************************************");
      System.out.println("* Welcome to number matching game.  At each round of the game, computer generates two\n"+
      "two big integer random numbers . Based on the digits macthed in both numbers you will get prize.\n"+
      " For each matched digit you will get a 100$ prize. For example if the generated numbers are 45678 and 86547 you will get 500$");
      System.out.println("*********************************************************************************************");    
   }
}
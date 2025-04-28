import java.util.Scanner;
/*
name:Matthew Marks
date:3/17/2023
program description: Simulates a simple expression evaluator
*/
public class MathMarks1
{
   //no code goes here
}
class Expression
{
   public static void main(String[] args)
   {
      start();
   }
   /* This must be the last method to implement
   After you have implemented all the methods*/
   public static void start()
   {
      Scanner kb = new Scanner(System.in);
      System.out.print("How many times do you want to use the software: ");
      int count = kb.nextInt();
      System.out.println("MM--------------------------------------------------------------");
      for(int i = 1; i <= count; i++)
      {  
      
          //your code, refeer to the word document
          list();
          System.out.println("MMM");
          System.out.print("Operand 1: ");
          int a = kb.nextInt();//user input
          System.out.print("Operand 2: ");
          int b = kb.nextInt();//user input
          System.out.println("Operator---> ");
          kb.nextLine();
          String op = kb.nextLine();
          System.out.println("MMM");
          int Result = evaluate(a, b, op);
          String aNumToWord = convertNumToWord(a); 
          String bNumToWord = convertNumToWord(b); 
          String opToword = convertOpToWords(op);    
          //According sample output
          System.out.println("MM------------------------");
          System.out.println("MMM"); 
          System.out.println("MM" + a + " " + op + " " + b + " = " + Result);
          System.out.println("MM" + aNumToWord+ " " + opToword + " " + bNumToWord + " is " + Result);
          System.out.println("MM");
			 System.out.println("MM------------------------");
			 System.out.println("MMM");  
      }
   }
   /*This method get the opration and returns the name of the operation in words. for example
   if the operation is * , it should return multiply.
   must use switch statement  */
   public static String convertOpToWords(String operator)
   {
         // your code
         switch(operator) 
         { 
		case "*" : return "multiply"; 
		case "+" : return "addition"; 
		case "-" : return "subtract"; 
		case "/" : return "dividing"; 
		case "%" : return "modulo"; 
		default : return "exponential"; 
        }
    } 
   
   
   /* This method gets a number 1-9 and returns it in  words.
   for example if the num is 1 it shuld return one
   must use if/else statements in this method
   */
    
   public static String convertNumToWord(int a)
   {       
     // your code
       // your code
     if(a==0) { //if a is 0, 
			return "zero";
		}
		else if(a==1) {  //if a is 1, 
			return "one";
		}
		else if(a==2) {  //if a is 2, 
			return "two";
		}
		else if(a==3) {  //if a is 3, 
			return "three";
		}
		else if(a==4) {  //if a is 4, 
			return "four";
		}
		else if(a==5) {  //if a is 5, 
			return "five";
		}
		else if(a==6) {  //if a is 6, 
			return "six";
		}
		else if(a==7) {  //if a is 7, 
			return "seven";
		}
		else if(a==8) {  //if a is 8, 
			return "eight";
		}
		else if(a==9){  //if a is 9.
			return "nine";
		}else{ //if user enters wrong a
		    return "Invalid";
      
     } 
   }
   /*
   this method gets two numbers and the operation and returns the result of the expression.
   for example if this method gets 3, 2 and * , then the method should return 6
   Must use switch cases  
   */
   public static int evaluate(int a, int b, String op)
   {
      //your code
      switch(op) 
      {  
		case "+": //if operator is +
			return a + b;
		case "-":  //if operator is -
			return a - b;
		case "*":  //if operator is *
			return a * b;
		case "/":  //if operator is /
			return a / b;
		case "%":  //if operator is %
			return a % b;
		default:  //if operator is pow
			return (int)Math.pow(a, b); // It will return exponent.
		}          
                       
   }
   /*This method list all the operations that the user can choose from. 
   You must create your own menu and  not to use the menu that I provided in the sample output
   be creative and provide a user freindly menu.
   providing the exact same menu as the sample output, will not get credit  
   */
   public static void list()
   {
     // your code
      System.out.printf("MMWelcome to Math App"); //welcomeing user
	   System.out.println("\nMMAddition enter +\nMMMultiplication enter *\nMMSubtraction enter -\nMMExponent enter ^\nMMDivision enter /\nMMModulus enter %");
	   System.out.println("MM--------------------------------------------------------------");
	}     
   
}
/*
name: Matthew Marks  
Date: 4/13/2024
description:a program that converts an infix expression to a postfix expression and then evaluates the postfix
expression.





Sample OUTPUT
Infix                                   postfix                                 Result                                  
 _____________________________________________________________________________________
 
 2 + 3 + 7 * 4 - 2 / 3 ?                 2 3 + 7 4 * + 2 3 / -                   33                                      
 3 - 4 / 2 + 6 * 3 ?                     3 4 2 / - 6 3 * +                       19                                      
 5 * 6 - 8 + 2 * 10 ?                    5 6 * 8 - 2 10 * +                      42                                      
 4 + 8 * 3 - 2 / 34 ?                    4 8 3 * + 2 34 / -                      28                                      
 6 - 3 + 6 / 2 * 4 - 8 ?                 6 3 - 6 2 / 4 * + 8 -                   7                                       
 2 + 3 * 6 ?                             2 3 6 * +                               20                                      
 2 * 3 + 4 / 3 * 2 ?                     2 3 * 4 3 / 2 * +                       8                                       
 2 * 3 + 1 - 3 * 4 ?                     2 3 * 1 + 3 4 * -                       -5                                      
 1 + 2 * 3 - 6 * 7 + 2 * 3 ?             1 2 3 * + 6 7 * - 2 3 * +               -29                                     
 5 * 6 - 8 + 2 * 10 ?                    5 6 * 8 - 2 10 * +                      42                                      
 6 - 3 + 6 / 2 * 4 - 8 ?                 6 3 - 6 2 / 4 * + 8 -                   7                                       
 11 + 12 * 21 - 22 ?                     11 12 21 * + 22 -                       241                                     
 

*/




import java.util.*;
import java.util.Stack;
import java.util.LinkedList;
public class ExpressionMarks
{
   //no code in here
}
class Expressions
{
   private String exp;
   public Expressions(String s)
   {
      exp = s;
   }
   public String getExp()
   {
       //your code
      return this.exp;
   }
   /*This method tokenizes the exp and stores each token in an ArrayList
   Refer to the documnet*/
   public ArrayList<String> tokenize(String exp)  
   {
      ArrayList<String> tokens = new ArrayList<>();
      StringBuilder token = new StringBuilder();
      for (char ch : exp.toCharArray()) 
      {
         if (ch == ' ' || ch == '+' || ch == '-' || ch == '*' || ch == '/')
          {
            if (token.length() > 0) {
               tokens.add(token.toString());
               token = new StringBuilder();
            }
            if (ch != ' ') tokens.add(Character.toString(ch));
         } else 
         {
            token.append(ch);
         }
      }
      if (token.length() > 0) tokens.add(token.toString());
      return tokens;
                     
     
   
   }
   /*
   Cretae the postfix of the exp. refer to the document*/
   public String getPostfix()
   {
      ArrayList<String> tokens = tokenize(this.exp);
      Stack<String> stack = new Stack<>();
      StringBuilder postfix = new StringBuilder();
   
      for (String token : tokens) 
      {
         if (token.matches("\\d+")) {  
            postfix.append(token).append(" ");
         } else if ("+-*/".contains(token)) 
         {  
            while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(token)) 
            {
               postfix.append(stack.pop()).append(" ");
            }
            stack.push(token);
         }
      }
   
      while (!stack.isEmpty()) 
      {
         postfix.append(stack.pop()).append(" ");
      }
   
      return postfix.toString().trim();
   }
   /*Returns the precedence of an operator
   Must follow the given instructions in the documnet.
   contains method from the String class must be used.
   No case statemnets can be used. */
   private static int precedence(String opr)
   {
      String op1 = "*/";
      String op2 = "+-";
      //your code 
      if (op1.contains(opr)) 
         return 3;
      else if (op2.contains(opr)) 
         return 2;
      return -1;  
   }
  /*
  This method evaluates the postfix. refer to the documnet*/
   public int evalPostfix()
   {
      String post = getPostfix();
      Stack<Integer> stack = new Stack<>();
      Scanner scanner = new Scanner(post);
      while (scanner.hasNext()) 
      {
         if (scanner.hasNextInt()) 
         {
            stack.push(scanner.nextInt());
         } else 
         {
            int num2 = stack.pop();
            int num1 = stack.pop();
            String op = scanner.next();
            stack.push(calculate(new String[]{Integer.toString(num1), Integer.toString(num2), op}));
         }
      }
      scanner.close();
      return stack.pop();
      
   }
    
      
  
   /*
   this method gets an array with the leb=ngth three holding two operands and one operator
   operator is stored at index 2. based on the operator the exp will be evaluated.
   Refer to the document
   */
   private int calculate(String[] last)
   {
      int num1 = Integer.parseInt(last[0]);
      int num2 = Integer.parseInt(last[1]);
      String operator = last[2];
   
      switch (operator) {
         case "+":
            return num1 + num2;
         case "-":
            return num1 - num2;
         case "*":
            return num1 * num2;
         case "/":
            if (num2 == 0) throw new ArithmeticException("Division by zero.");
            return num1 / num2;
         default:
            throw new IllegalArgumentException("Unsupported operator: " + operator);
      }
   }
      
   
}
/*Must complete the Driver to get 20 points. 
Must cretae 5 differnt expressions, each expressions must at least have 5 operators in them
Must be similar to the given Driver

*/
class ExpDriver
{
   public static void main(String[] args)
   {
      LinkedList<String> list = new  LinkedList<String>();
      list.add("15 * 3 + 8 - 2 / 4 + 10");
      list.add("20 + 5 - 3 * 7 + 4 / 2 - 8");
      list.add("12 / 6 + 15 * 2 - 9 + 3 - 4");
      list.add("8 * 4 / 2 + 18 - 5 * 3 + 2");
      list.add("25 - 5 * 6 / 3 + 10 - 4 + 2 / 2");
      
      Iterator<String> itr= list.iterator(); 
      System.out.printf("%-40s%-40s%-40s", "Infix", "postfix","Result"); 
      System.out.println("\n_____________________________________________________________________________________");
      System.out.println(); 
      while (itr.hasNext())
      {
         String infix  = itr.next();
         Expressions e = new Expressions(infix);
         String post = e.getPostfix();
         int result = e.evalPostfix();
         System.out.printf("%-40s%-40s%-40d", infix,   post , result);
         System.out.println();
      
           
      }
   }
   
}   
class Driver
{
   public static void main(String[] args)
   {
      LinkedList<String> list = new  LinkedList<String>();
      list.add("2 + 3 + 7 * 4 - 2 / 3 ?");
      list.add("3 - 4 / 2 + 6 * 3 ?");
      list.add("5 * 6 - 8 + 2 * 10 ?");
      list.add("4 + 8 * 3 - 2 / 34 ?");
      list.add("6 - 3 + 6 / 2 * 4 - 8 ?");
      list.add("2 + 3 * 6 ?");
      list.add("2 * 3 + 4 / 3 * 2 ?");
      list.add("2 * 3 + 1 - 3 * 4 ?");
      list.add("1 + 2 * 3 - 6 * 7 + 2 * 3 ?");
      list.add("5 * 6 - 8 + 2 * 10 ?");
      list.add("6 - 3 + 6 / 2 * 4 - 8 ?");
      list.add("11 + 12 * 21 - 22 ?");
      Iterator<String> itr= list.iterator(); 
      System.out.printf("%-40s%-40s%-40s", "Infix", "postfix","Result"); 
      System.out.println("\n_____________________________________________________________________________________");
      System.out.println(); 
      while (itr.hasNext())
      {
         String infix  = itr.next();
         Expressions e = new Expressions(infix);
         String post = e.getPostfix();
         int result = e.evalPostfix();
         System.out.printf("%-40s%-40s%-40d", infix,   post , result);
         System.out.println();
      
           
      }
   }
}
/*
Name:Matthew Marks
date:5/5/2024
description:Writing recursive methods with the given signatures. 
 */

import java.util.*;
import java.lang.*;
public class RecursiveMarks
{
// no code here
}
//must write code to test all the methods to make sure it is working correctly.(20 points)
class YourDriver
{
}
/*Do not delete the given driver*/ 
 
 class Driver
{
   public static void main(String [] args)
   {
     
     ///********************************************************
      LinkedList   list = new LinkedList();
      //filling the link list with some letters
      for(char i = 'a'; i < 'm'; i++)
      {
         list.add(((String)(i + "")));
      }   
      //testing the palindrom method    
      System.out.print(list + " is palindrome?  ");
      System.out.println(Recursive.palindrome(list));
      System.out.println("\n***********************************************\n");
      
      //***********************************************************************
      //creating a palindorm list to check the palindrom method
      LinkedList list2 = new LinkedList();
      for(char i = 'a'; i <= 'm'; i++)
      {
         list2.add(((String)(i + "")));
      }
      for(char i = 'm'; i >= 'a'; i--)
      {
         list2.add(((String)(i + "")));
      }    
      System.out.print(list2 + " is palindrome?  ");
      System.out.println(Recursive.palindrome(list2));
      System.out.println("\n**************************************************\n");
      
      //*******************************************************************************
      
      //testing the asccii method      
      System.out.println("\ntesting ascci metod");
      String s ="What goes around comes around"; 
      System.out.println("The list of the asccii code in the string " + s  + " is \n"+ Recursive.asccii(s));
      System.out.println("\n*****************************************************\n");
      
      //*********************************************************************************
      
      //testing the longest method to find the longest word in the list
      //filling in the array list
      LinkedList myList = new LinkedList();
      myList.add("Computers");
      myList.add("Philosophy");
      myList.add("building materials");
      myList.add("Costco warehouse");
      System.out.println("\ntesting longest string in the list of string" + myList.toString());
       
      System.out.println("The longest string is the list " + myList.toString() + 
         " is " + Recursive.longest(myList,""));
      System.out.println("\n*******************************************************\n");   
      //*********************************************************   
        //testing the equlas method to see if two list are equals in the reverse order 
         
       LinkedList m1 = new LinkedList();
       for(char i = 'a'; i <= 'm'; i++)
      {
         m1.add(((String)(i + "")));
      } 
      LinkedList m2 = new LinkedList();
      for(char i = 'm'; i >= 'a'; i--)
      {
         m2.add(((String)(i + "")));
      } 
      System.out.println(m1);
      System.out.println(m2);  
     // System.out.println(m1);
     // System.out.println(m2);
      System.out.println("Are the two list equalin the reverse order: " + Recursive.equalsReverse(m1,m2)); 
      for(char i = 'a'; i <= 'm'; i++)
      {
         m1.add(((String)(i + "")));
      } 
      for(char i = 'm'; i >= 'a'; i--)
      {
         m2.add(((String)(i + "")));
      } 


      m1.add("z");
      System.out.println(m1);
      System.out.println(m2);
      System.out.println("Are the two list equal in the reverse order: " + Recursive.equalsReverse(m1,m2));
      System.out.println("\n*********************************************************\n");
      
      //********************************************************************************
           
      //testing the average method    
             
      System.out.println("\ntesting the avg of the integers in a link list");
      LinkedList list3 = new LinkedList();
      Random rand = new Random();
      for(int i = 1; i <= 5; i++)
         list3.add((Integer)(rand.nextInt(20) + 1));
      int sum = 0;
      System.out.println(list3);
      System.out.print("The average is: " );
      System.out.println(Recursive.findAvg(list3,sum,list3.size()));
      System.out.println("**********************************");
            //*******************************************************
      //Calling the fib method
      LinkedList fibList = new LinkedList();
      System.out.println("The list of the first 12 fibinaci numbers: ");
      Recursive.fib(fibList,12);
      System.out.println(fibList);
      System.out.println("***************************");
      
      //***********************************
      //Testin the reverse method
      LinkedList reverse = new LinkedList();
      System.out.println(fibList);
      Recursive.listReversed(fibList,reverse);
             System.out.println("The reverse list is: ");
      System.out.println(reverse);
      System.out.println("\n************************************************************\n");
      
   
   }
} //end of main method
/*
In this program you must use the following methods from the LinkedList class
getFirst
removeFirst
getLast
removeLast
size
get(index)
No loop can be used with any of the methods. methods with loop will get zero points.
*/
class Recursive
{
  /*This method gets a link list of integer values and returns a a new list in the reverse order of the original list
  Must implement it recursively*/
  public static void listReversed(LinkedList list, LinkedList reversed)
  {
     //base case when the size of the list is zero(this case will end the recursive call
     if (list.size() == 0) 
     {
        return;
     }
    // add the last element of the list to the reversed list
    reversed.add(list.getLast());
    // remove the last element from the list
    list.removeLast();
    // call listReversed with the two lists as the parameters
    listReversed(list, reversed); 
  }
  
  /*write a method to create the fibinaci series recursively
  fibonaci series for the first 8 numbers is:  1 1 2 3 5 8 13 21   
  This method must be implemented recursively
  max represents the number of the fibbonaci numbers that must be created*/
  public static void fib(LinkedList list, int max)
  {
   if (max == 0) 
   {
        return;
    }
    // if the list is empty
    if (list.size() == 0) 
    {
        // add 1 to the list
        list.add(1);
        // add 1 to the list
        list.add(1);
    } else {
        // find the sum of the last two numbers in the list, and add the result to the list
        int a = (Integer) list.getLast();
        int b = (Integer) list.get(list.size() - 2);
        list.add(a + b);
    }
    // decrement max by 1
    fib(list, max - 1); 
  }
  
  /*This method prints the content of a the link list in the reverse order recursively*/
   public static void printReverse(LinkedList list)
   {
      // base case is when the size of the list is zero
    if (list.size() == 0) 
    {
        return;
    }
    // print the last element in the list
    System.out.println(list.getLast());
    // remove the last element from the list
    list.removeLast();
    // call the printReverse method and pass the list
    printReverse(list); 
   }
   
   
   /*This method returns true if the list is palindrome
   must be implemented recursively
   no loop can be used. This method must be implemented using the LinkedList objects */
   public static boolean palindrome(LinkedList list)   
   {
     // base case if the size of the list is 1 or 2 return true
    if (list.size() <= 1) 
    {
        return true;
    }
    // check the equality of the first and last element in the list
    boolean b = list.getFirst().equals(list.getLast());
    if (!b) return false;
    list.removeFirst();
    list.removeLast();
    // return b && palindrome(list)
    return palindrome(list);
   }
   
   
   /*This method gets a string and finds the sequence of the asccii codes in the given string
   for example if The   the string is "abcdef" then the return must be " 97 98 99 100 101 102"*/
   public static String asccii(String s)  
   {
    // if the length of the string is 0 return "";
    if (s.length() == 0) 
    {
        return "";
    }
    // get the ascii code of the first letter in the string and store it in variable called code
    int code = (int) s.charAt(0);
    // remove the first letter from the String s by using the substring method
    // return code + " " + ascii(s)
    return code + " " + asccii(s.substring(1));
   }
   
   /*This method gets an arralist and a string, return the longets string in the list
   This method must be implemented recursively
   no loop can be used*/
   public static String longest(LinkedList list, String longest)  
   {
    // if the list size is zero return longest
    if (list.size() == 0) 
    {
        return longest;
    }
    // get the first element in the list by using the getFirst method and store it in a variable called s
    String s = (String) list.getFirst();
    // if s is longer than longest
    if (s.length() > longest.length()) 
    {
        // set longest to s
        longest = s;
    }
    // remove the first element from the list using removeFirst method
    list.removeFirst();
    // return longest(list, longest)
    return longest(list, longest);
   }
   
   /*This method compares two Link list to see if they conatin the same values in the reversse order
   1 2 3 4 5
   5 4 3 2 1
   should return true for the two list otherwise should return false
   */
   public static Boolean equalsReverse(LinkedList list1, LinkedList list2)    
   {
     // if the two lists don't have the same size return false
    if (list1.size() != list2.size()) 
    {
        return false;
    }
    // if the size of either of the list is zero return true
    if (list1.size() == 0) 
    {
        return true;
    }
    // get the first element in list1
    String s1 = (String) list1.getFirst();
    // get the last element in list2
    String s2 = (String) list2.getLast();
    // if the first and last elements are not equal return false
    if (!s1.equals(s2)) 
    {
        return false;
    }
    // remove the first element from list1
    list1.removeFirst();
    // remove the last element from list2
    list2.removeLast();
    // return true && equalsReverse(list1, list2)
    return equalsReverse(list1, list2);
   }
   
   /*
   this method finds the average of the integers in a list recursively.
   non-recursive solutions are not acceptable
   */
   public static int findAvg(LinkedList list, int sum, int size)
   {
    // if the size of the list is zero return sum / size
    if (list.size() == 0) 
    {
        return sum / size;
    }
    // add the first element to the sum
    sum += (Integer) list.getFirst();
    // remove the first element
    list.removeFirst();
    // return findAvg(list, sum, size)
    return findAvg(list, sum, size);
   }
} //end of class

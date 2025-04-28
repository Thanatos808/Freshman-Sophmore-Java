/*
Matthew Marks  
date:2/16/23
Description:converts pennies to dollars, quarters, dimes, and nickels
*/ 
/*_______________________________________________________________________________________________
Sample output: your code must match this output
2042 pennies is equal to: 
20 dollars
1 quarters
1 dimes
1 nickels
2 pennies

_________________________________________________________________________________________________________
*/
public class ConversionMarks
{
   public static void main(String[] args)
   {
      conversion();
    
     
   }
   /* This method finds the number of dollars, quarters dimes, nikels and pennies in 2042 pennies
   for example 138 pennies is:
   138 / 100 = 2 dollars
   138 % 100 = 38 pennies left
   38/25 = 1 quarter
   38 % 25 = 13 pennies left
   13/10 = 1 dime
   13%10 = 3 pennies left
   3/ 5 = 0 nikel
   3 % 5 = 3 pennies
   therfore 138 pennies is equla to 2 dollars, 1 quarter, 1 dime, 0 nikel and 3 pennies
   */
   public static void conversion()
   {
     /*input
     */
      int money = 2042;
      int pennies = 2042;
      /*output 100 pennies = 1 dollar
      */     
      int dollar = pennies/100;
      
      /*leftover
      */ 
      int left = pennies % 100;
      
      /*finds the number of quarters
      */
      int quarter = left / 25;
      left = left % 25;
      
      /*finds the number of dimes
      */
      int dime = left / 10;
      left = left % 10;
      
      /*finds the number of nickels
      */
      int nickel = left / 5;
      left = left % 5;
      /* displays output
      */
      System.out.println(pennies + " pennies is equivalent to");
      System.out.println(dollar + " dollar(s)");
      System.out.println(quarter + " quarter(s)");
      System.out.println(nickel + " nickel(s)");
      System.out.println(left + " pennies");
   }
   
}
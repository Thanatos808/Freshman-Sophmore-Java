/*Name:Matthew Marks
date:2/23/2023
Description: Program shows gallon to litre conversion,
utilizing for loops, class constant and variable scope.
*/
public class GallonConversionMarks  
{
   
   public static final double LITER = 3.7;
   
   public static void main (String[] args)
   {
     
      Display();
      System.out.println();
      Conversion();
            
   }
   ////////////////////////////////////////////////////////////
   /*Creates a display box of what the program is.*/
   public static void Display()
   {
      
     //your code for the method #1
      for (int i = 1; i <= 45 ; i++)
      {
         System.out.print("*");
      
      }
      System.out.println();
      System.out.println("* This program converts gallons to litters  *");
      System.out.println("*  1 Gallon is about 3.78 liters            *");
      for (int i = 1; i <= 45; i++)
      {
         System.out.print("*");
      } 
     
   } 
   
    
   
   ////////////////////////////////////////////////////////////////////
   /*Converts gallons to litres and utilizes for loops to 100 gallons*/
   public static void Conversion()  
   {
     //Your code for the method #2
      double gallon = 1;
      double litre = gallon * 3.7;
     
      System.out.println("gallon      Litter");
      for (int i = 1; i <= 100; i+= 4)
      {
         System.out.println(i + "           " + i * LITER );
      }
     
     
   }
      
           
     
}
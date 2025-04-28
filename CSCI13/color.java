import java.util.Scanner;
public class color
{
   public static void main(String[] args)
   {
      Scanner kb = new Scanner(System.in);
      System.out.print("Enter the color: ");
      String c = kb.next();
      String color = getColor(c);
      System.out.println("The color is : "+ color);
   }
   public static String getColor(String s)
   {
      if (s.equalsIgnoreCase("R"))
         return "Red";
      if (s.equalsIgnoreCase("G"))
         return "Green";
      if (s.equalsIgnoreCase("B"))
         return "Blue";
      return "Unknown";   
   }  
   public static String getColor2(String s)
   {
      String result = "unknown";
      if (s.equalsIgnoreCase("R"))
         result = "Red";
      else if (s.equalsIgnoreCase("G"))
         result = "Green";
      else if (s.equalsIgnoreCase("B"))
         result = "Blue";
      return result;  
   }           
}
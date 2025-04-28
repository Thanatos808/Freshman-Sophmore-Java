import java.util.*;
public class ThreeHeads
{
   public static void main(String[] args)
   {
      Random rand = new Random();
      toss(rand);
   }
   public static void toss(Random rand)
   {
      boolean flag = true;
      Scanner kb = new Scanner(System.in);
      int heads = 0; //priming
      while(flag)
      {
         heads = 0;
      
         
         while(heads < 3)
         {
            int num = rand.nextInt(2); //generate 0 or 1
            if(num == 0)
            {
               heads++;
               System.out.println("H");
            }
            else
            {
               heads = 0;
               System.out.print("T");
            }
         }
         System.out.println("\nThree heads in a row!");
         System.out.println("do you want to try it again");
         String s = kb.next();
         if(s.equalsIgnoreCase("no"))
            flag = false;
     }    
   }
}
import java.util.Scanner;
   public class Chapter5
   {
      public static void main(String[] args)
      {
         Scanner kb = new Scanner (System.in);
         String pass = password(kb);
         System.out.println(pass);
      }
      public static String password(Scanner kb)
      {
       //String p = "";
         System.out.println("Password ");
         String p = kb.next();
         while(p.length() < 10)
         {
            System.out.println("Password ");
            p = kb.next();
         }
         return p;
      }
   
   
   }
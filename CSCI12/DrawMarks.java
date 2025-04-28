/*
  Matthew Marks
  Program creates train picture
  
  2/2/2023
*/        
public class DrawMarks
{

   public static void main(String[] args)
   {
      complete();
   }
   public static void complete()
   {
      top(); /*work split into top and bottom to make easier.*/ 
      bottom();       
   }     
   public static void top()/*roof of train*/
   {
      System.out.println("           ~                              ~  ");
      System.out.println("           ~~                             ~~  ");
      System.out.println("          ~~~                            ~~~ ");
      System.out.println("        ~~~~~~                         ~~~~~~");
      System.out.println("         /  \\                          /  \\");  
      System.out.println("        /    \\                        /    \\");
      System.out.println("       /      \\                      /      \\");
      System.out.println("      /        \\                    /        \\");
   }
   public static void bottom()/*main body of train*/
   {
      System.out.println("         |''|                          |''|");
      System.out.println("         |''|                          |''|");
      System.out.println(" ________|''|________          ________|''|________ ");
      System.out.println("|                    |        |                    |");
      System.out.println("| ---          ---   |        | ---          ---   |");
      System.out.println("| ---          ---   |@------@| ---          ---   |");
      System.out.println("|                    |@------@|                    |");
      System.out.println("|                    |        |                    |");
      System.out.println("|____________________|        |____________________|");
      System.out.println("    CCC//////CCC                  CCC//////CCC      ");
      System.out.println("    CCC\\\\\\\\\\\\CCC                  CCC\\\\\\\\\\\\CCC ");
      System.out.println("    CCC//////CCC                  CCC//////CCC      ");
      System.out.println("Today\tis\ta\tsunny\tday");
      System.out.println("\\//");
      System.out.println("//\\");
   }
}              

/*
Name: Matthew Marks      
Date: 7 Feb. 2023
Program description: Displays the word cookbook

*/
public class CookBookMarks   
{
   public static void main(String[] args)
   {
      System.out.println("----------------------------------------");
      System.out.println("This program displays the word COOKBOOK in the following format");
      System.out.println("----------------------------------------\n\n");
      draw();
   }
   /*
     Description : This method calls all the other methods to generate the provided output
   */
   public static void draw()
   {
        LetterC();
        System.out.println();
        LetterO();
        System.out.println();
        LetterO();
        System.out.println();
        LetterK();
        System.out.println();
        LetterB();
        System.out.println();
        LetterO();
        System.out.println();
        LetterO();
        System.out.println();
        LetterK();
   }
   
   /*
      Description: This method displays the letter C
   */
   public static void LetterC()  
   {
        System.out.println("CCCCCCCCC      CCCCCCCCC");
        System.out.println("CC             CC");
        System.out.println("CC             CC");
        System.out.println("CC             CC");
        System.out.println("CCCCCCCCC      CCCCCCCCC");
   }
   
   /* 
   Description: This method displays the letter O
   */
   
   public static void LetterO()   
   {
        System.out.println(" OOOOOOOOO        OOOOOOOOO ");
        System.out.println("O         O      O         O");
        System.out.println("O         O      O         O");
        System.out.println("O         O      O         O");
        System.out.println(" OOOOOOOOO        OOOOOOOOO");
          }
   /*
   Description: This method displays the letter K
   */
   public static void LetterK()  
   {
        System.out.println("K     K          K     K ");
        System.out.println("K    K           K    K"); 
        System.out.println("K   K            K   K");
        System.out.println("K  K             K  K");
        System.out.println("K   K            K   K");
        System.out.println("K    K           K    K");
        System.out.println("K     K          K     K");        
      
   }
   /*
   Description: This method displays tthe letter B
   */
   public static void LetterB()    
   {
        System.out.println("BBBBBBB          BBBBBBB ");
        System.out.println("B     B          B     B ");
        System.out.println("B     B          B     B ");
        System.out.println("B    B           B    B");
        System.out.println("BBBB             BBB");
        System.out.println("B   B            B    B");
        System.out.println("B     B          B     B ");
        System.out.println("B     B          B     B ");
        System.out.println("BBBBBBB          BBBBBBB ");
   }
}
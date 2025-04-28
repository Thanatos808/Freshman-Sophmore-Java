import java.util.Scanner;
public class DataValidation
{
   /*
   public static void main(String[] args)
   {
      Scanner kb = new Scanner(System.in);
      int age = getAge(kb);
      System.out.println("Your age is : "+ age);
   }
   public static int getAge(Scanner kb)
   {
      //System.out.print("Enter your age: ");
      int age = 0;// kb.nextInt();
      while ( age <= 0 || age > 100) // 1 -100
      { 
         System.out.print("Enter your age: ");
         age = kb.nextInt();
      }
      return age;
    }
    */
   /* public static void main(String[] args)
   {
     Scanner kb = new Scanner(System.in);
     int num = getInt(kb); 
     System.out.println("The number you entered is : "+ num);
   }
   //hasNextInt(), hasNextDouble(), hasNextBoolean(), hasNext(), hasNextLine()
   public static int getInt(Scanner kb)
   {
     System.out.print("Enter an integer number: ");
     while(!kb.hasNextInt())
     {
        kb.nextLine();//discard the user's input
        System.out.print("Enter an integer: ");
     }
     int num = kb.nextInt();
     return num;
   }  */
   
    /* public static void main(String[] args)
   {
     Scanner kb = new Scanner(System.in);
     double gpa = getGpa(kb);
     System.out.println("Your gpa is : "+ gpa);
   }
   //gpa > 0 && < 5
   public static double getGpa(Scanner kb)
   {
     double gpa = 0;
     while(gpa <= 0 || gpa > 5)
     {
        System.out.print("Enter your gpa: ");
        while(!kb.hasNextDouble())
        {
           kb.nextLine();
           System.out.print("Enter your gpa: ");
        }
        gpa = kb.nextDouble();
        kb.nextLine();
     }   
     
     return gpa;
   }*/
 
 /*  public static void main(String[] args)
   {
      Scanner kb = new Scanner(System.in);
      Random rand = new Random();
      int a = -1;
      while(a > 0)
      {
         System.out.println(a);
         a--;
      }while(a > 0)
      int b = 0;
      do
      {
         System.out.print("Enter a num: ");
         b = kb.nextInt();
      }
      while(b < 0) */
   
      public static void main(String[] args)
   {
     Scanner kb = new Scanner(System.in);
     Random rand = new Random();
    /* while(true)
     {
        quiz(kb, rand);
        System.out.println("Next in line");
     } */
     boolean go = true;
     while(go)
     {
        quiz(kb, rand);
        System.out.print("another person? ");
        String answer = kb.next();
        if(answer.equalsIgnoreCase("no"))
             go = false;
        else     
           System.out.println("Next in line");

     }  
  }
  public static void quiz (Scanner kb, Random rand)
  {
     int wrong = 0;
     do
     {
        int n1 = rand.nextInt(20 - 1 + 1) + 1;
        int n2 = rand.nextInt(20 - 1 + 1) + 1;
        System.out.print(n1 + " + " + n2 + " = ");
        int user = kb.nextInt();
        if(n1 + n2 == user)
          System.out.println("Correct");
        else
        {
           System.out.println("Incorrect");
           wrong++;
        }  
          
     
     }while(wrong <=3);
     System.out.println("Sorry you had more than 3 errors");
  }   
}
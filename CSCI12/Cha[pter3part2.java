import java.util.Scanner; // step 1 
 public class Chapter3part2
{
   public static void main(String[] args)
   {
                //2. create a pointer to the scanner class
                Scanner kb = new Scanner(System.in);
                //prompt the user to enter a value
                System.out.print("Enter your age:");
                double age =kb.nextDouble();// nextInt(), next(), nextLine()
                System.out.print("Enter an integer value:");
                int number =kb.nextInt(); //reads an integer
                //next
                System.out.print("Enter your name:");
                String name = kb.next(); //reads one word
                //nextLine
                kb.nextLine();//flush the buffer to get rid of the enter key
                System.out.print("Enter your address:");
                String address = kb.nextLine(); // reads one or more words
                
                
                
                
              int a = 6;
                int b = 9;
                add(a,b);
                for(int i = 1; i <= 10; i++)
                {
               int c = add(a,b);
                System.out.println(a + " " + b + " = " + c);
                a++;
                b++;
                } 
          
               
               
               
               
                // calling the getCost in a loop
      double price = 4.7;
      double gallons = 14;
      for(int i = 1; i <= 10; i++)
      {
        double cost = gasCost(price,gallons);
         System.out.println("price" + price + " Gallons used : " + gallons + " cost = " + cost);
         price = price + 1;
         gallons = gallons + .5;
      }
      double w;// = 110;
      double height;// = 70;
      for (int i = 1; i <= 10; i++)
      {
        System.out.print("Enter your Weight: ");
        w = kb.nextDouble();
        
        System.out.print("Enter your height:");
        height = kb.nextDouble();
        
      
      
        double bmi = getBmi (w, height);
        System.out.println("Weight = " + w + " height = " + height + ", BMI = " + bmi);
      }
      }
                  /*write a method to calculate the body mass index
               this method accepts two parameters: weight and height
               returns the BMI
               (703 * weight) / (height * height)*/
  public static double getBmi(double height, double weight)
    {
      return (703 * weight) / (height * height);
    
    }
   
        /*write a method that accepts two parameters of type double: price per gallon,
        gallons used, display the money spent on gas*/
   public static double gasCost(double price, double gallons)
   {
      double cost = price * gallons;
      return cost;
      
   }
   
        
        //write a method to add two numbers
   public static int  add(int n1, int n2)
   {
      int c =n1 + n2; 
    //System.out.println(n1+ " " + n2 + " = " + c);
    return c;
   }  
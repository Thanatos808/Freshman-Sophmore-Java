/*name:Matthew Marks
date:3/5/2023
program description: calculates cost and hours of travel for gas and electric car
*/
import java.util.*; 
public class TravelMarks  
{
  /* the complete main method is given do not make any channges*/ 
   public static void main(String[] args)
   {
      Scanner kb = new Scanner(System.in);
      description();
      System.out.print("How many time do you want to use the app: ");
      int count = kb.nextInt();
      for(int j = 1; j <= count; j++)
      {   
         gasTravel(kb);
         for(int i = 1; i <= 30; i++)
            System.out.print("&");
         System.out.println();   
         electricTravel(kb);
         for(int i = 1; i <= 30; i++)
            System.out.print("&");
         System.out.println();
      } 
      System.out.println("GOOD BYE");   
   }
   /*This method calculates the total cost charging the battery, Stops represents 
the number of the charges*/
   
   public static double chargeCost(int stops, double pricePerCharge)
   {
     
      return 0;  // <--- must be changed
   }
   
   /*This method caluclates the total monet spend on the gas to travel */
   public static double gasCost(double distance, double milesPerGallon, double costPerGallon)
   {
      return 0;// <----- must be changed
   }
   
   /*This method caluclates the number of the stops needed to charge the battery.
    milePerCharge represents the number of the miles  driven with a fully charged 
battery*/ 
   public static int stops(double distance, double milePerCharge)
   {
      return 0; // <-----must be changed
   }
   /*This method caluclate the hours of travel taking your gas car*/
   public static double travelHoursGasCar(double distance , double speed)
   {
      return 0; // <------ must be changed
   }
   
   /*This method calculates the hours traveling using your electric car
   stops represenst the number of the times the car needs to be charged
   hoursPerStop represents the time it takes to fully charge your car
   distance represents the total distace traveled
   speed represents the speed of the car
   */
   public static double travelHoursWithElectricCar(int stops, double hoursPerStop, double distance, double speed)
   {
      return 0; //<-----must be changed
   }
   
   /*This method calculates the cost and the time to travel with a gas car*/
   public static void gasTravel(Scanner kb)
   {
      System.out.println("\nTraveling with a gas car\n");
      //prompt the user to enter the number of the miles to travel 
      System.out.print("Enter the total number of the miles you are traveling: ");
      double miles = kb.nextDouble();
      //declare a varibale and read the user's input
      System.out.print("Enter speed: ");
       //1. prompt the user to enter the speed
      double speed = kb.nextDouble();
      //2. declare a variable and read the user's input
      System.out.print("Enter miles per gallon: ");
      //3. prompt the user to enter the miles per gallon
      double mpg = kb.nextDouble();
      //4. declare a variable and read the user's input
      System.out.print("Enter cost per gallon: ");
      
      //5. prompt the user to enter the cost per gallon
      double gallonCost = kb.nextDouble();
      //6. declare a variable and read the user's input
      System.out.print("Traveling with your gas car");
             
      //7. call the method travelWithGas and pass the proper parameters  
       double travelWithGas = miles / speed;
       
       
      //8. call the method getCost and pass the proper parameters
       double getCost = (miles / mpg) * gallonCost;
      
      //display the hours of travle and the cost of the travel 
      System.out.println("\nTraveingl with your gas car: ");
      //display  the result you got at step 7
       System.out.print(" Hours " + travelWithGas);
       System.out.println();
      //display the result you got at step 8
       System.out.print(" Cost " + getCost);
       
   }
   public static void electricTravel(Scanner kb)
   {
   
      System.out.println("\nTraveling with an electric car\n");
      
      System.out.print("Enter the total number of the miles you are traveling: ");
      double distance = kb.nextDouble();
      //prompt the user to enter the speed
      System.out.print("Enter speed: ");
      //declare a variable to read the speed
     double speed = kb.nextDouble();
     //prompt the user to enter the miles that can be driven with a fully charged battery
       System.out.print("Enter total number of miles you can travel with a fully charged battery: ");
      
      //declare a variable and read the input
       double miles = kb.nextDouble();
      
      //1.prompt the user to enter the number of the hours it takes to fully chare the car battery
       System.out.print("Enter the number of hours it takes to charge your car: ");
      //2.declare a variable and read the user's input 
      double hours = kb.nextDouble();
      //3.prompt the user to enter the cost per battery charge
      System.out.print("Enter amount of money needed each time to fully charge the battery: ");
      //4.declare a variable and read the user's input
      double cost = kb.nextDouble();
      
      //5.call the method stops with the proper parameters
      
      
      //6.call the method travelHourWithElectric with the proper parameters
      double  travelHourWithElectric = distance / speed + (distance / miles) * hours;                
      //7.call the method  chargeCost with the proper parameters 
      double chargeCost = (distance / miles)* cost;
      
      System.out.println("\nTraveling with your electric car\n");
      
      //display the results that you got in step 6 
      System.out.print(" Hours of travel " + travelHourWithElectric);
      System.out.println();
      //display the result from step 7   
      System.out.print(" charge cost " + chargeCost);       
   }
/* feel free to change the code in this method*/
   public static void description()
   {
      for(int i = 1; i <= 80; i++)
         System.out.print("&");
      System.out.println();
      System.out.println("This program calculates the cost and the time to travel to your destination ");
      System.out.println(" given the needed information for both gas car and the electric car.");
      System.out.println("Just answer some simple questions"); 
      for(int i = 1; i <= 80; i++)
         System.out.print("&");
      System.out.println();
   
       
   }
    
}
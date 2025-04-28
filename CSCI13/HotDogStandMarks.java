/*
Name:Matthew Marks   
Description: You have Hotdogs stand throughout the town and you want to be able to manage them. You want to find
out the number of the hotdogs sold at each stand and the total income from all the stand
date:2/18/2024
*/

import java.util.*;

public class HotDogStandMarks  
{
  //no code here
}
class HotDogStand
{
   public static int price = 10;
   public static int soldPrice = 12;
  /*declared all the instance variables*/ 
   private int ID; //ID for stand
   private String owner; // Owner of stand
   private String address; // Address of stand
   private int countSold; //Hotdogs sold
  
  
   //*created the constructor. refer to the UML diagram given in the document
   public HotDogStand(int ID, String owner, String address)
   {
      this.ID = ID; // constructor for ID
      this.owner = owner; // constructor for owner
      this.address = address; //constructor for address
      this.countSold = 0; //constructor for countSold, none sold intially
   }
   
   //*created all the required getter methods.refer to the UML diagram*/
   public int getID()
   {
      return ID;
   }   
   public String getOwner()
   {
      return owner;  
   }
   public String getAddress()
   {
      return address;
   }
   public int getCountSold()
   {
      return countSold;
   }
   
   
   //*declared all the setter methods. Refer to the UML diagram*/
   public void setAddress(String newAddress)
   {
      this.address = newAddress;
   }
   public void setOwner(String newOwner)
   {
      this.owner = newOwner;
   }
   
   
    
      
      
  //* created the order method. This method increased the countSold by the paramter count*/
   public void order(int count)
   {
      this.countSold += count;
   
   }
   /*
   Created the income method. This method calculates the income for the give station. The income can be calculate by
   the difference of soldPrice - price multiplyied by the countSold
   
   */
   public double income()
   {
      return (soldPrice - price) * countSold;
   }
   
   
   
   
   /*Created the toString method
   This method creates a String representing the HotDogStand.*/
   
   public String toString()
   {
      return "Station#: " + ID + 
             "\nOwner: " + owner +
             "\nAddress: " + address +
             "\nHot dog sold: " + countSold +
             "\nIncome: " + income();
   }
      
}
/*
Driver creates three hot dog stations. The stand ID# is generated randomly.Created three objects representing
the hotdog stand class. Number of hotdogs sold at each is generated randomly.
*/
class YourDriver
{
   public static void main(String[] args)
   {
      Random rand = new Random();
             
       //generate the first randon number and assign it to n1. must call the getRandNum that is given in this code
      int n1 = getRandNum(rand, 99999, 9999999);
       
       //generate the second randon number and assign it to n2
      int n2 = getRandNum(rand, 99999, 9999999); 
        
       //generate the third randon number and assign it to n3
      int n3 = getRandNum(rand, 99999, 9999999); 
       
       //n1, n2 n3 must be unique. a while loop is needed to check if they are unique or not
      while (n1 == n2 || n2 == n3 || n1 == n3)
      {
        //generate three random numbers, assign them to n1, n2, n3. must call the gerRandNum 3 times
         if (n1 == n2) n1 = getRandNum(rand, 99999, 9999999);
         if (n2 == n3) n2 = getRandNum(rand, 99999, 9999999);
         if (n1 == n3) n3 = getRandNum(rand, 99999, 9999999); 
      }
       
       
       
       //declare and instantiate three HotDogStand objects. with the choice of your locations.         
      HotDogStand stand1 = new HotDogStand(n1, "Matt", "Folsom");  //object 1       
      HotDogStand stand2 = new HotDogStand(n2, "Matt", "Rocklin");  //object 2              
      HotDogStand stand3 = new HotDogStand(n3, "Matt", "Roseville"); //object 3
              
       //generate three random numbers for the hotdogs sold at each stand between 200 - 500 and store them in c1, c2, c3. 
      int c1 = getRandNum(rand, 200, 500); //stand1
      int c2 = getRandNum(rand, 200, 500); //stand2
      int c3 = getRandNum(rand, 200, 500); //stand3        
       
       //call the order method on each HotDogStand object you created and pass c1, c2, c3 random numbers you created for the hotdogs sold
      stand1.order(c1);
      stand2.order(c2);
      stand3.order(c3);
                      
       
       //getting the total number of the hotdogs orderd at all of your stands.   
      int t1 = stand1.getCountSold();//for stand1
      int t2 = stand2.getCountSold();//for stand2
      int t3 = stand3.getCountSold();//for stand3
       //call the getCountSold on the each of your stands and store the result in t1,t2,t3. 
      int totalSold = t1 + t2 + t3;
             
       //call the method income on each of your stand and store each reslut in income1, income2, income3
      double income1 = stand1.income();
      double income2 = stand2.income();
      double income3 = stand3.income();
       
              
       //find the total income by adding income1, income2, income3
      double totalIncome = income1 + income2 + income3;
        
       
       //displaying the info            
      System.out.println(stand1);
      System.out.println("_______________________________________________");
       
       //call the tostring method on stand 2 you created
      System.out.println(stand2);
      System.out.println("_______________________________________________");
       //call the tostring method on the stand 3 you created
      System.out.println(stand3);
      System.out.println("________________________________________________");
       
       //display total hotdogs sold that you calculated
      System.out.println("Total hotdogs sold: " + totalSold);
       //display total income you calculated 
      System.out.println("Total income: $" + totalIncome);
   
   
     
   }
   public static int getRandNum(Random rand, int min, int max)
   {
      return rand.nextInt(max - min + 1) + min;
   }
}
/*This driver helps you on how to call the non-static methods from the HotDogStand class*/

class MyDriver
{
   public static void main(String[] args)
   {
      Random rand = new Random();
    //creating three objects
      HotDogStand stand1 = new HotDogStand(rand.nextInt(9999999)+99999, "Jose", "Folsom");
      HotDogStand stand2 = new HotDogStand(rand.nextInt(99999999)+99999, "Jose", "Rocklin");
      HotDogStand stand3 = new HotDogStand(rand.nextInt(99999999)+99999, "Jose", "Folsom");
       
      //ordering hot dogs at different stand
      stand1.order(100);
      stand2.order(150);
      stand3.order(175);
       
       //claculating the income form the stations
      double stand1Income = stand1.income();
      double stand2Income = stand2.income();
      double stand3Income = stand3.income();
       
       //getting the total number of the hotdogs orderd at all the stations
      int total = stand1.getCountSold() + stand2.getCountSold()+ stand3.getCountSold() ;
      double totalIncome = stand1.income() + stand2.income() + stand3.income();
       
       //displaying the info
      System.out.println(stand1);
      System.out.println("_______________________________________________");
      System.out.println(stand2);
      System.out.println("_______________________________________________");
      System.out.println(stand3);
      System.out.println("________________________________________________");
      System.out.println("Total hotdogs sold at all the stations: " + total);
      System.out.println("________________________________________________");
      System.out.println("Total income: " + totalIncome);
       
       
   
       
       
   }
}

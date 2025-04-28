/*
name: Matthew Marks
description: Create a class to keep track of the amount of money that a person can make based on the
commission. Each person has a base salary and they will get commission every time they sell an
item. Each rep can get a raise on the base salary.
date: 5/5/2023
*/

public class SaleStudentMarks 
{
   private double commissionRate;
   private double baseSalary;
   private double sales;
   private String fullName;
}

class SaleRep 
{
   // instance variables
   private double commissionRate;
   private double baseSalary;
   private double sales;
   private String fullName;

   // constructor
   public SaleRep(double baseSalary, double commissionRate, String fullName)
   {
      this.baseSalary = baseSalary;
      this.commissionRate = commissionRate;
      this.sales = 0;
      this.fullName = fullName;
   }

   // getter methods
   public double getCommission() 
   {
      return sales*commissionRate/100;
   }

   // setter methods

   // calculate the total monthly pay by calculating the commission that the person received
   public double paycheck() 
   {
      return baseSalary + sales * commissionRate / 100.0;
   }

   // this method is called every time the employee has a new sale
   public void addSale(double newSale) 
   {
      sales += newSale;
   }

   // reducing the sale
   public void returnItem(double amountReturned) 
   {
      sales = Math.max(sales - amountReturned, 0);
   }

   public void getRaise(double raiseRate) 
   {
      baseSalary *= (1 + raiseRate / 100.0);
   }

   // toString method
   public String toString() 
   {
      return "Name: " + fullName + ", Base Salary: $" + baseSalary + ", Commission Rate: " + commissionRate
             + "%, Total Sales: $" + sales + ", Paycheck: $" + paycheck() + "\nThe Commission you made: " + getCommission()
             + "\nTotal paid this month: " + paycheck();
   }
}


class MyDriver {
   public static void main(String[] args)
   {
      // creating objects of SaleRep
      SaleRep e1 = new SaleRep(1000, 6, "Jose Rodriguez");
   
      // sales for employee e1: Jose
      e1.addSale(5000);
      e1.addSale(3000);
      e1.addSale(1200);
   
      // an item is returned, therefore the sale amount must be adjusted
      e1.returnItem(5000);
   
      // another item is sold by
      e1.addSale(345);
   
      System.out.println(e1);
   
      // get a raise
      e1.getRaise(5);
   
      // displaying the result after the raise
      System.out.println(e1.toString());
      System.out.println("-------------------------------------------------------------------------");
   
      // Sale rep #2
      SaleRep e2 = new SaleRep(1800, 12, "Maria Chavez");
   
      // adding sale
      e2.addSale(1234);
      e2.addSale(7645);
      e2.addSale(3456);
   
      // an item is returned, therefore the sale amount must be adjusted
      e2.returnItem(5000);
   
      // another item is sold
      e2.addSale(345);
   
      System.out.println(e2);
   
      // got a raise
      e2.getRaise(8);
   
      // displaying the info after the raise
      System.out.println(e2);
      System.out.println("---------------------------------------------------------------------------");
   }
}

// create 2 Objects of SaleRep of your choice
// create similar code given in the MyDriver class for each of the objects
// This driver has 15 points
// do not copy and paste the provided driver since it does not help you to learn
class YourDriver 
{
   public static void main(String[] args)
   {
      // create the first object
      SaleRep e1 = new SaleRep(1500, 10, "John Doe");
   
      // add sales
      e1.addSale(2000);
      e1.addSale(3500);
   
      //
   }
}
/*
Name:Matthew Marks
Date:3/3/2024
Description:The program is designed for Southwest Airlines to manage passenger lists on flights, 
allowing the addition and deletion of passengers, displaying all passenger information, 
counting passengers, searching for specific passengers, and listing all passengers' last names. 
It treats planes as containers for passenger data, with each passenger having attributes like first and last name, ticket ID, seat number, and class.
*/
import java.util.*;
public class AirplaneMarks
{
  //no code goes here
}
class Person
{
	 //storing personal info
   private String name;
   private String lastName;
   private String phone;
   
   //constructor
   public Person(String name, String lastName, String phone)
   {
      this.name = name;
      this.lastName = lastName;
      this.phone = phone;
   }
   //setters
   public void setName(String name)
   {
      this.name = name;
   }
  
   public void setLastName(String lastName)
   {
      this.lastName = lastName;
   }
  
   public void setPhone(String phone)
   {
      this.phone = phone;
   } 
  //getters
   public String getName()
   {
      return this.name;
   }
  
   public String getLastName()
   {
      return this.lastName;
   }        
  
   public String getPhone()
   {
      return this.phone;
   }
  
   public String toString()
   {
      return "Name: " + name + "\nLast Name: " + lastName + "\nPhone: " + phone;
   }
  
   public boolean equals(Object o)
   {
      if (this == o) 
         return true;
      
      if(!(o instanceof Person)) 
         return false;
      
      Person p = (Person) o;
      
      return this.lastName.equals(p.lastName) && this.name.equals(p.name);
   }
   
   
  
}

class Passenger extends Person
{
	//additional info for passenger relating to plane
   private int seatNumber;
   private String classType;
   private String ticketId;
   
   public Passenger(String name, String last, String ticketId, int seatNumber,String classType, String phone)
   {
      super(name, last, phone);
      this.seatNumber = seatNumber;
      this.classType = classType;
      this.ticketId = ticketId;
   }
   //to change seat number
   public void changeSeatNumber(int num)
   {
      this.seatNumber = num;
   }
   
   //setter
   public void setClass(String classType)
   {
      this.classType = classType;
   }
   //getters
   public String getClassType()
   {
      return classType;
   }
   
   public int getSeatNumber()
   {
      return seatNumber;
   }
   
   public String getTicketId()
   {
      return ticketId;
   }
   //setter for ticket ID
   public void setTicketId(String ticketId)
   {
      this.ticketId = ticketId;
   }
   
   public String toString()
   {
      return super.toString() + "\nSeat number: " + seatNumber + "\nClass: " + classType + "\nTicketID: " + ticketId;
   } 
   
}
//interface for passenger list
interface list {   
   public boolean add(Object o);
   public Object search(Object o);
   public boolean delete(Object o);
   public void printLast();
   public void takeOff();
}

class Airplane implements list
{
    
   public static int count = 0;
    private Passenger[] plane;
    private boolean takeOff;
    private int planeNum;

    // constructor
    public Airplane(int planeNum) 
    {
        this.planeNum = planeNum;
        this.plane = new Passenger[10];
        this.takeOff = false;
    }
    //getters and setters
    public int getPlaneNumber() 
    {
        return planeNum;
    }

    public void setPlaneNumber(int num) 
    {
        this.planeNum = num;
    }

    public static int getCount() 
    {
        return count;
    }

    public boolean add(Object o) 
    {
        
        if (takeOff || !(o instanceof Passenger)) 
        {
            return false;
        }
        for (int i = 0; i < plane.length; i++) 
        {
            if (plane[i] == null)
            {
                plane[i] = (Passenger) o;
                count++;
                return true;
            }
        }
        return false;
    }

    public Object search(Object o) 
    {
       
        String lastName = null;
        if (o instanceof String) 
        {
            lastName = (String) o;
        }

        if (lastName != null) 
        {
            for (int i = 0; i < plane.length; i++) 
            {
                if (plane[i] != null && plane[i].getLastName().equalsIgnoreCase(lastName))
                {
                    return plane[i];
                }
            }
        }
        return null;
    }

    public boolean delete(Object o) 
    {
        //complete this method
        if (!(o instanceof String)) 
        {
            return false; 
        }
        String lastName = (String) o; 

        for (int i = 0; i < plane.length; i++) {
            if (plane[i] != null && plane[i].getLastName().equalsIgnoreCase(lastName)) 
            {
                plane[i] = null;
                count--;
                return true;
            }
        }
        return false;
    } 

    public void printLast() 
    {
        
        for (Passenger p : plane) 
        {
            if (p != null) 
            {
                System.out.println(p.getLastName());
            }
        }
    }

    public void takeOff() 
    {
        
        this.takeOff = true;
    }
	
}
/* Do not delete the given driver , The class Driver must be in your code when you submit it
Once you complete all the classes uncommnet the given driver to test your code.*/
	
class Driver {
   public static void main(String[]args) {
      Scanner in = new Scanner(System.in);
   	
      Scanner kb = new Scanner(System.in);
      Airplane plane = new Airplane(817345);
      Passenger p1 = new Passenger("Bobby", "Smith", "123456789", 1, "First class", "916-222-3333");
      Passenger p2 = new Passenger("Johnny", "Apples", "987654321", 8, "Business class", "818-000-1234");
      Passenger p3 = new Passenger("Tommy", "Jerrys", "567123489", 32, "Economy class","202-222-3333");
      Passenger p4 = new Passenger("Candy", "Cruze", "982134567", 15, "Premium Economy class","707-444-5555");
      
      //this passenger will be added after take off
      Passenger p5 = new Passenger("Kalotiii", "Aaronn", "762134589", 5, "Economy plus","817-222-6666");
      
      plane.add(p1);
      plane.add(p2);
      plane.add(p3);
      plane.add(p4);
      System.out.println("The palne is about to take off");
      plane.takeOff();
      System.out.println("adding a passenger after take off");
      plane.add(p5);
      String repeat = "";
      while(plane.getCount() > 0) 
      {
      
         System.out.println("Here is the list of the passengers in this plane");
         System.out.println("There are " + plane.getCount() + " Passengers on this plane"); 
         System.out.println(plane + "\n");
      
         System.out.println("Testing the printLast method to display the last names");
         plane.printLast();  
         System.out.println();
         
         System.out.println("Testing the static method getCount");
         System.out.println("This train has " + plane.getCount() + " Passengers\n");
         
         System.out.print("Enter the last name of the passenger to search for: ");
         String lastName = in.nextLine();
         System.out.println(plane.search(lastName));
         System.out.println();
         
         System.out.println("Testing the delete method");
         System.out.print("Enter the last name of the passenger to be deleted: ");
         String last = in.nextLine();
         plane.delete(last);
         System.out.println("Passenger " + last + " has been removed from the list\n");
         
         System.out.println("Here is the updated list");
         System.out.println(plane);
         System.out.println("*********************");
         System.out.print("Press any key to continue : ");
         repeat = kb.nextLine();
      }
      System.out.println("No passenger left on this airplane");
   	
   }
}
/*Complete the following driver to include the required code.*/
/*20 points is allocated for this driver*/
class marksDriver
{
   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
   	
      Scanner kb = new Scanner(System.in);
      Airplane plane = new Airplane(817345);
      Passenger p1 = new Passenger("Lebron", "James", "57621456", 1, "First class", "310-425-2323");
      Passenger p2 = new Passenger("Snoop", "Dogg", "12345687", 8, "Business class", "310-386-4747");
      Passenger p3 = new Passenger("Terry", "Crews", "992463", 32, "Business class","916-787-9999");
      Passenger p4 = new Passenger("Yao", "Ming", "982134567", 15, "Business class","777-011-2345");
      
      //this passenger will be added after take off
      Passenger p5 = new Passenger("John", "Smith", "762134589", 5, "Economy plus","817-222-6666");
      
      plane.add(p1);
      plane.add(p2);
      plane.add(p3);
      plane.add(p4);
      System.out.println("The palne is about to take off");
      plane.takeOff();
      System.out.println("adding a passenger after take off");
      plane.add(p5);
      String repeat = "";
      while(plane.getCount() > 0) 
      {
      
         System.out.println("Here is the list of the passengers in this plane");
         System.out.println("There are " + plane.getCount() + " Passengers on this plane"); 
         System.out.println(plane + "\n");
      
         System.out.println("Testing the printLast method to display the last names");
         plane.printLast();  
         System.out.println();
         
         System.out.println("Testing the static method getCount");
         System.out.println("This train has " + plane.getCount() + " Passengers\n");
         
         System.out.print("Enter the last name of the passenger to search for: ");
         String lastName = in.nextLine();
         System.out.println(plane.search(lastName));
         System.out.println();
         
         System.out.println("Testing the delete method");
         System.out.print("Enter the last name of the passenger to be deleted: ");
         String last = in.nextLine();
         plane.delete(last);
         System.out.println("Passenger " + last + " has been removed from the list\n");
         
         System.out.println("Here is the updated list");
         System.out.println(plane);
         System.out.println("*********************");
         System.out.print("Press any key to continue : ");
         repeat = kb.nextLine();
      }
      System.out.println("No passenger left on this airplane");
   	
   }

}

/*
Name:Matthew Marks
Description: Creates a social media app that allows you to create a list of the people you can follow. Also allows you to follow your followers. 
App is somewhat similar to Instagram.
*/
import java.util.*;
public class InstagramMarks
{
   //no code here
}
class User implements Comparable 
{
   private String first;
   private String last;
   private String username;
   private boolean followBack; 
   private int followerCount;//add an attribute of your choice
     
   //make sure to include the attribute of your choice in the constructor     
   public User(boolean followBack, String first, String last, String username){
       //your code
       this.followBack = followBack;
       this.first = first;
       this.last = last;
       this.username = username;
       this.followerCount = 0;
   }
   public boolean getFollow()
   {
      return followBack; 
   }
   public void unfollow()
   {
     this.followBack = false; 
   }
   public void follow()
   {
      this.followBack = true; 
   }
   public String getFirst() {
      return first; 
   }
   public String getLast() {
      return last; 
   }
             
   public void setFirst(String first) {
    this.first = first;  
   }
   public void setLast(String last) {
      this.last = last; 
   }
   public String getUsername()
   {
      return username; 
   }
   public int compareTo(User other) 
   {
      if (other == null) return 1;   
      return this.username.compareTo(other.username);
   }
   public boolean equals(User other) {
   
      if (this == other) return true; 
         if (other == null) return false; 
         return this.username.equals(other.username);
       
   }
   public String toString() {
     //your code
      return "User Name: " + username + "\nFirst: " + first + "\nLast: " + last + "\nFollow Back: " + followBack
      + "\nFollower Count: " + followerCount;
           
   }
   public int getFollowerCount() //getter method for the attribute you added
   {
      return followerCount;
   }
   public void setFollowerCount(int followerCount) //setter method for the attribute you added
   {
      this.followerCount = followerCount;
   }
}
class Instagram{
   private ArrayList<User> app;
     
    
   Instagram(){
      app = new ArrayList<User>();
         
       
   }
   public void followBack(String first, String last)
   {
     for(User user : app)  //your code
     {
        if (user.getFirst().equals(first) && user.getLast().equals(last))
        {
         user.follow();
        }
     }
   
   }
   public boolean follow(boolean followBack, String first, String last, String username) {
      for (User user : app)
      {
         if (user.getFirst().equals(first) && user.getLast().equals(last))    	//your code
         {
            return false; // must change
         }
      }   	 
                          	
   }
     
    /*This method removes the person from the list meaning that they are not following you
    and you are not following them*/
   public boolean delete(String first, String last ) 
   {
       return app.removeIf(user -> user.getFirst().equals(first) && user.getLast().equals(last));
   }
           
    
   public boolean find(String first, String last) {
      for (User user : app)
       {
            if (user.getFirst().equals(first) && user.getLast().equals(last)) 
            {
                return true;
            }
        }
        return false;
      
   }
    
   public ArrayList<User >getList(){
      return app;
   }
   public int followersNum()
   {
     int count = 0;
     for (User user : app)
     {
      if (user.getFollow())
      {
         count++;
      }
     }
     return count;
   }
   public int followingsNum()
   {
      return app.size();      
   } 
   public String toString() 
   { 
     StringBuilder sb = new StringBuilder();
        for (User user : app) 
        {
            sb.append(user.toString()).append("\n***************************************************************\n");
        }
        return sb.toString();
   
   }
}
/* create your own driver here
Must create a list with 5 users.
Make sure to call all the methods you wrote */
class MyDriver
{
   public static void main(String[] args)
   {
      
      
      
      //your code here: should be similar to the given driver below
   }
}

/*below is a sample driver. Do not remove this driver from your code when sub,itting it*/
class Driver{
   public static void main(String[]args) {
      Instagram myInsta = new Instagram();
      
    	/*Adding followers to your list*/
      /*the boolean field indicates whether you want to follow them back*/
      myInsta.follow(true, "Matthew", "Philips", "MatPhil"); // must modify this line to include the added attribute
      myInsta.follow(false, "Gary", "Kane",  "GKane"); //// must modify this line to include the added attribute
      myInsta.follow(true, "Robert", "Kenny",  "RKenny"); //// must modify this line to include the added attribute
      myInsta.follow(true, "Bill", "Fitch", "BillF");//// must modify this line to include the added attribute
      myInsta.follow(false, "Trevor", "Schlulz", "TrevorS");//// must modify this line to include the added attribute
      
    	/*Displaying your followers*/
      System.out.println("Your followers informations\n");
      System.out.println(myInsta);
    	
      /*Unfollowing a user*/
      System.out.println("Removing Robert Kenny from your followers list");
      myInsta.delete("Robert", "Kenny");
   	
      /*Displaying the list*/
      System.out.println("List of followers after removing Robert Kenny");
      System.out.println(myInsta);
   	
      /*adding a new follower*/
      System.out.println("Adding Elon Musk to your list of followers");
      myInsta.follow(true, "Elon", "Musk", "ElonM");
      
      /*Dipslying the followers*/
      System.out.println("List of your followers:");
      System.out.println(myInsta);
   	
      /*Searching for a follower*/
      System.out.println("Searching for Stonewall Jackson(StonW) in your followers list");
      if(myInsta.find("Jackson", "Stonewall") == false) {
         System.out.println("Stonewall Jackson is not in your list of followers");
         System.out.println("\n***************************");   
         System.out.println("You are following " + myInsta.followersNum() + " people");
      
         System.out.println("You have " + myInsta.followingsNum() + " followers");  
         System.out.println(myInsta);
         Scanner kb = new Scanner(System.in);
         System.out.println("Enter the first name and the last name of  of the person that you want to follow back: ");
      
         String first =kb.next();
         String last = kb.next();
          
         myInsta.followBack(first, last);
      
         System.out.println(myInsta);
      
      }
   	
   }
}
/*
Name:Matthew Marks
Date:2/24/224
description:Create an Email application with the following functionality.Create an email and send it to the recipient and/or CC some other recipients
Forward an email that was sent previously to some recipients
Modify the attributes of the email that has been created but has not been sent yet. Note that an
email that has been sent out cannot be modified. Attributes that may be modified are sender subject recipient conten
*/

import java.util.*;
public class DocMarks  
{
   //no code here
}
class Document
{
 
   private String content; 
 
   public Document(String text)
   {
      this.content = text;
   }
   
   public String getText()
   {
      return content; // returns documents contents
   }
   
   public void setContent(String newContent)
   {
      this.content = newContent;
   }
   
   public String toString()
   {
      return content;
   }
   
   public int characterCount()
   {
      return content.length(); //counts and returns the number of characters in the document
   }
   
   public int countWords()
   {
      if (content == null || content.isEmpty())
      {
         return 0;
      }
      String[] words = content.split(" ");
      return words.length;
   }
   
   public boolean find(String keyword)
   {
      return content.contains(keyword);// checks if document has keyword
   }
   
   public boolean equals(Document other)
   {
      return this.content.equalsIgnoreCase(other.content);
   }
   
   
}
class Email extends Document
{  
  public static String message = "sent emails cannot be modified";                      
    
  private String sender; // email sender
  private String recipient; // primary recipient of the email
  private Date date; // date the email was sent
  private String subject; //subject of the email
  private String cc; // cc recipients
  private boolean isSent = false;
     
  public Email(String text, String sender, String recipient, String subject, String cc)
  {
     super(text);
     this.sender = sender;
     this.recipient = recipient;
     this.subject = subject;
     this.cc = cc;
     this.date = new Date(); //sets date to current time   
  }
  //getter methods for Email class
  public void send()
  {
     this.isSent = true;
  }    
   
   public String getSender()
   {
      return sender;
   }
   
   public String getRecipient()
   {
      return recipient;
   }
   
   public String getSubject()
   {
      return subject;
   }
   
   public String getCC()
   {
      return cc;
   }
   
   public Date getDate()
   {
      return date;
   }
   
   public boolean getIsSent()
   {
      return isSent;
   }
   //setter methods for Email class
   public void setSender(String sender)
   {
      if (!isSent)
      {
         this.sender = sender;
      }
      else
      {
         System.out.println(message);
      }
   }
   
   public void setRecipient(String recipient)
   {
      if (!isSent)
      {
         this.recipient = recipient;
      }
      else
      {
         System.out.println(message);
      }
   }
   
   public void setSubject(String subject)
   {
      if (!isSent)
      {
        this.subject = subject;
      }
      else
      {
         System.out.println(message);
      }
   }
   
   public void setCC(String cc)
   {
      if (!isSent)
      {
         this.cc = cc;
      }
      else
      {
         System.out.println(message);
      }
   }
   
   public void editContent(String newText)
   {
      if(!isSent)
      {
         super.setContent(newText);
      }
      else
      {
         System.out.println(message);
      }
   }
   
   public Email forward(String recipient, String sender, String cc)
   {
     Email forwardedEmail = new Email(this.getText(), sender, recipient, this.subject, cc);
     return forwardedEmail;
   }
   
   public String toString()
   {
      return "From: " + sender + "\nTo: " + recipient + "\nnCC: " + cc + "\nDate: " + date + "\nSubject: "
      + subject + "\nContent: " + super.toString();
   }   
     
} 

//****************************************************************************************
class EmailDriver
{
    // public Email(String text, String sender,String recipiant, String subject, String cc)
    public static void main(String[] args)
    {
      //creating an Email object
       Email e1 = new Email("Good morning, the exam date has been changed. check the Canvas", "Teacher","All Students","Exam","");
      
       //sending the email
       e1.send();
       
       //disply the details about the email
       System.out.println(e1);
       System.out.println("\n\n");
       
       //searching the email for the email for the word tomorrow
       boolean b = e1.find("tomorrow");
       if(b)
         System.out.println("The word tomorrow was  found in the email");
       else
          System.out.println("The word tomorrow was not found in the email"); 
           
      
       //displaying just the content(text) of the email
       System.out.println("\nThe content of this email is: " + e1.getText());
       System.out.println();
       //modifying the content of the email
       e1.editContent("bye");
       System.out.println(e1.countWords());
       
       //changing the recipient of the e1 email
       e1.setRecipient("Jose@yahoo.com,Mary@gmail.com");
       System.out.println();
       
       //forwarding the email
       Email forward = e1.forward("Jose", "Ahmad" ,"Bruce");
       System.out.println();
       
       //printing the forwarded email 
       System.out.println("Here is the forwarded message\n");
       System.out.println("forwarded message\n"+ forward);
       System.out.println();
       
       //display the length of the text in the email
       System.out.println("The number of the letters in the email is: " + e1.characterCount());
       
       System.out.println("\n\nDisplaying the email again");
       
       System.out.println(e1);
       
    }
}

class YourDriver
{
    // public Email(String text, String sender,String recipiant, String subject, String cc)
    public static void main(String[] args)
    {
      //creating an Email object
       Email e1 = new Email("Good morning, the class schedule has been changed. Please check Canvas", "Teacher","All Students","Schedule","");
      
       //sending the email
       e1.send();
       
       //disply the details about the email
       System.out.println(e1);
       System.out.println("\n\n");
       
       //searching the email for the email for the word tomorrow
       boolean b = e1.find("schedule");
       if(b)
         System.out.println("The word schedule was found in the email");
       else
          System.out.println("The word schedule was not found in the email"); 
           
      
       //displaying just the content(text) of the email
       System.out.println("\nThe content of this email is: " + e1.getText());
       System.out.println();
       //modifying the content of the email
       e1.editContent("bye");
       System.out.println(e1.countWords());
       
       //changing the recipient of the e1 email
       e1.setRecipient("Alex@yahoo.com,Matthew@gmail.com");
       System.out.println();
       
       //forwarding the email
       Email forward = e1.forward("Tony", "Dave" ,"John");
       System.out.println();
       
       //printing the forwarded email 
       System.out.println("Here is the forwarded message\n");
       System.out.println("forwarded message\n"+ forward);
       System.out.println();
       
       //display the length of the text in the email
       System.out.println("The number of the letters in the email is: " + e1.characterCount());
       
       System.out.println("\n\nDisplaying the email again");
       
       System.out.println(e1);
   }    
}
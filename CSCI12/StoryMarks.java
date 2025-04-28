/*
Name:Matthew Marks
Date:3/7/2023
program description: Writes a story that allows user input to fill in the blanks.
*/

import java.util.*;
public class StoryMarks
{
   //no code goes here
}
class MyStory  
{
 
   public static void main(String[] args)
   {
      Scanner kb = new Scanner(System.in);
      System.out.print("How many stories are you making: ");
      int count = kb.nextInt();
      kb.nextLine(); //flush buffer
      for(int i = 1; i <= count ; i++)
      {
         System.out.println("Answer a few questions and I will make up a story for you\n");
         Baseball();
      
      }
   
   }

   public static void Baseball()
   {
      Scanner kb = new Scanner(System.in);
      int age;        
      String name;
      String hometown;
      String team;
      String equipment;
      String rivalCity;
      String rivalTeam;
      String atBat;
      String outcome;
      String seasons;
      System.out.print("What is your name? ");//user input section
      name = kb.next();
      System.out.print("How old are you? ");
      age = kb.nextInt();
      kb.nextLine(); 
      System.out.print("What is your hometown? ");
      hometown = kb.nextLine();
      System.out.print("Pick a sports mascot. ");
      team = kb.nextLine();
      System.out.print("Pick between a bat or glove. ");
      equipment = kb.nextLine();
      double price = Math.pow(age, 2);
      System.out.print("What city is your rivals from? ");
      rivalCity = kb.nextLine();
      System.out.print("What is your rivals mascot? ");
      rivalTeam = kb.nextLine();
      System.out.print("Did you hit a single, double ,triple, or homerun? ");
      atBat = kb.nextLine();
      System.out.print("Did your team win or lose? ");
      outcome = kb.nextLine();
      System.out.print("How many seasons did you play? ");
      seasons = kb.nextLine();
      
      String myStory1 = "One day " + name + " finally turned " + age + " and decided to join their local baseball team the " + hometown + " " + team +".";//storyline with user inputs
      System.out.println(myStory1);
      String myStory2 = "But " + name + " had a small problem. They still needed a " + equipment + " to play.";
      System.out.println(myStory2);
      String myStory3 = "Fortunately for " + name + " they lived near a sports store in downtown " + hometown + ".";
      System.out.println(myStory3);
      String myStory4 = "After a quick trip and their wallet $" + price + " lighter, " + name + " finally had a " + equipment +".";
      System.out.println(myStory4);
      String myStory5 = "Just in time for the teams next big game against their bitter rivals the " + rivalCity + " " + rivalTeam + ".";
      System.out.println(myStory5);
      String myStory6 = "During the game " + name + " hit a clutch " + atBat + " that tied the game.";
      System.out.println(myStory6);
      String myStory7 = "Ultimately the " + team + " " + outcome + " in a very close game. And " + name +" later went on to play " + seasons + " more seasons with the " + team +".";
      System.out.println(myStory7);
   }    
}
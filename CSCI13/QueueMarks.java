/*
Name:Matthew Marks
description:Create a queue of songs.
date:4/28/24
*/
import java.util.*;
public class QueueMarks
{
//no code here
}
class Song {
    // Instance variables
    private String song;
    private String singer;

    // Constructor
    public Song(String song, String singer) 
    {
        this.song = song;
        this.singer = singer;
    }

    // Getter for song name
    public String getSong() 
    {
        return song;
    }

    // Getter for singer name   
    public String getSinger() 
    {
        return singer;
    }

    // ToString method
    public String toString() 
    {
        return song + " by " + singer + "\n**************\n";
    }

    // Equals method
    public boolean equals(Song other) 
    {
        return this.song.equalsIgnoreCase(other.song) && this.singer.equalsIgnoreCase(other.singer);
    }

    // CompareTo method based on the singer, if same singer then compares the songs based on the name of the songs
    public int compareTo(Song other) {
        if (this.singer.compareTo(other.singer) == 0)
        {
            return this.song.compareTo(other.song);
        } else 
        {
            return this.singer.compareTo(other.singer);
        }
    }
}

class Queue {
    // Instance variable
    private ArrayList<Song> list;

    // Constructor
    public Queue() 
    {
        list = new ArrayList<Song>();
    }

    // Adding a song to the end of the queue
    public void enqueue(Song s) 
    {
        list.add(s);
    }

    // Removing a song from the front of the queue
    public Song dequeue() 
    {
        if (list.isEmpty()) 
        {
            throw new NoSuchElementException("Queue is empty");
        }
        return list.remove(0);
    }

    /* This method plays the song in the queue. playing the song in the front of the queue, removing the song at index 0 
     then moving to the next song until no more songs left in the queue */
    public void play() 
    {
        // Declare a stack called s
        Stack<Song> s = new Stack<Song>();
        // Create a scanner object
        Scanner scanner = new Scanner(System.in);
        // Declare a boolean variable called done and set it to false
        boolean done = false;

        // While done is false
        while (!done) 
        {
            try 
            {
                // Dequeue a song, store it in a variable called front of type Song, dequeue method must be called
                Song front = dequeue();
                // Push the variable front to the stack that you declared above
                s.push(front);
                // Display the content of the front
                System.out.println(front);
                System.out.println("Press any key to continue");
                // Flush the buffer
                scanner.nextLine();
            } catch (Exception e) {
                // Set done to true
                done = true;
            }
        }
        // Call the restore method and pass the s to it
        restore(s);
        scanner.close();
    }

    /* This method gets the name of a singer and finds all the songs with the given singer. return the list of the songs
     Since the list is a queue, you can only see the song at index 0. This method must be implemented using the queue concept 
     and not looping through the list. This method gets the song at the index 0, then pushes it to an extra storage of stack so that we can restore the queue using the stack */
    public ArrayList<Song> getSingerSongs(String singer) 
    {
        // Declare an ArrayList of Song with the name songs, to hold all the songs with the given singer
        ArrayList<Song> songs = new ArrayList<>();
        // Declare a stack named s 
        Stack<Song> s = new Stack<>();
        // Declare a boolean variable called done and set it to false
        boolean done = false;

        // While done is false
        while (!done) 
        {
            try 
            {
                // Dequeue a song and store it in a variable of type Song called front (method dequeue must be called)
                Song front = dequeue();
                // Push the front variable to the stack
                s.push(front);
                // If the singer's name in the variable front is the same as the singer parameter
                if (front.getSinger().equalsIgnoreCase(singer)) 
                {
                    // Add front to the ArrayList songs
                    songs.add(front);
                }
            } catch (Exception e) 
            {
                // Set done to true
                done = true;
            }
        }
        // Call the restore method and pass the stack s to it
        restore(s);
        return songs; // Return the ArrayList songs
    }

    /* This method goes through the queue, removing the element at index 0, pushes it to the stack, and also concatenates it 
     to the String s that will hold the list of all the songs.Must use try/catch. the code is similar to the method above. list.get(0).toString should be used.
     Also don't forget to call the restore method at the very end, before the return statement.Make sure to use try/catch  */
    public String toString() 
    {
        StringBuilder sb = new StringBuilder();
        Stack<Song> s = new Stack<Song>();
        boolean done = false;

        while (!done) 
        {
            try 
            {
                Song front = dequeue();
                s.push(front);
                sb.append(front.toString());
            } catch (Exception e) 
            {
                done = true;
            }
        }
        restore(s);
        return sb.toString();
    }

    /* This method gets a stack of songs and restores the original queue in the original order.*/
    public void restore(Stack<Song> s) 
    {
        while (!s.isEmpty()) 
        {
            Song song = s.pop();
            list.add(0, song);
        }
    }

    /* This method reverses the order of the songs in the queue. if the songs are a b c d then method reverse will change the queue to
     d c b a */
    public void reverseOrder() 
    {
        // Declare a boolean called done = false
        boolean done = false;

        // Declare a stack called s
        Stack<Song> s = new Stack<Song>();

        // While done is false
        while (!done) 
        {
            try 
            {
                // Dequeue the song and store it in a variable of type song called e
                Song e = dequeue();

                // Push e to the stack s
                s.push(e);
            } catch (Exception e)
            {
                // Set done to true
                done = true;
            }
        }

        // Set done to false
        done = false;

        // While done is false (this loop is building the queue in the reverse order using the stack s)
        while (!s.isEmpty()) 
        {
            try 
            {
                // Pop an element from the stack s, store it in a variable of type Song called o
                Song o = s.pop();

                // Enqueue the object o by calling the enqueue method
                enqueue(o);
            } catch (Exception e) 
            {
                // Set done to true
                done = true;
            }
        }
    }

    /* This method gets the name of a singer and returns the percentage of the songs in the queue from the given singer */
    public String getPercentage(String singer) 
    {
        // Declare a variable of type double to hold the number of the songs by the given singer
        double sum = 0;

        // Declare a variable called count to hold the total number of the songs in the queue 
        int count = 0;  

        // Declare a boolean called done set it to false
        boolean done = false;

        // Declare a stack called s
        Stack<Song> s = new Stack<Song>();

        // While done is false
        while (!done) 
        {
            try 
            {
                // Dequeue a song by calling the dequeue method and store it in a variable of type song called song
                Song song = dequeue();

                // Increment count
                count++;

                // Push song to the stack
                s.push(song);

                // If song.getSinger is the same as singer
                if (song.getSinger().equalsIgnoreCase(singer)) 
                {
                    // Increment sum
                    sum++;
                }
            } catch (Exception e) 
            { // Goes here when there is no song left in the queue
                // Set done to true
                done = true;
            }
        }

        // Call the restore method and pass s to it
        restore(s);

        return sum + " out of " + count + " is by the singer " + singer;
    }

    // Rebuild the queue from the given stack which contains all the songs
    public void preserve(Queue q) 
    {
        boolean b = false;
        while (!b) 
        {
            try 
            {
                this.enqueue(q.dequeue());
            } catch (Exception e) 
            {
                b = true;
            }
        }
    }
       
    
}
/*Do not remove this driver*/
class Driver
{
   public static void main(String[] args)
   {
      Queue  m = new Queue();
      m.enqueue(new Song ("Riders in the Sky", "Monroe"));
      m.enqueue(new Song("Catch My Breath","Clarkson"));
      m.enqueue(new Song("All American Girl", "Underwood"));
      m.enqueue(new Song("Anyway","McBride"));
      m.enqueue(new Song("Before He Cheats", "Underwood"));
      m.enqueue(new Song("Born Free", "Monroe"));
      m.enqueue(new Song("people Like Us","Clarkson"));
      m.enqueue(new Song("Give Her That", "Underwood"));
      m.enqueue(new Song("So Small", "Underwood"));
      m.enqueue(new Song("Stronger","Clarkson"));
      m.enqueue(new Song("Walk Away", "Monroe"));
      m.enqueue(new Song("Independence Day","McBride"));
      System.out.println("here is the list of your songs\n__________________________");
      System.out.println(m);
      System.out.println("The queue is : " + m);
      m.reverseOrder();
      System.out.println("The queue in the reverse order is: \n"+ m    );
      m.reverseOrder();
      
      System.out.println("\n\nSongs by Underwood: \n");
      System.out.println("\n\n" + m.getPercentage("Underwood"));
      System.out.println("\n\n" + m.getPercentage("Clarkson")+"\n\n");
      System.out.println("Now playing your songs\n");
      m.play();
           
    
   }
}
/*20 points
cretae at least 5 objects and create the driver similar to the given one */
class YourDriver
{
   public static void main(String[] args)
   {
      Queue  m = new Queue();
      m.enqueue(new Song ("California Love", "Tupac"));
      m.enqueue(new Song("Still D.R.E.", "Dr. Dre"));
      m.enqueue(new Song("Shook Ones, Pt. II", "Mobb Deep"));
      m.enqueue(new Song("Juicy", "The Notorious B.I.G."));
      m.enqueue(new Song("N.Y. State of Mind", "Nas"));
      m.enqueue(new Song("C.R.E.A.M.", "Wu-Tang Clan"));
      m.enqueue(new Song("The Message", "Grandmaster Flash & The Furious Five"));
      m.enqueue(new Song("Lose Yourself", "Eminem"));
      m.enqueue(new Song("No Vaseline", "Ice Cube"));
      m.enqueue(new Song("Fight The Power", "Public Enemy"));

      System.out.println("here is the list of your songs\n__________________________");
      System.out.println(m);
      System.out.println("The queue is : " + m);
      m.reverseOrder();
      System.out.println("The queue in the reverse order is: \n"+ m    );
      m.reverseOrder();
      
      System.out.println("\n\nSongs by Tupac: \n");
      System.out.println("\n\n" + m.getPercentage("Tupac"));
      System.out.println("\n\n" + m.getPercentage("Mobb Deep")+"\n\n");
      System.out.println("Now playing your songs\n");
      m.play();
           
    
   }
}
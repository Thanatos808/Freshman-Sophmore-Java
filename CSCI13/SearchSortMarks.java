/*
Name:Matthew Marks   
date:3/30/2024
description: An application to keep track of the doctors at a hospital. The doctors will be added to
list. Then the list will be sorted using three different sorting algorithms: bubble sort, insertion sort and
the selection sort. Also, we should be able to search the list using the binary search to find a given
doctor based on the last name and first name.
The code for some methods are provided.
The code for the following methods are not given
  Some getter methods
  setter methods
  ComparesTo methods
  toString method
  equals method
  
  inserion sort
  selection sort
  bubble sort
  binary search
*/

import java.util.*;

public class SearchSortMarks 
{
    //no code here
}

class Doctor implements Comparable<Doctor> 
{ 
    private String first;
    private String last;
    private String phone;
    private String specialty; 
    private int rating;

    // Constructor
    public Doctor(String first, String last, String phone, String specialty, int rating) 
    {
        this.first = first;
        this.last = last;
        this.phone = phone;
        this.specialty = specialty;
        this.rating = rating;
    }

    // Getter methods
    public String getLast() 
    {
        return last;
    }

    public String getFirst() 
    {
        return first;
    }

    public String getSpecialty() 
    { 
        return specialty;
    }

    public String getPhone() 
    {
        return phone;
    }

    public int getRating() 
    { 
        return rating;
    }

    // Setter methods
    public void setFirst(String first) 
    {
        this.first = first;
    }

    public void setLast(String last) 
    {
        this.last = last;
    }

    public void setSpecialty(String specialty) 
    { 
        this.specialty = specialty;
    }

    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public void setRating(int rating) 
    {
        this.rating = rating;
    }

    /* Compares object of type Doctor based on the last name,
     if the last name is the same then compare based on the first name.
     This method is used in the bubble sort.*/
    
    public int compareTo(Doctor d) 
    {
        int lastNameComparison = this.last.compareTo(d.last);
        if (lastNameComparison == 0) 
        {
            return this.first.compareTo(d.first);
        } else {
            return lastNameComparison;
        }
    }

    /* Compares objects of type Doctor based on the specialty.
     If two doctors have the same specialty, then compare them based on the last name.
     This method is called in the insertion sort.*/
    public int comparesTo(Doctor d) 
    {
        int specialtyComparison = this.specialty.compareTo(d.specialty);
        if (specialtyComparison == 0) {
            return this.last.compareTo(d.last);
        } else {
            return specialtyComparison;
        }
    }

    /* Compares objects based on the rating of the doctors.
     This compare method should be used in the selection sort.*/
    public int compareRating(Doctor d) 
    {
        return Integer.compare(this.rating, d.rating);
    }

    // This method creates a string representing all the attributes of the Doctor object.
    public String toString() 
    {
        return first + " " + last + " " + specialty + " " + phone + " " + rating;
    }

    /* This method is used to see if two objects of type doctor are the same.
     Two objects are the same if they have the same first and last name.*/
    public boolean equals(Doctor d) 
    {
        return this.first.equals(d.getFirst()) && this.last.equals(d.getLast());
    }
}

class Hospital 
{
    ArrayList<Doctor> doctors; // List of doctors

    // Constructor
    public Hospital() 
    {
        doctors = new ArrayList<>();
    }

    public ArrayList<Doctor> getList() 
    {
        return doctors;
    }

    // Sorts the objects based on the last name, therefore the compareTo method must be called.
    public void bubbleSort() 
    {
        boolean swapped;
        for (int i = 0; i < doctors.size() - 1; i++) 
        {
            swapped = false;
            for (int j = 0; j < doctors.size() - i - 1; j++) 
            {
                if (doctors.get(j).compareTo(doctors.get(j + 1)) > 0) 
                {
                    
                    Doctor temp = doctors.get(j);
                    doctors.set(j, doctors.get(j + 1));
                    doctors.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) break; 
        }
    }

    // Adds a doctor to the list of doctors
    public void addDoctor(String first, String last, String phone, String specialty, int rating) 
    {
        doctors.add(new Doctor(first, last, phone, specialty, rating));
    }

    // Deletes a doctor from the list
    public boolean deleteDoctor(String last) 
    {
        return doctors.removeIf(doctor -> doctor.getLast().equals(last));
    }

    // Adds a doctor to the end of the list
    public void add(String first, String last, String phone, String spec, int rating) 
    {
        addDoctor(first, last, phone, spec, rating);
    }

    @Override
    public String toString() 
    {
        StringBuilder s = new StringBuilder();
        for (Doctor doctor : doctors) 
        {
            s.append("\n").append(doctor.toString());
        }
        return s.toString();
    }

    /* Selection sort
   this method calles the compareRating method to sort all the the doctors based on the rating
   refer to the lecture notes on selection sort*/
    public void selectionSort() {
        for (int i = 0; i < doctors.size() - 1; i++) 
        {
            int minIdx = i;
            for (int j = i + 1; j < doctors.size(); j++) 
            {
                if (doctors.get(j).compareRating(doctors.get(minIdx)) < 0) 
                {
                    minIdx = j;
                }
            }
            Doctor temp = doctors.get(minIdx);
            doctors.set(minIdx, doctors.get(i));
            doctors.set(i, temp);
        }
    }

    /* This method uses binary search to find a doctor in the list.
     It must call the compareTo method to search for a doctor.*/
    public int binarySearch(Doctor d) 
    {
        int l = 0, r = doctors.size() - 1;
        while (l <= r) 
        {
            int m = l + (r - l) / 2;
            if (doctors.get(m).equals(d)) return m;

            if (doctors.get(m).compareTo(d) < 0) l = m + 1;
            else r = m - 1;
        }
        return -1; 
    }

    // This method sorts the list of the doctors based on their specialty.
    public void insertionSort() {
        for (int i = 1; i < doctors.size(); i++) 
        {
            Doctor currentDoctor = doctors.get(i);
            int j = i - 1;

            while (j >= 0 && doctors.get(j).comparesTo(currentDoctor) > 0) 
            {
                doctors.set(j + 1, doctors.get(j));
                j--;
            }
            doctors.set(j + 1, currentDoctor);
        }
    }
}



class YourDriver 
{
    public static void main(String[] args)
   {
      Hospital sutter = new Hospital();
      sutter.add ( "Allen","Iverson","568-345-9999" , "Dermatalogist", 4);
      sutter.add ( "Martha","Stewart","111-222-3333","Cardialogist", 5 );
      sutter.add ( "John","Smith","123-123-4567","Pediatrition", 3 );
      sutter.add ( "Alex","Rodrigues","987-567-3333" , "Punmnalogist", 4);
      sutter.add ( "David","Schulz","555-666-7777" , "Pain medicine", 3);
      sutter.add("James","Lebron","333-555-6666", "Phsyciatric", 4);
      sutter.add("Zack", "Efron","345-777-8989", "Radialogist", 5);
      sutter.add("James","Cook","111-222-3333", "Ocuplastic surgen", 4);
      
      System.out.println("******************************************");
      System.out.println("Testing the bubble sort sort based on the last name");
      
      sutter.bubbleSort();
      System.out.println("Here is the sorted list based on the last name");
      System.out.println(sutter);
      System.out.println("******************************************\n\n");
      
      System.out.println("Testing the binary search looking for John Smith");
      int i = sutter.binarySearch(new Doctor( "John","Smith","123-123-4567","Pediatrition", 3 ));
      System.out.println("The index for John Smith is : " + i+ "\n\n");
      System.out.println("*****************************************");
      
       
      System.out.println("adding 3 more doctors  to the list"); 
      
      System.out.println("******************************************");
      sutter.add("Joe", "Lambardy","345-777-8989", "Plastic surgern", 5);
      sutter.add("James","Cook","111-222-3333", "Ocuplastic surgen", 4);
      sutter.add("James","Lebron","333-555-6666", "Phsyciatric", 4);
      
      System.out.println("**************************************\n"); 
      System.out.println("New list of doctors");
      System.out.println(sutter);
      System.out.println("*********************************************");
      
      System.out.println("Testing the insertion sort based on the speciality");
      sutter.insertionSort();
      System.out.println(sutter);
      System.out.println("***************************************************");
      
      System.out.println("Adding more to the mercy");
      sutter.add("Susan", "Lee","888-999-9008", "Cardialogist", 5);
      sutter.add("Ashley", "Lewis","123-444-0780","Internal medicine", 4);
      sutter.add("John","Brown","111-999-6556", "Eye surgen",3);
      
      System.out.println("***********************************************");
      System.out.println("Testing the selection sort based on the rating of the doctors ratings");
      sutter.selectionSort();
      System.out.println("Here is the sorted list based on the rating ");
      System.out.println(sutter);
      System.out.println("************************************************\n");
      
      //sorting the list based on the last name
      sutter.bubbleSort();
      System.out.println("*************************************************");
      System.out.println("Sorted list based on the last name:");
      System.out.println(sutter);
      System.out.println("*************************************************");
      int index = sutter.binarySearch(new Doctor("Susan", "Lee","888-999-9008", "Cardialogist", 5));
      System.out.println("Susan is at index : "+ index);
                                  
   }
}
class Driver
{
   public static void main(String[] args)// throws FileNotFoundException
   {
      Hospital mercy = new Hospital();
      mercy.add ( "Ana","Baily","568-345-9999" , "Dermatalogist", 4);
      mercy.add ( "Mary","Busta","111-222-3333","Cardialogist", 5 );
      mercy.add ( "Richard","Smith","123-123-4567","Pediatrition", 3 );
      mercy.add ( "Alex","Rodrigues","987-567-3333" , "Punmnalogist", 4);
      mercy.add ( "Sarah","Schulz","555-666-7777" , "Pain medicine", 3);
      mercy.add("Roy","Trump","333-555-6666", "Phsyciatric", 4);
      mercy.add("Zack", "Lambard","345-777-8989", "Radialogist", 5);
      mercy.add("Alex","Cook","111-222-3333", "Ocuplastic surgen", 4);
      
      System.out.println("******************************************");
      System.out.println("Testing the bubble sort sort based on the last name");
      
      mercy.bubbleSort();
      System.out.println("Here is the sorted list based on the last name");
      System.out.println(mercy);
      System.out.println("******************************************\n\n");
      
      System.out.println("Testing the binary search looking for Richard Smith");
      int i = mercy.binarySearch(new Doctor( "Richard","Smith","123-123-4567","Pediatrition", 3 ));
      System.out.println("The index for Richard Smith is : " + i+ "\n\n");
      System.out.println("*****************************************");
      
       
      System.out.println("adding 3 more doctors  to the list"); 
      
      System.out.println("******************************************");
      mercy.add("Zack", "Lambard","345-777-8989", "Plastic surgern", 5);
      mercy.add("Alex","Cook","111-222-3333", "Ocuplastic surgen", 4);
      mercy.add("Roy","Trump","333-555-6666", "Phsyciatric", 4);
      
      System.out.println("**************************************\n"); 
      System.out.println("New list of doctors");
      System.out.println(mercy);
      System.out.println("*********************************************");
      
      System.out.println("Testing the insertion sort based on the speciality");
      mercy.insertionSort();
      System.out.println(mercy);
      System.out.println("***************************************************");
      
      System.out.println("Adding more to the mercy");
      mercy.add("Sarah", "Lee","888-999-9008", "Cardialogist", 5);
      mercy.add("AShly", "Lu","123-444-0780","Internal medicine", 4);
      mercy.add("Jose","Brwon","111-999-6556", "Eye surgen",3);
      
      System.out.println("***********************************************");
      System.out.println("Testing the selection sort based on the rating of the doctors ratings");
      mercy.selectionSort();
      System.out.println("Here is the sorted list based on the rating ");
      System.out.println(mercy);
      System.out.println("************************************************\n");
      
      //sorting the list based on the last name
      mercy.bubbleSort();
      System.out.println("*************************************************");
      System.out.println("Sorted list based on the last name:");
      System.out.println(mercy);
      System.out.println("*************************************************");
      int index = mercy.binarySearch(new Doctor("Sarah", "Lee","888-999-9008", "Cardialogist", 5));
      System.out.println("Sarah is at index : "+ index);
                                  
   }
  
}
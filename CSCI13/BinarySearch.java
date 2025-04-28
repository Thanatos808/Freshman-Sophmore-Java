public class BinarySearch
{
   public static void main(String[] args)
   {
      int[] num = {4,6,7,12,24,45,67};
      int index = binarySearch(num,6);
      System.out.println(index);
   }
   public static int binarySearch(int[] num, int a)
   {
      int first = 0; 
      int last = num.length -1;
      while(first <= last)
      {
         int middle = (first + last)/2;
         if(a== num[middle])
            return middle;
            else if (a > num[middle])
            {
               first = middle + 1;
            }
            else
               last = middle -1;
      }
      return -1;
   }

}
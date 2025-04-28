public class HelloWorld
{
   public static void main (String[] args)
   {
      complete();
      hello();
   }
   public static void complete()
   {
      hello(); 
      world();
   }
   public static void hello ()
   {
      System.out.print("hello ");
      world();
   }
   public static void world()
   {
      System.out.print("world ");
   }
}               
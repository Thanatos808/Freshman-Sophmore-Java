import java.lang.*;
public class Chapter3Part3
{
        public static void main(String[] args)
        {
                //public static double abs(double a)
                double pos = Math.abs(-3); 
                
                //public char charAt(int index)
                String s = "Hello";
                char c = s.charAt(3);
                
                
                //from the math class choose a method to find the maximum of two numbers
                //public static double max(double a, double b)
                int max = Math.max(34,56);
                
                //square root of 45
                //public static double sqrt(double a)
                double sqr = Math.sqrt(45);
                
                //calculate 3 to the power of 10
                //public static double pow(double a, double b)
                double power = Math.pow(3,10);
                
                //public static int round(float a )
                long r =(int) Math.round(4.9);
                System.out.println(r);
                
        }
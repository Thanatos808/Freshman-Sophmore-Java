public class Main {
    public static void main(String[] args) {
        try {
            // Test with a positive number
            System.out.println("Testing with a = 5");
            e(5);
            System.out.println("No exception thrown for a = 5");

            // Test with zero
            System.out.println("Testing with a = 0");
            e(0);
            System.out.println("No exception thrown for a = 0");

            // Test with a negative number
            System.out.println("Testing with a = -1");
            e(-1);
            System.out.println("No exception thrown for a = -1");
        } catch (Exception ex) {
            System.out.println("Exception caught: " + ex.getMessage());
        }
    }

    public static void e(int a) throws Exception {
        if (a < 0) {
            throw new Exception("Negative value not allowed: " + a);
        }
    }
}

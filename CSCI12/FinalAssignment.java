public class FinalAssignment
{
}
 class SaleRep {
   private double baseSalary;
   private double commissionRate;
   private String fullName;
   private double salesTotal;
   
   public SaleRep(double salary, double commissionRate, String fullName) {
      this.baseSalary = salary;
      this.commissionRate = commissionRate;
      this.fullName = fullName;
      this.salesTotal = 0;
   }
   
   public double getBaseSalary() {
      return this.baseSalary;
   }
   
   public double getCommissionRate() {
      return this.commissionRate;
   }
   
   public String getFullName() {
      return this.fullName;
   }
   
   public void setBaseSalary(double salary) {
      this.baseSalary = salary;
   }
   
   public void setCommissionRate(double commissionRate) {
      this.commissionRate = commissionRate;
   }
   
   public void addSale(double newSale) {
      this.salesTotal += newSale;
   }
   
   public void returnItem(double amountReturned) {
      this.salesTotal -= amountReturned;
   }
   
   public double getCommission() {
      return this.salesTotal * this.commissionRate / 100.0;
   }
   
   public void getRaise(double raiseRate) {
      this.baseSalary *= (1 + raiseRate / 100.0);
   }
   
   public double paycheck() {
      return this.baseSalary + getCommission();
   }
   
   public String toString() {
      return String.format("Sale Rep: %s, Base Salary: %.2f, Commission Rate: %.2f, Sales Total: %.2f, Commission: %.2f, Paycheck: %.2f", 
                          this.fullName, this.baseSalary, this.commissionRate, this.salesTotal, getCommission(), paycheck());
   }
}
public class yourDriver {
   public static void main(String[] args) {
      // create the first object
      SaleRep e1 = new SaleRep(1000, 6, "Jose Rodriguez");
      e1.addSale(5000);
      e1.addSale(3000);
      e1.addSale(1200);
      e1.returnItem(5000);
      e1.addSale(345);
      System.out.println(e1);
      e1.getRaise(5);
      System.out.println(e1);
   
      // create the second object
      SaleRep e2 = new SaleRep(1800, 12, "Maria Chavez");
      e2.addSale(1234);
      e2.addSale(7645);
      e2.addSale(3456);
      e2.returnItem(5000);
      e2.addSale(345);
      System.out.println(e2);
      e2.getRaise(8);
      System.out.println(e2);
   }
}

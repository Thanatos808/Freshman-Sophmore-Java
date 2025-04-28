public class SalesRep {
	//instance variables
	private double commissionRate;
	private double baseSalary;
	private double sales;
	private String fullName;

	/** this parameterized constructor assigns the value of instance variables with received parameters
	 * @param salary
	 * @param commissionRate
	 * @param fullName
	 */
	public SalesRep(double salary,double commissionRate,String fullName) {
		this.sales=0;
		this.baseSalary=salary;
		this.commissionRate=commissionRate;
		this.fullName=fullName;
	}
	/** this method returns the commissionRate
	 * @return commissionRate
	 */
	public double getCommissionRate() {
		return commissionRate;
	}
	/** this method returns the value of starting salary
	 * @return baseSalary
	 */
	public double getBaseSalary() {
		return baseSalary;
	}
	/** this method returns the full name of sales rep
	 * @return fullName
	 */
	public String getFullName() {
		return fullName;
	}
	/** this method sets the value of commissionRate with received parameter
	 * @param commissionRate
	 */
	public void setCommissionRate(double commissionRate) {
		this.commissionRate = commissionRate;
	}
	/** this method sets the baseSalary variable with the received parameter 
	 * @param baseSalary
	 */
	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	/** this method sets the value of fullName with the received parameter
	 * @param fullName
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/** this method returns the paycheck amount of salesrep
	 * @return baseSalary+getCommission()
	 */
	public double paycheck() {
		return baseSalary+getCommission();
	}
	/** this method returns the commission amount of sales rep
	 * @return sales*commission/100
	 */
	public double getCommission() {
		return sales*commissionRate/100;
	}
	/** this method adds the newSales to sales 
	 * @param newSale
	 */
	public void addSales(double newSale) {
		this.sales+=newSale;
	}
	/** this method subtracts the received parameter from sales
	 * @param amountReturned
	 */
	public void returnItem(double amountReturned) {
		this.sales-=amountReturned;
	}
	/** this method raise the rate of baseSalary by the received parameter
	 * @param raiseRate
	 */
	public void getRaise(double raiseRate) {
		this.baseSalary+=this.baseSalary*raiseRate/100.0;
	}
	/** this method returns the current object in string form
	 *
	 */
	public String toString()
	{
		String s = " ";
		s = s + "\nFull name: " + fullName + "| ";
		s = s + "Starting salary: " + baseSalary+"| ";
		s = s + "Comission rate: " + commissionRate + " | ";
		s = s +"Sales amount: " + sales+"| ";
		s = s + "pay check: " + paycheck();
		s= s+ "\nThe commission you made: " + getCommission();
		s = s+ "\nTotal paid this month: " + paycheck();
		return s;
	}

}
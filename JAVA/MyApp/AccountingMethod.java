
public class AccountingAppMethod {
	public static double valueOfsupply;
	public static double vatRate;
	public static double expenseRate;
	public static void main(String[] args) {
		
		valueOfsupply = 10000.0;
		vatRate = 0.1;
		expenseRate = 0.3;
		
		print();

	}

	public static void print() {
		System.out.println("Value of Supply : " + valueOfsupply);
		System.out.println("VAT : " + getVAT());
		System.out.println("Selling Price : " + getTotal());
		System.out.println("Expense : " + getExpense());
		System.out.println("Income : " + getIncome());
		System.out.println("Dividend1 : " + getDiv_1());
		System.out.println("Dividend2 : " + getDiv_2());
		System.out.println("Dividend3 : " + getDiv_3());
	}

	public static double getDiv_1() {
		return getIncome() * 0.5;
	}
	
	public static double getDiv_2() {
		return getIncome() * 0.3;
	}
	
	public static double getDiv_3() {
		return getIncome() * 0.2;
	}

	public static double getIncome() {
		return valueOfsupply - getExpense();
	}

	public static double getExpense() {
		return valueOfsupply * getTotal();
	}

	public static double getTotal() {
		return valueOfsupply + getVAT();
	}

	private static double getVAT() {
		return valueOfsupply * vatRate;
	}

}

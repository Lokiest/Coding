class Accounting {
	public double valueOfsupply;
	public double vatRate;
	public double expenseRate;
	
	public void print() {
		System.out.println("Value of Supply : " + valueOfsupply);
		System.out.println("VAT : " + getVAT());
		System.out.println("Selling Price : " + getTotal());
		System.out.println("Expense : " + getExpense());
		System.out.println("Income : " + getIncome());
		System.out.println("Dividend1 : " + getDiv_1());
		System.out.println("Dividend2 : " + getDiv_2());
		System.out.println("Dividend3 : " + getDiv_3());
	}

	public double getDiv_1() {
		return getIncome() * 0.5;
	}
	
	public double getDiv_2() {
		return getIncome() * 0.3;
	}
	
	public double getDiv_3() {
		return getIncome() * 0.2;
	}

	public double getIncome() {
		return valueOfsupply - getExpense();
	}

	public double getExpense() {
		return valueOfsupply * getTotal();
	}

	public double getTotal() {
		return valueOfsupply + getVAT();
	}

	private double getVAT() {
		return valueOfsupply * vatRate;
	}
}

public class AccountingAppInstance {
	
	public static void main(String[] args) {
		
		//Accounting11.valueOfsupply = 10000.0;
		//Accounting11.vatRate = 0.1;
		//Accounting11.expenseRate = 0.3;
		//Accounting11.print();
		
		//Accounting22.valueOfsupply = 20000.0;
		//Accounting22.vatRate = 0.3;
		//Accounting22.expenseRate = 0.2;
		//Accounting22.print();
		
		//Instance
		Accounting a1 = new Accounting();
		a1.valueOfsupply = 10000.0;
		a1.vatRate = 0.1;
		a1.expenseRate = 0.3;
		a1.print();
		
		Accounting a2 = new Accounting();
		a2.valueOfsupply = 30000.0;
		a2.vatRate = 0.3;
		a2.expenseRate = 0.2;
		a2.print();
		
		a1.print();
		
	}

	

}


public class AccountingApp2 {

	public static void main(String[] args) {
		// 공급가액
		double valueOfsupply = Double.parseDouble(args[0]);
		// 부가가치세율
		double vatRate = 0.1;
		// 부가세
		double VAT = valueOfsupply * vatRate;
		double expenseRate = 0.3;
		// 합계
		double total = valueOfsupply + VAT;
		double expense = valueOfsupply * expenseRate;
		double income = valueOfsupply - expense;
		double dividend_1 = income * 0.5;
		double dividend_2 = income * 0.3;
		double dividend_3 = income * 0.2;
		
		System.out.println("Value of Supply : " + valueOfsupply);
		System.out.println("VAT : " + VAT);
		System.out.println("Selling Price : " + total);
		System.out.println("Expense : " + expense);
		System.out.println("Income : " + income);
		System.out.println("Dividend1 : " + dividend_1);
		System.out.println("Dividend2 : " + dividend_2);
		System.out.println("Dividend3 : " + dividend_3);
		

	}

}

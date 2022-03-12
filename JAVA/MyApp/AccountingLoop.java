
public class AccountingAppArrayLoop {

	public static void main(String[] args) {
		
		double valueOfsupply = Double.parseDouble(args[0]);
		double vatRate = 0.1;
		double VAT = valueOfsupply * vatRate;
		double expenseRate = 0.3;
		double total = valueOfsupply + VAT;
		double expense = valueOfsupply * expenseRate;
		double income = valueOfsupply - expense;
		
		System.out.println("Value of Supply : " + valueOfsupply);
		System.out.println("VAT : " + VAT);
		System.out.println("Selling Price : " + total);
		System.out.println("Expense : " + expense);
		System.out.println("Income : " + income);
		
		double[] dividendRates = new double[3];
		dividendRates[0] = 0.5;
		dividendRates[1] = 0.3;
		dividendRates[2] = 0.2;
		
		int i = 0;
		while(i < dividendRates.length) {
			System.out.println("Dividend1 : " + (income * dividendRates[i]));
			i += 1;
		}

	}

}

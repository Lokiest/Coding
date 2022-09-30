package day05;

public class CoffeeShop {

	public static void main(String[] args) {
		VendingMachine vm = new VendingMachine();
		vm.make(3, 2, 1);
		vm.make(3, 2);
		String str = vm.make(5);
		System.out.println(str);
		vm.make(3, 3);
		vm.make(3);
		Yuja y1=new Yuja();
		y1.setSugar(2);
		y1.setYuja(3);
		vm.make(y1);

	}

}

package day05;

public class CoffeeMachine {
	
	private int coffee;
	private int sugar;
	private short cream;
	
	//setter
	public void setCoffee(int c) {
		coffee = c;
	}
	public void setSugar(int c) {
		sugar = c;
	}
	public void setCream(short s) {
		cream = s;
	}
	
	//getter
	public int getCoffee() {
		return coffee;
	}
	public int getSugar() {
		return sugar;
	}
	public int getCream() {
		return cream;
	}
}

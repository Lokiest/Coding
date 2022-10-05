package day06;

public abstract class Animal {
	public abstract void crySound();
	abstract public void getBaby(int n);
}

class Dog extends Animal {
	public void crySound() {
		System.out.println("멍멍");
	}
	public void getBaby(int n) {
		System.out.println(n + "마리의 새끼");
	}
}

class Cat extends Animal{
	public void crySound() {
		System.out.println("야옹 야옹");
	}
	public void getBaby(int n) {
		System.out.println(n + "마리의 새끼");
	}
}

class Duck extends Animal{
	public void crySound() {
		System.out.println("꽥꽥");
	}
	public void getBaby(int n) {
		System.out.println(n+"개의 알");
	}
}


package day06;

public abstract class Shape {
	int x, y;
	public String getInfo() {
		return "도형 클래스";
	}
	abstract public void area(int a, int b);
}

class Rectangle extends Shape{
	public void area(int w, int h) {
		int a = w*h;
		System.out.println("사각형 : " + a);
		
	}
}

class Triangle extends Shape{
	public void area(int a, int b) {
		System.out.println("직삼각형 : " + a*b/2);
	}
	
}

abstract class Circle extends Shape{
	double pi = 3.14;
	
}

class SubCircle extends Circle {
	
	@Override
	public void area(int r1, int r2) {
	}
	
	//Overload
	public void area(int r) {
		System.out.println("원 : " + r*r*pi);
	}
}

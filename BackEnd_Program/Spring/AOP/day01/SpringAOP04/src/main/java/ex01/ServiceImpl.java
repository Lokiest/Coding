package ex01;

public class ServiceImpl implements Service {

	@Override
	public void sayHello(String... names) {
		if(names!=null) {
			for(String name: names) {
				System.out.println("hello" + name);
			}
		}

	}

}

import org.opentutorials.iot.Elevator;
import org.opentutorials.iot.Security;
import org.opentutorials.iot.Lighting;

public class GotoHome {

	public static void main(String[] args) {
		// 이사를 간다면? 매번 주소를 바꾸기?
		String Home = "RAGON APT 801";
		
		// Elevator Call
		Elevator myElevator = new Elevator(Home);
		myElevator.callForUp(1);
		
		// Security Off
		Security mySecurity = new Security(Home);
		mySecurity.off();
		
		// Light On
		Lighting hallLamp = new Lighting(Home + " / HallLamp");
		hallLamp.on();
		
		Lighting floorLamp = new Lighting(Home + " / floorLamp");
		floorLamp.on();

	}

}

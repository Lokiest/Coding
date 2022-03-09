import javax.swing.JOptionPane;
import org.opentutorials.iot.Elevator;
import org.opentutorials.iot.Security;
import org.opentutorials.iot.Lighting;
import org.opentutorials.iot.DimmingLights;

public class GotoHomeInput {
	
	public static void main(String[] args) {
		String Home = args[0];
		String Bright = args[1];
		
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
		
		DimmingLights moodLamp = new DimmingLights(Home + " / moodLamp");
		moodLamp.setBright(Double.parseDouble(Bright));
		moodLamp.on();

	}

}

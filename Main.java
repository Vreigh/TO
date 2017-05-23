import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public final class Main {

	public static void main(String[] args) {
		try{
			Tank tank = new Tank(new ArrayList<Integer>(Arrays.asList(100)), "Tank");
			Engine engine = new Engine(new ArrayList<Integer>(Arrays.asList(100, 100)), "Engine");
			WheelManager wheelManager = new WheelManager(new ArrayList<Integer>(Arrays.asList(100, 100, 100, 100)), "Wheel Manager");
			GearBox gearBox = new GearBox(new ArrayList<Integer>(Arrays.asList(100)), "Gear Box");
			
			CentralComputer central = new CentralComputer(tank, engine, wheelManager, gearBox, "Central Computer");
			central.startEngines();
			central.start();
			central.waitForRequests();
			
		}catch(ArgumentException e){
			e.getStackTrace();
		}
		
	}

}

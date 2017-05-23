import java.util.Scanner;


public class CentralComputer implements Runnable{
	private Datagetable tank;
	private Datagetable engine;
	private Datagetable wheelManager;
	private Datagetable gearBox;
	private String name;
	private Thread t = null;
	
	public CentralComputer(Datagetable tank, Datagetable engine, Datagetable wheelManager, Datagetable gearBox, String name){
		this.tank = tank;
		this.engine = engine;
		this.wheelManager = wheelManager;
		this.gearBox = gearBox;
		this.name = name;
	}
	
	public void startEngines(){
		tank.start();
		engine.start();
		wheelManager.start();
		gearBox.start();
	}
	
	public void run(){
		
		while(true){
			try{
				System.out.println("Current status:");
				System.out.println("Fuel burning: " + tank.getData(0));
				System.out.println("Oil pressure:" + engine.getData(0));
				System.out.println("Oil temperature:" + engine.getData(1));
				System.out.println("Wheel 1 pressure:" + wheelManager.getData(0));
				System.out.println("Wheel 2 pressure:" + wheelManager.getData(1));
				System.out.println("Wheel 3 pressure:" + wheelManager.getData(2));
				System.out.println("Wheel 4 pressure:" + wheelManager.getData(3));
				System.out.println("Current gear:" + gearBox.getData(0));
				Thread.sleep(5000);
				
			}catch(InterruptedException e){
				System.out.println("Interrputed.");
			}
		}
		
	}
	public void start(){
		System.out.println("Starting " +  name );
	      if (t == null) {
	         t = new Thread (this, name);
	         t.start ();
	      }
	}
	
	public void waitForRequests(){
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		while(true){
			int c = reader.nextInt();
			switch(c){
			case 1:
				System.out.println("Printing avarages of tank:");
				System.out.println("Avarage Fuel burning: " + tank.getAvarageData(0));
				break;
			case 2:
				System.out.println("Printing avarages of egine:");
				System.out.println("Avarage Oil pressure:" + engine.getAvarageData(0));
				System.out.println("Avarage Oil temperature:" + engine.getAvarageData(1));
				break;
			case 3:
				System.out.println("Printing avarages of wheel manager:");
				System.out.println("Avarage Wheel 1 pressure:" + wheelManager.getAvarageData(0));
				System.out.println("Avarage Wheel 2 pressure:" + wheelManager.getAvarageData(1));
				System.out.println("Avarage Wheel 3 pressure:" + wheelManager.getAvarageData(2));
				System.out.println("Avarage Wheel 4 pressure:" + wheelManager.getAvarageData(3));
				break;
			case 4:
				System.out.println("Printing avarages of gear box:");
				System.out.println("avarage gear:" + gearBox.getAvarageData(0));
				break;
			}
		}
	}

}

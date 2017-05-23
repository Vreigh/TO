import java.util.ArrayList;
import java.util.Random;


public class Engine extends DataGainer{
	private final int MAX_PRESS = 10000;
	private final int MAX_TEMP = 1000;
	
	public Engine(ArrayList<Integer> sizes, String name) throws ArgumentException{
		super(sizes, name);
		if(sizes.size() != 2) throw new ArgumentException();
	}
	
	public void run(){
		Random rand = new Random();
		DataCollector pressData = super.data.get(0);
		DataCollector tempData = super.data.get(1);
		
		while(true){
			try{
				synchronized(pressData){
					pressData.push(rand.nextDouble()*MAX_PRESS);
				}
				synchronized(tempData){
					tempData.push(rand.nextDouble()*MAX_TEMP);
				}
				Thread.sleep(50);
				
			}catch(InterruptedException e){
				System.out.println("Interrputed.");
			}
		}	
	}
}

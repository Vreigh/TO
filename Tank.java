import java.util.ArrayList;
import java.util.Random;

public final class Tank extends DataGainer {
	private final int MAX_GENERATED = 100;
	
	public Tank(ArrayList<Integer> sizes, String name) throws ArgumentException{
		super(sizes, name);
		if(sizes.size() != 1) throw new ArgumentException();
	}
	
	public void run(){
		Random rand = new Random();
		DataCollector burnData = super.data.get(0);
		
		while(true){
			try{
				synchronized(burnData){
					burnData.push(rand.nextDouble()*MAX_GENERATED);
				}
				Thread.sleep(50);
				
			}catch(InterruptedException e){
				System.out.println("Interrputed.");
			}
		}	
	}
}

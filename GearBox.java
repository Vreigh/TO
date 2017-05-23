import java.util.ArrayList;
import java.util.Random;

public final class GearBox extends DataGainer {
	private final int MAX_GENERATED = 7;
	
	public GearBox(ArrayList<Integer> sizes, String name) throws ArgumentException{
		super(sizes, name);
		if(sizes.size() != 1) throw new ArgumentException();
	}
	
	public void run(){
		Random rand = new Random();
		DataCollector gearData = super.data.get(0);
		
		while(true){
			try{
				synchronized(gearData){
					gearData.push((double)rand.nextInt(MAX_GENERATED));
				}
				Thread.sleep(50);
				
			}catch(InterruptedException e){
				System.out.println("Interrputed.");
			}
		}	
	}
}

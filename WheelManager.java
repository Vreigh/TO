import java.util.ArrayList;
import java.util.Random;


public class WheelManager extends DataGainer{
	private final int MAX_GENERATED = 10000;
	
	public WheelManager(ArrayList<Integer> sizes, String name) throws ArgumentException{
		super(sizes, name);
		if(sizes.size() != 4) throw new ArgumentException();
	}
	
	public void run(){
		Random rand = new Random();
		
		while(true){
			try{

				for(int i=0; i<4; i++){
					synchronized(super.data.get(i)){
						super.data.get(i).push(rand.nextDouble()*MAX_GENERATED);
					}
				}
				
				Thread.sleep(50);
				
			}catch(InterruptedException e){
				System.out.println("Interrputed.");
			}
		}	
	}

}

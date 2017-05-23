import java.util.Random;

public final class Tank extends DataGainer {
	private final int MAX_GENERATED = 100;
	
	public Tank(int max, String name){
		super(max, name);
	}
	
	public void run(){
		Random rand = new Random();
		while(true){
			try{
				synchronized(super.data){
					super.data.push(rand.nextDouble()*MAX_GENERATED);
				}
				Thread.sleep(100);
				
			}catch(InterruptedException e){
				System.out.println("Interrputed.");
			}
		}	
	}
	
}

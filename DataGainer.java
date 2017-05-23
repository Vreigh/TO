
public abstract class DataGainer implements Runnable  {

	protected DataCollector data;
	private String name;
	private Thread t = null;
	
	public DataGainer(int max, String name){
		data = new DataCollector(max);
		this.name = name;
	}
	
	public double getData(){
		synchronized(data){
			return data.get(); 
		}
	}
	
	public double getAvarageData(){
		synchronized(data){
			return data.getAvarage();
		}
		
	}
	
	public abstract void run();
	
	public void start(){
		System.out.println("Starting " +  name );
	      if (t == null) {
	         t = new Thread (this, name);
	         t.start ();
	      }
	}
	
}

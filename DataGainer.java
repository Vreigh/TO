import java.util.ArrayList;

public abstract class DataGainer implements Runnable, Datagetable  {

	protected ArrayList<DataCollector> data;
	private String name;
	private Thread t = null;
	
	public DataGainer(ArrayList<Integer> sizes, String name){
		data = new ArrayList<DataCollector>();
		for(int n : sizes){
			data.add(new DataCollector(n));
		}
		this.name = name;
	}
	
	public ArrayList<Double> getAllData(){
		ArrayList<Double> result = new ArrayList<Double>();
		
		for(DataCollector col : data){
			synchronized(col){
				result.add(col.get());
			}
		}
		
		return result;
	}
	
	public ArrayList<Double> getAllAvarageData(){
		ArrayList<Double> result = new ArrayList<Double>();
		
		for(DataCollector col : data){
			synchronized(col){
				result.add(col.getAvarage());
			}
		}
		
		return result;
		
	}
	
	public double getData(int i){
		synchronized(data.get(i)){
			return data.get(i).get();
		}
	}
	
	public double getAvarageData(int i){
		synchronized(data.get(i)){
			return data.get(i).getAvarage();
		}
	}
	
	public void start(){
		System.out.println("Starting " +  name );
	      if (t == null) {
	         t = new Thread (this, name);
	         t.start ();
	      }
	}
	
}

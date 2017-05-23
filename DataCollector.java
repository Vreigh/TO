
public class DataCollector {
	private int max;
	private double data[];
	private int index = 0;
	boolean all = false;
	
	public DataCollector(int max){
		this.max = max;
		data = new double[max];
	}
	
	public double get(){
		return data[index];
		
	}
	
	public double getAvarage(){
		int toRet = 0;
		
		int itMax;
		if(all) itMax = max;
		else itMax = index + 1;
		
		for(int i=0; i<itMax; i++) toRet += data[i];
		
		return toRet / itMax;
	}
	
	public void push(double x){
		data[index] = x;
		if(++index == max){
			index = 0;
			all = true;
		}
	}
}

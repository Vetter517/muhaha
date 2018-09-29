package inclass;

public class lesson3 {

	public static void main(String[] args){
	
		double tempf = 4;
		double tempc;
		
		tempc = ((tempf - 32) * 5) / 9;
		
		tempc = Math.round(tempc *100) / 100;		
		System.out.println("Temp in celcius is " + tempc);
		
	}
	
}

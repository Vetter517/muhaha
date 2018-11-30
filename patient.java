package hospital;
public class patient {
	
	String name;
	String email;
	int timeStay;
	boolean isCritical; //depending on illness, to er right away, make sure room is reserved
	String illness;//reason for admission
	
	public static void toSurgery() {
		
	}
	
	public static void ERtoNormal() {
		
	}
//==============================================
	public void setName(String name) {
		this.name=name;
	}
	public String getName(){
		return this.name;
	}
//==============================================
	public void setEmail(String email) {
		this.email=email;
	}
	public String getEmail(){
		return this.email;
	}
//==============================================
	public void setTimeStay(int timeStay) {
		this.timeStay=timeStay;
	}
	public int getTimeStay(){
		return this.timeStay;
	}
//==============================================
	public void setIsCritical(boolean isCritical) {
		this.isCritical=isCritical;
	}
	public boolean getIsCritical(){
		return this.isCritical;
	}
//==============================================
	public void setIllness(String illness) {
		this.illness=illness;
	}
	public String getIllness(){
		return this.illness;
	}
//==============================================
}//end class 

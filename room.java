package hospital;

import hospital.patient;

//import java.util.ArrayList;
public class room {
	
	int roomNumber;
	boolean isOccupied;
	patient patient;
	String roomType; //normal, er x2, surgury x3, 1 waiting maybe
	//ArrayList waitingPatients;
//==============================================	
	public void setNumber(int num) {
		this.roomNumber=num;
	}
	public int getNumber() {
		return this.roomNumber;
	}
//==============================================
	public void setIsOccupied(boolean isOccupied) {
		if(this.patient != null) {
			this.isOccupied = true;
		}else {
			this.isOccupied = false;
		}
	}
	public boolean getIsOccupied(){
		return this.isOccupied;
	}
//==============================================
	public void setPatient(patient patient) {
		this.patient=patient;
	}
	public patient getPatient() {
		return this.patient;
	}
//==============================================	
	public void setRoomType(String strs) {
		this.roomType=strs;
	}
	public String getRoomType(){
		return this.roomType;
	}
//==============================================
	
}//end class

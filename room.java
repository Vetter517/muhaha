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
	public static void roomCheck(room[] roomArray) {
		for(int a=0;a<roomArray.length;a++) {
			room x = roomArray[a];
			if(x.isOccupied==true) {
				System.out.println("Room "+x.getNumber()+" is occupied.");
			}else {
				System.out.println("Room "+x.getNumber()+" is not occupied.");
			}//end if
		}//end for
	}//end check
	
	static void specificCheck(room r) {
		System.out.println("Looking for a specific room?");
	}
	
	public static int reserveRoom(room[] roomArray, patient patient) {
		int i=0;
		room temp;
		for(i=0;i<roomArray.length;i++) {
			temp = roomArray[i];
			if(patient.isCritical==false) {
				if(temp.isOccupied==false) {
					temp.patient = patient;
					roomArray[i]=temp;
					roomArray[i].isOccupied=true;
					return i;
				}
			}
		}
		return 30;
	}//end reserve rooms

	
	public static void releaseRoom(room room) {
		if(room.isOccupied==true) {
			System.out.println(room.getPatient().getName()+" has been released from the hospital.");
			System.out.println("Sending reciept email to: "+room.getPatient().getEmail());
			room.isOccupied = false;
			room.patient = null;
		}
	}
}//end class

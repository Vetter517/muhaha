package hospital;
import java.util.Scanner;
import hospital.patient;
import hospital.room;

public class complexMethods {
	public static void roomCheck(room[] roomArray) {
		for(int a=0;a<roomArray.length;a++) {
			room x = roomArray[a];
			if(x.isOccupied==true) {
				System.out.println("Room "+x.getNumber()+" is occupied for "+x.getPatient().getTimeStay()+" days.");
			}else {
				System.out.println("Room "+x.getNumber()+" is not occupied.");
			}//end if
		}//end for
	}//end check
	
	public static void specificCheck(room r) {
		System.out.println("Room "+r.getNumber()+" is occupied by "+r.getPatient().getName()+".");
		System.out.println("\tEmail: "+r.getPatient().getEmail());
		System.out.println("\tTime staying in hospital: "+r.getPatient().getTimeStay());
		System.out.println("\tIn critical condition: "+r.getPatient().getIsCritical());
		System.out.println("\tReason for stay: "+r.getPatient().getIllness());
	}//end specific
	
	public static int reserveRoom(room[] roomArray, patient patient) {
		int i=0;
		room temp;
		for(i=0;i<roomArray.length;i++) {
			temp = roomArray[i];
			if(patient.isCritical==false) {
				if(temp.isOccupied==false && temp.roomType.equals("normal")) {
					temp.patient = patient;
					roomArray[i]=temp;
					roomArray[i].isOccupied=true;
					return i;
				}
			}else if(patient.isCritical==true) {
				if(temp.isOccupied==false && temp.roomType.equals("emergency room")) {
					temp.patient = patient;
					roomArray[i]=temp;
					roomArray[i].isOccupied=true;
					roomArray[i].getPatient().timeStay=0;
				}
			}
		}
		return 10;
	}//end reserve rooms

	public static void releaseRoom(room room) {
		if(room.isOccupied==true) {
			System.out.println(room.getPatient().getName()+" has been released from the hospital.");
			System.out.println("Sending reciept email to: "+room.getPatient().getEmail());
			room.isOccupied = false;
			room.patient = null;
		}
	}//end release
	
	public static void movement(room[] r) {
		Scanner s = new Scanner(System.in);
		System.out.println("1. Move a patient to Surgery");
		System.out.println("2. Remove a patient from Surgery");
		System.out.println("3. Move a patient from ER");
		int x = s.nextInt();
		if(x==1) {
			System.out.println("Enter the room the patient is currently in:");
			moveToSurgery(r[s.nextInt()], r[8]);
		}else if(x==2) {
			removeFromSurgery(r[8]);
		}else if(x==3) {
			System.out.println("Enter the new amount of time to stay in the hospital:");
			r[9].patient.timeStay=s.nextInt();
			reserveRoom(r,moveFromER(r[9]));
		}else {
			System.out.println("Input number 1, 2, or 3");
		}
	}//end movement
	
	public static void moveToSurgery(room r, room s) {
		if(s.isOccupied==true) {
			System.out.println("Unable to move at this time. The room is occupied by "+ s.getPatient()+".");
		}else {
			patient temp = r.getPatient();
			s.patient=temp;
			s.patient.isCritical=true;
			s.isOccupied=true;
		}
	}//end surgery
	
	public static void removeFromSurgery(room r) {
		r.patient=null;
		r.isOccupied=false;
	}//end remove from surgery
	
	public static void moveFromER(room r) {
		patient temp = r.getPatient();
		r.patient=null;
		temp.isCritical=false;
		r.isOccupied=false;
		return temp;
	}//end move from er
}//end class

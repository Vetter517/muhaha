//touching to commit
package hospital;
import java.util.Arrays;
import java.util.Scanner;
import hospital.room;
import hospital.patient;
import hospital.hospitalRW;
import hospital.complexMethods;

public class hospitalMain {

	public static void main(String[] args) {
		System.out.println("Booting Up Hospital System...");
		
		room[] roomArray = new room[10];
		String filename = "hospitalText.txt";
		hospitalRW.createHospital(roomArray, filename);
		System.out.println("System ready.\n");
		mainMenu(roomArray);
		hospitalRW.closeHospital(roomArray,filename);
	}//end main

	public static void mainMenu(room[] rooms) {
		Scanner scanner = new Scanner(System.in);
		String input="";
		while (!input.equals("6")){
			System.out.println("\nWhat would you like to do? (Enter the number next to the option you would like to select)");
			System.out.println("1. Admit Patient into Hospital");
			System.out.println("2. Release Patient from Hospital");
			System.out.println("3. View all of the Rooms");
			System.out.println("4. View a Specific Room");
			System.out.println("5. Move a Patient");
			System.out.println("6. Exit the program");
			input=scanner.nextLine();
			
			if(input.equals("1")) {
				patient p = new patient();
				System.out.println("Name:");
				String name = scanner.nextLine();
				p.setName(name);
				System.out.println("Email:");
				String email = scanner.nextLine();
				p.setEmail(email);
				System.out.println("Time Staying:");
				int time = Integer.parseInt(scanner.nextLine());
				p.setTimeStay(time);
				System.out.println("Critical? (true or false):");
				p.setIsCritical(scanner.nextLine());
				System.out.println("Reason for Admitance:");
				String reason = scanner.nextLine();
				p.setIllness(reason);
				//ADD PATIENT TO ARRAY
				complexMethods.reserveRoom(rooms, p);
			}else if(input.equals("2")) {
				System.out.println("Please enter the room number the patient is staying in:");
				int number = Integer.parseInt(scanner.nextLine());
				if(number<10 && rooms[number].getPatient()!=null) {
					complexMethods.releaseRoom(rooms[number]);
				}else if(number<10 && rooms[number].getPatient()==null){
					System.out.println("You have entered a room that is currently open.");
				}else {
					System.out.println("Invalid room number. Please enter a number from 0 to 9.\n");
				}
			}else if(input.equals("3")) {
				complexMethods.roomCheck(rooms);
			}else if(input.equals("4")) {
				System.out.println("Enter the room that you want to view (0-7 normal,8 surgery, 9 emergency room)");
				int check = scanner.nextInt();
				complexMethods.specificCheck(rooms[check]);
			}else if(input.equals("5")) {
				complexMethods.movement(rooms);
			}else if(input.equals("6")) {
				scanner.close();
				System.out.println("Exiting the Program. File will be saved.");
				break;
			}//end if/else check
		}//end while
	}//end main menu
}//end class


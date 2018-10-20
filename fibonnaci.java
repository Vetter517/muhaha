import java.util.Scanner;

public class fibonnaci {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a number to go up to in the fibonacci sequence:");
		int n = input.nextInt();
		int temp1=0;
		int temp2=1;
		for(int i = 1;i<=n;i++) {
			System.out.println(temp2);
			int out = temp2+temp1;
			temp1=temp2;
			temp2=out;
		}
	}//end main
}//end class

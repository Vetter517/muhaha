package groupWork;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class textImport {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "textImport.txt";
		try {
            @SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader(fileName));
            System.out.println("File read successfully.");
		} catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
	}

}

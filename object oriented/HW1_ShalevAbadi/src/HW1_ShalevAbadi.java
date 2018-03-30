import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HW1_ShalevAbadi {

	public static void main(String[] args) throws FileNotFoundException {
		boolean isFileFlag;
		Scanner userInput = new Scanner(System.in);
		do {
			isFileFlag = true;
		try {
			
			System.out.println("Please enter instruments file name / path:");
			String input = userInput.next();
			File f = new File(input);
			userInput = new Scanner(f);
			
		} catch (FileNotFoundException e) {
			System.out.println("File Error! Please try again:");
			isFileFlag = !isFileFlag;
			userInput = new Scanner(System.in);
		}
	}
		while (!isFileFlag);
		
		userInput.close();
	
		
}}
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class HW1_ShalevAbadi {

	public static class Consts {
		public final static String GUITARS = "Guitars";
		public final static String BASS = "Bass";
		public final static String FLUTES = "Flutes";
		public final static String SAXOPHONES = "Saxophones";
	}

	public static void main(String[] args) throws Exception {
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
		} while (!isFileFlag);

		ArrayList<AfekaInstruments> myInstruments = new ArrayList<>();
		createInstrumentsAndAddToArrayList(userInput, Consts.GUITARS, myInstruments);
		createInstrumentsAndAddToArrayList(userInput, Consts.BASS, myInstruments);
		createInstrumentsAndAddToArrayList(userInput, Consts.FLUTES, myInstruments);
		createInstrumentsAndAddToArrayList(userInput, Consts.SAXOPHONES, myInstruments);

		AfekaInstruments.printInstruments(myInstruments);
		System.out.println("Diffetent Instruments: " + AfekaInstruments.getNumOfDifferentElements(myInstruments) );
		System.out.println("Most Expensive Instrument: ");
		AfekaInstruments.getMostExpensiveInstrument(myInstruments).toString();

		userInput.close();

	}

	private static void createInstrumentsAndAddToArrayList(Scanner userInput, String instrument,
			ArrayList<AfekaInstruments> arrToFill) throws Exception {
		int amountOfInstrument = getAmountOfInstrument(userInput, instrument);
		if (instrument == Consts.GUITARS) {
			for (int i = 0; i < amountOfInstrument; i++) {
				arrToFill.add(new Guitar(userInput));
			}
		} else if (instrument == Consts.BASS) {
			for (int i = 0; i < amountOfInstrument; i++) {
				arrToFill.add(new Guitar(userInput));
			}
		} else if (instrument == Consts.FLUTES) {
			for (int i = 0; i < amountOfInstrument; i++) {
				arrToFill.add(new Flute(userInput));
			}
		} else if (instrument == Consts.SAXOPHONES) {
			for (int i = 0; i < amountOfInstrument; i++) {
				arrToFill.add(new Saxophone(userInput));
			}
		}

	}

	private static int getAmountOfInstrument(Scanner s, String instrument) throws Exception {
		if (!s.hasNextInt()) {
			throw new Exception("Number of " + instrument + " didn't mentioned");
		}
		return s.nextInt();
	}
}
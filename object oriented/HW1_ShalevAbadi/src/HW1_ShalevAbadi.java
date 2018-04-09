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
		try {
			programFlow();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			System.exit(0);
		}
	}

	public static void programFlow() throws Exception {
		Scanner s = GetFileScanner();
		ArrayList<AfekaInstruments> instruments = ReadAllInstruments(s);
		printStatisticData(instruments);
	}

	private static void printStatisticData(ArrayList<AfekaInstruments> instruments) throws Exception {
		AfekaInstruments.printInstruments(instruments);
		if (instruments.size() > 0) {
			System.out.println();
			System.out.println("Diffetent Instruments: " + AfekaInstruments.getNumOfDifferentElements(instruments));
			System.out.println();
			System.out.println("Most Expensive Instrument: ");
			System.out.println(AfekaInstruments.getMostExpensiveInstrument(instruments).toString());
		}
	}

	private static ArrayList<AfekaInstruments> ReadAllInstruments(Scanner s) throws Exception {
		ArrayList<AfekaInstruments> afekaInstruments = new ArrayList<AfekaInstruments>();
		try {
			AfekaInstruments.addAllInstruments(afekaInstruments, createGuitars(s));
			AfekaInstruments.addAllInstruments(afekaInstruments, createBass(s));
			AfekaInstruments.addAllInstruments(afekaInstruments, createFlutes(s));
			AfekaInstruments.addAllInstruments(afekaInstruments, createSaxophones(s));
			System.out.println("Instruments loaded from file successfully!");
		} finally {
			s.close();
		}
		return afekaInstruments;
	}

	private static Scanner GetFileScanner() {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Please enter instruments file name / path:");
		while (true) {
			try {
				String input = userInput.nextLine();
				File f = new File(input);
				Scanner file = new Scanner(f);
				userInput.close();
				return file;
			} catch (FileNotFoundException e) {
				System.out.println("File Error! Please try again:");
			}
		}
		
	}

	private static ArrayList<AfekaInstruments> createGuitars(Scanner s) throws Exception {
		int amountOfInstrument = getAmountOfInstrument(s, Consts.GUITARS);
		ArrayList<AfekaInstruments> guitars = new ArrayList<AfekaInstruments>(amountOfInstrument);
		for (int i = 0; i < amountOfInstrument; i++) {
			guitars.add(new Guitar(s));
		}
		return guitars;
	}

	private static ArrayList<AfekaInstruments> createBass(Scanner s) throws Exception {
		int amountOfInstrument = getAmountOfInstrument(s, Consts.BASS);
		ArrayList<AfekaInstruments> bass = new ArrayList<AfekaInstruments>(amountOfInstrument);
		for (int i = 0; i < amountOfInstrument; i++) {
			bass.add(new Bass(s));
		}
		return bass;
	}

	private static ArrayList<AfekaInstruments> createFlutes(Scanner s) throws Exception {
		int amountOfInstrument = getAmountOfInstrument(s, Consts.FLUTES);
		ArrayList<AfekaInstruments> flutes = new ArrayList<AfekaInstruments>(amountOfInstrument);
		for (int i = 0; i < amountOfInstrument; i++) {
			flutes.add(new Flute(s));
		}
		return flutes;
	}

	private static ArrayList<AfekaInstruments> createSaxophones(Scanner s) throws Exception {
		int amountOfInstrument = getAmountOfInstrument(s, Consts.FLUTES);
		ArrayList<AfekaInstruments> saxsophones = new ArrayList<AfekaInstruments>(amountOfInstrument);
		for (int i = 0; i < amountOfInstrument; i++) {
			saxsophones.add(new Saxophone(s));
		}
		return saxsophones;
	}

	private static int getAmountOfInstrument(Scanner s, String instrument) throws Exception {
		if (!s.hasNextInt()) {
			throw new Exception("Number of " + instrument + " didn't mentioned");
		}
		int res = s.nextInt();
		return res;
	}
}
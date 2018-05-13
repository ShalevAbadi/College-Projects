import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class AfekaInstruments {

	public static void main(String[] args) {
		ArrayList<MusicalInstrument> allInstruments = new ArrayList<>();
		Scanner consoleScanner = new Scanner(System.in);
		File file = getInstrumentsFileFromUser(consoleScanner);

		loadInstrumentsFromFile(file, allInstruments);

		if (allInstruments.size() == 0) {
			System.out.println("There are no instruments in the store currently");
			return;
		}

		printInstruments(allInstruments);

		int different = getNumOfDifferentElements(allInstruments);

		System.out.println("\n\nDifferent Instruments: " + different);

		MusicalInstrument mostExpensive = getMostExpensiveInstrument(allInstruments);

		System.out.println("\n\nMost Expensive Instrument:\n" + mostExpensive);
		menuFlow(consoleScanner, allInstruments);
		consoleScanner.close();
	}

	private static void menuFlow(Scanner consoleScanner, ArrayList<MusicalInstrument> allInstruments) {
		boolean continues = true;
		AfekaInventory<MusicalInstrument> inventory = new AfekaInventory<>();
		do {
			printMenu();
			continues = getAndExecuteUserCommend(consoleScanner, inventory, allInstruments);
		} while (continues);

	}

	private static boolean getAndExecuteUserCommend(Scanner consoleScanner, AfekaInventory<MusicalInstrument> inventory,
			ArrayList<MusicalInstrument> allInstruments) {
		char choice = getCommend(consoleScanner);
		return executeCommend(choice, consoleScanner, inventory, allInstruments);
	}

	public static char getCommend(Scanner consoleScanner) {
		System.out.print("Your Option: ");
		char choice = consoleScanner.next().charAt(0);
		System.out.println(choice + "\n");
		return choice;
	}

	private static boolean executeCommend(char choice, Scanner consoleScanner, AfekaInventory<MusicalInstrument> inventory, ArrayList<MusicalInstrument> allInstruments) {
		switch(choice) {
		case '1':
			inventory.addAllStringInstruments(allInstruments, inventory.getInstruments());
			System.out.println("\nAll String Instruments Added Successfully!");
			break;
		case '2':
			inventory.addAllWindInstruments(allInstruments, inventory.getInstruments());
			System.out.println("\nAll Wind Instruments Added Successfully!");
			break;
		case '3':
			inventory.SortByBrandAndPrice(inventory.getInstruments());
			System.out.println("\nInstruments Sorted Successfully!");
			break;
		case '4':
			if (!inventory.getIsSorted()) {
				System.out.println("\nYou cannot preform binnary search on an unsorted list \n");
			}
			else {
			System.out.println("SEARCH INSTRUMENT: ");
			int index = inventory.binnarySearchByBrandAndPrice(inventory.getInstruments(), getBrandToSearch(consoleScanner),
					getPriceToSearch(consoleScanner));
			if (index == -1) {
				System.out.println("Instrument Not Found!");
			} else {
				System.out.println(inventory.getInstruments().get(index).toString());
			}
			}
			break;
		case '5':
			case5Flow(consoleScanner, inventory);
			break;
		case '6':
			case6Flow(consoleScanner, inventory);
			break;
		case '7':
			System.out.print(inventory.toString());
			break;
		default:{
			System.out.println("\nFinished!");
			return false;
		}} return true;
}

	public static void case6Flow(Scanner consoleScanner, AfekaInventory<MusicalInstrument> inventory) {
		System.out.println("\nDELETE ALL INSTRUMENTS:\n  ");
			System.out.print("Are You Sure?(Y/N)  ");
			do {
			char removeAnswer = consoleScanner.next().charAt(0);
			if (removeAnswer == 'Y' || removeAnswer == 'y') {
				if (inventory.removeAll(inventory.getInstruments())) {
					System.out.println("All Instruments Deleted Successfully!");
				} else{
					System.out.println("Error occured. Instruments didn't remove");
				}
				return;
			}
			if ((removeAnswer == 'N' || removeAnswer == 'n')) {
				System.out.println("You chose not to delete");
				return;
			}
			}while(true);
	}

	public static void case5Flow(Scanner consoleScanner, AfekaInventory<MusicalInstrument> inventory) {
		if (!inventory.getIsSorted()) {
			System.out.println("\nYou cannot delete from an unsorted list \n");
		}
		else {
		System.out.println("\nDELETE INSTRUMENT:\n  ");
		int index = inventory.binnarySearchByBrandAndPrice(inventory.getInstruments(), getBrandToSearch(consoleScanner),
				getPriceToSearch(consoleScanner));
		if (index != -1) {
			System.out.print("Are You Sure?(Y/N)  ");
			do {
			char removeAnswer = consoleScanner.next().charAt(0);
			if (removeAnswer == 'Y' || removeAnswer == 'y') {
				if (inventory.removeInstrument(inventory.getInstruments(),
						inventory.getInstruments().get(index))) {
					System.out.println("Instrument Deleted Successfully!");
				} else{
					System.out.println("Error occured. Instrument didn't remove");
				}
				return;
			}
			if ((removeAnswer == 'N' || removeAnswer == 'n')) {
				System.out.println("You chose not to delete");
				return;
			}
			}while(true);
			
		} else {
			System.out.println("Instrument Not Found!");
		}
		}
	}

	private static String getBrandToSearch(Scanner consoleScanner) {
		System.out.println("\nBrand: ");
		return consoleScanner.next();
	}

	private static Number getPriceToSearch(Scanner consoleScanner) {
		Number res = 0;
		System.out.println("\nPrice: ");
		if (consoleScanner.hasNextDouble()) {
			res = consoleScanner.nextDouble();
		}
		return res;
	}

	private static void printMenu() {
		System.out.println("\n-------------------------------------------------------------------------\n"
				+ "AFEKA MUSICAL INSTRUMENT INVENTORY MENU\n"
				+ "-------------------------------------------------------------------------\n"
				+ "1. Copy All String Instruments To Inventory\n" + "2. Copy All Wind Instruments To Inventory\n"
				+ "3. Sort Instruments By Brand And Price\n" + "4. Search Instrument By Brand And Price\n"
				+ "5. Delete Instrument\n" + "6. Delete all Instruments\n" + "7. Print Inventory Instruments\n"
				+ "Choose your option or any other key to EXIT\n");
	}

	public static File getInstrumentsFileFromUser(Scanner consoleScanner) {
		boolean stopLoop = true;
		File file;
		do {
			System.out.println("Please enter instruments file name / path:");
			String filepath = consoleScanner.nextLine();
			file = new File(filepath);
			stopLoop = file.exists() && file.canRead();

			if (!stopLoop)
				System.out.println("\nFile Error! Please try again\n\n");
		} while (!stopLoop);

		return file;
	}

	public static void loadInstrumentsFromFile(File file, ArrayList allInstruments) {
		Scanner scanner = null;

		try {

			scanner = new Scanner(file);

			addAllInstruments(allInstruments, loadGuitars(scanner));

			addAllInstruments(allInstruments, loadBassGuitars(scanner));

			addAllInstruments(allInstruments, loadFlutes(scanner));

			addAllInstruments(allInstruments, loadSaxophones(scanner));

		} catch (InputMismatchException | IllegalArgumentException ex) {
			System.err.println("\n" + ex.getMessage());
			System.exit(1);
		} catch (FileNotFoundException ex) {
			System.err.println("\nFile Error! File was not found");
			System.exit(2);
		} finally {
			scanner.close();
		}
		System.out.println("\nInstruments loaded from file successfully!\n");

	}

	public static ArrayList loadGuitars(Scanner scanner) {
		int numOfInstruments = scanner.nextInt();
		ArrayList guitars = new ArrayList(numOfInstruments);

		for (int i = 0; i < numOfInstruments; i++)
			guitars.add(new Guitar(scanner));

		return guitars;
	}

	public static ArrayList loadBassGuitars(Scanner scanner) {
		int numOfInstruments = scanner.nextInt();
		ArrayList bassGuitars = new ArrayList(numOfInstruments);

		for (int i = 0; i < numOfInstruments; i++)
			bassGuitars.add(new Bass(scanner));

		return bassGuitars;
	}

	public static ArrayList loadFlutes(Scanner scanner) {
		int numOfInstruments = scanner.nextInt();
		ArrayList flutes = new ArrayList(numOfInstruments);

		for (int i = 0; i < numOfInstruments; i++)
			flutes.add(new Flute(scanner));

		return flutes;
	}

	public static ArrayList loadSaxophones(Scanner scanner) {
		int numOfInstruments = scanner.nextInt();
		ArrayList saxophones = new ArrayList(numOfInstruments);

		for (int i = 0; i < numOfInstruments; i++)
			saxophones.add(new Saxophone(scanner));

		return saxophones;
	}

	public static void addAllInstruments(ArrayList instruments, ArrayList moreInstruments) {
		for (int i = 0; i < moreInstruments.size(); i++) {
			instruments.add(moreInstruments.get(i));
		}
	}

	public static void printInstruments(ArrayList instruments) {
		for (int i = 0; i < instruments.size(); i++)
			System.out.println(instruments.get(i));
	}

	public static int getNumOfDifferentElements(ArrayList instruments) {
		int numOfDifferentInstruments;
		ArrayList differentInstruments = new ArrayList();
		System.out.println();

		for (int i = 0; i < instruments.size(); i++) {
			if (!differentInstruments.contains((instruments.get(i)))) {
				differentInstruments.add(instruments.get(i));
			}
		}

		if (differentInstruments.size() == 1)
			numOfDifferentInstruments = 0;

		else
			numOfDifferentInstruments = differentInstruments.size();

		return numOfDifferentInstruments;
	}

	public static MusicalInstrument getMostExpensiveInstrument(ArrayList instruments) {
		double maxPrice = 0;
		MusicalInstrument mostExpensive = (MusicalInstrument) instruments.get(0);

		for (int i = 0; i < instruments.size(); i++) {
			MusicalInstrument temp = (MusicalInstrument) instruments.get(i);

			if (temp.getPrice().doubleValue() > maxPrice) {
				maxPrice = temp.getPrice().doubleValue();
				mostExpensive = temp;
			}
		}

		return mostExpensive;
	}

}

//Shalev Abadi 205740772
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
		AfekaInventory inventory = new AfekaInventory();
		do {
			printMenu();
			continues = getAndExecuteUserCommend(consoleScanner, inventory, allInstruments);
		} while (continues);

	}

	private static boolean getAndExecuteUserCommend(Scanner consoleScanner, AfekaInventory inventory,
			ArrayList<MusicalInstrument> allInstruments) {
		char choice = getCommend(consoleScanner);
		return executeCommend(choice, consoleScanner, inventory, allInstruments);
	}

	public static char getCommend(Scanner consoleScanner) {
		System.out.print("Your Option: ");
		char choice = consoleScanner.next().charAt(0);
		return choice;
	}

	private static boolean executeCommend(char choice, Scanner consoleScanner, AfekaInventory inventory,
			ArrayList<MusicalInstrument> allInstruments) {
		switch (choice) {
		case '1':
			addAllStringInstrumentsFlow(inventory, allInstruments);
			break;
		case '2':
			addAllWindIntrumentsFlow(inventory, allInstruments);
			break;
		case '3':
			sortInventoryFlow(inventory);
			break;
		case '4':
			searchInstrumentFlow(consoleScanner, inventory);
			break;
		case '5':
			removeOneInstrumentFlow(consoleScanner, inventory);
			break;
		case '6':
			removeAllInstrumentsFlow(consoleScanner, inventory);
			break;
		case '7':
			System.out.print(inventory.toString());
			break;
		default: {
			System.out.println("\nFinished!");
			return false;
		}
		}
		return true;
	}

	public static void searchInstrumentFlow(Scanner consoleScanner, AfekaInventory inventory) {
		if (!inventory.getIsSorted()) {
			System.out.println("\nYou cannot preform binnary search on an unsorted list \n");
		} else {
			System.out.println("SEARCH INSTRUMENT: ");
			int index = inventory.binnarySearchByBrandAndPrice(inventory.getInstruments(),
					getBrandToSearch(consoleScanner), getPriceToSearch(consoleScanner));
			if (index == -1) {
				System.out.println("Instrument Not Found!");

			} else {
				System.out.println(inventory.getInstruments().get(index).toString());
			}
		}
	}

	public static void sortInventoryFlow(AfekaInventory inventory) {
		inventory.SortByBrandAndPrice(inventory.getInstruments());
		System.out.println("\nInstruments Sorted Successfully!");
	}

	public static void addAllWindIntrumentsFlow(AfekaInventory inventory, ArrayList<MusicalInstrument> allInstruments) {
		inventory.addAllWindInstruments(allInstruments, inventory.getInstruments());
		System.out.println("\nAll Wind Instruments Added Successfully!");
	}

	public static void addAllStringInstrumentsFlow(AfekaInventory inventory,
			ArrayList<MusicalInstrument> allInstruments) {
		inventory.addAllStringInstruments(allInstruments, inventory.getInstruments());
		System.out.println("\nAll String Instruments Added Successfully!");
	}

	public static void removeAllInstrumentsFlow(Scanner consoleScanner, AfekaInventory inventory) {
		System.out.println("\nDELETE ALL INSTRUMENTS:\n  ");
		if (getUserApprovalToDelete(consoleScanner)) {
			removeAllAndPrintMessage(inventory);
		}
	}

	public static boolean getUserApprovalToDelete(Scanner consoleScanner) {
		System.out.print("Are You Sure?(Y/N)  ");
		do {
			char removeAnswer = consoleScanner.next().charAt(0);
			if (removeAnswer == 'Y' || removeAnswer == 'y') {
				return true;
			} else if ((removeAnswer == 'N' || removeAnswer == 'n')) {
				System.out.println("You chose not to delete");
				return false;
			}
		} while (true);
	}

	public static void removeAllAndPrintMessage(AfekaInventory inventory) {
		if (inventory.removeAll(inventory.getInstruments())) {
			System.out.println("All Instruments Deleted Successfully!");
		} else {
			System.out.println("Error occured. Instruments didn't remove");
		}
	}

	public static void removeOneInstrumentFlow(Scanner consoleScanner, AfekaInventory inventory) {
		if (!inventory.getIsSorted()) {
			System.out.println("\nYou cannot delete from an unsorted list \n");
		} else {
			System.out.println("\nDELETE INSTRUMENT:\n  ");
			int index = inventory.binnarySearchByBrandAndPrice(inventory.getInstruments(),
					getBrandToSearch(consoleScanner), getPriceToSearch(consoleScanner));
			if (index != -1) {
				System.out.println(inventory.getInstruments().get(index));
				if (getUserApprovalToDelete(consoleScanner)) {
					deleteOneInstrumentAndPrintMessage(inventory, index);
				}
			} else {
				System.out.println("Instrument Not Found!");
			}
		}
	}

	public static void deleteOneInstrumentAndPrintMessage(AfekaInventory inventory, int index) {
		if (inventory.removeInstrument(inventory.getInstruments(), inventory.getInstruments().get(index))) {
			System.out.println("Instrument Deleted Successfully!");
		} else {
			System.out.println("Error occured. Instrument didn't remove");
		}
	}

	private static String getBrandToSearch(Scanner consoleScanner) {
		System.out.println("\nBrand: ");
		return consoleScanner.next();

	}

	private static Number getPriceToSearch(Scanner consoleScanner) {
		System.out.println("\nPrice: ");
		if (consoleScanner.hasNextDouble()) {
			return consoleScanner.nextDouble();
		}
		consoleScanner.nextLine();
		consoleScanner.nextLine();
		return 0;
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

	public static void loadInstrumentsFromFile(File file, ArrayList<MusicalInstrument> allInstruments) {
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

	public static ArrayList<Guitar> loadGuitars(Scanner scanner) {
		int numOfInstruments = scanner.nextInt();
		ArrayList<Guitar> guitars = new ArrayList<>(numOfInstruments);
		for (int i = 0; i < numOfInstruments; i++)
			guitars.add(new Guitar(scanner));
		return guitars;
	}

	public static ArrayList<Bass> loadBassGuitars(Scanner scanner) {
		int numOfInstruments = scanner.nextInt();
		ArrayList<Bass> bassGuitars = new ArrayList<>(numOfInstruments);
		for (int i = 0; i < numOfInstruments; i++)
			bassGuitars.add(new Bass(scanner));
		return bassGuitars;
	}

	public static ArrayList<Flute> loadFlutes(Scanner scanner) {
		int numOfInstruments = scanner.nextInt();
		ArrayList<Flute> flutes = new ArrayList<>(numOfInstruments);
		for (int i = 0; i < numOfInstruments; i++)
			flutes.add(new Flute(scanner));
		return flutes;
	}

	public static ArrayList<Saxophone> loadSaxophones(Scanner scanner) {
		int numOfInstruments = scanner.nextInt();
		ArrayList<Saxophone> saxophones = new ArrayList<>(numOfInstruments);
		for (int i = 0; i < numOfInstruments; i++)
			saxophones.add(new Saxophone(scanner));
		return saxophones;
	}

	public static void addAllInstruments(ArrayList<MusicalInstrument> instruments,
			ArrayList<? extends MusicalInstrument> moreInstruments) {
		for (int i = 0; i < moreInstruments.size(); i++) {
			instruments.add(moreInstruments.get(i));
		}
	}

	public static <T extends MusicalInstrument> void printInstruments(ArrayList<T> instruments) {
		if (instruments.isEmpty())
			System.out.println("There Are No Instruments To Show");
		else {
			for (int i = 0; i < instruments.size(); i++)
				System.out.println(instruments.get(i));
		}
	}

	public static <T extends MusicalInstrument> int getNumOfDifferentElements(ArrayList<T> instruments) {
		int numOfDifferentInstruments;
		ArrayList<T> differentInstruments = new ArrayList<>();
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

	public static <T extends MusicalInstrument> MusicalInstrument getMostExpensiveInstrument(ArrayList<T> instruments) {
		double maxPrice = 0;
		MusicalInstrument mostExpensive = instruments.get(0);
		for (int i = 0; i < instruments.size(); i++) {
			MusicalInstrument temp = instruments.get(i);
			if (temp.getPrice().doubleValue() > maxPrice) {
				maxPrice = temp.getPrice().doubleValue();
				mostExpensive = temp;
			}
		}
		return mostExpensive;
	}
}

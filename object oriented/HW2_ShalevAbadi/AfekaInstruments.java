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

		startInventoryMenu(allInstruments);
	}

	public static void startInventoryMenu(ArrayList<MusicalInstrument> allInstruments) {
		AfekaInventory<MusicalInstrument> inventory = new AfekaInventory<>();
		Scanner choice = new Scanner(System.in);
		boolean exit = false;
		do {
			System.out.println("\n-------------------------------------------------------------------------\n"
					+ "AFEKA MUSICAL INSTRUMENT INVENTORY MENU\n"
					+ "-------------------------------------------------------------------------\n"
					+ "1. Copy All String Instruments To Inventory\n" + "2. Copy All Wind Instruments To Inventory\n"
					+ "3. Sort Instruments By Brand And Price\n" + "4. Search Instrument By Brand And Price\n"
					+ "5. Delete Instrument\n" + "6. Delete all Instruments\n" + "7. Print Inventory Instruments\n"
					+ "Choose your option or any other key to EXIT\n");
			System.out.print("Your Option: ");
			char menuChoice = choice.next().charAt(0);
			switch (menuChoice) {
			case '1':
				inventory.addAllStringInstruments(allInstruments, inventory.getMusicalArrayList());
				System.out.println("\nAll String Instruments Added Successfully!");
				break;
			case '2':
				inventory.addAllWindInstruments(allInstruments, inventory.getMusicalArrayList());
				System.out.println("\nAll Wind Instruments Added Successfully!");
				break;
			case '3':
				inventory.SortByBrandAndPrice(inventory.getMusicalArrayList());
				System.out.println("\nInstruments Sorted Successfully!");
				break;
			case '4':
				System.out.println("\nSEARCH INSTRUMENT:\n  ");
				System.out.print("Brand:");
				String case4Brand = choice.next();
				System.out.print("Price:");
				double case4Price = choice.nextDouble();
				int index4 = inventory.binnarySearchByBrandAndPrice(inventory.getMusicalArrayList(), case4Brand,
						case4Price);
				if (index4 != -1) {
					System.out.println(allInstruments.get(index4).toString());
				} else {
					System.out.println("Instrument Not Found!");
				}
				break;
			case '5':
				System.out.println("\nDELETE INSTRUMENT:\n  ");
				System.out.print("Brand:");
				String case5Brand = choice.next();
				System.out.print("Price:");
				double case5Price = choice.nextDouble();
				int index5;
				String case5Answer;
				index5 = inventory.binnarySearchByBrandAndPrice(inventory.getMusicalArrayList(), case5Brand,
						case5Price);
				if (index5 != -1) {
					System.out.print("Are You Sure?(Y/N)  ");

					case5Answer = choice.next();
					if (case5Answer.equalsIgnoreCase("Y")) {
						if (inventory.removeInstrument(inventory.getMusicalArrayList(),
								inventory.getMusicalArrayList().get(index5))) {
							System.out.println("Instrument Deleted Successfully!");
						} else {
							System.out.println("couldn't remove, dude");
						}
					}
				} else {
					System.out.println("Instrument Not Found!");
				}
				break;
			case '6':
				String case6Answer;
				System.out.print("\nDELETE ALL INSTRUMENTS:\n Are You Sure? (Y/N)  ");
				case6Answer = choice.next();
				if (case6Answer.equalsIgnoreCase("Y")) {
					if (inventory.removeAll(inventory.getMusicalArrayList())) {
						System.out.println("Instrument Deleted Successfully!");
					}
				}
				break;
			case '7':
				System.out.print(inventory.toString());
				break;
			default:
				System.out.println("\nFinished!");
				exit = true;
			}
		} while (!exit);

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
		ArrayList<Flute> flutes = new ArrayList<Flute>(numOfInstruments);

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

	public static void printInstruments(ArrayList<MusicalInstrument> instruments) {
		for (int i = 0; i < instruments.size(); i++)
			System.out.println(instruments.get(i));
	}

	public static int getNumOfDifferentElements(ArrayList<MusicalInstrument> instruments) {
		int numOfDifferentInstruments;
		ArrayList<MusicalInstrument> differentInstruments = new ArrayList<>();
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

	public static MusicalInstrument getMostExpensiveInstrument(ArrayList<MusicalInstrument> instruments) {
		Number maxPrice = 0;
		MusicalInstrument mostExpensive = (MusicalInstrument) instruments.get(0);

		for (int i = 0; i < instruments.size(); i++) {
			MusicalInstrument temp = (MusicalInstrument) instruments.get(i);

			if (temp.getPrice().doubleValue() > maxPrice.doubleValue()) {
				maxPrice = temp.getPrice();
				mostExpensive = temp;
			}
		}

		return mostExpensive;
	}

}

import java.util.ArrayList;
import java.util.Scanner;

public class AfekaInstruments {

	protected ArrayList<AfekaInstruments> listOfInstruments;
	protected String brand;
	protected double price;

	public AfekaInstruments(String brand, double price) throws Exception {
		setBrand(brand);
		setPrice(price);

	}

	public AfekaInstruments(Scanner s) throws Exception {
		if (!s.hasNext()) {
			throw new Exception("price didn't mentioned");
		}
		setPrice(s.nextDouble());
		s.nextLine();
		if (!s.hasNext()) {
			throw new Exception("brand didn't mentioned");
		}
		setBrand(s.nextLine());
	}

	public void setListOfInstruments(ArrayList<AfekaInstruments> listOfInstruments) {
		addAllInstruments(listOfInstruments, this.listOfInstruments);
		;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setPrice(double price) throws Exception {
		throwIfPriceInvalid(price);
		this.price = price;
	}

	public void throwIfPriceInvalid(double price) throws Exception {
		if (price < 0) {
			throw new Exception("Price must be a positive number!");
		}
	}

	public String getBrand() {
		return this.brand;
	}

	public double getPrice() {
		return this.price;
	}

	public void addAllInstruments(ArrayList<AfekaInstruments> addFrom, ArrayList<AfekaInstruments> addTo) {
		for (int i = 0; i < addFrom.size(); i++) {
			addTo.add(addFrom.get(i));
		}
	}

	public static void printInstruments(ArrayList<AfekaInstruments> arr) {
		if (arr.size() == 0) {
			System.out.println("There are no instruments in the store currently");
		} else {
			for (int i = 0; i < arr.size(); i++) {
				System.out.println(arr.get(i).toString());
			}
		}
	}

	@Override
	public boolean equals(Object other) {
		return (other == this) || ((isAfekaInstrument(other) && isEqualPrices(other) && isEqualBrands(other)));
	}

	public boolean isAfekaInstrument(Object other) {
		return other instanceof AfekaInstruments;
	}

	public boolean isEqualBrands(Object other) {
		return (((AfekaInstruments) other).getBrand().equals(this.getBrand()));
	}

	public boolean isEqualPrices(Object other) {
		return ((AfekaInstruments) other).getPrice() == this.getPrice();
	}

	public static AfekaInstruments getMostExpensiveInstrument(ArrayList<AfekaInstruments> arr) {
		int resInstrumentIndex = 0;
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(resInstrumentIndex).getPrice() < arr.get(i).getPrice())
				resInstrumentIndex = i;
		}
		return arr.get(resInstrumentIndex);
	}

	public static int getNumOfDifferentElements(ArrayList<AfekaInstruments> arr) {
		ArrayList<AfekaInstruments> differentElements = new ArrayList<AfekaInstruments>();
		fillArrayWithDifferentObjects(arr, differentElements);
		return differentElements.size();
	}

	public static void fillArrayWithDifferentObjects(ArrayList<AfekaInstruments> arrToCheck,
			ArrayList<AfekaInstruments> arrToFill) {
		for (int i = 0; i < arrToCheck.size(); i++) {
			boolean isExists = checkExistenceInArray(arrToCheck.get(i), arrToFill);
			if (!isExists) {
				arrToFill.add(arrToCheck.get(i));
			}
		}
	}

	public static boolean checkExistenceInArray(AfekaInstruments objectToCheck,
			ArrayList<AfekaInstruments> differentElements) {
		for (int j = 0; j < differentElements.size(); j++) {
			if (objectToCheck.equals(differentElements.get(j))) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		return (getBrand() + " " + this.getClass().getName() + " | Price: " + String.format("%.2f", getPrice()));

	}

}

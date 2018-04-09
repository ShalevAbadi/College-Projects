import java.util.ArrayList;
import java.util.Scanner;

public class AfekaInstruments {

	protected String brand;
	protected double price;

	public AfekaInstruments(String brand, double price) throws Exception {
		setBrand(brand);
		setPrice(price);

	}

	public AfekaInstruments(Scanner s) throws Exception {
		throwIfPriceNotMentioned(s);
		setPrice(s.nextDouble());
		s.nextLine();
		throwIfBrandNotMentioned(s);
		setBrand(s.nextLine());
	}

	private void throwIfBrandNotMentioned(Scanner s) throws Exception {
		if (!s.hasNext()) {
			throw new Exception("Brand didn't mentioned");
		}
	}
	private void throwIfBrandNotMentioned(String brand) throws Exception {
		if (brand.trim().isEmpty() || brand == null) {
			throw new Exception("Brand didn't mentioned");
		}
	}

	private void throwIfPriceNotMentioned(Scanner s) throws Exception {
		if (!s.hasNext()) {
			throw new Exception("Price didn't mentioned");
		}
	}

	public void setBrand(String brand) throws Exception {
		throwIfBrandNotMentioned(brand);
		this.brand = brand;
	}

	public void setPrice(double price) throws Exception {
		throwIfPriceInvalid(price);
		this.price = price;
	}

	private void throwIfPriceInvalid(double price) throws Exception {
		if (price <= 0) {
			throw new Exception("Price must be a positive number!");
		}
	}

	public String getBrand() {
		return this.brand;
	}

	public double getPrice() {
		return this.price;
	}

	public static void addAllInstruments(ArrayList<AfekaInstruments> addTo, ArrayList<AfekaInstruments> addFrom) throws Exception {
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
	public boolean equals(Object obj) {
		return (obj == this) || ((isAfekaInstrument(obj) && isEqualPrices(obj) && isEqualBrands(obj)));
	}

	private boolean isAfekaInstrument(Object obj) {
		return obj instanceof AfekaInstruments;
	}

	private boolean isEqualBrands(Object obj) {
		return (((AfekaInstruments) obj).getBrand().equals(this.getBrand()));
	}

	private boolean isEqualPrices(Object obj) {
		return ((AfekaInstruments) obj).getPrice() == this.getPrice();
	}

	public static AfekaInstruments getMostExpensiveInstrument(ArrayList<AfekaInstruments> arr) throws Exception {
		throwIfListIsEmpty(arr);
		AfekaInstruments resInstrument =arr.get(0);
		for (int i = 1; i < arr.size(); i++) {
			if (resInstrument.getPrice() < arr.get(i).getPrice())
				resInstrument = arr.get(i);
		}
		return resInstrument;
	}

	private static void throwIfListIsEmpty(ArrayList<AfekaInstruments> arr) throws Exception {
		if (arr.isEmpty()) {
			throw new Exception("The list can't be empty!");
		}
	}

	public static int getNumOfDifferentElements(ArrayList<AfekaInstruments> arr) {
		ArrayList<AfekaInstruments> differentElements = new ArrayList<AfekaInstruments>();
		fillArrayWithDifferentObjects(arr, differentElements);
		return differentElements.size();
	}

	private static void fillArrayWithDifferentObjects(ArrayList<AfekaInstruments> arrToCheck,
			ArrayList<AfekaInstruments> arrToFill) {
		for (int i = 0; i < arrToCheck.size(); i++) {
			addIfNotExist(arrToCheck, arrToFill, i);
		}
	}

	public static void addIfNotExist(ArrayList<AfekaInstruments> arrToCheck, ArrayList<AfekaInstruments> arrToFill,
			int i) {
		boolean isExists = checkExistenceInArray(arrToCheck.get(i), arrToFill);
		if (!isExists) {
			arrToFill.add(arrToCheck.get(i));
		}
	}

	private static boolean checkExistenceInArray(AfekaInstruments objectToCheck,
			ArrayList<AfekaInstruments> differentElements) {
		for (int j = 0; j < differentElements.size(); j++) {
			if (objectToCheck.equals(differentElements.get(j))) {
				return true;
			}
		}
		return false;
	}

	public String toString() {
		String strPrice = String.format("%4.2f", getPrice());
		return	String.format(" %-9s%-9s| Price: %7s",getBrand() ,this.getClass().getName(),strPrice);

	}

}

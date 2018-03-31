import java.util.Scanner;

public class Guitar extends StringInstruments {

	private final static String[] types = { "acoustic", "electric", "classic" };
	private final static int CLASSIC_NUM_OF_STRINGS = 6;
	private final static int ACOUSTIC_NUM_OF_STRINGS = 6;
	private final static int ELECTRIC_MAX_NUM_OF_STRINGS = 8;
	private final static int ELECTRIC_MIN_NUM_OF_STRINGS = 6;
	protected final static int DEFAULT_NUM_OF_STRINGS = 6;
	private String type;

	public Guitar(Scanner s) throws Exception {
		super(s);

		if (!s.hasNext()) {
			throw new Exception("guitar type didn't mentioned");
		}
		setType(s.next());
	}

	public Guitar(String brand, double price, String type) throws Exception {
		super(brand, price, DEFAULT_NUM_OF_STRINGS);
		setType(type);
	}

	public Guitar(String brand, double price, int numOfStrings, String type) throws Exception {
		super(brand, price, numOfStrings);
		setType(type);
	}

	public void setType(String type) throws Exception {

		for (int i = 0; i < types.length; i++) {
			if (type.equalsIgnoreCase(types[i])) {

				this.type = type;
				return;
			}
		}
		throw new Exception("guitar can only be of type " + types.toString());

	}

	private boolean validateTypeAndStringsAmount(int numOfStrings, int numToCheck) {
		return (numToCheck == numOfStrings);
	}

	private boolean validateTypeAndStringsAmount(int minNumOfStrings, int maxNumOfStrings, int numToCheck) {
		return (numToCheck <= maxNumOfStrings && numToCheck >= minNumOfStrings);
	}

	public String getType() {
		return this.type;
	}

	@Override
	public boolean equals(Object other) {
		return super.equals(other) && isGuitar(other) && isEqualType(other);
	}

	public boolean isGuitar(Object other) {
		return other instanceof Guitar;
	}

	public boolean isEqualType(Object other) {
		return ((Guitar) other).getType() == this.getType();
	}

}

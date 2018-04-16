import java.util.Scanner;

public class Guitar extends StringInstruments {

	public static class Consts {
		public final static int CLASSIC_NUM_OF_STRINGS = 6;
		public final static int ACOUSTIC_NUM_OF_STRINGS = 6;
		public final static int ELECTRIC_MAX_NUM_OF_STRINGS = 8;
		public final static int ELECTRIC_MIN_NUM_OF_STRINGS = 6;
		public final static int DEFAULT_NUM_OF_STRINGS = 6;

		public static class Types {
			public final static String CLASSIC = "Classic";
			public final static String ELECTRIC = "Electric";
			public final static String ACOUSTIC = "Acoustic";
		}
	}

	private String type;

	public Guitar(Scanner s) throws Exception {
		super(s);
		throwIfTypeNotMentioned(s);
		setType(s.nextLine());
	}

	private void throwIfTypeNotMentioned(Scanner s) throws Exception {
		if (!s.hasNext()) {
			throw new Exception("Guitar type didn't mentioned");
		}
	}

	public Guitar(String brand, double price, String type) throws Exception {
		this(brand, price, Consts.DEFAULT_NUM_OF_STRINGS, type);
	}

	public Guitar(String brand, double price, int numOfStrings, String type) throws Exception {
		super(brand, price, numOfStrings);
		setType(type);
	}

	public void setType(String type) throws Exception {
		throwIfTypeAndNumberOfStringsInvalid(type, getNumOfStrings());
		this.type = type;

	}
	
	private void throwIfTypeAndNumberOfStringsInvalid(String type, int numOfStrings) throws Exception {
		if (type.equalsIgnoreCase(Consts.Types.ACOUSTIC)) {
			throwIfInvalidNumOfStrings(Consts.Types.ACOUSTIC, Consts.ACOUSTIC_NUM_OF_STRINGS , numOfStrings);
		} else if (type.equalsIgnoreCase("classic")) {
			throwIfInvalidNumOfStrings(Consts.Types.CLASSIC, Consts.CLASSIC_NUM_OF_STRINGS, numOfStrings);
		} else if (type.equalsIgnoreCase("electric")) {
			throwIfInvalidNumOfStrings(Consts.Types.ELECTRIC, Consts.ELECTRIC_MIN_NUM_OF_STRINGS, Consts.ELECTRIC_MAX_NUM_OF_STRINGS , numOfStrings);
		} else {
			throw new Exception("guitar type invalid");
		}
	}
	
	@Override
	public void validateNumOfStrings(int numOfStrings) throws Exception {
		if (type == null) {
			super.validateNumOfStrings(numOfStrings);
		}
		else {
			throwIfTypeAndNumberOfStringsInvalid(this.type, numOfStrings);
		}
	}
	private void throwIfInvalidNumOfStrings(String type, int validNumOfStrings, int numOfStrings) throws Exception {
		if (validNumOfStrings != numOfStrings) {
			throw new Exception(type + " guitars have " + validNumOfStrings + " strings, not " + numOfStrings);
		}
	}

	private void throwIfInvalidNumOfStrings(String type, int minNumOfStrings, int maxNumOfStrings, int numOfStringsToValidate) throws Exception {
		if (numOfStringsToValidate > maxNumOfStrings || numOfStringsToValidate < minNumOfStrings) {
			throw new Exception(type + " guitars number of string is a number between " + minNumOfStrings + " and "
					+ maxNumOfStrings);
		}
	}

	public String getType() {
		return this.type;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj) && isGuitar(obj) && isEqualType(obj);
	}

	private boolean isGuitar(Object obj) {
		return obj instanceof Guitar;
	}

	private boolean isEqualType(Object obj) {
		return ((Guitar) obj).getType().equals(this.getType());
	}

	@Override
	public String toString() {
		return (super.toString() + "  Type: " + getType());
	}
}

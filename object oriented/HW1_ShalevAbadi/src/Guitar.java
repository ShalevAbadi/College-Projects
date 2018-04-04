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

	public void throwIfTypeNotMentioned(Scanner s) throws Exception {
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
		this.type = type;
		throwIfTypeAndNumberOfStringsInvalid();

	}

	private void throwIfTypeAndNumberOfStringsInvalid() throws Exception {
		if (this.type.equalsIgnoreCase(Consts.Types.ACOUSTIC)) {
			this.type = Consts.Types.ACOUSTIC;
			throwIfInvalidNumOfStrings(Consts.ACOUSTIC_NUM_OF_STRINGS);
		} else if (this.type.equalsIgnoreCase("classic")) {
			this.type = Consts.Types.CLASSIC;
			throwIfInvalidNumOfStrings(Consts.CLASSIC_NUM_OF_STRINGS);
		} else if (this.type.equalsIgnoreCase("electric")) {
			this.type = Consts.Types.ELECTRIC;
			throwIfInvalidNumOfStrings(Consts.ELECTRIC_MIN_NUM_OF_STRINGS, Consts.ELECTRIC_MAX_NUM_OF_STRINGS);

		} else {
			throw new Exception("guitar type invalid");
		}
	}

	private void throwIfInvalidNumOfStrings(int validNumOfStrings) throws Exception {
		if (validNumOfStrings != numOfStrings) {
			throw new Exception(type + " guitars have " + validNumOfStrings + " strings, not " + numOfStrings);
		}
	}

	private void throwIfInvalidNumOfStrings(int minNumOfStrings, int maxNumOfStrings) throws Exception {
		if (numOfStrings > maxNumOfStrings || numOfStrings < minNumOfStrings) {
			throw new Exception(type + " guitars number of string is a number between " + minNumOfStrings + " and "
					+ maxNumOfStrings);
		}
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
		return ((Guitar) other).getType().equals(this.getType());
	}

	@Override
	public String toString() {
		return (super.toString() + "Type: " + getType());

	}
}

import java.util.Scanner;

public class Bass extends StringInstruments {

	public static class Consts {
		public final static String TRUE = "True";
		public final static String FALSE = "False";
		public final static int MAX_NUM_OF_STRINGS = 6;
		public final static int MIN_NUM_OF_STRINGS = 4;

	}

	private boolean fretless;

	public Bass(Scanner s) throws Exception {
		super(s);

		throwIfInvalidNumOfStrings(Consts.MIN_NUM_OF_STRINGS, Consts.MAX_NUM_OF_STRINGS);
		if (!s.hasNext()) {
			throw new Exception("didn't mentioned if fretless");
		}
		setFretless(parseBoolean(s.next()));

	}

	private void throwIfInvalidNumOfStrings(int minNumOfStrings, int maxNumOfStrings) throws Exception {
		if (numOfStrings > maxNumOfStrings || numOfStrings < minNumOfStrings) {
			throw new Exception(
					"Bass guitars number of string is a number between " + minNumOfStrings + " and " + maxNumOfStrings);
		}
	}

	public Bass(String brand, double price, int numOfStrings, Boolean fretless) throws Exception {
		super(brand, price, numOfStrings);
		setFretless(fretless);
	}

	private boolean parseBoolean(String value) throws Exception {
		if (value.equalsIgnoreCase("" + true)) {
			return true;
		} else if (value.equalsIgnoreCase("" + false)) {
			return false;
		}
		throw new Exception("Whether a bass is fretless or not is boolean, any other string than \"True\" or\r\n"
				+ "\"False\" is not acceptable");
	}

	public void setFretless(boolean fretless) {
		this.fretless = fretless;
	}

	public boolean getFretless() {
		return this.fretless;
	}

	@Override
	public boolean equals(Object other) {
		return super.equals(other) && isBass(other) && isEqualFretless(other);
	}

	public boolean isEqualFretless(Object other) {
		return ((Bass) other).getFretless() == this.getFretless();
	}

	public boolean isBass(Object other) {
		return other instanceof Bass;
	}

}

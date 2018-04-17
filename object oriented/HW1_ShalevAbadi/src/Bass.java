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
		throwIfFretlessNotMentioned(s);
		setFretless(parseBoolean(s.nextLine()));

	}

	private void throwIfFretlessNotMentioned(Scanner s) throws Exception {
		if (!s.hasNext()) {
			throw new Exception("Didn't mentioned if fretless");
		}
	}
	
	@Override
	public void validateNumOfStrings(int numOfStrings) throws Exception {
	if (numOfStrings > Consts.MAX_NUM_OF_STRINGS || numOfStrings < Consts.MIN_NUM_OF_STRINGS) {
			throw new Exception(
					"Bass number of string is a number between " + Consts.MAX_NUM_OF_STRINGS + " and " + Consts.MIN_NUM_OF_STRINGS);
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
	public boolean equals(Object obj) {
		return super.equals(obj) && isBass(obj) && isEqualFretless(obj);
	}

	private boolean isEqualFretless(Object obj) {
		return ((Bass) obj).getFretless() == this.getFretless();
	}

	private boolean isBass(Object obj) {
		return obj instanceof Bass;
	}

	@Override
	public String toString() {
		return (super.toString() + "  Fretless: " + getFretless());
	}
}

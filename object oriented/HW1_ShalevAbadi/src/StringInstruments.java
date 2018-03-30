
public class StringInstruments extends AfekaInstruments {
	private final static int defaultNumOfStrings = 6;
	private int numOfStrings;

	public StringInstruments(String brand, double price) {
		this(brand, price, defaultNumOfStrings);
	}

	public StringInstruments(String brand, double price, int numOfStrings) {
		super(brand, price);
		setNumOfStrings(numOfStrings);
	}

	public void setNumOfStrings(int numOfStrings) {
		this.numOfStrings = numOfStrings;
	}

	public int getNumOfStrings() {
		return this.numOfStrings;
	}

	@Override
	public boolean equals(Object other) {
		return super.equals(other) && isStringInstrument(other) && isEqualNumOfStrings(other);
	}

	public boolean isStringInstrument(Object other) {
		return other instanceof StringInstruments;
	}

	public boolean isEqualNumOfStrings(Object other) {
		return (((StringInstruments) other).getNumOfStrings() == this.getNumOfStrings());
	}
}

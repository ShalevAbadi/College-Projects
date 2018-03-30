
public class Bass extends StringInstruments {

	private boolean fretless;

	public Bass(String brand, double price, int numOfStrings, Boolean fretless) {
		super(brand, price, numOfStrings);
		setFreless(fretless);
	}

	public void setFreless(boolean fretless) {
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

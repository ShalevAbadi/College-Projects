
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
		if (other == this) {
			return true;
		}
		if (super.equals(other)) {
			if (!(other instanceof Bass)) {
				return false;
			}
			return (((Bass) other).getFretless() == this.getFretless());
		}
		return false;
	}
}

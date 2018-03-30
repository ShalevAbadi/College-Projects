
public class Guitar extends StringInstruments {

	private String type;
	
	public Guitar(String brand, double price, int numOfStrings, String type) {
		super(brand, price, numOfStrings);
		setType(type);
	}
	
	public void setType(String type) {
		this.type = type;
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

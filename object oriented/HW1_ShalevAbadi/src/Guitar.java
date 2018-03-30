
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
		if (other == this) {
			return true;
		}
		if (super.equals(other)) {
			if (!(other instanceof Guitar)) {
				return false;
			}
			return (((Guitar) other).getType() == this.getType());
		}
		return false;
	}
	
}

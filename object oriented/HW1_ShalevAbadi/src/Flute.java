
public class Flute extends WindInstruments {
	private String type;
	
	public Flute(String brand, double price, String material, String type) {
		super(brand, price, material);
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
			if (!(other instanceof Flute)) {
				return false;
			}
			return (((Flute) other).getType() == this.getType());
		}
		return false;
	}
}

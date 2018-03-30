
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

		return super.equals(other) && isFlute(other) && isEqualType(other);
	}

	public boolean isFlute(Object other) {
		return other instanceof Flute;
	}

	public boolean isEqualType(Object other) {
		return ((Flute) other).getType() == this.getType();
	}
}

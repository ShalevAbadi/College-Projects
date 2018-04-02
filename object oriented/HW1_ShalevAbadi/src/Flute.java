import java.util.Scanner;

public class Flute extends WindInstruments {

	private final static String[] types = { "recorder", "bass", "transverse" };
	private String type;

	public Flute(Scanner s) throws Exception {
		super(s);
		if (!s.hasNext()) {
			throw new Exception("flute type didn't mentioned");
		}
		setType(s.nextLine());
	}

	public Flute(String brand, double price, String material, String type) throws Exception {
		super(brand, price, material);
		setType(type);
	}

	public void setType(String type) throws Exception {
		for (int i = 0; i < types.length; i++) {
			if (type.equalsIgnoreCase(types[i])) {
				this.type = type;
				return;
			}
		}
		throw new Exception("Flute can only be of type " + types.toString());
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

	@Override
	public String toString() {
		return (super.toString() + "Type: " + getType());

	}
}

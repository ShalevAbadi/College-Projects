import java.util.Scanner;

public class Saxophone extends WindInstruments {

	private final static String[] MATERIALS = { "Metal" };

	public Saxophone(Scanner s) throws Exception {
		super(s);
		throwIfInvalidMaterial();
	}

	private void throwIfInvalidMaterial() throws Exception {
		for (int i = 0; i < MATERIALS.length; i++) {
			if (MATERIALS[i].equalsIgnoreCase(material)) {
				return;
			}
		}
		throw new Exception("Saxophone can only be made of " + MATERIALS.toString());
	}

	public Saxophone(String brand, double price) throws Exception {
		super(brand, price, MATERIALS[0]);

	}

	@Override
	public boolean equals(Object other) {
		return (isSaxophone(other) && super.equals(other));
	}

	public boolean isSaxophone(Object other) {
		return other instanceof Saxophone;
	}

}

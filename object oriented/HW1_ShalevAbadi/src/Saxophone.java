import java.util.Scanner;

public class Saxophone extends WindInstruments {

	private final static String[] MATERIALS = { "metal" };

	public Saxophone(Scanner s) throws Exception {
		super(s);
		throwIfInvalidMaterial();
	}

	private void throwIfInvalidMaterial() throws Exception {
		for (int i = 0; i < MATERIALS.length; i++) {
			if (material.equalsIgnoreCase(MATERIALS[i])) {
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
		return super.equals(other) && isSaxophone(other);
	}

	public boolean isSaxophone(Object other) {
		return other instanceof Saxophone;
	}

}

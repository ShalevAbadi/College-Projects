import java.util.Scanner;

public class WindInstruments extends AfekaInstruments {

	protected final static String[] MATERIALS = { "Wood", "Metal", "Plastic" };
	protected String material;

	public WindInstruments(Scanner s) throws Exception {
		super(s);
		throwIfMaterialNotMentioned(s);
		setMaterial(s.nextLine());
	}

	public void throwIfMaterialNotMentioned(Scanner s) throws Exception {
		if (!s.hasNext()) {
			throw new Exception("Material didn't mentioned");
		}
	}

	public WindInstruments(String brand, double price, String material) throws Exception {
		super(brand, price);
		setMaterial(material);
	}

	public void setMaterial(String material) throws Exception {
		for (int i = 0; i < MATERIALS.length; i++) {
			if (material.equalsIgnoreCase(MATERIALS[i])) {
				this.material = MATERIALS[i];
				return;
			}
		}
		throw new Exception(this.getClass() + " can only be of type " + material.toString());
	}

	public String getMaterial() {
		return this.material;
	}

	@Override
	public boolean equals(Object other) {
		return (isWindInstrument(other) && super.equals(other) && isEqualMaterial(other));
	}

	public boolean isEqualMaterial(Object other) {
		return (((WindInstruments) other).getMaterial().equals(this.getMaterial()));
	}

	public boolean isWindInstrument(Object other) {
		return (other instanceof WindInstruments);
	}

	@Override
	public String toString() {
		return (super.toString() + ", Made of:	" + getMaterial() + "|");

	}
}

import java.util.Scanner;

public class WindInstruments extends AfekaInstruments {

	private final static String[] MATERIALS = { "Wood", "Metal", "Plastic" };
	private String material;

	public WindInstruments(Scanner s) throws Exception {
		super(s);
		throwIfMaterialNotMentioned(s);
		setMaterial(s.nextLine());
	}

	private void throwIfMaterialNotMentioned(Scanner s) throws Exception {
		if (!s.hasNext()) {
			throw new Exception("Material didn't mentioned");
		}
	}

	public WindInstruments(String brand, double price, String material) throws Exception {
		super(brand, price);
		setMaterial(material);
	}
	
	public String[] getValidMaterials() {
		return WindInstruments.MATERIALS;
	}

	public void setMaterial(String material) throws Exception {
		String[] validMaterials = getValidMaterials();
		for (int i = 0; i < validMaterials.length; i++) {
			if (material.equalsIgnoreCase(validMaterials[i])) {
				this.material = validMaterials[i];
				return;
			}
		}
		throw new Exception(this.getClass() + " can only be made of " + material.toString());
	}

	public String getMaterial() {
		return this.material;
	}

	@Override
	public boolean equals(Object obj) {
		return (isWindInstrument(obj) && super.equals(obj) && isEqualMaterial(obj));
	}

	private boolean isEqualMaterial(Object obj) {
		return (((WindInstruments) obj).getMaterial().equals(this.getMaterial()));
	}

	private boolean isWindInstrument(Object obj) {
		return (obj instanceof WindInstruments);
	}

	@Override
	public String toString() {
		return super.toString()  + String.format(", Made of:%13s|", getMaterial());

	}
}


public class WindInstruments extends AfekaInstruments {

	private String material;
	
	public void setMaterial(String material) {
		this.material = material;
	}
	public WindInstruments(String brand, double price, String material) {
		super(brand, price);
		setMaterial(material);
	}
	
	
	public String getMaterial() {
		return this.material;
	}
	
	@Override
	public boolean equals(Object other) {
		return super.equals(other) && isWindInstrument(other) && isEqualMaterial(other);
	}
	public boolean isEqualMaterial(Object other) {
		return ((WindInstruments) other).getMaterial() == this.getMaterial();
	}
	public boolean isWindInstrument(Object other) {
		return other instanceof WindInstruments;
	}
}


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
		if (other == this) {
			return true;
		}
		if (super.equals(other)) {
			if (!(other instanceof WindInstruments)) {
				return false;
			}
			return (((WindInstruments) other).getMaterial() == this.getMaterial());
		}
		return false;
	}
}

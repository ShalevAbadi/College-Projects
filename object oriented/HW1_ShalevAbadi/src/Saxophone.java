
public class Saxophone extends WindInstruments {
	
	public Saxophone(String brand, double price) {
		super(brand, price, "metal");
		
	}
	
	@Override
	public boolean equals(Object other) {
		if (super.equals(other)) {
			return (other instanceof Saxophone);
		}
		return false;
	}

}

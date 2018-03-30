
public class Saxophone extends WindInstruments {
	
	public Saxophone(String brand, double price) {
		super(brand, price, "metal");
		
	}
	
	@Override
	public boolean equals(Object other) {
		return super.equals(other) && isSaxophone(other);
	}

	public boolean isSaxophone(Object other) {
		return other instanceof Saxophone;
	}

}

import java.util.Scanner;

public class Saxophone extends WindInstruments {

	private final static String[] materials = { "metal" };

	public Saxophone(Scanner s) throws Exception {
		super(s);
	}

	public Saxophone(String brand, double price) throws Exception {
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

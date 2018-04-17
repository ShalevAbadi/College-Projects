import java.util.Scanner;

public class Saxophone extends WindInstruments {

	private final static String[] MATERIALS = { "Metal" };

	public Saxophone(Scanner s) throws Exception {
		super(s);
	}
	
	@Override
	protected String[] getValidMaterials() {
		return Saxophone.MATERIALS;
	}

	public Saxophone(String brand, double price) throws Exception {
		super(brand, price, MATERIALS[0]);

	}

	@Override
	public boolean equals(Object obj) {
		return (isSaxophone(obj) && super.equals(obj));
	}

	private boolean isSaxophone(Object obj) {
		return obj instanceof Saxophone;
	}
}

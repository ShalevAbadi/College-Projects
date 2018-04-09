import java.util.Scanner;

public class StringInstruments extends AfekaInstruments {

	protected int numOfStrings;

	public StringInstruments(Scanner s) throws Exception {
		super(s);
		throwIfNumOfStringsNotMentioned(s);
		setNumOfStrings(s.nextInt());
		s.nextLine();
	}

	private void throwIfNumOfStringsNotMentioned(Scanner s) throws Exception {
		if (!s.hasNextInt()) {
			throw new Exception("Num of strings didn't mentioned");
		}
	}

	public StringInstruments(String brand, double price, int numOfStrings) throws Exception {
		super(brand, price);
		setNumOfStrings(numOfStrings);
	}

	public void setNumOfStrings(int numOfStrings) {
		this.numOfStrings = numOfStrings;
	}

	public int getNumOfStrings() {
		return this.numOfStrings;
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj) && isStringInstrument(obj) && isEqualNumOfStrings(obj);
	}

	private boolean isStringInstrument(Object obj) {
		return obj instanceof StringInstruments;
	}

	private boolean isEqualNumOfStrings(Object obj) {
		return (((StringInstruments) obj).getNumOfStrings() == this.getNumOfStrings());
	}

	@Override
	public String toString() {
		return super.toString() + String.format(", Number of strings:%3s|" , getNumOfStrings());
	}
}

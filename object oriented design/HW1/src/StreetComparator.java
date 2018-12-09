
public class StreetComparator extends AddressBookComparator {

	public StreetComparator() {
		super(CommandButton.NAME_SIZE, CommandButton.NAME_SIZE + CommandButton.STREET_SIZE);
	}
	
	@Override
	public int compare(String arg0, String arg1) {
		int originalCompare = super.compare(arg0, arg1);
		if(originalCompare == 0) {
			return 1;
		}
		return originalCompare;
	}
}
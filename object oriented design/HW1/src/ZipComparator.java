
public class ZipComparator extends AddressBookComparator {

	public ZipComparator() {
		super(CommandButton.RECORD_SIZE - CommandButton.ZIP_SIZE, CommandButton.RECORD_SIZE);
	}
	
	@Override
	public int compare(String arg0, String arg1) {
		arg0 = generateStringToCompareByIndexes(arg0).trim();
		arg1 = generateStringToCompareByIndexes(arg1).trim();
		return Integer.parseInt(arg0) - Integer.parseInt(arg1);
	}

}

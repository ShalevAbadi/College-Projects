import java.util.Comparator;

public abstract class AddressBookComparator implements Comparator<String> {
	protected int beginingIndex;
	protected int endIndex;
	
	public AddressBookComparator(int beginingIndex, int endIndex) {
		this.beginingIndex = beginingIndex;
		this.endIndex = endIndex;
	}
	
	protected String generateStringToCompareByIndexes(String s){
		return s.substring(beginingIndex, endIndex);
	}
	
	@Override
	public int compare(String arg0, String arg1) {
		return generateStringToCompareByIndexes(arg0).compareTo(generateStringToCompareByIndexes(arg1));
	}
}


public class SimpleAddressBookPane implements MyAddressBookPane{
	
	private AddressBookPane addressBookPane;
	
	public SimpleAddressBookPane() {
		this.addressBookPane = new AddressBookPane();
	}

	@Override
	public AddressBookPane convertToAddressBook() {
		return addressBookPane;
	}
}

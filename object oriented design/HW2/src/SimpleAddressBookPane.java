
public class SimpleAddressBookPane implements MyAddressBookPane{
	
	private AddressBookPane addressBookPane;
	
	public SimpleAddressBookPane() {
		this.addressBookPane = AddressBookPane.getInstance();
	}

	@Override
	public AddressBookPane convertToAddressBook() {
		return addressBookPane;
	}
}

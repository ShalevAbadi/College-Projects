
public abstract class DecoratedAddressBookPane implements MyAddressBookPane{
	
	private MyAddressBookPane myAddressBookPane;
	
	public DecoratedAddressBookPane(MyAddressBookPane myAddressBookPane) {
		this.myAddressBookPane = myAddressBookPane;
	}

	@Override
	public AddressBookPane convertToAddressBook() {
		return myAddressBookPane.convertToAddressBook();
	}

}


public class AddressBookPrimary extends DecoratedAddressBookPane{
	AddButton addBtn;
	RedoButton reBtn;
	UndoButton unBtn;
	
	public AddressBookPrimary(MyAddressBookPane myAddressBookPane) {
		super(myAddressBookPane);
		addBtn = new AddButton(super.convertToAddressBook(), super.convertToAddressBook().raf);
		reBtn = new RedoButton(super.convertToAddressBook(), super.convertToAddressBook().raf);
		unBtn = new UndoButton(super.convertToAddressBook(), super.convertToAddressBook().raf);
		
	}
	
	private void decorateAddressBookPane() {
		super.convertToAddressBook().jpButton.getChildren().addAll(addBtn, reBtn, unBtn);
	}
	
	@Override
	public AddressBookPane convertToAddressBook() {
		decorateAddressBookPane();
		return super.convertToAddressBook();
	}
}

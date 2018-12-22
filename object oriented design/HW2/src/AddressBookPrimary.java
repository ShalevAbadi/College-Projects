
public class AddressBookPrimary extends DecoratedAddressBookPane {
	AddButton addBtn;
	RedoButton reBtn;
	UndoButton unBtn;

	public AddressBookPrimary(MyAddressBookPane myAddressBookPane) {
		super(myAddressBookPane);
		addBtn = new AddButton(super.convertToAddressBook(), super.convertToAddressBook().getRaf());
		addBtn.setOnAction(super.convertToAddressBook().ae);
		reBtn = new RedoButton(super.convertToAddressBook(), super.convertToAddressBook().getRaf());
		reBtn.setOnAction(super.convertToAddressBook().ae);
		unBtn = new UndoButton(super.convertToAddressBook(), super.convertToAddressBook().getRaf());
		unBtn.setOnAction(super.convertToAddressBook().ae);

	}

	private void decorateAddressBookPane() {
		super.convertToAddressBook().getButtonsPane().getChildren().addAll(addBtn, reBtn, unBtn);
	}

	@Override
	public AddressBookPane convertToAddressBook() {
		decorateAddressBookPane();
		return super.convertToAddressBook();
	}
}

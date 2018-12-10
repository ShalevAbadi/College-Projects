
public class AddressBookPrimary extends AddressBookPane{
	
	public AddressBookPrimary() {
		super();
		AddButton jbtAdd = new AddButton(this, raf);
		jbtAdd.setOnAction(ae);
		this.jpButton.getChildren().add(jbtAdd);
	}
}

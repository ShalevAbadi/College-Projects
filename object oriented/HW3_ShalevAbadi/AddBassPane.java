
import javafx.scene.control.CheckBox;
import javafx.scene.text.Text;

public class AddBassPane extends AddStringInstrumentPane {

	Text fretless = new Text("fretless");
	CheckBox fretlessBox = new CheckBox();
	
	public AddBassPane() {
		addRow(getRowCount(), fretless, fretlessBox);
		brandPrompt = "FenderJazz";
		pricePrompt = "Ex: 7500";
		numberOfStringPrompt = "Ex: 4";
		setPrompts();
	}

	@Override
	public MusicalInstrument getInstrumentToAdd() {
		String brand = brandField.getText();
		int price = Integer.parseInt(priceField.getText());
		int numOfStrings = Integer.parseInt(numberOfStringsField.getText());
		Boolean isFretless = fretlessBox.isSelected();
		return new Bass(brand, price, numOfStrings, isFretless);
	}
}

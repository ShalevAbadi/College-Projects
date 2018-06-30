import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;

public class AddGuitarPane extends AddStringInstrumentPane {
	
	Text type = new Text("Guitar Type:");
	final static ObservableList<String> TYPES_LIST = FXCollections.observableArrayList(Guitar.GUITAR_TYPE);
	ComboBox<String> typesComboBox = new ComboBox<>(TYPES_LIST);
	
	public AddGuitarPane() {
		typesComboBox.setPromptText("Type");
		addRow(getRowCount(), type, typesComboBox);
		brandPrompt = "Ex: Gibson";
		pricePrompt = "Ex: 7500";
		numberOfStringPrompt = "Ex: 6";
		setPrompts();
	}

	@Override
	public MusicalInstrument getInstrumentToAdd() {
		String brand = brandField.getText();
		int price = Integer.parseInt(priceField.getText());
		int numOfStrings = Integer.parseInt(numberOfStringsField.getText());
		String type = typesComboBox.getValue();
		return new Guitar(brand, price, numOfStrings, type);
	}
}

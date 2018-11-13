import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;

public class AddFlutePane extends AddInstrumentPane {
	final static Text MATERIAL = new Text("Material:");
	final static ObservableList<String> MATERIALS_LIST = FXCollections
			.observableArrayList(Flute.WIND_INSTRUMENT_MATERIAL);
	final static Text TYPE = new Text("Flute Type:");
	final static ObservableList<String> TYPES_LIST = FXCollections.observableArrayList(Flute.FLUET_TYPE);
	private ComboBox<String> materialsComboBox = new ComboBox<>(MATERIALS_LIST);
	private ComboBox<String> typesComboBox = new ComboBox<>(TYPES_LIST);

	public AddFlutePane() {
		materialsComboBox.setPromptText("Material");
		typesComboBox.setPromptText("type");
		addRow(getRowCount(), MATERIAL, materialsComboBox);
		addRow(getRowCount(), TYPE, typesComboBox);
		brandPrompt = "Ex: Levit";
		pricePrompt = "Ex: 300";
		setPrompts();
	}

	@Override
	public MusicalInstrument getInstrumentToAdd() {
		String brand = brandField.getText();
		int price = Integer.parseInt(priceField.getText());
		String material = materialsComboBox.getValue();
		String fluteType = typesComboBox.getValue();
		return new Flute(brand, price, material, fluteType);
	}

}

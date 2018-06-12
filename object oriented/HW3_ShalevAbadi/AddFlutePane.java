import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;

public class AddFlutePane extends AddInstrumentPane {
	final static Text MATERIAL = new Text("Material:");
	private ComboBox<String> materialsCombeBox = new ComboBox<>(MATERIALS_LIST);
	final static ObservableList<String> MATERIALS_LIST = FXCollections.observableArrayList(Flute.WIND_INSTRUMENT_MATERIAL);
	final static Text TYPE = new Text("Flute Type:");
	final static ObservableList<String> TYPES_LIST = FXCollections.observableArrayList(Flute.FLUET_TYPE);
	private ComboBox<String> typesCombeBox = new ComboBox<>(TYPES_LIST);
	
	public AddFlutePane() {
		materialsCombeBox.setPromptText("Material");
		typesCombeBox.setPromptText("type");
		addRow(getRowCount(), MATERIAL, materialsCombeBox);
		addRow(getRowCount(),TYPE, typesCombeBox);
		brandPrompt = "Ex: Levit";
		pricePrompt = "Ex: 300";
		setPrompts();
	}


}

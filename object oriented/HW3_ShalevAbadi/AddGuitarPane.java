
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.text.Text;

public class AddGuitarPane extends AddStringInstrumentPane {
	
	Text type = new Text("Guitar Type:");
	final static ObservableList<String> TYPES = FXCollections.observableArrayList(Guitar.GUITAR_TYPE);
	private ComboBox<String> typesCombeBox = new ComboBox<>(TYPES);
	
	public AddGuitarPane() {
		typesCombeBox.setPromptText("Type");
		addRow(getRowCount(), type, typesCombeBox);
		addRow(getRowCount(), new Text(), addButton);
	}
}

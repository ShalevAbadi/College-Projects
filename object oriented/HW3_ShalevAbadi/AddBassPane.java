
import javafx.scene.control.CheckBox;
import javafx.scene.text.Text;

public class AddBassPane extends AddStringInstrumentPane {

	Text fretless = new Text("fretless");
	CheckBox fretlessBox = new CheckBox();
	
	public AddBassPane() {
		addRow(getRowCount(),fretless, fretlessBox);
		addRow(getRowCount(), new Text(), addButton);
	}
}

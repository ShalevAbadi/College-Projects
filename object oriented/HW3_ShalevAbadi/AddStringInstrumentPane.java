import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public abstract class AddStringInstrumentPane extends AddInstrumentPane {

	TextField numberOfStringsField = new TextField();
	Text numberOfStrings = new Text("Number Of Strings:");
	
	public AddStringInstrumentPane(){
		addRow(getRowCount(), numberOfStrings, numberOfStringsField );
	}
}

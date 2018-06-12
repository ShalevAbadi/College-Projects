import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public abstract class AddStringInstrumentPane extends AddInstrumentPane {

	TextField numberOfStringsField = new TextField();
	Text numberOfStrings = new Text("Number Of Strings:");
	String numberOfStringPrompt;
	public AddStringInstrumentPane() {
		addRow(getRowCount(), numberOfStrings, numberOfStringsField);
	}
	
	@Override
	protected void setPrompts() {
		super.setPrompts();
		numberOfStringsField.setPromptText(numberOfStringPrompt);
		
	}
}

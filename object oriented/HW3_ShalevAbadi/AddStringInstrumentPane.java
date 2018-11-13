import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public abstract class AddStringInstrumentPane extends AddInstrumentPane {

	protected TextField numberOfStringsField = new TextField();
	protected Text numberOfStrings = new Text("Number Of Strings:");
	protected String numberOfStringPrompt;

	public AddStringInstrumentPane() {
		addRow(getRowCount(), numberOfStrings, numberOfStringsField);
	}

	@Override
	protected void setPrompts() {
		super.setPrompts();
		numberOfStringsField.setPromptText(numberOfStringPrompt);
	}
}

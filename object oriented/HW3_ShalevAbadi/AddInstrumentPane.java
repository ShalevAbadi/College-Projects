
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public abstract class AddInstrumentPane extends GridPane {
	public final static int HGAP_VAL = 20;
	public final static int VGAP_VAL = 20;
	public final static int PADDING_VAL = 10;
	protected String brandPrompt;
	protected String pricePrompt;
	protected TextField brandField = new TextField();
	protected Text brand = new Text("Brand:");
	protected TextField priceField = new TextField();
	protected Text price = new Text("Price:");

	public AddInstrumentPane() {
		setAlignment(Pos.CENTER);
		setHgap(HGAP_VAL);
		setVgap(VGAP_VAL);
		setPadding(new Insets(PADDING_VAL));
		addRow(getRowCount(), brand, brandField);
		addRow(getRowCount(), price, priceField);
	}

	protected void setPrompts() {
		brandField.setPromptText(brandPrompt);
		priceField.setPromptText(pricePrompt);
	}

	public abstract MusicalInstrument getInstrumentToAdd();
}

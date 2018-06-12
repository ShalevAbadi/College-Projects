
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public abstract class AddInstrumentPane extends GridPane {

	TextField brandField = new TextField();
	Text brand = new Text("Brand:");
	TextField priceField = new TextField();
	Text price = new Text("Price:");
	Button addButton = new Button("add");
	
	public AddInstrumentPane() {
		setAlignment(Pos.CENTER);
        setHgap(20);
        setVgap(20);
        setPadding(new Insets(10));	
        addRow(getRowCount(), brand, brandField);
        addRow(getRowCount(), price, priceField);
	}
}

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class InstrumentProperties extends GridPane {
		private final int TEXT_MIN_WIDTH = 200;
		private Text typeText = new Text("Type: ");
		private Text brandText = new Text("Brand: ");
		private Text priceText = new Text("Price: ");
		private TextField typeField = new TextField();
		private TextField brandField = new TextField();
		private TextField priceField = new TextField();

		public InstrumentProperties() {
			initializeAllTextsProperties();
			initializeAllTextsFields();
			initializeRows();
			setAlignment(Pos.CENTER);
		}

		private void initializeRows() {
			addRow(getRowCount(), typeText, typeField);
			addRow(getRowCount(), brandText, brandField);
			addRow(getRowCount(), priceText, priceField);
		}

		private void initializeAllTextsProperties() {
			setTextProperties(typeText);
			setTextProperties(brandText);
			setTextProperties(priceText);
		}

		private void initializeAllTextsFields() {
			setTextFieldProperties(typeField);
			setTextFieldProperties(brandField);
			setTextFieldProperties(priceField);
		}

		private void setTextProperties(Text text) {
			text.minWidth(TEXT_MIN_WIDTH);
		}

		private void setTextFieldProperties(TextField textField) {
			textField.setMinWidth(300);
			textField.setEditable(false);
		}

		public void setTypeFieldText(String text) {
			typeField.setText(text);
		}

		public void setBrandFieldText(String text) {
			brandField.setText(text);
		}

		public void setPriceFieldText(String text) {
			priceField.setText(text);
		}

	}
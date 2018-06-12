import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;

public class AddNewInstrument extends Stage {
	public static final ObservableList<String> INSTRUMENTS = FXCollections.observableArrayList("Guitar", "Saxophone",
			"Bass", "Flute");
	ComboBox<String> instrumentsComboBox = new ComboBox<>(INSTRUMENTS);
	AddGuitarPane guitarPane = new AddGuitarPane();
	AddBassPane bassPane = new AddBassPane();
	VBox layoutContainer = new VBox();
	
	public AddNewInstrument() {
		setTitle("Add an instrument");
		setMinHeight(400);
		setMinWidth(400);
		instrumentsComboBox.setPromptText("Choose Instrument Type Here");
		instrumentsComboBox.setMinWidth(200);
		instrumentsComboBox.setOnAction(e -> {
			openAddInstrumentWindow(instrumentsComboBox.getValue());
		});

		layoutContainer.getChildren().add(instrumentsComboBox);
		layoutContainer.setFillWidth(true);
		layoutContainer.setAlignment(Pos.CENTER);
		setScene(new Scene(layoutContainer));

	}

	private void openAddInstrumentWindow(String value) {
		switch (value) {
		case "Guitar":
			resetLayoutContainer();
			layoutContainer.getChildren().add(guitarPane);
			break;
		case "Saxophone":
			// showAddSaxophone();
			break;
		case "Bass":
			resetLayoutContainer();
			layoutContainer.getChildren().add(bassPane);
			break;
		case "Flute":
			// showAddFlute();
			break;
		}

	}

	private void resetLayoutContainer() {
		layoutContainer.getChildren().clear();
		layoutContainer.getChildren().add(instrumentsComboBox);
	}
}

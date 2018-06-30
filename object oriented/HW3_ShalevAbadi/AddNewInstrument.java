import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;

public class AddNewInstrument extends Stage {
	private MusicalInstrument instrumentToAdd;
	public static final ObservableList<String> INSTRUMENTS = FXCollections.observableArrayList("Guitar", "Saxophone",
			"Bass", "Flute");
	ComboBox<String> instrumentsComboBox = new ComboBox<>(INSTRUMENTS);
	VBox layoutContainer = new VBox();
	private Button addButton = new Button("add");

	public AddNewInstrument() {
		layoutContainer.getChildren().add(instrumentsComboBox);
		setMinHeight(400);
		setMinWidth(400);
		setTitle("Add an instrument");
		instrumentsComboBox.setPromptText("Choose Instrument Type Here");
		instrumentsComboBox.setMinWidth(200);
		instrumentsComboBox.setOnAction(e -> {
			openAddInstrumentWindow(instrumentsComboBox.getValue());
		});
		layoutContainer.setFillWidth(true);
		layoutContainer.setAlignment(Pos.CENTER);
		setScene(new Scene(layoutContainer));
	}

	public Button getAddButton() {
		return addButton;
	}

	public MusicalInstrument getInstrumentToAdd() {
		return instrumentToAdd;
	}

	public AddInstrumentPane getAddInstrumentPane() {
		if (layoutContainer.getChildren().size() > 0) {
			return (AddInstrumentPane) (layoutContainer.getChildren().get(1));
		}
		return null;
	}

	private void openAddInstrumentWindow(String value) {
		switch (value) {
		case "Guitar":
			resetLayoutContainer(new AddGuitarPane());
			break;
		case "Saxophone":
			resetLayoutContainer(new AddSaxophonePane());
			break;
		case "Bass":
			resetLayoutContainer(new AddBassPane());
			break;
		case "Flute":
			resetLayoutContainer(new AddFlutePane());
			break;
		}
	}

	private void resetLayoutContainer(AddInstrumentPane instrumentToAddPane) {
		if (layoutContainer.getChildren().size() > 1) {
			layoutContainer.getChildren().remove((layoutContainer.getChildren().size() - 2));
			layoutContainer.getChildren().add(layoutContainer.getChildren().size() - 1, instrumentToAddPane);
		} else {
			layoutContainer.getChildren().add(instrumentToAddPane);
			layoutContainer.getChildren().add(addButton);
		}
	}
}

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;

public class AddNewInstrument extends Stage {
	private ArrayList<MusicalInstrument> addTo; 
	public static final ObservableList<String> INSTRUMENTS = FXCollections.observableArrayList("Guitar", "Saxophone",
			"Bass", "Flute");
	ComboBox<String> instrumentsComboBox = new ComboBox<>(INSTRUMENTS);
	AddGuitarPane guitarPane = new AddGuitarPane();
	AddBassPane bassPane = new AddBassPane();
	AddSaxophonePane saxsophonePane = new AddSaxophonePane();
	AddFlutePane flutePane = new AddFlutePane();
	VBox layoutContainer = new VBox();
	Button addButton = new Button("add");
	
	public AddNewInstrument(ArrayList<MusicalInstrument> addTo) {
		this.addTo = addTo;
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
			layoutContainer.getChildren().addAll(guitarPane, addButton);
			addGuitar();
			break;
		case "Saxophone":
			resetLayoutContainer();
			layoutContainer.getChildren().addAll(saxsophonePane, addButton);
			addSaxophone();
			break;
		case "Bass":
			resetLayoutContainer();
			layoutContainer.getChildren().addAll(bassPane, addButton);
			addBass();
			break;
		case "Flute":
			resetLayoutContainer();
			addFlute();
			layoutContainer.getChildren().addAll(flutePane, addButton);
			break;
		}

	}
	
private void addGuitar() {
	addButton.setOnAction(e ->{
				String brand = guitarPane.brandField.getText();
				int price = Integer.parseInt(guitarPane.priceField.getText());
				int numOfStrings = Integer.parseInt(guitarPane.numberOfStringsField.getText());
				String type = guitarPane.typesComboBox.getValue();
				addTo.add(new Guitar(brand, price, numOfStrings, type));
				close();
				});
}

private void addSaxophone() {
	addButton.setOnAction(e ->{
		String brand = saxsophonePane.brandField.getText();
		int price = Integer.parseInt(saxsophonePane.priceField.getText());
		addTo.add(new Saxophone(brand, price));
		close();
	});
}

private void addBass() {
	addButton.setOnAction(e ->{
		String brand = bassPane.brandField.getText();
		int price = Integer.parseInt(bassPane.priceField.getText());
		int numOfStrings = Integer.parseInt(bassPane.numberOfStringsField.getText());
		Boolean isFretless = bassPane.fretlessBox.isSelected();
		addTo.add(new Bass(brand, price, numOfStrings, isFretless));
		close();
	});
}

private void addFlute() {
	addButton.setOnAction(e ->{
		String brand = guitarPane.brandField.getText();
		int price = Integer.parseInt(guitarPane.priceField.getText());
		String material = flutePane.materialsComboBox.getValue();
		String fluteType = flutePane.typesComboBox.getValue();
		addTo.add(new Flute(brand, price, material, fluteType));
		close();
	});
}

	private void resetLayoutContainer() {
		layoutContainer.getChildren().clear();
		layoutContainer.getChildren().add(instrumentsComboBox);
	}
}

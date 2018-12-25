import java.io.IOException;
import java.io.RandomAccessFile;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class AddressBookJavaFx extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		AddressBookPane[] panes = initializeAddressBookPanes();
		Scene[] scenes = initializeScenes(panes);
		Stage[] stages = initializeAddressBookStages(scenes);
		showStages(stages);
	}

	private AddressBookPane[] initializeAddressBookPanes() {
		AddressBookPane[] panes = { AddressBookPane.getInstance(), AddressBookPane.getInstance(),
				(new AddressBookPrimary(new SimpleAddressBookPane())).convertToAddressBook() };
		return panes;
	}

	private void showStages(Stage[] stages) {
		for (int i = 0; i < stages.length; i++) {
			if (stages[i] != null) {
				stages[i].show();
			}
		}
	}

	private Stage[] initializeAddressBookStages(Scene[] scenes) {
		Stage[] stages = new Stage[scenes.length];
		for (int i = 0; i < stages.length; i++) {
			if (scenes[i] != null) {
				Stage newStage = new Stage();
				newStage.setTitle("AddressBook");
				newStage.setScene(scenes[i]);
				stages[i] = newStage;
			}
		}
		return stages;
	}

	private Scene[] initializeScenes(Pane[] panes) {
		Scene[] scenes = new Scene[panes.length];
		for (int i = 0; i < panes.length; i++) {
			if (panes[i] != null) {
				Scene newScene = new Scene(panes[i]);
				newScene.getStylesheets().add("styles.css");
				scenes[i] = newScene;
			}
		}
		return scenes;
	}

}

class AddressBookPane extends GridPane implements Singleton {
	private RandomAccessFile raf;
	public static int currentNumOfInstances = 0;
	public final static String TOO_MANY_INSTANCES_MASSAGE = "Singelton violation. Only 3 panes were created";
	// Text fields
	private TextField jtfName = new TextField();
	private TextField jtfStreet = new TextField();
	private TextField jtfCity = new TextField();
	private TextField jtfState = new TextField();
	private TextField jtfZip = new TextField();
	// Buttons
	private FlowPane jpButton = new FlowPane();
	private FirstButton jbtFirst;
	private NextButton jbtNext;
	private PreviousButton jbtPrevious;
	private LastButton jbtLast;
	public EventHandler<ActionEvent> ae = new EventHandler<ActionEvent>() {
		public void handle(ActionEvent arg0) {
			((Command) arg0.getSource()).Execute();
		}
	};

	public static AddressBookPane getInstance() {
		if (currentNumOfInstances < MAX_INSTANCES) {
			currentNumOfInstances++;
			return new AddressBookPane();
		} else {
			System.out.println(TOO_MANY_INSTANCES_MASSAGE);
			return null;
		}
	}

	private AddressBookPane() { // Open or create a random access file
		try {
			raf = new RandomAccessFile("address.dat", "rw");
		} catch (IOException ex) {
			System.out.print("Error: " + ex);
			System.exit(0);
		}
		jtfState.setAlignment(Pos.CENTER_LEFT);
		jtfState.setPrefWidth(25);
		jtfZip.setPrefWidth(60);
		jbtFirst = new FirstButton(this, raf);
		jbtNext = new NextButton(this, raf);
		jbtPrevious = new PreviousButton(this, raf);
		jbtLast = new LastButton(this, raf);
		Label state = new Label("State");
		Label zp = new Label("Zip");
		Label name = new Label("Name");
		Label street = new Label("Street");
		Label city = new Label("City");
		// Panel p1 for holding labels Name, Street, and City
		GridPane p1 = new GridPane();
		p1.add(name, 0, 0);
		p1.add(street, 0, 1);
		p1.add(city, 0, 2);
		p1.setAlignment(Pos.CENTER_LEFT);
		p1.setVgap(8);
		p1.setPadding(new Insets(0, 2, 0, 2));
		GridPane.setVgrow(name, Priority.ALWAYS);
		GridPane.setVgrow(street, Priority.ALWAYS);
		GridPane.setVgrow(city, Priority.ALWAYS);
		// City Row
		GridPane adP = new GridPane();
		adP.add(jtfCity, 0, 0);
		adP.add(state, 1, 0);
		adP.add(jtfState, 2, 0);
		adP.add(zp, 3, 0);
		adP.add(jtfZip, 4, 0);
		adP.setAlignment(Pos.CENTER_LEFT);
		GridPane.setHgrow(jtfCity, Priority.ALWAYS);
		GridPane.setVgrow(jtfCity, Priority.ALWAYS);
		GridPane.setVgrow(jtfState, Priority.ALWAYS);
		GridPane.setVgrow(jtfZip, Priority.ALWAYS);
		GridPane.setVgrow(state, Priority.ALWAYS);
		GridPane.setVgrow(zp, Priority.ALWAYS);
		// Panel p4 for holding jtfName, jtfStreet, and p3
		GridPane p4 = new GridPane();
		p4.add(jtfName, 0, 0);
		p4.add(jtfStreet, 0, 1);
		p4.add(adP, 0, 2);
		p4.setVgap(1);
		GridPane.setHgrow(jtfName, Priority.ALWAYS);
		GridPane.setHgrow(jtfStreet, Priority.ALWAYS);
		GridPane.setHgrow(adP, Priority.ALWAYS);
		GridPane.setVgrow(jtfName, Priority.ALWAYS);
		GridPane.setVgrow(jtfStreet, Priority.ALWAYS);
		GridPane.setVgrow(adP, Priority.ALWAYS);
		// Place p1 and p4 into jpAddress
		GridPane jpAddress = new GridPane();
		jpAddress.add(p1, 0, 0);
		jpAddress.add(p4, 1, 0);
		GridPane.setHgrow(p1, Priority.NEVER);
		GridPane.setHgrow(p4, Priority.ALWAYS);
		GridPane.setVgrow(p1, Priority.ALWAYS);
		GridPane.setVgrow(p4, Priority.ALWAYS);
		// Set the panel with line border
		jpAddress.setStyle("-fx-border-color: grey;" + " -fx-border-width: 1;" + " -fx-border-style: solid outside ;");
		// Add buttons to a panel
		jpButton.setHgap(5);
		jpButton.getChildren().addAll(jbtFirst, jbtNext, jbtPrevious, jbtLast);
		jpButton.setAlignment(Pos.CENTER);
		GridPane.setVgrow(jpButton, Priority.NEVER);
		GridPane.setVgrow(jpAddress, Priority.ALWAYS);
		GridPane.setHgrow(jpButton, Priority.ALWAYS);
		GridPane.setHgrow(jpAddress, Priority.ALWAYS);
		// Add jpAddress and jpButton to the stage
		this.setVgap(5);
		this.add(jpAddress, 0, 0);
		this.add(jpButton, 0, 1);
		jbtFirst.setOnAction(ae);
		jbtNext.setOnAction(ae);
		jbtPrevious.setOnAction(ae);
		jbtLast.setOnAction(ae);
		jbtFirst.Execute();
	}

	public void actionHandled(ActionEvent e) {
		((Command) e.getSource()).Execute();
	}

	public RandomAccessFile getRaf() {
		return this.raf;
	}

	public FlowPane getButtonsPane() {
		return this.jpButton;
	}

	public void cleanText() {
		jtfCity.setText("");
		jtfName.setText("");
		jtfState.setText("");
		jtfStreet.setText("");
	}

	public void SetName(String text) {
		jtfName.setText(text);
	}

	public void SetStreet(String text) {
		jtfStreet.setText(text);
	}

	public void SetCity(String text) {
		jtfCity.setText(text);
	}

	public void SetState(String text) {
		jtfState.setText(text);
	}

	public void SetZip(String text) {
		jtfZip.setText(text);
	}

	public String GetName() {
		return jtfName.getText();
	}

	public String GetStreet() {
		return jtfStreet.getText();
	}

	public String GetCity() {
		return jtfCity.getText();
	}

	public String GetState() {
		return jtfState.getText();
	}

	public String GetZip() {
		return jtfZip.getText();
	}
}

interface Command {
	public void Execute();
}

class CommandButton extends Button implements Command {
	public final static int NAME_SIZE = 32;
	public final static int STREET_SIZE = 32;
	public final static int CITY_SIZE = 20;
	public final static int STATE_SIZE = 2;
	public final static int ZIP_SIZE = 5;
	public final static int RECORD_SIZE = (NAME_SIZE + STREET_SIZE + CITY_SIZE + STATE_SIZE + ZIP_SIZE);
	protected AddressBookPane p;
	protected RandomAccessFile raf;
	public static CareTaker careTaker = new CareTaker();
	public static Originator originator = new Originator();
	public static int amountOfUndoClicksAvailable = 0;

	public CommandButton(AddressBookPane pane, RandomAccessFile r) {
		super();
		p = pane;
		raf = r;
	}

	public void Execute() {
	}

	/** Write a record at the end of the file */
	public void writeAddress() {
		try {
			raf.seek(raf.length());
			FixedLengthStringIO.writeFixedLengthString(p.GetName(), NAME_SIZE, raf);
			FixedLengthStringIO.writeFixedLengthString(p.GetStreet(), STREET_SIZE, raf);
			FixedLengthStringIO.writeFixedLengthString(p.GetCity(), CITY_SIZE, raf);
			FixedLengthStringIO.writeFixedLengthString(p.GetState(), STATE_SIZE, raf);
			FixedLengthStringIO.writeFixedLengthString(p.GetZip(), ZIP_SIZE, raf);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/** Read a record at the specified position */
	public void readAddress(long position) throws IOException {
		if (raf.length() > 0) {
			raf.seek(position);
			String name = FixedLengthStringIO.readFixedLengthString(NAME_SIZE, raf);
			String street = FixedLengthStringIO.readFixedLengthString(STREET_SIZE, raf);
			String city = FixedLengthStringIO.readFixedLengthString(CITY_SIZE, raf);
			String state = FixedLengthStringIO.readFixedLengthString(STATE_SIZE, raf);
			String zip = FixedLengthStringIO.readFixedLengthString(ZIP_SIZE, raf);
			p.SetName(name);
			p.SetStreet(street);
			p.SetCity(city);
			p.SetState(state);
			p.SetZip(zip);
		} else {
			emptyTextBoxes();
		}
	}

	public void emptyTextBoxesIfFileEmpty() {
		try {
			if (raf.length() <= 0) {
				emptyTextBoxes();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void emptyTextBoxes() {
		p.SetName("");
		p.SetStreet("");
		p.SetCity("");
		p.SetState("");
		p.SetZip("");
	}

	public void removeLastRecord() {
		try {
			if (raf.length() > 0) {
				raf.setLength(raf.length() - 2 * RECORD_SIZE);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String getLastRecord() {
		try {
			if (raf.length() > 0) {
				raf.seek(raf.length() - 2 * RECORD_SIZE);
				return FixedLengthStringIO.readFixedLengthString(RECORD_SIZE, raf);
			}
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void addAddressToOriginator() {
		saveOriginatorStateToCareTaker();
		setOriginatorStateToCurrendAddress();
	}

	public void setOriginatorStateToCurrendAddress() {
		String addressToAdd = getLastRecord();
		originator.setState(addressToAdd);
	}

	public void saveOriginatorStateToCareTaker() {
		if (!isOriginatorStateNull()) {
			careTaker.add(originator.saveStateToMemento());
		}
	}

	public boolean isOriginatorStateNull() {
		return originator.getState() == null;
	}

	public void writeOriginatorStateToFile() {
		if (!isOriginatorStateNull()) {
			try {
				raf.seek(raf.length());
				FixedLengthStringIO.writeFixedLengthString(originator.getState(), RECORD_SIZE, raf);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void updateOriginatorStateFromMementoStack() {
		Memento tempMemento = careTaker.get();
		originator.setState(tempMemento != null ? tempMemento.getState() : null);
	}
}

class AddButton extends CommandButton {
	public AddButton(AddressBookPane pane, RandomAccessFile r) {
		super(pane, r);
		this.setText("Add");
	}

	@Override
	public void Execute() {
		writeAddress();
		amountOfUndoClicksAvailable++;
		careTaker.emptyStack();
		originator.setState(null);
	}
}

class RedoButton extends CommandButton {
	public RedoButton(AddressBookPane pane, RandomAccessFile r) {
		super(pane, r);
		this.setText("Redo");
	}

	@Override
	public void Execute() {
		if (originator.getState() != null) {
			super.writeOriginatorStateToFile();
			super.updateOriginatorStateFromMementoStack();
			amountOfUndoClicksAvailable++;
		}
	}
}

class UndoButton extends CommandButton {
	public UndoButton(AddressBookPane pane, RandomAccessFile r) {
		super(pane, r);
		this.setText("Undo");
	}

	@Override
	public void Execute() {
		try {
			if (amountOfUndoClicksAvailable > 0) {
				super.addAddressToOriginator();
				super.removeLastRecord();
				amountOfUndoClicksAvailable--;
				readAddress(0);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}

class NextButton extends CommandButton {
	public NextButton(AddressBookPane pane, RandomAccessFile r) {
		super(pane, r);
		this.setText("Next");
	}

	@Override
	public void Execute() {
		try {
			long currentPosition = raf.getFilePointer();
			if (currentPosition < raf.length()) {
				readAddress(currentPosition);
			}
			emptyTextBoxesIfFileEmpty();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}

class PreviousButton extends CommandButton {
	public PreviousButton(AddressBookPane pane, RandomAccessFile r) {
		super(pane, r);
		this.setText("Previous");
	}

	@Override
	public void Execute() {
		try {
			long currentPosition = raf.getFilePointer();
			if (currentPosition - 2 * 2 * RECORD_SIZE >= 0) {
				readAddress(currentPosition - 2 * 2 * RECORD_SIZE);
			}
			emptyTextBoxesIfFileEmpty();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}

class LastButton extends CommandButton {
	public LastButton(AddressBookPane pane, RandomAccessFile r) {
		super(pane, r);
		this.setText("Last");
	}

	@Override
	public void Execute() {
		try {
			long lastPosition = raf.length();
			if (lastPosition > 0) {
				readAddress(lastPosition - 2 * RECORD_SIZE);
			}
			emptyTextBoxesIfFileEmpty();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}

class FirstButton extends CommandButton {
	public FirstButton(AddressBookPane pane, RandomAccessFile r) {
		super(pane, r);
		this.setText("First");
	}

	@Override
	public void Execute() {
		try {
			readAddress(0);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}

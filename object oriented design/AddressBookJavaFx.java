import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.TreeSet;

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
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class AddressBookJavaFx extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		AddressBookPane pane = new AddressBookPane();
		Scene scene = new Scene(pane);
		scene.getStylesheets().add("styles.css");
		primaryStage.setTitle("AddressBook");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setAlwaysOnTop(true);
	}
}

class AddressBookPane extends GridPane {
	private RandomAccessFile raf;
	// Text fields
	private TextField jtfName = new TextField();
	private TextField jtfStreet = new TextField();
	private TextField jtfCity = new TextField();
	private TextField jtfState = new TextField();
	private TextField jtfZip = new TextField();
	// Buttons
	private AddButton jbtAdd;
	private FirstButton jbtFirst;
	private NextButton jbtNext;
	private PreviousButton jbtPrevious;
	private LastButton jbtLast;
	private Sort1Button jbtSort1;
	private Sort2Button jbtSort2;
	private IterButton jbtIter;
	public EventHandler<ActionEvent> ae = new EventHandler<ActionEvent>() {
		public void handle(ActionEvent arg0) {
			((Command) arg0.getSource()).Execute();
		}
	};

	public AddressBookPane() { // Open or create a random access file
		try {
			raf = new RandomAccessFile("address.dat", "rw");
		} catch (IOException ex) {
			System.out.print("Error: " + ex);
			System.exit(0);
		}
		jtfState.setAlignment(Pos.CENTER_LEFT);
		jtfState.setPrefWidth(80);
		jtfZip.setPrefWidth(50);
		jbtAdd = new AddButton(this, raf);
		jbtFirst = new FirstButton(this, raf);
		jbtNext = new NextButton(this, raf);
		jbtPrevious = new PreviousButton(this, raf);
		jbtLast = new LastButton(this, raf);
		jbtSort1 = new Sort1Button(this, raf);
		jbtSort2 = new Sort2Button(this, raf);
		jbtIter = new IterButton(this, raf);
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
		adP.setHgap(10);
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
		FlowPane jpButton = new FlowPane();
		jpButton.setHgap(5);
		jpButton.getChildren().addAll(jbtAdd, jbtFirst, jbtNext, jbtPrevious, jbtLast, jbtSort1, jbtSort2, jbtIter);
		jpButton.setAlignment(Pos.CENTER);
		GridPane.setVgrow(jpButton, Priority.NEVER);
		GridPane.setVgrow(jpAddress, Priority.ALWAYS);
		GridPane.setHgrow(jpButton, Priority.ALWAYS);
		GridPane.setHgrow(jpAddress, Priority.ALWAYS);
		// Add jpAddress and jpButton to the stage
		this.setPrefWidth(500);
		this.setVgap(5);
		this.add(jpAddress, 0, 0);
		this.add(jpButton, 0, 1);
		jbtAdd.setOnAction(ae);
		jbtFirst.setOnAction(ae);
		jbtNext.setOnAction(ae);
		jbtPrevious.setOnAction(ae);
		jbtLast.setOnAction(ae);
		jbtSort1.setOnAction(ae);
		jbtSort2.setOnAction(ae);
		jbtIter.setOnAction(ae);
		jbtFirst.Execute();
	}

	public void actionHandled(ActionEvent e) {
		((Command) e.getSource()).Execute();
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
	public final static int STATE_SIZE = 10;
	public final static int ZIP_SIZE = 5;
	public final static int RECORD_SIZE = (NAME_SIZE + STREET_SIZE + CITY_SIZE + STATE_SIZE + ZIP_SIZE);
	public final static int RECORD_BYTES_SIZE = 2 * RECORD_SIZE;
	protected AddressBookPane p;
	protected RandomAccessFile raf;

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
	}

	public void sortByComperator(AddressBookComparator comparator) throws IOException {
		int i, j;
		int numberOfRecords = (int) (raf.length() / RECORD_BYTES_SIZE);
		for (i = 0; i < numberOfRecords - 1; i++) {
			for (j = 0; j < numberOfRecords - i - 1; j++) {
				if (comparator.compare(readRecordAtIndex(j), readRecordAtIndex(j + 1)) > 0) {
					swapRecords(j, j + 1);
				}
			}
		}
	}

	public void swapRecords(int index1, int index2) throws IOException {
		String temp = readRecordAtIndex(index1);
		writeRecordAtIndex(index1, readRecordAtIndex(index2));
		writeRecordAtIndex(index2, temp);
	}

	public String readRecordAtIndex(int index) throws IOException {
		long position = index * RECORD_BYTES_SIZE;
		raf.seek(position);
		return FixedLengthStringIO.readFixedLengthString(RECORD_SIZE, raf);
	}

	public void writeRecordAtIndex(int index, String recordToWrite) {
		try {
			long position = index * RECORD_BYTES_SIZE;
			raf.seek(position);
			FixedLengthStringIO.writeFixedLengthString(recordToWrite, RECORD_SIZE, raf);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public ListIterator<String> iterator() {
		return new FileIterator();
	}

	private class FileIterator implements ListIterator<String> {

		int currentIndex = 0;
		int lastIndex = 0;

		public FileIterator() {
			this(0);
		}

		public FileIterator(int beginingIndex) {
			this.currentIndex = beginingIndex;
			this.lastIndex = beginingIndex;
		}

		private long indexToPosition(int index) {
			return index * RECORD_BYTES_SIZE;
		}

		@Override
		public void add(String recordToWrite) {
			try {
				String temp = copyRestOfFileFromIndex(currentIndex);
				writeRecordAtIndex(currentIndex, recordToWrite);
				currentIndex++;
				lastIndex = currentIndex;
				pasteRestOfFileAtIndex(currentIndex, temp);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		private void pasteRestOfFileAtIndex(int index, String restOfFile) throws IOException {
			long position = indexToPosition(index);
			int restSize = (int) ((raf.length() - position) / 2);
			raf.seek(position);
			FixedLengthStringIO.writeFixedLengthString(restOfFile, restSize, raf);

		}

		private String copyRestOfFileFromIndex(int index) throws IOException {
			long position = indexToPosition(index);
			int restSize;
			restSize = (int) ((raf.length() - position) / 2);
			raf.seek(position);
			return FixedLengthStringIO.readFixedLengthString(restSize, raf);
		}

		@Override
		public boolean hasNext() {
			try {
				return (indexToPosition(currentIndex) < raf.length());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return false;
		}

		@Override
		public boolean hasPrevious() {
			return currentIndex > 0;
		}

		@Override
		public String next() {
			if (this.hasNext()) {
				try {
					lastIndex = currentIndex;
					currentIndex = nextIndex();
					return readRecordAtIndex(previousIndex());
				} catch (IOException e) {
					currentIndex = previousIndex();
					e.printStackTrace();
				}
			}
			return null;
		}

		@Override
		public int nextIndex() {
			if (!this.hasNext()) {
				try {
					return ((int) raf.length());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return currentIndex + 1;
		}

		@Override
		public String previous() {
			if (this.hasPrevious()) {
				try {
					lastIndex = currentIndex;
					currentIndex = previousIndex();
					return readRecordAtIndex(currentIndex);
				} catch (IOException e) {
					currentIndex = nextIndex();
					e.printStackTrace();
				}
			}
			return null;
		}

		@Override
		public int previousIndex() {
			if (this.hasPrevious()) {
				return currentIndex - 1;
			}
			return -1;
		}

		@Override
		public void remove() {
			if (hasPrevious()) {
				try {
					
					int removeIndex = maxIndex();
					String temp = copyRestOfFileFromIndex(removeIndex);
					lastIndex = currentIndex;
					pasteRestOfFileAtIndex(currentIndex, temp);
					raf.setLength(raf.length() - RECORD_BYTES_SIZE);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		private int maxIndex() {
			return currentIndex < lastIndex ? currentIndex : lastIndex;
		}

		private boolean isNextOrPreviousHasBeenCalled() {
			return currentIndex != lastIndex;
		}

		@Override
		public void set(String arg0) {
			if (isNextOrPreviousHasBeenCalled()) {
				writeRecordAtIndex(maxIndex(), arg0);
				lastIndex = currentIndex;
			}
		}

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
			if (currentPosition < raf.length())
				readAddress(currentPosition);
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
			if (currentPosition - 2 * 2 * RECORD_SIZE >= 0)
				readAddress(currentPosition - 2 * 2 * RECORD_SIZE);
			else
				;
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
			if (lastPosition > 0)
				readAddress(lastPosition - 2 * RECORD_SIZE);
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
			if (raf.length() > 0)
				readAddress(0);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}

class Sort1Button extends CommandButton {
	public Sort1Button(AddressBookPane pane, RandomAccessFile r) {
		super(pane, r);
		this.setText("Sort1");
	}

	@Override
	public void Execute() {
		try {
			if (raf.length() > 0)
				sortByComperator(new NameComparator());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}

class Sort2Button extends CommandButton {
	public Sort2Button(AddressBookPane pane, RandomAccessFile r) {
		super(pane, r);
		this.setText("Sort2");
	}

	@Override
	public void Execute() {
		try {
			if (raf.length() > 0)
				sortByComperator(new ZipComparator());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}

class IterButton extends CommandButton {
	private ListIterator<String> lit = this.iterator();
	private LinkedHashMap<String, String> addressMap = new LinkedHashMap<String, String>();
	private TreeSet<String> addressTree = new TreeSet<String>(new StreetComparator());

	public IterButton(AddressBookPane pane, RandomAccessFile r) {
		super(pane, r);
		this.setText("Iter");
	}

	@Override
	public void Execute() {
		if (addressMap.isEmpty()) {
			fillAddressMap();
			writeAddressMapToFile();
		} else {
			fillAddressTree();
			writeAddressTreeToFile();
		}
	}

	private void emptyFileWithIterator() {
		while (lit.hasNext()) {
			lit.next();
			lit.remove();
		}
		while (lit.hasPrevious()) {
			lit.previous();
			lit.remove();
		}
	}

	private void writeAddressMapToFile() {
		emptyFileWithIterator();
		Iterator<Entry<String, String>> addressMapIterator = addressMap.entrySet().iterator();
		Entry<String, String> entry;
		while (addressMapIterator.hasNext()) {
			entry = addressMapIterator.next();
			lit.add(entry.getKey() + entry.getValue());
			lit.next();
		}
	}

	private void fillAddressMap() {
		while (lit.hasNext()) {
			String fullRecord = lit.next();
			String key = fullRecord.substring(0, RECORD_SIZE - ZIP_SIZE);
			String value = fullRecord.substring(RECORD_SIZE - ZIP_SIZE, RECORD_SIZE);
			addressMap.put(key, value);
		}
	}

	private void fillAddressTree() {
		Iterator<Entry<String, String>> addressMapIterator = addressMap.entrySet().iterator();
		Entry<String, String> entry;
		while (addressMapIterator.hasNext()) {
			entry = addressMapIterator.next();
			addressTree.add(entry.getKey() + entry.getValue());
		}
	}

	private void writeAddressTreeToFile() {
		emptyFileWithIterator();
		Iterator<String> addressTreeIterator = addressTree.iterator();
		while (addressTreeIterator.hasNext()) {
			String entry = addressTreeIterator.next();
			lit.add(entry);
		}
	}
}

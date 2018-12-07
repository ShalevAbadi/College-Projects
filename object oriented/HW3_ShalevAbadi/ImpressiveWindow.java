import java.util.ArrayList;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.value.ObservableNumberValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

public class ImpressiveWindow extends BorderPane {
	public final static int IMPRESSIVE_WINDOW_PADDING = 10;
	public static final int IMPRESSIVE_WINDOW_WIDTH = 600;
	public final static int IMPRESSIC_WINDOW_HEIGHT = 300;
	private ArrayList<MusicalInstrument> instrumentsSearchResault = new ArrayList<MusicalInstrument>();
	private ArrayList<MusicalInstrument> allInstruments = new ArrayList<MusicalInstrument>();
	private int instrumentIndex = 0;
	private SearchPanel searchPanel = new SearchPanel();
	private Navigation navigation = new Navigation();
	private MidSection midSection = new MidSection();
	private Commercial commercial = new Commercial(IMPRESSIVE_WINDOW_WIDTH);
	
	public ImpressiveWindow(ArrayList<MusicalInstrument> instruments) {
		allInstruments.addAll(instruments);
		instrumentsSearchResault.addAll(allInstruments);
		setPrefSize(IMPRESSIVE_WINDOW_WIDTH, IMPRESSIC_WINDOW_HEIGHT);
		setPadding(new Insets(IMPRESSIVE_WINDOW_PADDING));
		setPositions();
		setChildrenAlignments();
		initializeImpressiveWindowActions();
		showCurrentInstrument();
		widthProperty().addListener(e -> {
			commercial = new Commercial(getWidth());
			setBottom(commercial);
		});
	}

	private void setChildrenAlignments() {
		searchPanel.setAlignment(Pos.TOP_CENTER);
		midSection.setAlignment(Pos.CENTER);
		setAlignment(navigation.getPrevious(), Pos.CENTER);
		setAlignment(navigation.getNext(), Pos.CENTER);
	}

	private void setPositions() {
		setTop(searchPanel);
		setLeft(navigation.getPrevious());
		setRight(navigation.getNext());
		setBottom(commercial);
		setCenter(midSection);
	}

	private void initializeImpressiveWindowActions() {
		initializeDeleteAction();
		initializeClearAction();
		initializeAddAction();
		initializeSearchPanelActions();
		initializeNextButtonAction();
		initializePreviousButtonAction();
	}

	public void showCurrentInstrument() {
		if (instrumentsSearchResault.isEmpty()) {
			midSection.showNoItems();
		} else {
			midSection.showInstrument(instrumentsSearchResault.get(instrumentIndex));
		}
	}

	private void initializePreviousButtonAction() {
		navigation.getPrevious().setOnAction(e -> {
			setIndexToPrevious();
			showCurrentInstrument();
		});
	}

	public void setIndexToPrevious() {
		if (instrumentIndex <= 0) {
			instrumentIndex = (instrumentsSearchResault.size() - 1);
		} else {
			instrumentIndex--;
		}
	}

	private void initializeNextButtonAction() {
		navigation.getNext().setOnAction(e -> {
			setIndexToNext();
			showCurrentInstrument();
		});
	}

	public void setIndexToNext() {
		if (instrumentIndex >= (instrumentsSearchResault.size() - 1)) {
			instrumentIndex = 0;
		} else {
			instrumentIndex++;
		}
	}

	public void initializeClearAction() {
		midSection.getButtons().getClearButton().setOnAction(e -> {
			allInstruments.removeAll(allInstruments);
			instrumentsSearchResault.removeAll(instrumentsSearchResault);
			instrumentIndex = 0;
			showCurrentInstrument();
		});
	}

	public void initializeAddAction() {
		midSection.getButtons().getAddButton().setOnAction(e -> {
			addInstrumentWindowFlow();
		});

		addEventFilter(KeyEvent.KEY_PRESSED, e -> {
			if (e.getCode() == KeyCode.A) {
				if (!searchPanel.getSearchTextField().isFocused()) {
					addInstrumentWindowFlow();
				}
			}
		});
	}

	public void addInstrumentWindowFlow() {
		AddNewInstrument addStage = new AddNewInstrument();
		addStage.show();
		addStage.getAddButton().setOnAction(n -> {
			addInstrumentToList(addStage);
			showLastAddedInstrument();
			addStage.close();
		});
	}

	public void addInstrumentToList(AddNewInstrument addStage) {
		try {
			MusicalInstrument new1 = addStage.getAddInstrumentPane().getInstrumentToAdd();
			allInstruments.add(new1);
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Error");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	private void showLastAddedInstrument() {
		if (allInstruments.size() > 0) {
			midSection.showInstrument(allInstruments.get(allInstruments.size() - 1));
		}
	}

	public void initializeDeleteAction() {
		midSection.getButtons().getDeleteButton().setOnAction(e -> {
			deleteInstrument();
		});

		addEventFilter(KeyEvent.KEY_PRESSED, e -> {
			if (e.getCode() == KeyCode.DELETE) {
				if (!searchPanel.getSearchTextField().isFocused()) {
					deleteInstrument();
				}
			}
		});
	}

	public void deleteInstrument() {
		if (!instrumentsSearchResault.isEmpty()) {
			allInstruments.remove(instrumentsSearchResault.get(instrumentIndex));
			instrumentsSearchResault.remove(instrumentIndex);
			if (instrumentIndex == (instrumentsSearchResault.size()) && !instrumentsSearchResault.isEmpty()) {
				instrumentIndex--;
			}
			showCurrentInstrument();
		}
	}

	private void initializeSearchPanelActions() {
		initializeGoEvent();
		initializeEnterEvent();
	}

	private void initializeEnterEvent() {
		addEventFilter(KeyEvent.KEY_PRESSED, e -> {
			if (e.getCode() == KeyCode.ENTER) {
				searchEvent();
			}
		});
	}

	private void initializeGoEvent() {
		searchPanel.getGoButton().setOnAction(s -> {
			searchEvent();
		});
	}

	private void searchEvent() {
		searchHandle(searchPanel.getSearchTextField());
		showCurrentInstrument();
	}

	private void searchHandle(TextField searchTextField) {
		instrumentIndex = 0;
		String searchText = searchTextField.getText();
		instrumentsSearchResault.removeAll(instrumentsSearchResault);
		if (searchText == null) {
			instrumentsSearchResault.addAll(allInstruments);
		}

		else {
			searchInAllInstruments(searchText);
		}
	}

	public void searchInAllInstruments(String searchText) {
		for (int i = 0; i < allInstruments.size(); i++) {
			if (allInstruments.get(i).toString().toUpperCase().contains(searchText.toUpperCase())) {
				instrumentsSearchResault.add(allInstruments.get(i));
			}
		}
	}
	
	
}
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;

public class ImpressiveWindow extends BorderPane {
	private ArrayList<MusicalInstrument> instrumentsSearchResault = new ArrayList<MusicalInstrument>();
	ArrayList<MusicalInstrument> allInstruments = new ArrayList<MusicalInstrument>();
	private int instrumentIndex = 0;
	SearchPanel searchPanel = new SearchPanel();
	Navigation navigation = new Navigation();
	MidSection midSection = new MidSection();
	Commercial commercial = new Commercial();

	public ImpressiveWindow(ArrayList<MusicalInstrument> instruments) {
		allInstruments.addAll(instruments);
		instrumentsSearchResault.addAll(allInstruments);
		setPrefSize(600, 225);
		setPadding(new Insets(10, 10, 10, 10));
		setPositions();
		setChildrenAlignments();
		initializeImpressiveWindowActions();
		showCurrentInstrument();
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

	private void initializeSearchPanelActions() {
		goEvent();
		enterEvent();
	}

	private void enterEvent() {
		addEventFilter(KeyEvent.KEY_PRESSED, e -> {
			if (e.getCode() == KeyCode.ENTER) {
				searchEvent();
			}
		});
	}

	private void goEvent() {
		searchPanel.getGoButton().setOnAction(e -> {
			searchEvent();
		});
	}

	private void searchEvent() {
		searchHandle(searchPanel.getSearchTextField());
		searchPanel.getSearchTextField().setText(null);
		showCurrentInstrument();
	}

	private void searchHandle(TextField searchTextField) {
		instrumentIndex = 0;
		String searchText = searchTextField.getText();
		if (searchText == null) {
			instrumentsSearchResault.removeAll(instrumentsSearchResault);
			instrumentsSearchResault.addAll(allInstruments);
		}

		else if (!instrumentsSearchResault.isEmpty()) {
			instrumentsSearchResault.removeAll(instrumentsSearchResault);
			searchInAllInstruments(searchText);
		}
		else if (instrumentsSearchResault.isEmpty()) {
			instrumentsSearchResault.addAll(allInstruments);
		}
	}

	public void searchInAllInstruments(String searchText) {
		for (int i = 0; i < allInstruments.size(); i++) {
			if (allInstruments.get(i).toString().toUpperCase().contains(searchText.toUpperCase())) {
				instrumentsSearchResault.add(allInstruments.get(i));
			}
		}
	}

	private void initializeImpressiveWindowActions() {
		initializeDeleteAction();
		initializeClearAction();
		initializeAddAction();
		initializeSearchPanelActions();
		initializeNextButtonAction();
		initializePreviousButtonAction();
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
			addInstrument();
		});

		addEventFilter(KeyEvent.KEY_PRESSED, e -> {
			if (e.getCode() == KeyCode.A) {
				addInstrument();
			}
		});
	}

	public void addInstrument() {
		AddNewInstrument addStage = new AddNewInstrument();
		addStage.show();
		addStage.getAddButton().setOnAction(n -> {
			MusicalInstrument new1 = addStage.getAddInstrumentPane().getInstrumentToAdd();
			allInstruments.add(new1);
			showLastAddedInstrument();
			addStage.close();
		});
	}

	private void showLastAddedInstrument() {
		midSection.showInstrument(allInstruments.get(allInstruments.size() - 1));
	}

	public void initializeDeleteAction() {
		midSection.getButtons().getDeleteButton().setOnAction(e -> {
			deleteInstrument();
		});

		addEventFilter(KeyEvent.KEY_PRESSED, e -> {
			if (e.getCode() == KeyCode.DELETE) {
				deleteInstrument();
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

	private void setChildrenAlignments() {
		searchPanel.setAlignment(Pos.TOP_CENTER);
		midSection.setAlignment(Pos.CENTER);
		setAlignment(navigation.getPrevious(), Pos.CENTER);
		setAlignment(navigation.getNext(), Pos.CENTER);
	}

	private void setPositions() {
		setTop(searchPanel);
		setCenter(midSection);
		setLeft(navigation.getPrevious());
		setRight(navigation.getNext());
		setBottom(commercial);
	}

}

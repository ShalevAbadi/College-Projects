import java.util.ArrayList;
import java.util.Calendar;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class ImpressiveWindow extends BorderPane {
	private ArrayList<MusicalInstrument> instrumentsSearchResault = new ArrayList<MusicalInstrument>();
	private ArrayList<MusicalInstrument> allInstruments = new ArrayList<MusicalInstrument>();
	private int instrumentIndex = 0;
	SearchPanel searchPanel = new SearchPanel();
	Navigation navigation = new Navigation();
	MyButtons add = new MyButtons("Add", 50, 50);
	MyButtons delete = new MyButtons("Delete", 50, 50);
	MyButtons clear = new MyButtons("Clear", 50, 50);
	InstrumentVals instrumentVals = new InstrumentVals();
	Commercial commercial = new Commercial();

	private class Navigation {
		private MyButtons previous = new MyButtons("<", 50, 50);
		private MyButtons next = new MyButtons(">", 50, 50);

		public Navigation() {
			previousHandle();
			nextHandle();
		}

		public MyButtons getPrevious() {
			return previous;
		}

		public MyButtons getNext() {
			return next;
		}

		private void previousHandle() {
			previous.setOnAction(e -> {
				if (instrumentIndex <= 0) {
					instrumentIndex = (instrumentsSearchResault.size() - 1);
				} else {
					instrumentIndex--;
				}
				instrumentVals.showInstrument();
			});
		}

		private void nextHandle() {
			next.setOnAction(e -> {
				if (instrumentIndex >= (instrumentsSearchResault.size()-1)) {
					instrumentIndex = 0;
				} else {
					instrumentIndex++;
				}
				instrumentVals.showInstrument();
			});
		}

	}

	private class SearchPanel extends HBox {
		TextField search = new TextField("search...");
		Button go = new Button("Go!");

		private SearchPanel() {
			setSpacing(5);
			search.setPromptText("search...");
			search.setMinWidth(550);
			go.setMinWidth(35);
			getChildren().addAll(search, go);
			searchPanelEvents();
		}

		private void searchPanelEvents() {
			goEvent();
			enterEvent();
		}

		private void enterEvent() {
			search.setOnKeyPressed(e -> {
				if (e.getCode() == KeyCode.ENTER) {
					searchInstruments(search);
					search.setText(null);
					instrumentVals.showInstrument();
				}
			});
		}

		private void goEvent() {
			go.setOnAction(e -> {
				searchInstruments(search);
				search.setText(null);
				instrumentVals.showInstrument();
			});
		}
	}

	private void searchInstruments(TextField searchTextField) {
		String searchText = searchTextField.getText();
		System.out.println(searchText);
		if (!instrumentsSearchResault.isEmpty()) {
			instrumentsSearchResault.removeAll(instrumentsSearchResault);
		}
		for (int i = 0; i < allInstruments.size(); i++) {
			if (allInstruments.get(i).toString().toUpperCase().contains(searchText.toUpperCase())) {
				instrumentsSearchResault.add(allInstruments.get(i));
			}
		}
		if (instrumentsSearchResault.isEmpty()) {
			instrumentsSearchResault.addAll(allInstruments);
		}
	}

	private class TextAndTextField extends HBox {
		TextField textField = new TextField();

		private TextAndTextField(String textStr, int spacing) {
			Text text = new Text(textStr);
			setSpacing(spacing);
			text.minWidth(200);
			textField.setMinWidth(300);
			textField.setEditable(false);
			getChildren().addAll(text, textField);
			setAlignment(Pos.CENTER);
		}

		public TextField getTextField() {
			return textField;
		}
	}

	private class MyButtons extends Button {
		private MyButtons(String str, int width, int height) {
			super(str);
			setWidth(width);
			setHeight(height);
		}
	}

	private class Commercial extends Text {

		private Commercial() {
			Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
				setTextContent();
			}), new KeyFrame(Duration.seconds(1)));
			setClockAndPlay(clock);
			Timeline timeline = setTextMovement();
			setTextApearance();
			setOnMouseMoved(e->{
				timeline.pause();
			});
			setOnMouseExited(e->{
				timeline.play();
			});
		}

		public void setClockAndPlay(Timeline clock) {
			clock.setCycleCount(Animation.INDEFINITE);
			clock.play();
		}

		public void setTextApearance() {
			setFill(Color.RED);
			setFont(Font.font("Arial", FontWeight.BOLD, 10));
		}

		public Timeline setTextMovement() {
			Duration startDuration = Duration.ZERO;
			Duration endDuration = Duration.seconds(10);
			KeyValue startKeyValue = new KeyValue(this.translateXProperty(), -600);
			KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);
			KeyValue endKeyValue = new KeyValue(this.translateXProperty(), 600);
			KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);
			Timeline timeline = new Timeline(startKeyFrame, endKeyFrame);
			timeline.setCycleCount(Timeline.INDEFINITE);
			timeline.setAutoReverse(true);
			timeline.play();
			return timeline;
		}

		public void setTextContent() {
			Calendar cal = Calendar.getInstance();
			int second = cal.get(Calendar.SECOND);
			int minute = cal.get(Calendar.MINUTE);
			int hour = cal.get(Calendar.HOUR);
			int mounth = cal.get(Calendar.MONTH);
			int day = cal.get(Calendar.DAY_OF_MONTH);
			int year = cal.get(Calendar.YEAR);
			setText(year + "-" + mounth + "-" + day + "  " + hour + ":" + (minute) + ":" + second
					+ "Afeka Instruments Music Store $$$ ON SALE!!! $$$ Guitars, Basses, Flutes, Saxophones and more!");
		}
	}

	private class InstrumentVals extends VBox {
		TextAndTextField typeLine = new TextAndTextField("Type:", 15);
		TextAndTextField brandLine = new TextAndTextField("Brand:", 10);
		TextAndTextField priceLine = new TextAndTextField("Price:", 15);

		private InstrumentVals() {
			setSpacing(10);
			minWidth(300);
			HBox buttons = creatInstrumentValsButtons();
			getChildren().addAll(typeLine, brandLine, priceLine, buttons);
			showInstrument();
		}

		private void showNoItems() {
			String noItems = "No Items";
			brandLine.getTextField().setText(noItems);
			typeLine.getTextField().setText(noItems);
			priceLine.getTextField().setText(noItems);
		}

		private void showInstrument() {
			if (!instrumentsSearchResault.isEmpty()) {
				typeLine.getTextField().setText(
						instrumentsSearchResault.get(instrumentIndex).getClass().getCanonicalName().toString());
				brandLine.getTextField().setText(instrumentsSearchResault.get(instrumentIndex).getBrand());
				priceLine.getTextField().setText(instrumentsSearchResault.get(instrumentIndex).getPrice().toString());
			} else {
				showNoItems();
			}
		}

		public HBox creatInstrumentValsButtons() {
			HBox buttons = new HBox(10);
			buttons.minWidth(300);
			buttons.getChildren().addAll(add, delete, clear);
			buttons.setAlignment(Pos.CENTER);
			delete.setOnAction(e -> {
				if (!instrumentsSearchResault.isEmpty()) {
					allInstruments.remove(instrumentsSearchResault.get(instrumentIndex));
					instrumentsSearchResault.remove(instrumentIndex);
					if (instrumentIndex == (instrumentsSearchResault.size()) && !instrumentsSearchResault.isEmpty()) {
						instrumentIndex--;
					}
					showInstrument();
				}
			});

			clear.setOnAction(e -> {
				allInstruments.removeAll(allInstruments);
				instrumentsSearchResault.removeAll(instrumentsSearchResault);
				instrumentIndex = 0;
				showInstrument();
			});
			return buttons;

		}
	}

	public ImpressiveWindow(ArrayList<MusicalInstrument> instruments) {
		allInstruments.addAll(instruments);
		instrumentsSearchResault.addAll(allInstruments);
		instrumentVals.showInstrument();
		setPrefSize(600, 225);
		setPadding(new Insets(10, 10, 10, 10));
		setPositions();
		setChildrenAlignments();

	}

	private void setChildrenAlignments() {
		searchPanel.setAlignment(Pos.TOP_CENTER);
		instrumentVals.setAlignment(Pos.CENTER);
		setAlignment(navigation.getPrevious(), Pos.CENTER);
		setAlignment(navigation.getNext(), Pos.CENTER);
	}

	private void setPositions() {
		setTop(searchPanel);
		setCenter(instrumentVals);
		setLeft(navigation.getPrevious());
		setRight(navigation.getNext());
		setBottom(commercial);
	}

}

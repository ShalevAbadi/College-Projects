import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class SearchPanel extends HBox {
	public final static int SEARCH_PANEL_PADDING = 10;
	public final static int SEARCH_PANEL_SPACING = 5;
	private TextField search = new TextField("search...");
	private Button go = new Button("Go!");

	public SearchPanel() {
		setSpacing(SEARCH_PANEL_SPACING);
		setPadding(new Insets(SEARCH_PANEL_PADDING));
		search.setPromptText("search...");
		getChildren().addAll(search, go);
		HBox.setHgrow(search, Priority.ALWAYS);
	}

	public TextField getSearchTextField() {
		return search;
	}

	public Button getGoButton() {
		return go;
	}
}
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class SearchPanel extends HBox {
	TextField search = new TextField("search...");
	Button go = new Button("Go!");

	public SearchPanel() {
		setSpacing(5);
		search.setPromptText("search...");
		search.setMinWidth(550);
		go.setMinWidth(35);
		setPadding(new Insets(10));
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
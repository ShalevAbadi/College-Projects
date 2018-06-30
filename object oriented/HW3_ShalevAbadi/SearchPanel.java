import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class SearchPanel extends HBox {
	TextField search = new TextField("search...");
	MyButtons go = new MyButtons("Go!" , 10, 10);

	public SearchPanel() {
		setSpacing(5);
		search.setPromptText("search...");
		search.setMinWidth(550);
		go.setMinWidth(35);
		getChildren().addAll(search, go);
	}
	
	public TextField getSearchTextField() {
		return search;
	}
	
	public MyButtons getGoButton() {
		return go;
	}
}
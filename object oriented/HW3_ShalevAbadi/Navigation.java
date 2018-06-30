import javafx.geometry.Insets;
import javafx.scene.control.Button;

public class Navigation {
	private Button previous = new Button("<");
	private Button next = new Button(">");

	public Navigation() {
		previous.setPadding(new Insets(7));
		next.setPadding(new Insets(7));
	}

	public Button getPrevious() {
		return previous;
	}

	public Button getNext() {
		return next;
	}
}
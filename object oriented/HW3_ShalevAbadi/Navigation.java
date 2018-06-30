import javafx.scene.control.Button;

public class Navigation {
	private Button previous = new Button("<");
	private Button next = new Button(">");

	public Button getPrevious() {
		return previous;
	}

	public Button getNext() {
		return next;
	}
}
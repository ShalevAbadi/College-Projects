import javafx.geometry.Insets;
import javafx.scene.control.Button;

public class Navigation {
	public final static int NAVIGATION_BUTTON_PADDING = 7;
	private Button previous = new Button("<");
	private Button next = new Button(">");

	public Navigation() {
		previous.setPadding(new Insets(NAVIGATION_BUTTON_PADDING));
		next.setPadding(new Insets(NAVIGATION_BUTTON_PADDING));
	}

	public Button getPrevious() {
		return previous;
	}

	public Button getNext() {
		return next;
	}
}
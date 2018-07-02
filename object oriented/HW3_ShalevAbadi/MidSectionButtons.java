import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class MidSectionButtons extends HBox {
	public final static int MID_SEC_BUTTONS_SPACING = 20;
	public final static int MID_SECTION_BUTTONS_PADDING = 10;
	public final static int MID_SECTION_BUTTONS_MIN_WIDTH = 300;
	public final static int BUTTON_PDDING = 5;
	private Button add = new Button("Add");
	private Button delete = new Button("Delete");
	private Button clear = new Button("Clear");

	public MidSectionButtons() {
		super(MID_SEC_BUTTONS_SPACING);
		minWidth(MID_SECTION_BUTTONS_MIN_WIDTH);
		setPadding(new Insets(MID_SECTION_BUTTONS_PADDING));
		setButtonsPadding();
		getChildren().addAll(add, delete, clear);
		setAlignment(Pos.CENTER);
	}

	public void setButtonsPadding() {
		add.setPadding(new Insets(BUTTON_PDDING));
		delete.setPadding(new Insets(BUTTON_PDDING));
		clear.setPadding(new Insets(BUTTON_PDDING));
	}

	public Button getAddButton() {
		return add;
	}

	public Button getDeleteButton() {
		return delete;
	}

	public Button getClearButton() {
		return clear;
	}
}

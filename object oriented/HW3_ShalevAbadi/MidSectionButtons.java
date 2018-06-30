import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class MidSectionButtons extends HBox {
	Button add = new Button("Add");
	Button delete = new Button("Delete");
	Button clear = new Button("Clear");

	public MidSectionButtons() {
		super(20);
		minWidth(300);
		setPadding(new Insets(10));
		setButtonsPadding();
		getChildren().addAll(add, delete, clear);
		setAlignment(Pos.CENTER);
	}

	public void setButtonsPadding() {
		add.setPadding(new Insets(5));
		delete.setPadding(new Insets(5));
		clear.setPadding(new Insets(5));
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

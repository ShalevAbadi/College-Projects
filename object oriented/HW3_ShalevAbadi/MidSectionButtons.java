import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class MidSectionButtons extends HBox {
	MyButtons add = new MyButtons("Add", 50, 50);
	MyButtons delete = new MyButtons("Delete", 50, 50);
	MyButtons clear = new MyButtons("Clear", 50, 50);

	public MidSectionButtons() {
		super(10);
		minWidth(300);
		getChildren().addAll(add, delete, clear);
		setAlignment(Pos.CENTER);
	}
	
	public MyButtons getAddButton(){
		return add;
	}
	
	public MyButtons getDeleteButton(){
		return delete;
	}
	
	public MyButtons getClearButton(){
		return clear;
	}
}

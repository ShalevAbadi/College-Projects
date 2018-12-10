import javafx.stage.Stage;

public class AddressBookStage extends Stage implements Singleton {

	private static int CURRENT_STAGES = 0;
	
	public static AddressBookStage getInstace() {
		if (CURRENT_STAGES < MAX_STAGES) {
			CURRENT_STAGES++;
			return new AddressBookStage();
		}
		throw new UnsupportedOperationException("Singelton violation. Only 3 panes were created");
	}

}

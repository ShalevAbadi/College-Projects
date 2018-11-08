import javafx.scene.layout.VBox;

public class MidSection extends VBox {
	private final String NO_ITEMS = "No Items";
	private InstrumentProperties instrumentProperties = new InstrumentProperties();
	private MidSectionButtons buttons = new MidSectionButtons();

	public MidSection() {
		getChildren().addAll(instrumentProperties, buttons);
		buttons.getAddButton().requestFocus();
	}

	public MidSectionButtons getButtons() {
		return buttons;
	}

	public void showNoItems() {
		instrumentProperties.setTypeFieldText(NO_ITEMS);
		instrumentProperties.setBrandFieldText(NO_ITEMS);
		instrumentProperties.setPriceFieldText(NO_ITEMS);
	}

	public void showInstrument(MusicalInstrument instrumentToShow) {
		instrumentProperties.setTypeFieldText(instrumentToShow.getClass().getCanonicalName().toString());
		instrumentProperties.setBrandFieldText(instrumentToShow.getBrand());
		instrumentProperties.setPriceFieldText(instrumentToShow.getPrice().toString());
	}
}
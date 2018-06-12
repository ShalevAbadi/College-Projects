import java.io.File;
import java.util.ArrayList;
import java.util.Optional;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

public class HW3_ShalevAbadi extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		//File file = getFileFromUser();
		//ArrayList<MusicalInstrument> instruments = new ArrayList<MusicalInstrument>();
        //AfekaInstruments.loadInstrumentsFromFile(file, instruments);
		//ImpressiveWindow window = new ImpressiveWindow(instruments);
		//Scene scene = new Scene(window);
		AddGuitarPane pane = new AddGuitarPane();
		Scene scene = new Scene(pane);
		
		//primaryStage.setScene(scene);
		primaryStage = new AddNewInstrument();
		primaryStage.show();
	}

	private File getFileFromUser() {
		boolean continues = true;
		File file = null;
		do {
			TextInputDialog textInput = createAndShowFileTextInput();
			Optional<String> result = textInput.showAndWait();
			if (result.isPresent()) {
				file = new File(result.get());
				continues = !(file.canRead());
				if (continues) {
					showFileErrorAlert();
				}
			} else {
				System.exit(0);
			}
		} while (continues);
		return file;
	}

	public TextInputDialog createAndShowFileTextInput() {
		TextInputDialog textInput = new TextInputDialog();
		textInput.setTitle("confirmation");
		textInput.setHeaderText("Load Instruments From File");
		textInput.setContentText("Plaese enter file name:");
		return textInput;
	}

	public void showFileErrorAlert() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText("File Error!");
		alert.setContentText("Cannot read from file, please try again");
		alert.showAndWait();
	}
}
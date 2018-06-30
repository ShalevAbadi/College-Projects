import java.util.Calendar;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Commercial extends Text {

	public Commercial() {
		Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
			setTextContent();
		}), new KeyFrame(Duration.seconds(1)));
		setClockAndPlay(clock);
		Timeline timeline = setTextMovement();
		setTextApearance();
		setOnMouseMoved(e -> {
			timeline.pause();
		});
		setOnMouseExited(e -> {
			timeline.play();
		});
	}

	public void setClockAndPlay(Timeline clock) {
		clock.setCycleCount(Animation.INDEFINITE);
		clock.play();
	}

	public void setTextApearance() {
		setFill(Color.RED);
		setFont(Font.font("Arial", FontWeight.BOLD, 10));
	}

	public Timeline setTextMovement() {
		Duration startDuration = Duration.ZERO;
		Duration endDuration = Duration.seconds(10);
		KeyValue startKeyValue = new KeyValue(this.translateXProperty(), -600);
		KeyFrame startKeyFrame = new KeyFrame(startDuration, startKeyValue);
		KeyValue endKeyValue = new KeyValue(this.translateXProperty(), 600);
		KeyFrame endKeyFrame = new KeyFrame(endDuration, endKeyValue);
		Timeline timeline = new Timeline(startKeyFrame, endKeyFrame);
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.setAutoReverse(true);
		timeline.play();
		return timeline;
	}

	public void setTextContent() {
		Calendar cal = Calendar.getInstance();
		int second = cal.get(Calendar.SECOND);
		int minute = cal.get(Calendar.MINUTE);
		int hour = cal.get(Calendar.HOUR);
		int mounth = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int year = cal.get(Calendar.YEAR);
		setText(year + "-" + mounth + "-" + day + "  " + hour + ":" + (minute) + ":" + second
				+ "Afeka Instruments Music Store $$$ ON SALE!!! $$$ Guitars, Basses, Flutes, Saxophones and more!");
	}
}
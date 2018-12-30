import java.applet.Applet;

public class AnnounceTimeOnSeparateThread implements Runnable {

	int hour;
	int minutes;
	int sleepTime = 1000;

	public AnnounceTimeOnSeparateThread(int hour, int minutes) {
		this.hour = hour;
		this.minutes = minutes;
	}

	@Override
	public void run() {
		try {
			announceHour();
			announceMinutes();
			announceAmOrPm();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public void announceAmOrPm() throws InterruptedException {
		String amOrPm = this.hour > 12 ? "pm" : "am";
		Thread.sleep(sleepTime);
		Applet.newAudioClip(this.getClass().getResource("/audio/" + amOrPm + ".au")).play();
	}

	@SuppressWarnings("deprecation")
	public void announceMinutes() throws InterruptedException {
		Applet.newAudioClip(this.getClass().getResource("/audio/minute" + minutes + ".au")).play();
		Thread.sleep(sleepTime);
	}

	@SuppressWarnings("deprecation")
	public void announceHour() throws InterruptedException {
		Applet.newAudioClip(this.getClass().getResource("/audio/hour" + hour % 12 + ".au")).play();
		Thread.sleep(sleepTime);
	}
}

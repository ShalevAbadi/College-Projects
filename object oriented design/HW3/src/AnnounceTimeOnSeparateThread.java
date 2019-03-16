import java.applet.*;

@SuppressWarnings("deprecation")
public class AnnounceTimeOnSeparateThread implements Runnable {

	int hour;
	int minutes;
	AudioClip[] hoursArr = new AudioClip[12];
	AudioClip[] minutesArr = new AudioClip[60];
	AudioClip am;
	AudioClip pm;

	int sleepTime = 1000;

	public AnnounceTimeOnSeparateThread(int hour, int minutes) {
		loadHoursToArr();
		loadMinutesToArr();
		loadAmPm();
	}

	private void loadAmPm() {
		am = Applet.newAudioClip(this.getClass().getResource("/audio/am.au"));
		pm = Applet.newAudioClip(this.getClass().getResource("/audio/pm.au"));
	}

	private void loadMinutesToArr() {
		for (int i = 0; i < minutesArr.length; i++) {
			minutesArr[i] = Applet.newAudioClip(this.getClass().getResource("/audio/minute" + i + ".au"));
		}
	}

	private void loadHoursToArr() {
		for (int i = 0; i < hoursArr.length; i++) {
			hoursArr[i] = Applet.newAudioClip(this.getClass().getResource("/audio/hour" + i + ".au"));
		}
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	@Override
	public void run() {
		try {
			hoursArr[hour].play();
			Thread.sleep(sleepTime);
			minutesArr[minutes].play();
			Thread.sleep(sleepTime);
			announceAmOrPm();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void announceAmOrPm() {
		AudioClip amOrPm = hour > 12 ? am : pm;
		amOrPm.play();
	}
}

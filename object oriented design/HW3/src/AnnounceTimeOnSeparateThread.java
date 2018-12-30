import java.applet.Applet;

public class AnnounceTimeOnSeparateThread implements Runnable{

	int hour;
	int minutes;
	int sleepTime = 1000;
	
	public AnnounceTimeOnSeparateThread(int hour, int minutes) {
		this. hour = hour;
		this. minutes = minutes;
	}
	
	
	@SuppressWarnings("deprecation")
	@Override
	public void run() {
		try {
		Applet.newAudioClip(this.getClass().getResource("/audio/hour" + hour % 12 + ".au")).play();
		Thread.sleep(sleepTime);
		Applet.newAudioClip(this.getClass().getResource("/audio/minute" + minutes + ".au")).play();
		Thread.sleep(sleepTime);
		String amOrPm = this.hour > 12 ? "pm" : "am";
		Thread.sleep(sleepTime);
		Applet.newAudioClip(this.getClass().getResource("/audio/" + amOrPm + ".au")).play();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

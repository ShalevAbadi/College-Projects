import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javafx.application.Platform;
public class Tick implements Runnable
{	private int sleepTime = 1000;
	private ClockPane clockPane;
	private boolean suspended = false;
	private  Lock lock = new ReentrantLock();
	private  Condition stop = lock.newCondition();
	public Tick(ClockPane clockPane)
	{ this.clockPane = clockPane;
	}
	@Override
	public void run()
	{    moveClock();
	}
	public void announceTime() {
		if(clockPane.getSecond() == 0) {
			new Thread(new AnnounceTimeOnSeparateThread(clockPane.getHour(), clockPane.getMinute())).start();
		}
	}
	public  void moveClock()
	{  while (true)
	   { 	lock.lock();
	        if (suspended)
		        try
	            {	stop.await();
		        } 
	            catch (InterruptedException e)
	            { e.printStackTrace();
		        }
	            finally
	             {  lock.unlock();
	             }
	         else
	         {   clockPane.setCurrentTime();
  	             Platform.runLater(() -> clockPane.paintClock());
  	             announceTime();
	             try
	             {	Thread.sleep(sleepTime);
		         } 
	             catch (InterruptedException e)
	             { 	e.printStackTrace();
		         }
	             finally
	             {  lock.unlock();
	             }
	        } 
	   }     
	}
	public  synchronized void pause()
	{   suspended = true;
	}
	public void play()
	{  lock.lock();
	   suspended = false;
	   stop.signal();
	   lock.unlock();
	}
}

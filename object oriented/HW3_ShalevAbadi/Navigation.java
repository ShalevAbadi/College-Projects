public class Navigation {
	private MyButtons previous = new MyButtons("<", 50, 50);
	private MyButtons next = new MyButtons(">", 50, 50);

	public MyButtons getPrevious() {
		return previous;
	}

	public MyButtons getNext() {
		return next;
	}
}
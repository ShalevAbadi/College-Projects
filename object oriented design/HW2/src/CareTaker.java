import java.util.Stack;

public class CareTaker {
	private Stack<Memento> mementoStack = new Stack<Memento>();

	public void add(Memento state) {
		mementoStack.push(state);
	}

	public Memento get() {
		if (!mementoStack.isEmpty()) {
			return mementoStack.pop();
		}
		return null;
	}
}
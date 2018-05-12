
public interface InstrumentFunc<T extends MusicalInstrument> extends Cloneable, Comparable<T> {

	public int compareTo(MusicalInstrument o);

}

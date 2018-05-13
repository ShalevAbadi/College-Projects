import java.util.ArrayList;

public interface StorageManagement<T extends MusicalInstrument> {

	void addAllStringInstruments(ArrayList<? extends MusicalInstrument> src, ArrayList<? super MusicalInstrument> dest);

	void addAllWindInstruments(ArrayList<? extends MusicalInstrument> src, ArrayList<? super MusicalInstrument> dest);

	void SortByBrandAndPrice(ArrayList<MusicalInstrument> musicalList);

	int binnarySearchByBrandAndPrice(ArrayList<MusicalInstrument> musicalList, String brand, Number price);

	void addInstrument(ArrayList<T> musicalList, T instrument);

	boolean removeInstrument(ArrayList<T> musicalList, T instrument);

	boolean removeAll(ArrayList<MusicalInstrument> musicalList);




}

import java.util.ArrayList;

public interface StorageManagement<T extends MusicalInstrument> {

	void addAllStringInstruments(ArrayList<T> musicalList, ArrayList<T> stringToPutList);

	void addAllWindInstruments(ArrayList<T> musicalList, ArrayList<T> windToPutList);

	void SortByBrandAndPrice(ArrayList<MusicalInstrument> musicalList);

	int binnarySearchByBrandAndPrice(ArrayList<MusicalInstrument> musicalList, String brand, Number price);

	void addInstrument(ArrayList<MusicalInstrument> musicalList, MusicalInstrument instrument);

	boolean removeInstrument(ArrayList<MusicalInstrument> musicalList, MusicalInstrument instrument);

	boolean removeAll(ArrayList<MusicalInstrument> musicalList);

}

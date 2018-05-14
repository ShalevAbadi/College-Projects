import java.util.ArrayList;

public interface StorageManagement<T extends MusicalInstrument> {

	void addAllStringInstruments(ArrayList<? extends MusicalInstrument> src, ArrayList<? super MusicalInstrument> dest);

	void addAllWindInstruments(ArrayList<? extends MusicalInstrument> src, ArrayList<? super MusicalInstrument> dest);

	void SortByBrandAndPrice(ArrayList<? extends MusicalInstrument> musicalList);

	int binnarySearchByBrandAndPrice(ArrayList<MusicalInstrument> musicalList, String brand, Number price);

	void addInstrument(ArrayList<? super MusicalInstrument> musicalList, MusicalInstrument instrument);

	boolean removeInstrument(ArrayList<? extends MusicalInstrument> musicalList, MusicalInstrument instrument);

	boolean removeAll(ArrayList<MusicalInstrument> musicalList);




}

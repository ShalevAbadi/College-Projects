
//Shalev Abadi 205740772
import java.util.ArrayList;

public interface StorageManagement {
	// Itzik allowed not to use <E> because its unnecessary
	void addAllStringInstruments(ArrayList<? extends MusicalInstrument> src, ArrayList<? super MusicalInstrument> dest);

	void addAllWindInstruments(ArrayList<? extends MusicalInstrument> src, ArrayList<? super MusicalInstrument> dest);

	void SortByBrandAndPrice(ArrayList<? extends MusicalInstrument> musicalList);

	int binnarySearchByBrandAndPrice(ArrayList<? extends MusicalInstrument> list, String brand, Number price);

	void addInstrument(ArrayList<? super MusicalInstrument> musicalList, MusicalInstrument instrument);

	boolean removeInstrument(ArrayList<? extends MusicalInstrument> musicalList, MusicalInstrument instrument);

	boolean removeAll(ArrayList<? extends MusicalInstrument> musicalList);

}

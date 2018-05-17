
//Shalev Abadi 205740772
import java.util.ArrayList;
import java.util.Collections;

public class AfekaInventory implements StorageManagement {
	private ArrayList<MusicalInstrument> instruments = new ArrayList<>();
	private double totalPrice;
	private boolean isSorted;

	public ArrayList<MusicalInstrument> getInstruments() {
		return instruments;
	}

	public void setInstruments(ArrayList<MusicalInstrument> arr) {
		this.instruments = arr;
	}

	public Number getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setTotalPrice() {
		double sum = 0;
		for (int i = 0; i < instruments.size(); i++) {
			sum = genericSum(sum, instruments.get(i).getPrice());
		}
		this.totalPrice = sum;
	}

	public boolean getIsSorted() {
		return isSorted;
	}

	public void setSorted(boolean isSorted) {
		this.isSorted = isSorted;
	}

	public <N1 extends Number, N2 extends Number> double genericSum(N1 num1, N2 num2) {
		return num1.doubleValue() + num2.doubleValue();

	}

	@Override
	public void addAllStringInstruments(ArrayList<? extends MusicalInstrument> src,
			ArrayList<? super MusicalInstrument> dest) {
		for (int i = 0; i < src.size(); i++) {
			if (src.get(i) instanceof StringInstrument) {
				dest.add(src.get(i));
			}
		}
		isSorted = false;
		setTotalPrice();
	}

	@Override
	public void addAllWindInstruments(ArrayList<? extends MusicalInstrument> src,
			ArrayList<? super MusicalInstrument> dest) {
		for (int i = 0; i < src.size(); i++) {
			if (src.get(i) instanceof WindInstrument) {
				dest.add(src.get(i));
			}
		}
		isSorted = false;
		setTotalPrice();
	}

	public void SortByBrandAndPrice(ArrayList<? extends MusicalInstrument> list) {
		Collections.sort(list);
		setSorted(true);
	}

	@Override
	public int binnarySearchByBrandAndPrice(ArrayList<? extends MusicalInstrument> list, String brand, Number price) {
		int high = list.size() - 1, low = 0, middle;
		while (high >= low) {
			middle = (high + low) / 2;
			int compareResult = list.get(middle).compareTo(brand, price);
			if (compareResult == 0) {
				return middle;
			} else if (compareResult > 0) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}
		return -1;
	}

	@Override
	public void addInstrument(ArrayList<? super MusicalInstrument> list, MusicalInstrument instrument) {
		list.add(instrument);
		setTotalPrice();
	}

	@Override
	public boolean removeInstrument(ArrayList<? extends MusicalInstrument> list, MusicalInstrument instrument) {
		boolean remove = list.remove(instrument);
		setTotalPrice();
		return remove;
	}

	@Override
	public boolean removeAll(ArrayList<? extends MusicalInstrument> list) {
		boolean remove = false;
		while (!list.isEmpty()) {
			remove = list.remove(list.get(0));
		}
		if (remove) {
			setTotalPrice();
			setSorted(false);
		}
		return remove;
	}

	@Override
	public String toString() {
		return "------------------------------------------------------------------------- \n"
				+ "AFEKA MUSICAL INSTRUMENTS INVENTORY \n"
				+ "------------------------------------------------------------------------- \n" + instrumentsToString()
				+ "\n" + "Total Price:" + String.format("%.2f %4s Sorted: %b", totalPrice, "", isSorted);
	}

	private String instrumentsToString() {
		String res = "";
		if (instruments.size() == 0) {
			res += "There Is No Instruments To Show\n";
		} else {
			for (int i = 0; i < instruments.size(); i++) {
				res += (instruments.get(i).toString() + "\n");
			}
		}
		return res;
	}
}
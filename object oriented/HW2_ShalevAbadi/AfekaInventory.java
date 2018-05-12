import java.util.ArrayList;

public class AfekaInventory<T extends MusicalInstrument> implements StorageManagement<T> {
	private ArrayList<T> musicalArrayList = new ArrayList<>();
	private double totalPrice;
	private boolean isArraySorted;

	public ArrayList<T> getMusicalArrayList() {
		return musicalArrayList;
	}

	public void setArr(ArrayList<T> arr) {
		this.musicalArrayList = arr;
	}

	public Number getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice() {
		double sum = 0;
		for (int i = 0; i < musicalArrayList.size(); i++) {
			sum = genericSum(sum, musicalArrayList.get(i).getPrice());
		}
		this.totalPrice = sum;
	}

	public boolean isArraySorted() {
		return isArraySorted;
	}

	public void setArraySorted(boolean isArraySorted) {

		this.isArraySorted = isArraySorted;
	}

	public <N1 extends Number, N2 extends Number> double genericSum(N1 num1, N2 num2) {
		return num1.doubleValue() + num2.doubleValue();

	}

	@Override
	public void addAllStringInstruments(ArrayList<T> musicalList, ArrayList<T> arrayTarget) {
		for (int i = 0; i < musicalList.size(); i++) {
			if (musicalList.get(i) instanceof StringInstrument) {
				arrayTarget.add(musicalList.get(i));
			}
		}
		isArraySorted = false;
		setTotalPrice();
	}

	@Override
	public void addAllWindInstruments(ArrayList<T> musicalList, ArrayList<T> arrayTarget) {
		for (int i = 0; i < musicalList.size(); i++) {
			if (musicalList.get(i) instanceof WindInstrument) {
				arrayTarget.add(musicalList.get(i));
			}
		}
		isArraySorted = false;
		setTotalPrice();
	}

	public void SortByBrandAndPrice(ArrayList<MusicalInstrument> musicalList) {
		MusicalInstrument temp;

		for (int i = 1; i < musicalList.size(); i++) {
			for (int j = i; j > 0; j--) {

				if (musicalList.get(j).compareTo(musicalList.get(j - 1)) < 0) {
					temp = musicalList.get(j);
					musicalList.set(j, musicalList.get(j - 1));
					musicalList.set(j - 1, temp);
				}
			}

		}
		isArraySorted = true;
	}

	@Override
	public int binnarySearchByBrandAndPrice(ArrayList<MusicalInstrument> musicalList, String brand, Number price) {
		if (!isArraySorted)
			return -1;
		int high = musicalList.size() - 1, low = 0, middle;
		while (high >= low) {
			middle = (high + low) / 2;
			int compareResult = musicalList.get(middle).getBrand().compareTo(brand);
			if (compareResult == 0) {
				if (musicalList.get(middle).getPrice().doubleValue() == price.doubleValue()) {
					return middle;
				} else if (musicalList.get(middle).getPrice().doubleValue() > price.doubleValue()) {
					high = middle - 1;
				} else {
					low = middle + 1;
				}
			} else if (compareResult > 0) {
				high = middle - 1;
			} else {
				low = middle + 1;
			}
		}
		return -1;
	}

	@Override
	public void addInstrument(ArrayList<MusicalInstrument> musicalList, MusicalInstrument instrument) {
		musicalList.add(instrument);
		setTotalPrice();
	}

	@Override
	public boolean removeInstrument(ArrayList<MusicalInstrument> musicalList, MusicalInstrument instrument) {
		boolean remove = musicalList.remove(instrument);
		setTotalPrice();
		return remove;
	}

	@Override
	public boolean removeAll(ArrayList<MusicalInstrument> musicalList) {
		boolean remove = musicalList.removeAll(musicalList);
		setTotalPrice();
		return remove;
	}

	@Override
	public String toString() {
		return "------------------------------------------------------------------------- \n"
				+ "AFEKA MUSICAL INSTRUMENTS INVENTORY \n"
				+ "------------------------------------------------------------------------- \n" + instrumentsToString()
				+ "\n" + "Total Price:" + String.format("%.2f %4s Sorted: %b", totalPrice, "", isArraySorted);
	}

	private String instrumentsToString() {
		String res = "";
		if (musicalArrayList.size() == 0) {
			res += "There Is No Instruments To Show\n";
		} else {
			for (int i = 0; i < musicalArrayList.size(); i++) {
				res += (musicalArrayList.get(i).toString() + "\n");
			}
		}
		return res;
	}

	
}
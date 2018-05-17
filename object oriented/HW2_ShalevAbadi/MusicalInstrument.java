//Shalev Abadi 205740772
import java.util.InputMismatchException;
import java.util.Scanner;

abstract class MusicalInstrument implements InstrumentFunc<MusicalInstrument> {
	private Number price;
	private String brand;

	public <T extends Number> MusicalInstrument(String brand, T price) {
		setBrand(brand);
		setPrice(price);
	}

	public MusicalInstrument(Scanner scanner) {
		double price = 0;
		String brand;

		try {
			price = scanner.nextDouble();
		} catch (InputMismatchException ex) {
			throw new InputMismatchException("Price not found!");
		}
		setPrice(price);
		scanner.nextLine();
		brand = scanner.nextLine();
		setBrand(brand);
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Number getPrice() {
		return price;
	}

	public <T extends Number> void setPrice(T price) {
		if (price.doubleValue() > 0) {
			if (price.doubleValue() - price.intValue() > 0) {
				this.price = price.doubleValue();
			} else {
				this.price = price.intValue();
			}
		} else
			throw new InputMismatchException("Price must be a positive number!");

	}

	protected boolean isValidType(String[] typeArr, String material) {
		for (int i = 0; i < typeArr.length; i++) {
			if (material.equals(typeArr[i])) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || !(o instanceof MusicalInstrument))
			return false;

		MusicalInstrument otherInstrument = (MusicalInstrument) o;

		return getPrice().doubleValue() == otherInstrument.getPrice().doubleValue()
				&& getBrand().equals(otherInstrument.getBrand());
	}

	@Override
	public int compareTo(MusicalInstrument compared) {
		return compareTo(compared.getBrand(), compared.getPrice());
	}
	
	public int compareTo(String Brand, Number price) {
		int brandCompare = this.getBrand().compareTo(Brand);
		if (brandCompare == 0) {
			double priceCompare = (this.getPrice().doubleValue() - price.doubleValue());
			if (priceCompare < 0) {
				return -1;
			} else if (priceCompare > 0) {
				return 1;
			}
			return 0;
		}
		return brandCompare;
	}

	@Override
	public String toString() {
		return String.format("%-8s %-9s| Price: %7s,", getBrand(), getClass().getCanonicalName(),
				getPrice().toString());
	}

}

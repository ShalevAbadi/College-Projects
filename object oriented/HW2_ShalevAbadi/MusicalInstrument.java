import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

public abstract class MusicalInstrument implements InstrumentFunc<MusicalInstrument> {
	private Number price;
	private String brand;

	public MusicalInstrument(String brand, Number price) {
		setBrand(brand);
		setPrice(price);
	}

	public MusicalInstrument(Scanner scanner) {
		Number price = 0;
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

	public void setPrice(Number price) {
		if (price.doubleValue() > 0) {
			if ((price.doubleValue() - price.intValue() == 0)) {
				this.price = price.intValue();
			} else {
				this.price = price.doubleValue();
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

		return getPrice().doubleValue() == otherInstrument.getPrice().doubleValue() && getBrand().equals(otherInstrument.getBrand());
	}

	@Override
	public String toString() {
		return String.format("%-8s %-9s| Price: %7s,", getBrand(), getClass().getCanonicalName(), getPrice().toString());
	}

	@Override
	public int compareTo(MusicalInstrument o) {
		if (this.brand.compareTo(o.getBrand()) == 0) {
			if (this.price.doubleValue() == o.getPrice().doubleValue()) {
				return 0;
			} else if (this.price.doubleValue() > o.getPrice().doubleValue()) {
				return 1;
			} else
				return -1;
		} else if (this.brand.compareTo(o.getBrand()) > 0) {
			return 1;
		} else
			return -1;

	}
}

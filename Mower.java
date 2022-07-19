public abstract class Mower {
	private String manufacturer;
	private int year;
	private String serialNumber;
	
	public Mower() {
		this.setManufacturer("");
		this.setSerialNumber("");
		this.setYear(0);
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	public String toString() {
		return getManufacturer() + "," + getYear() + "," + getSerialNumber();
	}
}

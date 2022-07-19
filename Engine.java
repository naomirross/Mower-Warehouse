public class Engine {
	private String manufacturer;
	private double horsePower;
	private int cyclinders;
	
	public Engine() {
		this.manufacturer = "";
		this.horsePower = 0.0;
		this.cyclinders = 0;
	}
	
	public Engine(String manufacturer, double horsePower, int cyclinders) {
		this.manufacturer = manufacturer;
		this.horsePower = horsePower;
		this.cyclinders = cyclinders;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	public double getHorsePower() {
		return horsePower;
	}
	
	public void setHorsePower(double horsePower) {
		this.horsePower = horsePower;
	}
	
	public int getCyclinders() {
		return cyclinders;
	}
	
	public void setCyclinders(int cyclinders) {
		this.cyclinders = cyclinders;
	}
	
	public String toString() {
		return getManufacturer() + "," + getHorsePower()  + "," + getCyclinders()  + "," ; 
	}
}

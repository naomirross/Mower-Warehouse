public class CommericalMower extends LawnTractor{

	private double operatingHours;
	private boolean zeroTurnRadius;
	
	public CommericalMower() {
		this.operatingHours = 0.0;
		this.zeroTurnRadius = false;
	}

	public double getOperatingHours() {
		return operatingHours;
	}

	public void setOperatingHours(double operatingHours) {
		this.operatingHours = operatingHours;
	}

	public boolean isZeroTurnRadius() {
		return zeroTurnRadius;
	}

	public void setZeroTurnRadius(boolean zeroTurnRadius) {
		this.zeroTurnRadius = zeroTurnRadius;
	}
	@Override
	public String toString() {
		return getManufacturer() + "\n" + getYear() + "\n" + getSerialNumber()+ "\nC\n"+ getEngine().getManufacturer() + "\n" + getEngine().getHorsePower() + "\n" + getEngine().getCyclinders() +"\n" + getModel()+"\n" + getDeckWidth() + "\n"+getOperatingHours() +"\n"+isZeroTurnRadius();
	}
}
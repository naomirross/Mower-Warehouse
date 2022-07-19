public abstract class WalkBehindMower extends Mower {
	private double cutWidth;
	private double wheelDiameter;
	
	public WalkBehindMower() {
		this.setCutWidth(0.0);
		this.setWheelDiameter(0.0);
	}

	public double getCutWidth() {
		return cutWidth;
	}

	public void setCutWidth(double cutWidth) {
		this.cutWidth = cutWidth;
	}

	public double getWheelDiameter() {
		return wheelDiameter;
	}

	public void setWheelDiameter(double wheelDiameter) {
		this.wheelDiameter = wheelDiameter;
	}
	@Override
	public String toString() {
		return getManufacturer() + "\n" + getYear() + "\n" + getSerialNumber()+ "\nP\n"+getCutWidth() + "\n" + getWheelDiameter() + "\n";
	}
}
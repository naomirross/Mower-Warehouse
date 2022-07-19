public class PushReelMower extends WalkBehindMower{
	private int numWheels;
	
	PushReelMower(){
		this.numWheels = 0;
	}

	public int getNumWheels() {
		return numWheels;
	}

	public void setNumWheels(int numWheels) {
		this.numWheels = numWheels;
	}
	@Override
	public String toString() {
		return getManufacturer() + "\n" + getYear() + "\n" + getSerialNumber()+ "\nP\n"+getCutWidth() + "\n" + getWheelDiameter() + "\n"+getNumWheels();
	}
}

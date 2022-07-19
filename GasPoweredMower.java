public class GasPoweredMower extends WalkBehindMower {
	private Engine engine;
	private boolean selfPropelled;
	
	public GasPoweredMower() {
		this.engine = new Engine();
		this.selfPropelled = false;
	}
	
	public Engine getEngine() {
		return engine;
	}

	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public boolean isSelfPropelled() {
		return selfPropelled;
	}

	public void setSelfPropelled(boolean selfPropelled) {
		this.selfPropelled = selfPropelled;
	}
	@Override
	public String toString() {
		return getManufacturer() + "\n" + getYear() + "\n" + getSerialNumber() + "\nG\n" + getCutWidth() + "\n" + getWheelDiameter() + "\n" + getEngine().getManufacturer() + "\n" + getEngine().getHorsePower() + "\n" + getEngine().getCyclinders() + "\n" + isSelfPropelled();
	}
}
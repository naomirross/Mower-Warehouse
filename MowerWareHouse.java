import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;

public class MowerWareHouse {
	private String storeName;
	private ArrayList<Mower> mowers;
	
	MowerWareHouse(){
		this.setStoreName("");
		this.setMowers(new ArrayList<Mower>());
	}
	
	public void readMowerData( String inputFileName ) throws FileNotFoundException {
		
		Scanner fileScnr = new Scanner(new FileReader(inputFileName));
		String storeName = fileScnr.nextLine();
		this.setStoreName(storeName);
		
		while(fileScnr.hasNext()) {
			//generic variables
			String manufacturer = fileScnr.nextLine();
			int year = Integer.parseInt(fileScnr.nextLine());
			String serialNum = fileScnr.nextLine();

			String subclass = fileScnr.nextLine();
			switch(subclass) {
			
			case "L":
				LawnTractor lawnTractor = new LawnTractor();
				//mower properties
				lawnTractor.setManufacturer(manufacturer);
				lawnTractor.setYear(year);
				lawnTractor.setSerialNumber(serialNum);
				//subclass
				Engine engine = new Engine();
				engine.setManufacturer(fileScnr.nextLine());
				engine.setHorsePower(Double.parseDouble(fileScnr.nextLine()));
				engine.setCyclinders(Integer.parseInt(fileScnr.nextLine()));
				lawnTractor.setEngine(engine);
				lawnTractor.setModel(fileScnr.nextLine());
				lawnTractor.setDeckWidth(Double.parseDouble(fileScnr.nextLine()));
				mowers.add(lawnTractor);
				break;
				
			case "C":
				CommericalMower comMower = new CommericalMower();
				//mower properties
				comMower.setManufacturer(manufacturer);
				comMower.setYear(year);
				comMower.setSerialNumber(serialNum);
				//subclass
				Engine comEngine = new Engine();
				comEngine.setManufacturer(fileScnr.nextLine());
				comEngine.setHorsePower(Double.parseDouble(fileScnr.nextLine()));
				comEngine.setCyclinders(Integer.parseInt(fileScnr.nextLine()));
				comMower.setEngine(comEngine);
				comMower.setModel(fileScnr.nextLine());
				comMower.setDeckWidth(Double.parseDouble(fileScnr.nextLine()));
				comMower.setOperatingHours(Double.parseDouble(fileScnr.nextLine()));
				comMower.setZeroTurnRadius(Boolean.parseBoolean(fileScnr.nextLine()));
				mowers.add(comMower);
				break;
				
			case "G":
				GasPoweredMower gasMower = new GasPoweredMower();
				//mower properties
				gasMower.setManufacturer(manufacturer);
				gasMower.setYear(year);
				gasMower.setSerialNumber(serialNum);
				//subclass
				gasMower.setCutWidth(Double.parseDouble(fileScnr.nextLine()));
				gasMower.setWheelDiameter(Double.parseDouble(fileScnr.nextLine()));
				Engine gasEngine = new Engine();
				gasEngine.setManufacturer(fileScnr.nextLine());
				gasEngine.setHorsePower(Double.parseDouble(fileScnr.nextLine()));
				gasEngine.setCyclinders(Integer.parseInt(fileScnr.nextLine()));
				gasMower.setSelfPropelled(Boolean.parseBoolean(fileScnr.nextLine()));
				gasMower.setEngine(gasEngine);
				mowers.add(gasMower);
				break;
				
			case "P":
				PushReelMower pushMow = new PushReelMower();
				//mower properties
				pushMow.setManufacturer(manufacturer);
				pushMow.setYear(year);
				pushMow.setSerialNumber(serialNum);
				//subclass
				pushMow.setCutWidth(Double.parseDouble(fileScnr.nextLine()));
				pushMow.setWheelDiameter(Double.parseDouble(fileScnr.nextLine()));
				pushMow.setNumWheels(Integer.parseInt(fileScnr.nextLine()));
				mowers.add(pushMow);
				break;
			}
		}
	}
	
	public void saveMowerData( String outputFileName ) throws IOException {
		FileWriter fileOutput = new FileWriter(outputFileName);
		String toWrite = "";
		toWrite += storeName;
		for(int i = 0;i < mowers.size();i++) {
			toWrite += "\n" + mowers.get(i).toString();
		}
		fileOutput.write(toWrite);
		fileOutput.close();
	}
	
	public String getStoreName() {
		return storeName;
	}
	
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	public ArrayList<Mower> getMowers() {
		return mowers;
	}
	
	public void setMowers(ArrayList<Mower> mowers) {
		this.mowers = mowers;
	}
	@Override
	public String toString() {
		String toPrint = "";
		toPrint += storeName;
		for(int i = 0;i < mowers.size();i++) {
			toPrint += "\n" + mowers.get(i).toString();
		}
		return toPrint;
	}
}

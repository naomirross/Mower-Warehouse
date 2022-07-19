import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import java.io.File;
import java.io.IOException;

public class Client {

	public static void main(String[] args) throws IOException{
		Scanner scnr = new Scanner(System.in);
		String inputFile = "";
		MowerWareHouse warehouse = new MowerWareHouse();
		System.out.println("===== Mower Warehouse =====");
		System.out.println("Choose a file to read from.\n");
		
		//read into file for information
		if(args.length > 0) {
			File fileName = new File(args[0]);
			String filePath = fileName.getAbsolutePath();
			warehouse.readMowerData(filePath);
		}else {
			JFileChooser fileInputPick = new JFileChooser();
			int pick = fileInputPick.showOpenDialog(new JFrame());
			
			if (pick == JFileChooser.APPROVE_OPTION) {
				File file = fileInputPick.getSelectedFile();
				inputFile = file.getAbsolutePath();
				warehouse.readMowerData(inputFile);
			}
		}
		
		//add LawnTractor class
		Engine lawnEngine = new Engine("Kawasaki", 9, 2);
		LawnTractor lawnTrac = new LawnTractor();
		lawnTrac.setManufacturer("John Deere");
		lawnTrac.setYear(2018);
		lawnTrac.setSerialNumber("ACD3P");
		lawnTrac.setDeckWidth(50.4);
		lawnTrac.setModel("Model5");
		lawnTrac.setEngine(lawnEngine);
		warehouse.getMowers().add(lawnTrac);
		
		//add Push Reel Mower
		PushReelMower pushMow = new PushReelMower();
		pushMow.setManufacturer("Husqvarna");
		pushMow.setYear(2017);
		pushMow.setSerialNumber("B87G4");
		pushMow.setCutWidth(13.3);
		pushMow.setNumWheels(2);
		pushMow.setWheelDiameter(2.7);
		warehouse.getMowers().add(pushMow);
		
		//add Gas Powered Mower
		Engine gasEngine = new Engine("Honda",10,2);
		GasPoweredMower gasMower = new GasPoweredMower();
		gasMower.setManufacturer("Craftmans");
		gasMower.setYear(2008);
		gasMower.setSerialNumber("G6FR4");
		gasMower.setCutWidth(21);
		gasMower.setWheelDiameter(16.6);
		gasMower.setSelfPropelled(true);
		gasMower.setEngine(gasEngine);
		warehouse.getMowers().add(gasMower);
		
		//add Commerical Mower
		Engine comEngine = new Engine("Kohler",8,4);
		CommericalMower comMower = new CommericalMower();
		comMower.setManufacturer("Swisher");
		comMower.setYear(2018);
		comMower.setSerialNumber("CH74EX");
		comMower.setModel("Model3");
		comMower.setDeckWidth(4.8);
		comMower.setOperatingHours(36);
		comMower.setZeroTurnRadius(true);
		comMower.setEngine(comEngine);
		warehouse.getMowers().add(comMower);
		
		//write into outFile with added information
		System.out.println("Choose a file to write into.\n");
		JFileChooser fileOutputPick = new JFileChooser();
		int result = fileOutputPick.showOpenDialog(new JFrame("Choose a file to write into."));
		if(result == JFileChooser.APPROVE_OPTION) {
			File outWrite = fileOutputPick.getSelectedFile();
			String outwriteName = outWrite.getAbsolutePath();
			warehouse.saveMowerData(outwriteName);
		}
		
		System.out.println("Enter your choice of Mower to get information.");
		System.out.println("Type C for Commerical Mower, G for Gas Powered Mower, P for Push Reel Mower, L for Lawn Tractor, and S to stop : ");
		
		String choice = scnr.nextLine();
		while(!choice.equals("S")) {
			if(choice.equals("L")) {
				for(Mower mower: warehouse.getMowers()) {
					String tempName = mower.getClass().getName();
					if(tempName.equals("LawnTractor")) {
						LawnTractor tempMower = (LawnTractor) mower;
						System.out.println(tempMower.getManufacturer() + "," + tempMower.getYear() + "," + tempMower.getSerialNumber()  + ",L," + tempMower.getEngine().getManufacturer() + "," + tempMower.getEngine().getHorsePower()  + "," + tempMower.getEngine().getCyclinders()  + "," + tempMower.getModel()  + "," + tempMower.getDeckWidth());
					}
				}
				System.out.println("Type C for Commerical Mower, G for Gas Powered Mower, P for Push Reel Mower, L for Lawn Tractor, and S to stop : ");
				choice = scnr.next();
				
			}else if(choice.equals("C")) {
				for(Mower mower: warehouse.getMowers()) {
					String tempName = mower.getClass().getName();
					if(tempName.equals("CommericalMower")) {
						CommericalMower tempMower = (CommericalMower) mower;
						System.out.println(tempMower.getManufacturer() + "," + tempMower.getYear() + "," + tempMower.getSerialNumber()  + ",C," + tempMower.getEngine().getManufacturer() + "," + tempMower.getEngine().getHorsePower()  + "," + tempMower.getEngine().getCyclinders()  + "," + tempMower.getModel()  + "," + tempMower.getDeckWidth() + "," + tempMower.getOperatingHours() + "," + tempMower.isZeroTurnRadius());
					}
				}
				System.out.println("Type C for Commerical Mower, G for Gas Powered Mower, P for Push Reel Mower, L for Lawn Tractor, and S to stop : ");
				choice = scnr.next();

			}else if(choice.equals("G")) {
				for(Mower mower: warehouse.getMowers()) {
					String tempName = mower.getClass().getName();
					if(tempName.equals("GasPoweredMower")) {
						GasPoweredMower tempMower = (GasPoweredMower) mower;
						System.out.println(tempMower.getManufacturer() + "," + tempMower.getYear() + "," + tempMower.getSerialNumber() + ",G," + tempMower.getCutWidth() + "," + tempMower.getWheelDiameter() + "," + tempMower.getEngine().getManufacturer() + "," + tempMower.getEngine().getHorsePower() + "," + tempMower.getEngine().getCyclinders() + "," + tempMower.isSelfPropelled());					
					}
				}
				System.out.println("Type C for Commerical Mower, G for Gas Powered Mower, P for Push Reel Mower, L for Lawn Tractor, and S to stop : ");
				choice = scnr.next();

			}else if(choice.equals("P")) {
				for(Mower mower: warehouse.getMowers()) {
					String temp = mower.getClass().getName();
					if(temp.equals("PushReelMower")) {
						PushReelMower tempMower = (PushReelMower) mower;
						System.out.println(tempMower.getManufacturer() + "," + tempMower.getYear() + "," + tempMower.getSerialNumber()+ ",P,"+ tempMower.getCutWidth() + "," + tempMower.getWheelDiameter() + "," + tempMower.getNumWheels());
					}
				}
				System.out.println("Type C for Commerical Mower, G for Gas Powered Mower, P for Push Reel Mower, L for Lawn Tractor, and S to stop : ");
				choice = scnr.next();
				
			}else {
			System.out.println("Error! Incorrect input! \n");
			System.out.println("Enter your choice of Mower to get information.");
			System.out.println("Type C for Commerical Mower, G for Gas Powered Mower, P for Push Reel Mower, L for Lawn Tractor, and S to stop : ");
			choice = scnr.next();
			}
		}
		scnr.close();
}
}

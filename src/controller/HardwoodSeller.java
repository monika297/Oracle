/**
 * 
 */
package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import model.WoodItem;

/**
 * @author Esteban
 *
 */
public class HardwoodSeller {
	public static List<Double> deliveryTimeList = new ArrayList<Double>();
	/**
	 * 
	 * @author monika_arora
	 * enum contains the prices for woodItem per BF
	 *
	 */
	public enum PRICETABLE{
		CHERRY(5.95),
		CURLY_MAPLE(6.00),
		GENUINE_MAHOGANY(9.60),
		WENGE(22.35),
		WHITE_OAK(6.70),
		SAWDUST(1.5);

		private final double value;

		private PRICETABLE(final double newValue) {
			value = newValue;
		}

		public double getValue() { return value; }
	}

	/**
	 * 
	 * @author monika_arora
	 * enum contains the base delivery for each woodItem
	 *
	 */
	public enum BASEDELIVERYTIME{
		CHERRY(2.5),
		CURLY_MAPLE(1.5),
		GENUINE_MAHOGANY(3),
		WENGE(5),
		WHITE_OAK(2.3),
		SAWDUST(1);

		private final double value;

		private BASEDELIVERYTIME(final double newValue) {
			value = newValue;
		}

		public double getValue() { return value; }
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HardwoodSeller hardwoodSeller = new HardwoodSeller();
		Scanner console = new Scanner(System.in);
		System.out.println("Enter the path for the file");
		String filePath = console.next();
		try {
			hardwoodSeller.readInputFile(filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param inputFilePath
	 * @throws IOException
	 * This method reads the input file
	 */
	public void readInputFile(String inputFilePath) throws IOException{
		HardwoodSeller hardwoodSeller = new HardwoodSeller();
		List<WoodItem> items = new ArrayList<WoodItem>();
		WoodItem woodItemObject = new WoodItem();
		String line = null;
		try {
			FileReader fileReader = new FileReader(inputFilePath);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while((line=bufferedReader.readLine())!= null){
				String[] str = line.split(";");
				if(str.length==3 && !line.contains(":")){
					String buyerName = str[0];
					String address = str[1];
					String date = str[2];
					System.out.println("Buyer's Name:" + " " + buyerName);
					System.out.println("Address:" + " " + address);
					System.out.println("Date:" + " " + date);
				}else{
					items.clear();
					for(int i=0;i<str.length;i++){
						WoodItem item = new WoodItem();
						String[] woodDetails = str[i].split(":");
						String nameOfWood = woodDetails[0];
						String quantity = woodDetails[1];
						double quantityValue = Double.parseDouble(quantity);
						item.setQuantity(quantityValue);
						item.setType(nameOfWood);
						if(nameOfWood.equalsIgnoreCase("cherry")){
							BASEDELIVERYTIME name = BASEDELIVERYTIME.CHERRY;
							item.setBaseDeliveryTime(name.getValue());
							PRICETABLE price = PRICETABLE.CHERRY;
							item.setPrice(price.getValue());
							item.setTotalPrice(item.getPrice() * quantityValue);
						}else
							if(nameOfWood.equalsIgnoreCase("curly maple")){
								BASEDELIVERYTIME name = BASEDELIVERYTIME.CURLY_MAPLE;
								item.setBaseDeliveryTime(name.getValue());
								PRICETABLE price = PRICETABLE.CURLY_MAPLE;
								item.setPrice(price.getValue());
								item.setTotalPrice(item.getPrice() * quantityValue);
							}else
								if(nameOfWood.equalsIgnoreCase("genuine mahogany")){
									BASEDELIVERYTIME name = BASEDELIVERYTIME.GENUINE_MAHOGANY;
									item.setBaseDeliveryTime(name.getValue());
									PRICETABLE price = PRICETABLE.GENUINE_MAHOGANY;
									item.setPrice(price.getValue());
									item.setTotalPrice(item.getPrice() * quantityValue);
								}else
									if(nameOfWood.equalsIgnoreCase("wenge")){
										BASEDELIVERYTIME name = BASEDELIVERYTIME.WENGE;
										item.setBaseDeliveryTime(name.getValue());
										PRICETABLE price = PRICETABLE.WENGE;
										item.setPrice(price.getValue());
										item.setTotalPrice(item.getPrice() * quantityValue);
									}else
										if(nameOfWood.equalsIgnoreCase("white oak")){
											BASEDELIVERYTIME name = BASEDELIVERYTIME.WHITE_OAK;
											item.setBaseDeliveryTime(name.getValue());
											PRICETABLE price = PRICETABLE.WHITE_OAK;
											item.setPrice(price.getValue());
											item.setTotalPrice(item.getPrice() * quantityValue);
										}else
											if(nameOfWood.equalsIgnoreCase("sawdust")){
												BASEDELIVERYTIME name = BASEDELIVERYTIME.SAWDUST;
												item.setBaseDeliveryTime(name.getValue());
												PRICETABLE price = PRICETABLE.SAWDUST;
												item.setPrice(price.getValue());
												item.setTotalPrice(item.getPrice() * quantityValue);
											}
						items.add(item);
					}
					double deliveryTime = 0.0;
					double totalPrice = 0.0;
					deliveryTimeList.clear();
					System.out.println("List of ordered woods are:");
					for(WoodItem woodItem : items){

						System.out.println("Name of Wood Ordered : " + " " + woodItem.getType() + " " + ","
								+ "Quantity :" + " " +  woodItem.getQuantity()  + "BF" + " " + "," + "Price per Bare Foot :" + " " + "$" + woodItem.getPrice());
						if((woodItem.getQuantity()>=1) && (woodItem.getQuantity()<=100)){
							deliveryTime = 1 * (woodItem.getBaseDeliveryTime())	;
						}else
							if((woodItem.getQuantity()>=101) && (woodItem.getQuantity()<=200)){
								deliveryTime = 2 * (woodItem.getBaseDeliveryTime())	;
							}else
								if((woodItem.getQuantity()>=201) && (woodItem.getQuantity()<=300)){
									deliveryTime = 3 * (woodItem.getBaseDeliveryTime())	;
								}else
									if((woodItem.getQuantity()>=301) && (woodItem.getQuantity()<=400)){
										deliveryTime = 4 * (woodItem.getBaseDeliveryTime())	;
									}else
										if((woodItem.getQuantity()>=401) && (woodItem.getQuantity()<=500)){
											deliveryTime = 5 * (woodItem.getBaseDeliveryTime())	;
										}else
											if((woodItem.getQuantity()>=501) && (woodItem.getQuantity()<=1000)){
												deliveryTime = 5.5 * (woodItem.getBaseDeliveryTime())	;
											}
						totalPrice = totalPrice + woodItem.getTotalPrice();
						woodItemObject.setTotalPrice(totalPrice);
						deliveryTimeList.add(deliveryTime);
					}
					double deliveryETA = hardwoodSeller.deliveryTime();
					woodItemObject.setDeliveryETA(deliveryETA);
					System.out.println(woodItemObject);
				}
			}
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return deliveryETA
	 * Calculates the max hours of delivery for a woodItem
	 */
	public Double deliveryTime(){
		double deliveryETA = Collections.max(deliveryTimeList);
		return deliveryETA;
	}

}

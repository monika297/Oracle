/**
 * Class defining the elements of a wood type
 */
package model;

/**
 * 
 * @author monika_arora
 *
 */
public class WoodItem {

	String type;
	Double baseDeliveryTime;
	Double price;
	Double quantity;
	Double totalPrice;
	Double deliveryETA;

	/**
	 * Default constructor 
	 */
	public WoodItem(){
		this.type = "Empty";
		this.baseDeliveryTime = 0.0;
		this.price = 0.0;
		this.quantity = 0.0;
		this.totalPrice = 0.0;
		this.deliveryETA = 0.0;
	}

	/**
	 * Constructor of a WoodItem element with parameters
	 * @param type Name of the wood type
	 * @param daseDeliveryTime base delivery time
	 * @param price price per Bare Foot
	 * @param quantity Quantity of wood ordered
	 * @param totalPrice total price for all the woods
	 * @param deliveryETA the maximum hours required for delivery
	 */
	public WoodItem(String type, Double baseDeliveryTime, Double price, Double quantity, Double totalPrice, Double deliveryETA) {
		super();
		this.type = type;
		this.baseDeliveryTime = baseDeliveryTime;
		this.price = price;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.deliveryETA = deliveryETA;
	}

	/**
	 * Get the type of Wood
	 * 
	 * @return Name of the WoodItem
	 */
	public String getType() {
		return type;
	}

	/**
	 * Get the base delivery time
	 * 
	 * @return the baseDeliverytime
	 */
	public Double getBaseDeliveryTime() {
		return baseDeliveryTime;
	}

	/**
	 * 
	 * Get the price per Bare Foot
	 * 
	 * @return the price for 1 Bare Foot of this WoodItem
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * 
	 * Get the quantity of wood
	 * 
	 * @return the quantity of wood
	 */
	public Double getQuantity() {
		return quantity;
	}

	/**
	 * 
	 * Get the total price of all the woodItems
	 * 
	 * @return the total price for Bare Foot of the WoodItems ordered
	 */
	public Double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * 
	 * Get the max delivery hours of all the woodItems
	 * 
	 * @return the max delivery hours Bare Foot of the WoodItems ordered
	 */
	public Double getDeliveryETA() {
		return deliveryETA;
	}

	public void setDeliveryETA(Double deliveryETA) {
		this.deliveryETA = deliveryETA;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public void setBaseDeliveryTime(Double baseDeliveryTime) {
		this.baseDeliveryTime = baseDeliveryTime;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 * You may implement this method to fit your needs
	 */
	@Override
	public String toString() {	
		return "Total Price for all the woods:" + " " + "$" + this.getTotalPrice() + "\n"
				+ "The delivery ETA is:" + " " +  this.deliveryETA + " " +"hrs" + "\n" 
				+ "******************************************************************************************";
	}

}

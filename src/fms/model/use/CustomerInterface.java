package fms.model.use;

public interface CustomerInterface extends UserInterface {
	public void setCustomerID(int customerID);
	public int getCustomerID();
	public void setCreditCard(String creditCard);
	public String getCreditCard();
	public void setUseID(int useID);
	public int getUseID();
}

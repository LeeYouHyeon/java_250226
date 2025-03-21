package day12_Customer;

public class Customer {
	protected int customerID;
	protected String customerName = "";
	protected String customerGrade = "Silver";
	protected int bonusPoint;
	protected double bonusRatio = 0.01;
	protected double discount = 0;

	public Customer() {
	}

	public Customer(int id, String name) {
		customerID = id;
		customerName = name;
	}

	public int calcPrice(int item) {
		bonusPoint += (int) item * bonusRatio;
		return (int) (item * (1 - discount));
	}

	public void customerInfo() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return customerName + "님은 " + customerGrade + " 고객이며, 보너스 포인트는 " + bonusPoint + "점입니다.";
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerGrade() {
		return customerGrade;
	}

	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}

	public int getBonusPoint() {
		return bonusPoint;
	}

	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}

	public double getBonusRatio() {
		return bonusRatio;
	}

	public void setBonusRatio(double bonusRatio) {
		this.bonusRatio = bonusRatio;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

}

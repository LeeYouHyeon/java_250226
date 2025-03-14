package day12_Customer;

public class GoldCustomer extends Customer {
	public GoldCustomer() {
		setCustomerGrade("Gold");
		setBonusRatio(0.02);
		setDiscount(0.1);
	}
	public GoldCustomer(int id, String name) {
		this();
		setCustomerID(id);
		setCustomerName(name);
	}

}
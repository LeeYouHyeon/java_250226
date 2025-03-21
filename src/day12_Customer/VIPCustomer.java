package day12_Customer;

public class VIPCustomer extends Customer {
	private String agentName = "";
	private String agentNum;

	public VIPCustomer() {
		setDiscount(0.1);
		setCustomerGrade("VIP");
		setBonusRatio(0.03);
	}
	public VIPCustomer(int id, String name) {
		this();
		setCustomerID(id);
		setCustomerName(name);
	}
	public VIPCustomer(int id, String name, String agentName, String agentNum) {
		this(id, name);
		this.agentName = agentName;
		this.agentNum = agentNum;
	}

	@Override
	public String toString() {
		return customerName + "님은 " + customerGrade + " 고객이며, 보너스 포인트는 " + bonusPoint + "점입니다." +
				"\n전담 상담사는 " + agentName + "이고, 번호는 " + agentNum + "입니다.";
	}
	
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getAgentNum() {
		return agentNum;
	}
	public void setAgentNum(String agentNum) {
		this.agentNum = agentNum;
	}
}

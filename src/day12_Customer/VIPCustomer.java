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
		return customerName + "���� " + customerGrade + " ���̸�, ���ʽ� ����Ʈ�� " + bonusPoint + "���Դϴ�." +
				"\n���� ����� " + agentName + "�̰�, ��ȣ�� " + agentNum + "�Դϴ�.";
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

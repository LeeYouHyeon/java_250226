package sale;

public class Order extends Menu {
	private int count;
	private int total;
	
	public Order() {;}
	public Order(Menu menu, int count) {
		super(menu.getName(), menu.getPrice());
		this.count = count;
		this.total = count*this.getPrice();
	}
	
	@Override
	public String toString() {
		return String.format("%s(%d) * %d = %d", this.getName(), this.getPrice(), count, getTotal());
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotal() {
		return total;
	}
}

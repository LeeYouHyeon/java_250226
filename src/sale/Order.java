package sale;

public class Order extends Menu {
	private int count;
	private int total;
	
	public Order() {;}
	public Order(Menu menu, int count) {
		super(menu.getName(), menu.getPrice());
		this.count = count;
		this.total = menu.getPrice()*count;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%d) * %d = %d", this.getName(), this.getPrice(), count, total);
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
		total = count*this.getPrice();
	}
	public int getTotal() {
		return total;
	}
}

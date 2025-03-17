package sale;

public class Order {
	private Menu menu;
	private int count;
	
	public Order() {;}
	public Order(Menu menu, int count) {
		this.menu = menu;
		this.count = count;
	}
	
	@Override
	public String toString() {
		return String.format("%s(%d) * %d = %d", menu.getName(), menu.getPrice(), count, getTotal());
	}
	
	public String getName() {
		return menu.getName();
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotal() {
		return menu.getPrice()*count;
	}
}

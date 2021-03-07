package pizzashop.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Order {
	int tableNumber;
	HashMap<String, Integer> orderedItems;
	public OrderStatus status = OrderStatus.ORDERED;

	public LocalDateTime getCookingStart() {
		return cookingStart;
	}

	public void setCookingStart(LocalDateTime cookingStart) {
		this.cookingStart = cookingStart;
	}

	private LocalDateTime cookingStart;

	public Order(int tableNumber) {
		this.tableNumber = tableNumber;
		this.orderedItems = new HashMap<>();
	}

	public void addItemToOrder(int quantity, String item) {
		orderedItems.put(item, quantity);
	}

	public int getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(int tableNumber) {
		this.tableNumber = tableNumber;
	}

	public Map<String, Integer> getOrderedItems() {
		return orderedItems;
	}

	public void setOrderedItems(Map<String, Integer> orderedItems) {
		this.orderedItems = (HashMap<String, Integer>) orderedItems;
	}

	@Override
	public String toString() {
		String a = "Order{" +
				"tableNumber=" + tableNumber +
				", orderedItems=" + orderedItems +
				", status=" + status +
				'}';
		if(cookingStart != null) {
			a = a.concat("Cooking started at " + cookingStart.getHour() + ":" +cookingStart.getMinute());
		}
		return a;
	}
}

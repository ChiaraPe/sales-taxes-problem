package salestaxes.items;

import java.math.BigDecimal;

public class Item {

	public enum ItemType {
		BOOKS,
		FOOD,
		MEDICAL_PRODUCTS,
		OTHER;
	}
	
	private final String name;
	private final ItemType type;
	private final boolean imported;
	private final BigDecimal price;
	private final int quantity;
	
	private BigDecimal tax;
	private BigDecimal totalPrice;
	
	public Item(String name, ItemType type, boolean imported, BigDecimal price, int quantity) {
		this.name = name;
		this.type = type;
		this.imported = imported;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public ItemType getType() {
		return type;
	}

	public boolean isImported() {
		return imported;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}
	
	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	@Override
	public String toString() {
		return quantity + " " + name  + " at " + price;
	}
	
}

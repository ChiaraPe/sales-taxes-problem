package salestaxes.items;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Basket {

	private List<Item> items = new ArrayList<>();
	private BigDecimal salesTaxes;
	private BigDecimal total;
	
	public Basket() {
	}
	
	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public BigDecimal getSalesTaxes() {
		return salesTaxes;
	}

	public void setSalesTaxes(BigDecimal salesTaxes) {
		this.salesTaxes = salesTaxes;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public void addItem(Item item) {
		items.add(item);
	}
	
}

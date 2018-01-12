package salestaxes;

import java.math.BigDecimal;

import salestaxes.items.Basket;
import salestaxes.items.Item;
import salestaxes.items.Item.ItemType;

public class InputFactory {

	public Basket getBasket1() {
		Basket b = new Basket();
		b.addItem(new Item("book", ItemType.BOOKS, false, BigDecimal.valueOf(12.49).setScale(2), 1));
		b.addItem(new Item("music CD", ItemType.OTHER, false, BigDecimal.valueOf(14.99).setScale(2), 1));
		b.addItem(new Item("chocolate bar", ItemType.FOOD, false, BigDecimal.valueOf(0.85).setScale(2), 1));
		return b;
	}

	public Basket getBasket2() {
		Basket b = new Basket();
		b.addItem(new Item("imported box of chocolates", ItemType.FOOD, true, BigDecimal.valueOf(10.00).setScale(2), 1));
		b.addItem(new Item("imported bottle of perfume", ItemType.OTHER, true, BigDecimal.valueOf(47.50).setScale(2), 1));
		return b;
	}

	public Basket getBasket3() {
		Basket b = new Basket();
		b.addItem(new Item("imported bottle of perfume", ItemType.OTHER, true, BigDecimal.valueOf(27.99).setScale(2), 1));
		b.addItem(new Item("bottle of perfume", ItemType.OTHER, false, BigDecimal.valueOf(18.99).setScale(2), 1));
		b.addItem(new Item("packet of headache pills", ItemType.MEDICAL_PRODUCTS, false, BigDecimal.valueOf(9.75).setScale(2), 1));
		b.addItem(new Item("box of imported chocolates", ItemType.FOOD, true, BigDecimal.valueOf(11.25).setScale(2), 1));
		return b;
	}
	
}

package salestaxes.services;

import java.util.List;

import salestaxes.items.Basket;
import salestaxes.items.Item;

public class PrintUtils {

	// Prints a list of all items contained in the input basket, each one with relative quantity
	// and original price
	public static void printBasket(Basket b) {
		if (b != null) {
			List<Item> items = b.getItems();
			if (items.isEmpty())
				System.out.println("Empty shopping basket");
			else {
				for (Item item : b.getItems()) {
					System.out.println(item.toString());	
				}
			}
			System.out.println("\n");
		}
	}

	// Prints the receipt of the input basket, which lists the name of all the items and their price (including tax), 
	// finishing with the total cost of the items, and the total amounts of sales taxes paid.
	public static void printReceipt(Basket b) {
		if (b != null) {
			List<Item> items = b.getItems();
			if (items.isEmpty())
				System.out.println("Empty shopping basket");
			else {
				for (Item g : b.getItems()) {
					System.out.println(g.getQuantity() + " " + g.getName() + ": " + g.getTotalPrice());	
				}
				System.out.println("Sales Taxes: " + b.getSalesTaxes());
				System.out.println("Total: " + b.getTotal());
				System.out.println("\n");
			}
		}
	}

}

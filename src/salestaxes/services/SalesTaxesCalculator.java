package salestaxes.services;

import java.math.BigDecimal;
import java.util.Arrays;

import salestaxes.items.Basket;
import salestaxes.items.Item;
import salestaxes.items.Item.ItemType;

public class SalesTaxesCalculator {

	private static final BigDecimal ROUND_FACTOR = BigDecimal.valueOf(0.05);

	// Computes the total amount of sales taxes e the final total price for the input basket
	public void computeSalesTaxes(Basket b) {
		if (b != null) {
			BigDecimal salesTaxes = BigDecimal.ZERO;
			BigDecimal total = BigDecimal.ZERO;

			for (Item g : b.getItems()) {
				applyTax(g);

				salesTaxes = salesTaxes.add(g.getTax());
				total = total.add(g.getTotalPrice());
			}

			b.setSalesTaxes(salesTaxes);
			b.setTotal(total);
		}
	}

	// Computes the total amount of sales taxes e the final price for the input item
	private void applyTax(Item item) {
		if (item != null) {
			BigDecimal price = SalesTaxesCalculator.nullToZero(item.getPrice());
			BigDecimal tax = BigDecimal.ZERO;

			// Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical products 
			// that are exempt. 
			if (!isItemExemptFromBasicSalesTaxes(item.getType()))
				tax = computeBasicSalesTax(price);

			// Import duty is an additional sales tax applicable on all imported goods at a rate of 5%, 
			// with no exemptions.
			if (item.isImported())
				tax = tax.add(computeImportDutyTax(price));

			// The rounding rules for sales tax are that for a tax rate of n%, a shelf price of p contains 
			// (np/100 rounded up to the nearest 0.05) amount of sales tax.
			tax = roundOff(tax);

			item.setTax(tax);
			item.setTotalPrice(price.add(tax));
		}
	}

	// Compute a tax of 10%
	private BigDecimal computeBasicSalesTax(BigDecimal value) {
		return value.multiply(BigDecimal.valueOf(0.10));
	}

	// Compute a tax of 5%
	private BigDecimal computeImportDutyTax(BigDecimal value) {
		return value.multiply(BigDecimal.valueOf(0.05));
	}

	// Rounds input value to the nearest 0.05
	private BigDecimal roundOff(BigDecimal val) {
		val = val.divide(ROUND_FACTOR);
		val = new BigDecimal(Math.ceil(val.doubleValue()));
		val = val.multiply(ROUND_FACTOR);
		return val;
	}

	// Determinate if input item type is exempt from basic sales taxes
	private boolean isItemExemptFromBasicSalesTaxes(ItemType type) {
		return Arrays.asList(ItemType.BOOKS, ItemType.FOOD, ItemType.MEDICAL_PRODUCTS).contains(type);
	}

	private static BigDecimal nullToZero(BigDecimal value) {
		return value == null ? BigDecimal.ZERO : value;
	}

}
